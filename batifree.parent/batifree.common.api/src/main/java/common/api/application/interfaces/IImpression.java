/***********************************************************************
 * Module: IImpressionJasper.java Author: Kero Purpose: Defines the Interface IImpressionJasper
 ***********************************************************************/

package common.api.application.interfaces;

import java.util.Map;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IImpression</b><br/>
 * 
 * Interface <IImpressionJasper>.
 * 
 * 
 * 
 * @author Kero
 */
public interface IImpression {
	/**
	 * Classe <b>FormatOut</b><br/>
	 * 
	 * Type de format de sortie.
	 */
	public enum FormatOut {
		/** Format HTML. */
		HTML,
		/** Format PDF. */
		PDF,
		/** Format aperçu avant impression. */
		APERCU,
		/** Format impression. */
		IMPRIMANTE,
		/** Format Tableur (Excel). */
		TABLEUR;

	}

	/** Répertoire par défaut de la génération des rapports. */
	String FOLDER_REPORT = "rapports/";

	/**
	 * Génère un rapport
	 * 
	 * 
	 * 
	 * @param pNomDuRapport Le nom du rapport sans son extension
	 * @param pFormatSortie Format de sortie d'impression.
	 * @param pParams Map des différents paramètres passés au rapport (ID_CLIENT par exemple) pour utilisation par le rapport
	 * @param pCheminFichierDeSortie Chemin complet (avec extension) du fichier de sortie (HTML, Tableur, PDF). Indiquer null si Aperçu ou Imprimante
	 * @param pApplication Application courante.
	 * @throws BatifreeException BatifreeException
	 */
	void generateReport(String pNomDuRapport, IImpression.FormatOut pFormatSortie, Map<String, Object> pParams, String pCheminFichierDeSortie,
	        IApplicationCommun pApplication) throws BatifreeException;

	/**
	 * Génère un rapport
	 * 
	 * 
	 * 
	 * @param pRapport Le rapport
	 * @param pFormatSortie Format de sortie d'impression.
	 * @param pParams Map des différents paramètres passés au rapport (ID_CLIENT par exemple) pour utilisation par le rapport
	 * @param pCheminFichierDeSortie Chemin complet (avec extension) du fichier de sortie (HTML, Tableur, PDF). Indiquer null si Aperçu ou Imprimante
	 * @param pApplication Application courante.
	 * @throws BatifreeException BatifreeException
	 */
	void generateReport(byte[] pRapport, IImpression.FormatOut pFormatSortie, Map<String, Object> pParams, String pCheminFichierDeSortie,
	        IApplicationCommun pApplication) throws BatifreeException;

}