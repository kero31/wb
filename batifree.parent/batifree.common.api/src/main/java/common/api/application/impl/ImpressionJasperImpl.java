package common.api.application.impl;

import java.util.Map;

import java.io.File;
import java.net.URL;
import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.springframework.stereotype.Service;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.IImpression;
import common.api.exception.BatifreeException;

/**
 * Petite classe utilitaire pour lancer une impression d'un état JasperReport On suppose que cette classe est placée avec les difféents rapports dans
 * le package "rapports".
 */
@Service("ImpressionJasper")
public class ImpressionJasperImpl implements IImpression {

	/**
	 * Génère un rapport
	 * 
	 * 
	 * @param pNomDuRapport Le nom du rapport sans son extension .jasper
	 * @param pConnection La connexion java.sql à la base de donnée
	 * @param pFormatSortie "Aperçu","Imprimante","Tableur","HTML","PDF"
	 * @param pParams Map des différents paramètres passés au rapport (ID_CLIENT par exemple) pour utilisation par le rapport
	 * @param pCheminFichierDeSortie chemin complet (avec extension) du fichier de sortie (HTML, Tableur, PDF). Indiquer null si Aperçu ou Imprimante
	 * @throws BatifreeException
	 */
	private void generateRepport(String pNomDuRapport, Connection pConnection, FormatOut pFormatSortie, Map<String, Object> pParams,
			String pCheminFichierDeSortie) throws BatifreeException {

		// on suppose que le package dans lequel se trouve le rapport est nommé "rapports"
		pParams.put("SUBREPORT_DIR", FOLDER_REPORT);

		URL cheminRapport = getClass().getResource("/" + FOLDER_REPORT + pNomDuRapport + ".jasper");

		try {
			// chargement du rapport :
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(cheminRapport);

			// calcul et mise en page du rapport avec utilisation des paramètres et de la connexion
			// l'objet jasperPrint contient le résultat
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, pParams, pConnection);

			// Utilisation en fonction type de format de sortie
			switch (pFormatSortie) {
			case APERCU:
				// Si le format de sortie est "Aperçu", le résultat est placé dans un JFrame (JasperViewer) qui fait un EXIT_ON_CLOSE par défaut
				// il faut donc passer le paramètre false pour empêcher l'arrêt de l'application après un aperçu
				// Le false empêche l'arrêt de l'application
				new JasperViewer(jasperPrint, false);
				break;
			case HTML:
				// suppression de la pagination si format HTML (sinon on est au format A4 !!!)
				pParams.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);

				// pour exporter au format HTML JasperExportManager crée un sous répertoire.
				// en cas de ré-exportation du rapport, il faut supprimer le sous-répertoire sinon ça plante
				String NomRepHtml = pCheminFichierDeSortie.subSequence(0, pCheminFichierDeSortie.lastIndexOf(".")) + "_files";
				File RepHtm = new File(NomRepHtml);
				if (RepHtm.exists()) {
					File[] Fichiers = RepHtm.listFiles();
					for (File fichier : Fichiers) {
						fichier.delete();
					}
				}
				RepHtm.delete();
				JasperExportManager.exportReportToHtmlFile(jasperPrint, pCheminFichierDeSortie);
				break;
			case IMPRIMANTE:
				JasperPrintManager.printReport(jasperPrint, false);
				break;
			case PDF:
				JasperExportManager.exportReportToPdfFile(jasperPrint, pCheminFichierDeSortie);
				break;
			case TABLEUR:
				JRXlsExporter exporter = new JRXlsExporter();

				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, pCheminFichierDeSortie);
				exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

				exporter.exportReport();
				break;
			default:
				break;

			}
		} catch (JRException ex) {
			throw new BatifreeException("Erreur impression", ex);
		}

	}

	@Override
	public void generateReport(String pNomDuRapport, FormatOut pFormatSortie, Map<String, Object> pParams, String pCheminFichierDeSortie,
			IApplicationCommun pApplication) throws BatifreeException {
		generateRepport(pNomDuRapport, pApplication.getUserService().getConnectionSQL(), pFormatSortie, pParams, pCheminFichierDeSortie);
	}

	@Override
	public void generateReport(byte[] pRapport, FormatOut pFormatSortie, Map<String, Object> pParams, String pCheminFichierDeSortie,
			IApplicationCommun pApplication) throws BatifreeException {
		// generateRepport(pNomDuRapport, pApplication.getUserService().getConnectionSQL(), pFormatSortie, pParams, pCheminFichierDeSortie);
		// TODO revoir

	}
}