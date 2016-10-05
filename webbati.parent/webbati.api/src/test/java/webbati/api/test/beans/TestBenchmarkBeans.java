package webbati.api.test.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import common.api.exception.WebbatiException;
import webbati.api.application.interfaces.IFactoryBf;
import webbati.api.manager.interfaces.IActiviteManager;
import webbati.api.manager.interfaces.IBinaireManager;
import webbati.api.manager.interfaces.ICategorieManager;
import webbati.api.manager.interfaces.IChantierManager;
import webbati.api.manager.interfaces.IClientManager;
import webbati.api.manager.interfaces.IEcheancierReglementManager;
import webbati.api.manager.interfaces.IFamilleManager;
import webbati.api.manager.interfaces.IFournisseurManager;
import webbati.api.manager.interfaces.IImageManager;
import webbati.api.manager.interfaces.ILocalisationManager;
import webbati.api.manager.interfaces.ILotBibManager;
import webbati.api.manager.interfaces.IMateriauxBibManager;
import webbati.api.manager.interfaces.IModePaiementManager;
import webbati.api.manager.interfaces.IPaysManager;
import webbati.api.manager.interfaces.IReglementManager;
import webbati.api.manager.interfaces.ITacheBibManager;
import webbati.api.manager.interfaces.ITvaManager;
import webbati.api.metier.interfaces.IAcompte;
import webbati.api.metier.interfaces.IActivite;
import webbati.api.metier.interfaces.IAvoir;
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IBinaire;
import webbati.api.metier.interfaces.ICategorie;
import webbati.api.metier.interfaces.IChantier;
import webbati.api.metier.interfaces.ICivilite;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IEnginBib;
import webbati.api.metier.interfaces.IEtat;
import webbati.api.metier.interfaces.IEtude;
import webbati.api.metier.interfaces.IFacture;
import webbati.api.metier.interfaces.IFamille;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IGroupeCnt;
import webbati.api.metier.interfaces.IImage;
import webbati.api.metier.interfaces.ILocalisation;
import webbati.api.metier.interfaces.ILotBib;
import webbati.api.metier.interfaces.IMainOeuvreBib;
import webbati.api.metier.interfaces.IMateriauxBib;
import webbati.api.metier.interfaces.IMateriauxEtude;
import webbati.api.metier.interfaces.IModePaiement;
import webbati.api.metier.interfaces.IPays;
import webbati.api.metier.interfaces.IReglement;
import webbati.api.metier.interfaces.ISituation;
import webbati.api.metier.interfaces.ISousTraitantBib;
import webbati.api.metier.interfaces.ITacheBib;
import webbati.api.metier.interfaces.ITva;
import webbati.api.test.commun.TestCommunBfApi;

public class TestBenchmarkBeans extends TestCommunBfApi {

	private static final Logger LOGGER = Logger.getLogger(TestBenchmarkBeans.class);

	private final String TVA_LIBELLE_1 = "tva1 - 19.6";
	private final Float TVA_TAUX_1 = 19.6F;

	private final String FAMILLE_DESC_1 = "desc1";
	private final Short FAMILLE_TYPE_1 = 3;
	private final String FAMILLE_DESC_11 = "desc11";
	private final Short FAMILLE_TYPE_11 = 4;
	private final String FAMILLE_DESC_111 = "desc111";
	private final Short FAMILLE_TYPE_111 = 5;

	private final String PAYS_LIBELLE_1 = "pays libelle1";
	private final String LOCALISATION_LIBELLE_1 = "loc libelle1";
	private final String ACTIVITE_LIBELLE_1 = "activite libelle1";
	private final String CATEGORIE_LIBELLE_1 = "categorie libelle1";
	private final String ETAT_LIBELLE_1 = "etat libelle1";
	private final String CIVILITE_LIBELLE_1 = "civilite libelle1";

	private final byte[] BIN_BIB_DESCRIPTIF_OBJECT_1 = { 1, 2 };
	private final byte[] BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1 = { 2, 3 };
	private final byte[] BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1 = { 3, 4 };
	private final byte[] BIN_BIB_NOTES_OBJECT_1 = { 4, 5 };
	private final byte[] BIN_IMAGE_OBJECT_1 = { 4, 5 };

	private final String BIB_MX_BAR_CODE_1 = "mx bar code 1";
	private final String BIB_MX_CODE_1 = "mx code 1";
	private final Float BIB_MX_BENEFICE_1 = 20F;
	private final Float BIB_MX_FRAIS_GENRERAUX_1 = 30F;
	private final String BIB_MX_MOT_CLE_1 = "mx mot cle 1";
	private final String BIB_MX_NUM_SERIE_1 = "mx num serie 1";
	private final Float BIB_MX_PRIX_ACHAT_1 = 40F;
	private final String BIB_MX_UNITE_1 = "mx un 1";
	private final Float BIB_MX_PRIX_TARIF_1 = 50F;
	private final Float BIB_MX_REMISE_1 = 10F;
	private final String BIB_MX_ETUDE_CODE_1 = "mx code etude 1";

	private final String BIB_MO_BAR_CODE_1 = "mo bar code 1";
	private final String BIB_MO_CODE_1 = "mo code 1";
	private final Float BIB_MO_BENEFICE_1 = 30F;
	private final Float BIB_MO_FRAIS_GENRERAUX_1 = 40F;
	private final String BIB_MO_MOT_CLE_1 = "mo mot cle 1";
	private final String BIB_MO_NUM_SERIE_1 = "mo num serie 1";
	private final Float BIB_MO_PRIX_ACHAT_1 = 50F;
	private final String BIB_MO_UNITE_1 = "mo un 1";
	private final Float BIB_MO_QUANTITE_1 = 60F;

	private final String BIB_ENG_BAR_CODE_1 = "eng bar code 1";
	private final String BIB_ENG_CODE_1 = "eng code 1";
	private final Float BIB_ENG_BENEFICE_1 = 30F;
	private final Float BIB_ENG_FRAIS_GENERAUX_1 = 40F;
	private final String BIB_ENG_MOT_CLE_1 = "eng mot cle 1";
	private final String BIB_ENG_NUM_SERIE_1 = "eng num serie 1";
	private final Float BIB_ENG_PRIX_ACHAT_1 = 50F;
	private final String BIB_ENG_UNITE_1 = "eng un 1";
	private final String BIB_ENG_IMMATRICULATION = "eng immat 1";
	private final Date BIB_ENG_IMMATRICULATION_DATE = getDate();
	private final Float BIB_ENG_QUANTITE_1 = 60F;

	private final String BIB_SST_BAR_CODE_1 = "sst bar code 1";
	private final String BIB_SST_CODE_1 = "sst code 1";
	private final Float BIB_SST_BENEFICE_1 = 30F;
	private final Float BIB_SST_FRAIS_GENRERAUX_1 = 40F;
	private final String BIB_SST_MOT_CLE_1 = "sst mot cle 1";
	private final String BIB_SST_NUM_SERIE_1 = "sst num serie 1";
	private final Float BIB_SST_PRIX_ACHAT_1 = 50F;
	private final String BIB_SST_UNITE_1 = "sst un 1";

	private final String BIB_LOT_CODE_1 = "lot code 1";
	private final String BIB_LOT_MOT_CLE_1 = "lot mot cle 1";
	private final String BIB_LOT_UNITE_1 = "lot un 1";

	private final String BIB_TAC_BAR_CODE_1 = "tac bar code 1";
	private final String BIB_TAC_CODE_1 = "tac code 1";
	private final Float BIB_TAC_BENEFICE_1 = 30F;
	private final Float BIB_TAC_FRAIS_GENERAUX_1 = 40F;
	private final String BIB_TAC_MOT_CLE_1 = "tac mot cle 1";
	private final String BIB_TAC_NUM_SERIE_1 = "tac num serie 1";
	private final Float BIB_TAC_PRIX_ACHAT_1 = 50F;
	private final String BIB_TAC_UNITE_1 = "tac un 1";
	private final Boolean BIB_TAC_PRIX_VENTE_FIXE_1 = true;
	private final Float BIB_TAC_BENEFICE_ENG_1 = 60F;
	private final Float BIB_TAC_FRAIS_GENRERAUX_ENG_1 = 70F;
	private final Float BIB_TAC_BENEFICE_MO_1 = 80F;
	private final Float BIB_TAC_FRAIS_GENRERAUX_MO_1 = 90F;
	private final Float BIB_TAC_BENEFICE_MX_1 = 100F;
	private final Float BIB_TAC_FRAIS_GENRERAUX_MX_1 = 110F;
	private final Float BIB_TAC_BENEFICE_SST_1 = 120F;
	private final Float BIB_TAC_FRAIS_GENRERAUX_SST_1 = 130F;
	private final Float BIB_TAC_QUANTITE_1 = 140F;

	private final String FOUR_CODE_1 = "code four1";
	private final String FOUR_CODE_NAF_1 = "nafFo1";
	private final Boolean FOUR_HIDE_1 = false;
	private final String FOUR_NOM_SOCIETE_1 = "four1 nom societe";
	private final Date FOUR_RAPPEL_DATE_1 = getDate();
	private final String FOUR_SIREN_1 = "siren four1";
	private final String FOUR_TVA_INTRA_1 = "tvaintraFo1";

	private final byte[] BIN_CONTACT_RAPPEL_MOTIF_OBJECT_1 = { 5, 6 };
	private final byte[] BIN_CONTACT_REMARQUES_OBJECT_1 = { 6, 7 };

	private final String CLIENT_CODE_1 = "code client1";
	private final String CLIENT_CODE_NAF_1 = "nafCl1";
	private final Boolean CLIENT_HIDE_1 = false;
	private final String CLIENT_NOM_SOCIETE_1 = "client1 nom societe";
	private final Date CLIENT_RAPPEL_DATE_1 = getDate();
	private final String CLIENT_SIREN_1 = "siren client1";
	private final String CLIENT_TVA_INTRA_1 = "tvaintraCl1";
	private final boolean CLIENT_PROSPECT_1 = true;
	private final Float CLIENT_MONTANT_PLAFOND_1 = 50F;

	private final String COO_COMPLEMENTAIRE_1 = "coo complement 1";
	private final String COO_CP_1 = "coo cp 1";
	private final String COO_FAX_1 = "coo fax 1";
	private final String COO_MAIL_1 = "coo mail 1";
	private final String COO_MAIL2_1 = "coo mail2 1";
	private final String COO_MOBILE_1 = "coo mobile 1";
	private final String COO_NOM_1 = "coo nom 1";
	private final String COO_PRENOM_1 = "coo prenom 1";
	private final String COO_RUE_1 = "coo rue 1";
	private final String COO_TEL_1 = "coo tel 1";
	private final String COO_TEL2_1 = "coo tel2 1";
	private final String COO_VILLE_1 = "coo ville 1";
	private final String COO_WEB_1 = "coo web 1";

	private final String MODE_PAIEMENT_LIBELLE = "mdp libelle 1";

	private final String REGLEMENT_CODE = "rgl code 1";
	private final String REGLEMENT_DESCRIPTIF = "rgl descriptif 1";
	private final Date REGLEMENT_DATE_PAIEMENT = getDate();
	private final String REGLEMENT_BANQUE = "rgl banque 1";
	private final String REGLEMENT_NUM_CHEQUE = "rgl num cheque 1";

	private final Float ECHEANCIER_REGLEMENT_MONTANT_2 = 69F;

	private final Float FOURNISSEUR_MATERIAUX_PRIX_TARIF_1 = 102F;
	private final Float FOURNISSEUR_MATERIAUX_QTE_MINI_1 = 10F;
	private final Float FOURNISSEUR_MATERIAUX_REMISE_1 = 20F;

	private final byte[] BIN_AFFAIRE_INTRODUCTION_OBJECT_1 = { 9, 10 };
	private final byte[] BIN_AFFAIRE_DESCRIPTIF_OBJECT_1 = { 10, 11 };
	private final byte[] BIN_AFFAIRE_CONCLUSION_OBJECT_1 = { 11, 12 };
	private final byte[] BIN_AFFAIRE_METRE_OBJECT_1 = { 12, 13 };
	private final byte[] BIN_AFFAIRE_NOTES_OBJECT_1 = { 13, 14 };

	private final String DEVIS_CODE_1 = "devis code 1";
	private final Date DEVIS_DATE_CLOTURE_1 = getDate();
	private final Date DEVIS_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date DEVIS_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date DEVIS_DUREE_VALIDITE_1 = getDate();
	private final String DEVIS_REFERENCE_1 = "devis reference 1";
	private final Boolean DEVIS_TERMINE_1 = true;
	private final Boolean DEVIS_VALIDE_1 = true;

	private final String FACTURE_CODE_1 = "facture code 1";
	private final Date FACTURE_DATE_CLOTURE_1 = getDate();
	private final Date FACTURE_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date FACTURE_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date FACTURE_DUREE_VALIDITE_1 = getDate();
	private final String FACTURE_REFERENCE_1 = "facture reference 1";
	private final Boolean FACTURE_TERMINE_1 = true;
	private final Boolean FACTURE_VALIDE_1 = true;

	private final String SITUATION_CODE_1 = "situation code 1";
	private final Date SITUATION_DATE_CLOTURE_1 = getDate();
	private final Date SITUATION_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date SITUATION_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date SITUATION_DUREE_VALIDITE_1 = getDate();
	private final String SITUATION_REFERENCE_1 = "situation reference 1";
	private final Boolean SITUATION_TERMINE_1 = true;
	private final Boolean SITUATION_VALIDE_1 = true;

	private final String AVOIR_CODE_1 = "avoir code 1";
	private final Date AVOIR_DATE_CLOTURE_1 = getDate();
	private final Date AVOIR_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date AVOIR_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date AVOIR_DUREE_VALIDITE_1 = getDate();
	private final String AVOIR_REFERENCE_1 = "avoir reference 1";
	private final Boolean AVOIR_TERMINE_1 = true;
	private final Boolean AVOIR_VALIDE_1 = true;

	private final String ACOMPTE_CODE_1 = "acompte code 1";
	private final Date ACOMPTE_DATE_CLOTURE_1 = getDate();
	private final Date ACOMPTE_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date ACOMPTE_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date ACOMPTE_DUREE_VALIDITE_1 = getDate();
	private final String ACOMPTE_REFERENCE_1 = "acompte reference 1";
	private final Boolean ACOMPTE_TERMINE_1 = true;
	private final Boolean ACOMPTE_VALIDE_1 = true;

	private final String GROUPE_CNT_LIBELLE_1 = "libelle grpCnt1";

	private final String DIV_CNT_CODE_1 = "code divCnt1";
	private final String DIV_CNT_CODE_NAF_1 = "nafDi1";
	private final Boolean DIV_CNT_HIDE_1 = false;
	private final String DIV_CNT_NOM_SOCIETE_1 = "divCnt1 nom societe";
	private final Date DIV_CNT_RAPPEL_DATE_1 = getDate();
	private final String DIV_CNT_SIREN_1 = "siren divCnt1";
	private final String DIV_CNT_TVA_INTRA_1 = "tvaintraDi1";

	private final int COEFF_NB = 1;

	private final int NB_TVA = COEFF_NB * 10;
	// Nombre total de familles : 20000
	private final int NB_FAMILLE_NIVEAU_0 = COEFF_NB * 100;
	private final int NB_FAMILLE_NIVEAU_1 = COEFF_NB * 20;
	private final int NB_FAMILLE_NIVEAU_2 = COEFF_NB * 10;
	private final int NB_PAYS = COEFF_NB * 220;
	private final int NB_LOCALISATION = COEFF_NB * 15;
	private final int NB_ACTIVITE = COEFF_NB * 20;
	private final int NB_CATEGORIE = COEFF_NB * 20;
	private final int NB_CHANTIER = COEFF_NB * 1000;
	private final int NB_ETAT = COEFF_NB * 20;
	private final int NB_CIVILITE = COEFF_NB * 20;
	private final int NB_FOURNISSEUR = COEFF_NB * 50;
	private final int NB_CLIENT = COEFF_NB * 1000;
	private final int NB_DEVIS_PAR_CLIENT = COEFF_NB * 3;
	private final int NB_ETUDE_PAR_DEVIS = COEFF_NB * 2;
	private final int NB_FACTURE_PAR_CLIENT = COEFF_NB * 2;
	private final int NB_ACOMPTE_PAR_CLIENT = COEFF_NB * 1;
	private final int NB_SITUATION_PAR_CLIENT = COEFF_NB * 1;
	private final int NB_AVOIR_PAR_CLIENT = COEFF_NB * 2;
	private final int NB_MATERIAUX = COEFF_NB * 100;
	private final int NB_MATERIAUX_PAR_ETUDE_PAR_DEVIS = COEFF_NB * 7;
	private final int NB_MATERIAUX_PAR_FOURNISSEUR = COEFF_NB * 35;
	private final int NB_MAIN_OEUVRE = COEFF_NB * 35;
	private final int NB_ENGIN = COEFF_NB * 20;
	private final int NB_SOUS_TRAITANT = COEFF_NB * 30;
	private final int NB_LOT = COEFF_NB * 50;
	private final int NB_LOT_DETAIL = COEFF_NB * 20;
	private final int NB_TACHE = COEFF_NB * 35000;
	private final int NB_TACHE_DETAIL = COEFF_NB * 6;
	private final int NB_MODE_PAIEMENT = COEFF_NB * 10;
	private final int NB_REGLEMENT = COEFF_NB * 100;
	private final int NB_GROUPE_CONTACT = COEFF_NB * 10;
	private final int NB_DIVERS_CONTACT = COEFF_NB * 100;

	private final double COEFF_TIMER = 1;

	private final double TIMER_MAX_TVA = COEFF_TIMER * 400;
	private final double TIMER_MAX_FAMILLE = COEFF_TIMER * 400;
	private final double TIMER_MAX_FAMILLE_GET_CHILDREN = COEFF_TIMER * 900;
	private final double TIMER_MAX_PAYS = COEFF_TIMER * 400;
	private final double TIMER_MAX_LOCALISATION = COEFF_TIMER * 400;
	private final double TIMER_MAX_ACTIVITE = COEFF_TIMER * 400;
	private final double TIMER_MAX_CATEGORIE = COEFF_TIMER * 400;
	private final double TIMER_MAX_CHANTIER = COEFF_TIMER * 400;
	private final double TIMER_MAX_ETAT = COEFF_TIMER * 400;
	private final double TIMER_MAX_CIVILITE = COEFF_TIMER * 400;
	private final double TIMER_MAX_FOURNISSEUR = COEFF_TIMER * 400;
	private final double TIMER_MAX_FOURNISSEUR_MATERIAUX = COEFF_TIMER * 500;
	private final double TIMER_MAX_CLIENT = COEFF_TIMER * 400;
	private final double TIMER_MAX_CLIENT_AFFAIRE = COEFF_TIMER * 400;
	private final double TIMER_MAX_DEVIS = COEFF_TIMER * 400;
	private final double TIMER_MAX_DEVIS_ETUDE = COEFF_TIMER * 400;
	private final double TIMER_MAX_DEVIS_ETUDE_MATERIAUX = COEFF_TIMER * 400;
	private final double TIMER_MAX_FACTURE = COEFF_TIMER * 400;
	private final double TIMER_MAX_ACOMPTE = COEFF_TIMER * 400;
	private final double TIMER_MAX_SITUATION = COEFF_TIMER * 400;
	private final double TIMER_MAX_AVOIR = COEFF_TIMER * 400;
	private final double TIMER_MAX_MATERIAUX = COEFF_TIMER * 400;
	private final double TIMER_MAX_MAIN_OEUVRE = COEFF_TIMER * 400;
	private final double TIMER_MAX_ENGIN = COEFF_TIMER * 400;
	private final double TIMER_MAX_SOUS_TRAITANT = COEFF_TIMER * 400;
	private final double TIMER_MAX_LOT = COEFF_TIMER * 400;
	private final double TIMER_MAX_LOT_DETAIL = COEFF_TIMER * 400;
	private final double TIMER_MAX_TACHE = COEFF_TIMER * 400;
	private final double TIMER_MAX_TACHE_DETAIL = COEFF_TIMER * 400;
	private final double TIMER_MAX_MODE_PAIEMENT = COEFF_TIMER * 400;
	private final double TIMER_MAX_REGLEMENT = COEFF_TIMER * 400;
	private final double TIMER_MAX_GROUPE_CONTACT = COEFF_TIMER * 400;
	private final double TIMER_MAX_DIVERS_CONTACT = COEFF_TIMER * 400;
	private final double TIMER_MAX_GET_LIST_TACHES_PARENTE = COEFF_TIMER * 400;

	/**
	 * Username pour les tests
	 */
	private String TEST_USERNAME = "test_unitaire_benchmark";

	@Override
	protected String getUsernameTest() {
		return TEST_USERNAME;
	}

	/**
	 * Retourne une date et heure.
	 * 
	 * @return date
	 */
	private final Date getDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH, 23);
		cal.set(Calendar.MONTH, 7);
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 5);
		cal.set(Calendar.SECOND, 10);
		return cal.getTime();
	}

	/**
	 * @throws WebbatiException
	 */
	private void testAddAll() throws WebbatiException {
		boolean isBeginTransaction = false;
		if (isBeginTransaction) {
			beginTransaction();
		}

		try {
			IFactoryBf factory = app.getFactory();

			ITva tva1 = null;
			for (int i = 0; i < NB_TVA; i++) {
				tva1 = factory.createNewInstance(ITva.class);
				tva1.setLibelle(TVA_LIBELLE_1);
				tva1.setTaux(TVA_TAUX_1);
				ITvaManager tvaMng = app.getTvaManager();
				tva1 = tvaMng.save(tva1);
			}

			IFamille fam1 = null;
			for (int i = 0; i < NB_FAMILLE_NIVEAU_0; i++) {
				fam1 = factory.createNewInstance(IFamille.class);
				fam1.setDescriptif(FAMILLE_DESC_1);
				fam1.setType(FAMILLE_TYPE_1);

				// Liste Famille niveau 1
				List<IFamille> listFamilleNiveau1 = new ArrayList<>();
				for (int j = 0; j < NB_FAMILLE_NIVEAU_1; j++) {
					IFamille fam11 = factory.createNewInstance(IFamille.class);
					fam11.setDescriptif(FAMILLE_DESC_11);
					fam11.setType(FAMILLE_TYPE_11);

					// Liste Famille niveau 2
					List<IFamille> listFamilleNiveau2 = new ArrayList<>();
					for (int k = 0; k < NB_FAMILLE_NIVEAU_2; k++) {
						IFamille fam111 = factory.createNewInstance(IFamille.class);
						fam111.setDescriptif(FAMILLE_DESC_111);
						fam111.setType(FAMILLE_TYPE_111);
						listFamilleNiveau2.add(fam111);
					}
					fam11.setListLigne(listFamilleNiveau2);

					listFamilleNiveau1.add(fam11);
				}
				fam1.setListLigne(listFamilleNiveau1);

				// Crée la liste de famille de niveau 0
				List<IFamille> listFamille = new ArrayList<>();
				listFamille.add(fam1);

				IFamilleManager familleMng = app.getFamilleManager();
				familleMng.save(listFamille);
			}

			IPays pays1 = null;
			for (int i = 0; i < NB_PAYS; i++) {
				pays1 = factory.createNewInstance(IPays.class);
				pays1.setLibelle(PAYS_LIBELLE_1);
				IPaysManager paysMng = app.getPaysManager();
				pays1 = paysMng.save(pays1);
			}

			ILocalisation loc1 = null;
			for (int i = 0; i < NB_LOCALISATION; i++) {
				loc1 = factory.createNewInstance(ILocalisation.class);
				loc1.setLibelle(LOCALISATION_LIBELLE_1);
				ILocalisationManager locMng = app.getLocalisationManager();
				loc1 = locMng.save(loc1);
			}

			IActivite act1 = null;
			for (int i = 0; i < NB_ACTIVITE; i++) {
				act1 = factory.createNewInstance(IActivite.class);
				act1.setLibelle(ACTIVITE_LIBELLE_1);
				IActiviteManager actMng = app.getActiviteManager();
				act1 = actMng.save(act1);
			}

			ICategorie cat1 = null;
			for (int i = 0; i < NB_CATEGORIE; i++) {
				cat1 = factory.createNewInstance(ICategorie.class);
				cat1.setLibelle(CATEGORIE_LIBELLE_1);
				ICategorieManager catMng = app.getCategorieManager();
				cat1 = catMng.save(cat1);
			}

			IChantier cht1 = null;
			for (int i = 0; i < NB_CHANTIER; i++) {
				cht1 = factory.createNewInstance(IChantier.class);
				IChantierManager chtMng = app.getChantierManager();
				cht1 = chtMng.save(cht1);
			}

			IEtat etat1 = null;
			for (int i = 0; i < NB_ETAT; i++) {
				etat1 = factory.createNewInstance(IEtat.class);
				etat1.setLibelle(ETAT_LIBELLE_1);
				etat1 = app.getEtatManager().save(etat1);
			}

			ICivilite civ1 = null;
			for (int i = 0; i < NB_CIVILITE; i++) {
				civ1 = factory.createNewInstance(ICivilite.class);
				civ1.setLibelle(CIVILITE_LIBELLE_1);
				civ1 = app.getCiviliteManager().save(civ1);
			}

			// Binaires
			IBinaireManager binaireMng = app.getBinaireManager();

			IFournisseur four1 = null;
			for (int i = 0; i < NB_FOURNISSEUR; i++) {
				// Contact binaire
				IBinaire binRappelMotif1 = factory.createNewInstance(IBinaire.class);
				binRappelMotif1.setObjet(BIN_CONTACT_RAPPEL_MOTIF_OBJECT_1);
				binRappelMotif1 = binaireMng.save(binRappelMotif1);

				IBinaire binRemarques1 = factory.createNewInstance(IBinaire.class);
				binRemarques1.setObjet(BIN_CONTACT_REMARQUES_OBJECT_1);
				binRemarques1 = binaireMng.save(binRemarques1);

				// /////////
				// CoordonneeCnt
				ICoordonneeCnt coo1 = factory.createNewInstance(ICoordonneeCnt.class);
				coo1.setCivilite(civ1);
				coo1.setComplementaire(COO_COMPLEMENTAIRE_1);
				coo1.setCp(COO_CP_1);
				coo1.setFax(COO_FAX_1);
				coo1.setLocalisation(loc1);
				coo1.setMail(COO_MAIL_1);
				coo1.setMail2(COO_MAIL2_1);
				coo1.setMobile(COO_MOBILE_1);
				coo1.setNom(COO_NOM_1);
				coo1.setPays(pays1);
				coo1.setPrenom(COO_PRENOM_1);
				coo1.setRue(COO_RUE_1);
				coo1.setTel1(COO_TEL_1);
				coo1.setTel2(COO_TEL2_1);
				coo1.setVille(COO_VILLE_1);
				coo1.setWeb(COO_WEB_1);
				coo1 = app.getCoordonneeCntManager().save(coo1);

				four1 = factory.createNewInstance(IFournisseur.class);
				four1.setActivite(act1);
				four1.setCategorie(cat1);
				four1.setCode(FOUR_CODE_1);
				four1.setCodeNaf(FOUR_CODE_NAF_1);
				four1.setCoordonnee(coo1);
				four1.setHide(FOUR_HIDE_1);
				four1.setNomSociete(FOUR_NOM_SOCIETE_1);
				four1.setRappelDate(FOUR_RAPPEL_DATE_1);
				four1.setRappelMotif(binRappelMotif1);
				four1.setRemarques(binRemarques1);
				four1.setSiren(FOUR_SIREN_1);
				four1.setTvaIntra(FOUR_TVA_INTRA_1);
				four1 = app.getFournisseurManager().save(four1);

				// /////////
				// Fournisseur - Materiaux
				for (int j = 0; j < NB_MATERIAUX_PAR_FOURNISSEUR; j++) {
					IFournisseurMateriaux frnbMx = factory.createNewInstance(IFournisseurMateriaux.class);
					frnbMx.setFournisseur(four1);
					frnbMx.setPrixTarif(FOURNISSEUR_MATERIAUX_PRIX_TARIF_1);
					frnbMx.setQuantiteMini(FOURNISSEUR_MATERIAUX_QTE_MINI_1);
					frnbMx.setRemise(FOURNISSEUR_MATERIAUX_REMISE_1);

					// /////////
					// Bib binaire - image
					IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
					binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
					binDescriptif1 = binaireMng.save(binDescriptif1);

					IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
					binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
					binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

					IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
					binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
					binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

					IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
					binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
					binNote1 = binaireMng.save(binNote1);

					IImage img1 = factory.createNewInstance(IImage.class);
					img1.setObjet(BIN_IMAGE_OBJECT_1);
					IImageManager imgMng = app.getImageManager();
					img1 = imgMng.save(img1);

					// Mx Bib
					IMateriauxBib mxBib = factory.createNewInstance(IMateriauxBib.class);
					mxBib.setTva(tva1);
					mxBib.setDescriptif(binDescriptif1);
					mxBib.setDescriptionCommerciale(binDescriptifCommercial1);
					mxBib.setDescriptionTechnique(binDescriptifTechnique1);
					mxBib.setNotes(binNote1);
					mxBib.setBarCode(BIB_MX_BAR_CODE_1);
					mxBib.setBenefice(BIB_MX_BENEFICE_1);
					mxBib.setCode(BIB_MX_CODE_1);
					mxBib.setFraisGeneraux(BIB_MX_FRAIS_GENRERAUX_1);
					mxBib.setImage(img1);
					mxBib.setMotCle(BIB_MX_MOT_CLE_1);
					mxBib.setNumSerie(BIB_MX_NUM_SERIE_1);
					mxBib.setPrixAchatUnitaire(BIB_MX_PRIX_ACHAT_1);
					mxBib.setUnite(BIB_MX_UNITE_1);
					mxBib.setFamille(fam1);
					mxBib.setRemise(BIB_MX_REMISE_1);
					mxBib.setFournisseurDefaut(four1);
					mxBib.setPrixTarif(BIB_MX_PRIX_TARIF_1);
					List<IFournisseurMateriaux> listFrnMx = new ArrayList<>();
					listFrnMx.add(frnbMx);
					mxBib.setListFournisseurMateriaux(listFrnMx);
					IMateriauxBibManager mxbibmng = app.getMateriauxBibManager();
					mxBib = mxbibmng.saveLigne(mxBib);
				}
			}

			IMateriauxBib mxBib = null;
			for (int i = 0; i < NB_MATERIAUX; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				// /////////
				// Mx Bib
				mxBib = factory.createNewInstance(IMateriauxBib.class);
				mxBib.setTva(tva1);
				mxBib.setDescriptif(binDescriptif1);
				mxBib.setDescriptionCommerciale(binDescriptifCommercial1);
				mxBib.setDescriptionTechnique(binDescriptifTechnique1);
				mxBib.setNotes(binNote1);
				mxBib.setBarCode(BIB_MX_BAR_CODE_1);
				mxBib.setBenefice(BIB_MX_BENEFICE_1);
				mxBib.setCode(BIB_MX_CODE_1);
				mxBib.setFraisGeneraux(BIB_MX_FRAIS_GENRERAUX_1);
				mxBib.setImage(img1);
				mxBib.setMotCle(BIB_MX_MOT_CLE_1);
				mxBib.setNumSerie(BIB_MX_NUM_SERIE_1);
				mxBib.setPrixAchatUnitaire(BIB_MX_PRIX_ACHAT_1);
				mxBib.setUnite(BIB_MX_UNITE_1);
				mxBib.setFamille(fam1);
				mxBib.setRemise(BIB_MX_REMISE_1);
				mxBib.setFournisseurDefaut(four1);
				mxBib.setPrixTarif(BIB_MX_PRIX_TARIF_1);
				IMateriauxBibManager mxbibmng = app.getMateriauxBibManager();
				mxBib = mxbibmng.saveLigne(mxBib);
			}
			// /////////
			// Autre Bib
			// //////////
			// -> Mx
			// -> Mo
			// -> Engin
			// -> SousTraitant
			// -> Lot
			// ----> SousTraitant
			// -> Tache
			// ----> Engin
			// ----> Mo
			// //////////
			IMainOeuvreBib moBib = null;
			for (int i = 0; i < NB_MAIN_OEUVRE; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				moBib = factory.createNewInstance(IMainOeuvreBib.class);
				moBib.setTva(tva1);
				moBib.setDescriptif(binDescriptif1);
				moBib.setDescriptionCommerciale(binDescriptifCommercial1);
				moBib.setDescriptionTechnique(binDescriptifTechnique1);
				moBib.setNotes(binNote1);
				moBib.setBarCode(BIB_MO_BAR_CODE_1);
				moBib.setBenefice(BIB_MO_BENEFICE_1);
				moBib.setCode(BIB_MO_CODE_1);
				moBib.setFraisGeneraux(BIB_MO_FRAIS_GENRERAUX_1);
				moBib.setImage(img1);
				moBib.setMotCle(BIB_MO_MOT_CLE_1);
				moBib.setNumSerie(BIB_MO_NUM_SERIE_1);
				moBib.setPrixAchatUnitaire(BIB_MO_PRIX_ACHAT_1);
				moBib.setUnite(BIB_MO_UNITE_1);
				moBib.setFamille(fam1);
				moBib.setQuantite(BIB_MO_QUANTITE_1);
				moBib = app.getMainOeuvreBibManager().saveLigne(moBib);
			}

			IEnginBib engBib = null;
			for (int i = 0; i < NB_ENGIN; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				engBib = factory.createNewInstance(IEnginBib.class);
				engBib.setTva(tva1);
				engBib.setDescriptif(binDescriptif1);
				engBib.setDescriptionCommerciale(binDescriptifCommercial1);
				engBib.setDescriptionTechnique(binDescriptifTechnique1);
				engBib.setNotes(binNote1);
				engBib.setBarCode(BIB_ENG_BAR_CODE_1);
				engBib.setBenefice(BIB_ENG_BENEFICE_1);
				engBib.setCode(BIB_ENG_CODE_1);
				engBib.setFraisGeneraux(BIB_ENG_FRAIS_GENERAUX_1);
				engBib.setImage(img1);
				engBib.setMotCle(BIB_ENG_MOT_CLE_1);
				engBib.setNumSerie(BIB_ENG_NUM_SERIE_1);
				engBib.setPrixAchatUnitaire(BIB_ENG_PRIX_ACHAT_1);
				engBib.setUnite(BIB_ENG_UNITE_1);
				engBib.setFamille(fam1);
				engBib.setQuantite(BIB_ENG_QUANTITE_1);
				engBib.setImmatriculation(BIB_ENG_IMMATRICULATION);
				engBib.setImmatriculationDate(BIB_ENG_IMMATRICULATION_DATE);
				engBib = app.getEnginBibManager().saveLigne(engBib);
			}

			ISousTraitantBib sstBib = null;
			for (int i = 0; i < NB_SOUS_TRAITANT; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				sstBib = factory.createNewInstance(ISousTraitantBib.class);
				sstBib.setTva(tva1);
				sstBib.setDescriptif(binDescriptif1);
				sstBib.setDescriptionCommerciale(binDescriptifCommercial1);
				sstBib.setDescriptionTechnique(binDescriptifTechnique1);
				sstBib.setNotes(binNote1);
				sstBib.setBarCode(BIB_SST_BAR_CODE_1);
				sstBib.setBenefice(BIB_SST_BENEFICE_1);
				sstBib.setCode(BIB_SST_CODE_1);
				sstBib.setFraisGeneraux(BIB_SST_FRAIS_GENRERAUX_1);
				sstBib.setImage(img1);
				sstBib.setMotCle(BIB_SST_MOT_CLE_1);
				sstBib.setNumSerie(BIB_SST_NUM_SERIE_1);
				sstBib.setPrixAchatUnitaire(BIB_SST_PRIX_ACHAT_1);
				sstBib.setUnite(BIB_SST_UNITE_1);
				sstBib.setFamille(fam1);
				sstBib = app.getSousTraitantBibManager().saveLigne(sstBib);
			}

			showArboBib();

			ILotBib lotBib = null;
			for (int i = 0; i < NB_LOT; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				lotBib = factory.createNewInstance(ILotBib.class);
				lotBib.setTva(tva1);
				lotBib.setDescriptif(binDescriptif1);
				lotBib.setDescriptionCommerciale(binDescriptifCommercial1);
				lotBib.setDescriptionTechnique(binDescriptifTechnique1);
				lotBib.setNotes(binNote1);
				lotBib.setCode(BIB_LOT_CODE_1);
				lotBib.setImage(img1);
				lotBib.setMotCle(BIB_LOT_MOT_CLE_1);
				lotBib.setUnite(BIB_LOT_UNITE_1);
				lotBib.setFamille(fam1);
				List<IBibliotheque> listLigneLot = new ArrayList<>();

				for (int j = 0; j < NB_LOT_DETAIL; j++) {
					listLigneLot.add(sstBib.getCloneForImport());
				}

				lotBib.setListLigne(listLigneLot);
				lotBib = app.getLotBibManager().saveLigne(lotBib);
			}

			ITacheBib tacBib = null;
			for (int i = 0; i < NB_TACHE; i++) {
				// Bib binaire - image
				IBinaire binDescriptif1 = factory.createNewInstance(IBinaire.class);
				binDescriptif1.setObjet(BIN_BIB_DESCRIPTIF_OBJECT_1);
				binDescriptif1 = binaireMng.save(binDescriptif1);

				IBinaire binDescriptifCommercial1 = factory.createNewInstance(IBinaire.class);
				binDescriptifCommercial1.setObjet(BIN_BIB_DESCRIPTIF_COMMERCIAL_OBJECT_1);
				binDescriptifCommercial1 = binaireMng.save(binDescriptifCommercial1);

				IBinaire binDescriptifTechnique1 = factory.createNewInstance(IBinaire.class);
				binDescriptifTechnique1.setObjet(BIN_BIB_DESCRIPTIF_TECHNIQUE_OBJECT_1);
				binDescriptifTechnique1 = binaireMng.save(binDescriptifTechnique1);

				IBinaire binNote1 = factory.createNewInstance(IBinaire.class);
				binNote1.setObjet(BIN_BIB_NOTES_OBJECT_1);
				binNote1 = binaireMng.save(binNote1);

				IImage img1 = factory.createNewInstance(IImage.class);
				img1.setObjet(BIN_IMAGE_OBJECT_1);
				IImageManager imgMng = app.getImageManager();
				img1 = imgMng.save(img1);

				tacBib = factory.createNewInstance(ITacheBib.class);
				tacBib.setTva(tva1);
				tacBib.setDescriptif(binDescriptif1);
				tacBib.setDescriptionCommerciale(binDescriptifCommercial1);
				tacBib.setDescriptionTechnique(binDescriptifTechnique1);
				tacBib.setNotes(binNote1);
				tacBib.setBarCode(BIB_TAC_BAR_CODE_1);
				tacBib.setBenefice(BIB_TAC_BENEFICE_1);
				tacBib.setCode(BIB_TAC_CODE_1);
				tacBib.setFraisGeneraux(BIB_TAC_FRAIS_GENERAUX_1);
				tacBib.setImage(img1);
				tacBib.setMotCle(BIB_TAC_MOT_CLE_1);
				tacBib.setNumSerie(BIB_TAC_NUM_SERIE_1);
				tacBib.setPrixAchatUnitaire(BIB_TAC_PRIX_ACHAT_1);
				tacBib.setUnite(BIB_TAC_UNITE_1);
				tacBib.setQuantite(BIB_TAC_QUANTITE_1);
				tacBib.setFamille(fam1);
				tacBib.setPrixVenteFixe(BIB_TAC_PRIX_VENTE_FIXE_1);
				tacBib.setFraisGenerauxEng(BIB_TAC_FRAIS_GENRERAUX_ENG_1);
				tacBib.setFraisGenerauxMo(BIB_TAC_FRAIS_GENRERAUX_MO_1);
				tacBib.setFraisGenerauxMx(BIB_TAC_FRAIS_GENRERAUX_MX_1);
				tacBib.setFraisGenerauxSt(BIB_TAC_FRAIS_GENRERAUX_SST_1);
				tacBib.setBeneficeEng(BIB_TAC_BENEFICE_ENG_1);
				tacBib.setBeneficeMo(BIB_TAC_BENEFICE_MO_1);
				tacBib.setBeneficeMx(BIB_TAC_BENEFICE_MX_1);
				tacBib.setBeneficeSt(BIB_TAC_BENEFICE_SST_1);
				List<IBibliotheque> listLigneTache = new ArrayList<>();

				for (int j = 0; j < NB_TACHE_DETAIL; j++) {
					listLigneTache.add(engBib.getCloneForImport());
				}

				tacBib.setListLigne(listLigneTache);
				tacBib = app.getTacheBibManager().saveLigne(tacBib);
			}

			// ////////
			// Affaire : Règlement - mode de paiement
			IModePaiement modePaiement1 = null;
			for (int i = 0; i < NB_MODE_PAIEMENT; i++) {
				modePaiement1 = factory.createNewInstance(IModePaiement.class);
				modePaiement1.setLibelle(MODE_PAIEMENT_LIBELLE);
				IModePaiementManager modePaiementMng = app.getModePaiementManager();
				modePaiement1 = modePaiementMng.save(modePaiement1);
			}

			IReglement reglement1 = null;
			for (int i = 0; i < NB_REGLEMENT; i++) {
				reglement1 = factory.createNewInstance(IReglement.class);
				reglement1.setBanque(REGLEMENT_BANQUE);
				reglement1.setCode(REGLEMENT_CODE);
				reglement1.setDatePaiement(REGLEMENT_DATE_PAIEMENT);
				reglement1.setDescriptif(REGLEMENT_DESCRIPTIF);
				reglement1.setNumCheque(REGLEMENT_NUM_CHEQUE);
				reglement1.setModePaiement(modePaiement1);
				IReglementManager rgltMng = app.getReglementManager();
				reglement1 = rgltMng.save(reglement1);
			}

			// ////////
			// Clients
			IClient client1 = null;
			for (int i = 0; i < NB_CLIENT; i++) {
				// Contact binaire
				IBinaire binRappelMotif1 = factory.createNewInstance(IBinaire.class);
				binRappelMotif1.setObjet(BIN_CONTACT_RAPPEL_MOTIF_OBJECT_1);
				binRappelMotif1 = binaireMng.save(binRappelMotif1);

				IBinaire binRemarques1 = factory.createNewInstance(IBinaire.class);
				binRemarques1.setObjet(BIN_CONTACT_REMARQUES_OBJECT_1);
				binRemarques1 = binaireMng.save(binRemarques1);

				// /////////
				// CoordonneeCnt
				ICoordonneeCnt coo1 = factory.createNewInstance(ICoordonneeCnt.class);
				coo1.setCivilite(civ1);
				coo1.setComplementaire(COO_COMPLEMENTAIRE_1);
				coo1.setCp(COO_CP_1);
				coo1.setFax(COO_FAX_1);
				coo1.setLocalisation(loc1);
				coo1.setMail(COO_MAIL_1);
				coo1.setMail2(COO_MAIL2_1);
				coo1.setMobile(COO_MOBILE_1);
				coo1.setNom(COO_NOM_1);
				coo1.setPays(pays1);
				coo1.setPrenom(COO_PRENOM_1);
				coo1.setRue(COO_RUE_1);
				coo1.setTel1(COO_TEL_1);
				coo1.setTel2(COO_TEL2_1);
				coo1.setVille(COO_VILLE_1);
				coo1.setWeb(COO_WEB_1);
				coo1 = app.getCoordonneeCntManager().save(coo1);

				client1 = factory.createNewInstance(IClient.class);
				client1.setActivite(act1);
				client1.setCategorie(cat1);
				client1.setCode(CLIENT_CODE_1);
				client1.setCodeNaf(CLIENT_CODE_NAF_1);
				client1.setCoordonnee(coo1);
				client1.setHide(CLIENT_HIDE_1);
				client1.setNomSociete(CLIENT_NOM_SOCIETE_1);
				client1.setRappelDate(CLIENT_RAPPEL_DATE_1);
				client1.setRappelMotif(binRappelMotif1);
				client1.setRemarques(binRemarques1);
				client1.setSiren(CLIENT_SIREN_1);
				client1.setTvaIntra(CLIENT_TVA_INTRA_1);
				client1.setProspect(CLIENT_PROSPECT_1);
				client1.setMontantPlafond(CLIENT_MONTANT_PLAFOND_1);
				client1 = app.getClientManager().save(client1);

				// ////////
				// Affaires - binaire
				IBinaire binAffConclusion1 = factory.createNewInstance(IBinaire.class);
				binAffConclusion1.setObjet(BIN_AFFAIRE_CONCLUSION_OBJECT_1);
				binAffConclusion1 = binaireMng.save(binAffConclusion1);

				IBinaire binAffDescriptif1 = factory.createNewInstance(IBinaire.class);
				binAffDescriptif1.setObjet(BIN_AFFAIRE_DESCRIPTIF_OBJECT_1);
				binAffDescriptif1 = binaireMng.save(binAffDescriptif1);

				IBinaire binAffIntroduction1 = factory.createNewInstance(IBinaire.class);
				binAffIntroduction1.setObjet(BIN_AFFAIRE_INTRODUCTION_OBJECT_1);
				binAffIntroduction1 = binaireMng.save(binAffIntroduction1);

				IBinaire binAffMetre1 = factory.createNewInstance(IBinaire.class);
				binAffMetre1.setObjet(BIN_AFFAIRE_METRE_OBJECT_1);
				binAffMetre1 = binaireMng.save(binAffMetre1);

				IBinaire binAffNotes1 = factory.createNewInstance(IBinaire.class);
				binAffNotes1.setObjet(BIN_AFFAIRE_NOTES_OBJECT_1);
				binAffNotes1 = binaireMng.save(binAffNotes1);

				// Affaires - Devis
				IDevis dev1 = null;
				for (int j = 0; j < NB_DEVIS_PAR_CLIENT; j++) {
					dev1 = factory.createNewInstance(IDevis.class);
					dev1.setChantier(cht1);
					dev1.setClient(client1);
					dev1.setCode(DEVIS_CODE_1);
					dev1.setConclusion(binAffConclusion1);
					dev1.setDateCloture(DEVIS_DATE_CLOTURE_1);
					dev1.setDateDebTravaux(DEVIS_DATE_DEB_TRAVAUX_1);
					dev1.setDateFinTravaux(DEVIS_DATE_FIN_TRAVAUX_1);
					dev1.setDescriptif(binAffDescriptif1);
					dev1.setDureeValidite(DEVIS_DUREE_VALIDITE_1);
					dev1.setEtat(etat1);
					dev1.setIntroduction(binAffIntroduction1);
					dev1.setMetre(binAffMetre1);
					dev1.setNotes(binAffNotes1);
					dev1.setReference(DEVIS_REFERENCE_1);
					dev1.setTermine(DEVIS_TERMINE_1);
					dev1.setValide(DEVIS_VALIDE_1);
					dev1 = app.getDevisManager().save(dev1);

					// Affaires - Devis - Etude
					for (int k = 0; k < NB_ETUDE_PAR_DEVIS; k++) {
						IEtude etude4 = factory.createNewInstanceEtude(dev1);
						List<IBibEltEtude> listBibtoDevis1Etude = factory.createNewListInstance(IBibEltEtude.class);
						for (int l = 0; l < NB_MATERIAUX_PAR_ETUDE_PAR_DEVIS; l++) {
							IMateriauxEtude mxDevisEtude1 = mxBib.getCloneForImport(IMateriauxEtude.class);
							mxDevisEtude1.setCode(BIB_MX_ETUDE_CODE_1);
							listBibtoDevis1Etude.add(mxDevisEtude1);
						}
						etude4.setListBibliotheque(listBibtoDevis1Etude);
						etude4 = app.getEtudeManager().save(etude4);
					}
				}

				// Affaires - Facture
				IFacture facture1 = null;
				for (int j = 0; j < NB_FACTURE_PAR_CLIENT; j++) {
					facture1 = factory.createNewInstanceAffaire(IFacture.class, dev1);
					facture1.setChantier(cht1);
					facture1.setClient(client1);
					facture1.setCode(FACTURE_CODE_1);
					facture1.setConclusion(binAffConclusion1);
					facture1.setDateCloture(FACTURE_DATE_CLOTURE_1);
					facture1.setDateDebTravaux(FACTURE_DATE_DEB_TRAVAUX_1);
					facture1.setDateFinTravaux(FACTURE_DATE_FIN_TRAVAUX_1);
					facture1.setDescriptif(binAffDescriptif1);
					facture1.setDureeValidite(FACTURE_DUREE_VALIDITE_1);
					facture1.setEtat(etat1);
					facture1.setIntroduction(binAffIntroduction1);
					facture1.setMetre(binAffMetre1);
					facture1.setNotes(binAffNotes1);
					facture1.setReference(FACTURE_REFERENCE_1);
					facture1.setTermine(FACTURE_TERMINE_1);
					facture1.setValide(FACTURE_VALIDE_1);
					facture1 = app.getFactureManager().save(facture1);

					// Affaires - Facture - Echeancier
					IEcheancier echeancierFacture = factory.createNewInstanceEcheancier(facture1);
					echeancierFacture = app.getEcheancierManager().save(echeancierFacture);

					// EcheancierReglement
					IEcheancierReglement echRegltFacture1 = factory.createNewInstanceEcheancierReglement(echeancierFacture, reglement1);
					echRegltFacture1.setMontant(ECHEANCIER_REGLEMENT_MONTANT_2);
					IEcheancierReglementManager echRegltMng = app.getEcheancierReglementManager();
					echRegltFacture1 = echRegltMng.save(echRegltFacture1);
				}

				// Affaires - Situation
				ISituation situation1 = null;
				for (int j = 0; j < NB_SITUATION_PAR_CLIENT; j++) {
					situation1 = factory.createNewInstanceAffaire(ISituation.class, dev1);
					situation1.setChantier(cht1);
					situation1.setClient(client1);
					situation1.setCode(SITUATION_CODE_1);
					situation1.setConclusion(binAffConclusion1);
					situation1.setDateCloture(SITUATION_DATE_CLOTURE_1);
					situation1.setDateDebTravaux(SITUATION_DATE_DEB_TRAVAUX_1);
					situation1.setDateFinTravaux(SITUATION_DATE_FIN_TRAVAUX_1);
					situation1.setDescriptif(binAffDescriptif1);
					situation1.setDureeValidite(SITUATION_DUREE_VALIDITE_1);
					situation1.setEtat(etat1);
					situation1.setIntroduction(binAffIntroduction1);
					situation1.setMetre(binAffMetre1);
					situation1.setNotes(binAffNotes1);
					situation1.setReference(SITUATION_REFERENCE_1);
					situation1.setTermine(SITUATION_TERMINE_1);
					situation1.setValide(SITUATION_VALIDE_1);
					situation1 = app.getSituationManager().save(situation1);
				}

				// Affaires - Avoir
				IAvoir avoir1 = null;
				for (int j = 0; j < NB_AVOIR_PAR_CLIENT; j++) {
					avoir1 = factory.createNewInstanceAffaire(IAvoir.class, dev1);
					avoir1.setChantier(cht1);
					avoir1.setClient(client1);
					avoir1.setCode(AVOIR_CODE_1);
					avoir1.setConclusion(binAffConclusion1);
					avoir1.setDateCloture(AVOIR_DATE_CLOTURE_1);
					avoir1.setDateDebTravaux(AVOIR_DATE_DEB_TRAVAUX_1);
					avoir1.setDateFinTravaux(AVOIR_DATE_FIN_TRAVAUX_1);
					avoir1.setDescriptif(binAffDescriptif1);
					avoir1.setDureeValidite(AVOIR_DUREE_VALIDITE_1);
					avoir1.setEtat(etat1);
					avoir1.setIntroduction(binAffIntroduction1);
					avoir1.setMetre(binAffMetre1);
					avoir1.setNotes(binAffNotes1);
					avoir1.setReference(AVOIR_REFERENCE_1);
					avoir1.setTermine(AVOIR_TERMINE_1);
					avoir1.setValide(AVOIR_VALIDE_1);
					avoir1.setFacture(facture1);
					avoir1 = app.getAvoirManager().save(avoir1);
				}

				// Affaires - Acompte
				IAcompte acompte1 = null;
				for (int j = 0; j < NB_ACOMPTE_PAR_CLIENT; j++) {
					acompte1 = factory.createNewInstanceAffaire(IAcompte.class, dev1);
					acompte1.setChantier(cht1);
					acompte1.setCode(ACOMPTE_CODE_1);
					acompte1.setConclusion(binAffConclusion1);
					acompte1.setDateCloture(ACOMPTE_DATE_CLOTURE_1);
					acompte1.setDateDebTravaux(ACOMPTE_DATE_DEB_TRAVAUX_1);
					acompte1.setDateFinTravaux(ACOMPTE_DATE_FIN_TRAVAUX_1);
					acompte1.setDescriptif(binAffDescriptif1);
					acompte1.setDureeValidite(ACOMPTE_DUREE_VALIDITE_1);
					acompte1.setEtat(etat1);
					acompte1.setIntroduction(binAffIntroduction1);
					acompte1.setMetre(binAffMetre1);
					acompte1.setNotes(binAffNotes1);
					acompte1.setReference(ACOMPTE_REFERENCE_1);
					acompte1.setTermine(ACOMPTE_TERMINE_1);
					acompte1.setValide(ACOMPTE_VALIDE_1);
					acompte1 = app.getAcompteManager().save(acompte1);
				}
			}

			// ////////
			// Groupe contact
			IGroupeCnt groupeCnt1 = null;
			for (int i = 0; i < NB_GROUPE_CONTACT; i++) {
				groupeCnt1 = factory.createNewInstance(IGroupeCnt.class);
				groupeCnt1.setLibelle(GROUPE_CNT_LIBELLE_1);
				groupeCnt1 = app.getGroupeCntManager().save(groupeCnt1);
			}

			// Divers Contact
			IDiversCnt diversCnt1 = null;
			for (int i = 0; i < NB_DIVERS_CONTACT; i++) {
				// Contact binaire
				IBinaire binRappelMotif1 = factory.createNewInstance(IBinaire.class);
				binRappelMotif1.setObjet(BIN_CONTACT_RAPPEL_MOTIF_OBJECT_1);
				binRappelMotif1 = binaireMng.save(binRappelMotif1);

				IBinaire binRemarques1 = factory.createNewInstance(IBinaire.class);
				binRemarques1.setObjet(BIN_CONTACT_REMARQUES_OBJECT_1);
				binRemarques1 = binaireMng.save(binRemarques1);

				// /////////
				// CoordonneeCnt
				ICoordonneeCnt coo1 = factory.createNewInstance(ICoordonneeCnt.class);
				coo1.setCivilite(civ1);
				coo1.setComplementaire(COO_COMPLEMENTAIRE_1);
				coo1.setCp(COO_CP_1);
				coo1.setFax(COO_FAX_1);
				coo1.setLocalisation(loc1);
				coo1.setMail(COO_MAIL_1);
				coo1.setMail2(COO_MAIL2_1);
				coo1.setMobile(COO_MOBILE_1);
				coo1.setNom(COO_NOM_1);
				coo1.setPays(pays1);
				coo1.setPrenom(COO_PRENOM_1);
				coo1.setRue(COO_RUE_1);
				coo1.setTel1(COO_TEL_1);
				coo1.setTel2(COO_TEL2_1);
				coo1.setVille(COO_VILLE_1);
				coo1.setWeb(COO_WEB_1);
				coo1 = app.getCoordonneeCntManager().save(coo1);

				diversCnt1 = factory.createNewInstance(IDiversCnt.class);
				diversCnt1.setActivite(act1);
				diversCnt1.setCategorie(cat1);
				diversCnt1.setCode(DIV_CNT_CODE_1);
				diversCnt1.setCodeNaf(DIV_CNT_CODE_NAF_1);
				diversCnt1.setCoordonnee(coo1);
				diversCnt1.setHide(DIV_CNT_HIDE_1);
				diversCnt1.setNomSociete(DIV_CNT_NOM_SOCIETE_1);
				diversCnt1.setRappelDate(DIV_CNT_RAPPEL_DATE_1);
				diversCnt1.setRappelMotif(binRappelMotif1);
				diversCnt1.setRemarques(binRemarques1);
				diversCnt1.setSiren(DIV_CNT_SIREN_1);
				diversCnt1.setTvaIntra(DIV_CNT_TVA_INTRA_1);
				List<IGroupeCnt> listGrpCntDiversCnt1 = factory.createNewListInstance(IGroupeCnt.class);
				listGrpCntDiversCnt1.add(groupeCnt1);
				diversCnt1.setListGroupeContact(listGrpCntDiversCnt1);
				diversCnt1 = app.getDiversCntManager().save(diversCnt1);
			}

			if (isBeginTransaction) {
				commitTransaction();
			}
		} catch (WebbatiException e) {
			rollbackTransaction();
			LOGGER.error("testAdd", e);
			throw e;
		} finally {
			closeTransaction();
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void testGetListEjb() throws Exception {
		/*
		// //////////
		// La 1ère requête est longue
		app.getTvaManager().getList();

		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();
		Transaction trans = session.beginTransaction();
		try {
			Criteria crit = session.createCriteria(EnginBib.class).add(Restrictions.eq("niveau", 1));
			//.add(Restrictions.eq("superParentId", 184240)).add(Restrictions.gt("borneGauche", 0)).add(Restrictions.lt("borneDroite", 3722))

			crit.setMaxResults(100);

			StopWatch clockSpecific = null;
			long duree = 0;

			// //////////////////////////////
			// Start clock
			clockSpecific = new StopWatch(getClass().getName());
			clockSpecific.start("Specif");

			crit.list();

			// Stop clock
			clockSpecific.stop();
			duree = clockSpecific.getLastTaskTimeMillis();
			System.out.println("\n ======> Temps d'execution 0 : global : running time (millis) = " + duree + " <======\n");

			// //////////////////////////////
			// Start clock
			clockSpecific = new StopWatch(getClass().getName());
			clockSpecific.start("Specif");

			List<EnginBib> list1 = crit.list();
			List<EnginBibImpl> listMetier1 = MyBeanUtils.getInstance().copyPropertiesEJBList(EnginBibImpl.class, list1);
			// List<IFamille> listMetier2 = new ArrayList<IFamille>();
			// listMetier2.addAll(listMetier1);

			// Stop clock
			clockSpecific.stop();
			duree = clockSpecific.getLastTaskTimeMillis();
			System.out.println("\n ======> Temps d'execution 1 : global : running time (millis) = " + duree + " <======\n");

			// //////////////////////////////
			// Start clock
			clockSpecific = new StopWatch(getClass().getName());
			clockSpecific.start("Specif");

			app.getEnginBibManager().getList();

			// Stop clock
			clockSpecific.stop();
			duree = clockSpecific.getLastTaskTimeMillis();
			System.out.println("\n ======> Temps d'execution 3 : global : running time (millis) = " + duree + " <======\n");
		} catch (Exception e) {
			// trans.rollback();
			throw e;
		} finally {
			session.close();
		}
		*/
	}

	/**
	 * Teste la durée d'exécution des listes
	 * 
	 * @throws WebbatiException
	 */
	private void testGetList() throws WebbatiException {

		// //////////
		// La 1ère requête est longue
		app.getTvaManager().getList();

		// /////////
		// Objets divers
		startTimer();
		app.getTvaManager().getList();
		assertTimer(TIMER_MAX_TVA);

		startTimer();
		app.getFamilleManager().getList();
		assertTimer(TIMER_MAX_FAMILLE);

		IFamilleManager familleMng = app.getFamilleManager();
		List<IFamille> listFamille = familleMng.getList();
		Assert.assertNotNull(listFamille);
		IFamille famille1 = null;
		for (IFamille fam : listFamille) {
			if (FAMILLE_DESC_1.equals(fam.getDescriptif())) {
				famille1 = fam;
			}
		}
		Assert.assertNotNull(famille1);
		startTimer();
		famille1 = familleMng.getWithChildren(famille1);
		assertTimer(TIMER_MAX_FAMILLE_GET_CHILDREN);
		Assert.assertNotNull(famille1);
		IFamille famille11 = famille1.getListLigne().get(0);
		Assert.assertEquals(FAMILLE_DESC_11, famille11.getDescriptif());

		startTimer();
		app.getPaysManager().getList();
		assertTimer(TIMER_MAX_PAYS);

		startTimer();
		app.getLocalisationManager().getList();
		assertTimer(TIMER_MAX_LOCALISATION);

		startTimer();
		app.getActiviteManager().getList();
		assertTimer(TIMER_MAX_ACTIVITE);

		startTimer();
		app.getCategorieManager().getList();
		assertTimer(TIMER_MAX_CATEGORIE);

		startTimer();
		app.getChantierManager().getList();
		assertTimer(TIMER_MAX_CHANTIER);

		startTimer();
		app.getEtatManager().getList();
		assertTimer(TIMER_MAX_ETAT);

		startTimer();
		app.getCiviliteManager().getList();
		assertTimer(TIMER_MAX_CIVILITE);

		startTimer();
		app.getModePaiementManager().getList();
		assertTimer(TIMER_MAX_MODE_PAIEMENT);

		// /////////
		// Fournisseur
		startTimer();
		app.getFournisseurManager().getList();
		assertTimer(TIMER_MAX_FOURNISSEUR);

		IFournisseurManager fourMng = app.getFournisseurManager();
		IFournisseur four1 = null;
		for (IFournisseur obj : fourMng.getList()) {
			if (FOUR_CODE_1.equals(obj.getCode())) {
				four1 = obj;
			}
		}
		Assert.assertNotNull(four1);
		// Fournisseur Materiaux
		startTimer();
		four1.getListFournisseurMateriaux();
		assertTimer(TIMER_MAX_FOURNISSEUR_MATERIAUX);

		// /////////
		// Bib
		// Mx Bib
		showArboBib();
		startTimer();
		app.getMateriauxBibManager().getList();
		assertTimer(TIMER_MAX_MATERIAUX);
		IMateriauxBibManager mxbibMng = app.getMateriauxBibManager();
		IMateriauxBib mxBib1 = null;
		for (IMateriauxBib obj : mxbibMng.getList()) {
			if (BIB_MX_CODE_1.equals(obj.getCode())) {
				mxBib1 = obj;
			}
		}
		mxBib1 = mxbibMng.getWithChildren(mxBib1);
		Assert.assertNotNull(mxBib1);
		// Fournisseur Materiaux
		startTimer();
		mxBib1.getListFournisseurMateriaux();
		assertTimer(TIMER_MAX_FOURNISSEUR_MATERIAUX);

		startTimer();
		app.getMateriauxBibManager().getListTacheParente(mxBib1);
		assertTimer(TIMER_MAX_GET_LIST_TACHES_PARENTE);

		// MainOeuvre Bib
		startTimer();
		app.getMainOeuvreBibManager().getList();
		assertTimer(TIMER_MAX_MAIN_OEUVRE);

		// Engin Bib
		startTimer();
		app.getEnginBibManager().getList();
		assertTimer(TIMER_MAX_ENGIN);

		// SousTraitant Bib
		startTimer();
		app.getSousTraitantBibManager().getList();
		assertTimer(TIMER_MAX_SOUS_TRAITANT);

		showArboBib();

		// Lot Bib
		ILotBibManager lotBibMng = app.getLotBibManager();
		startTimer();
		lotBibMng.getList();
		assertTimer(TIMER_MAX_LOT);
		ILotBib lotBib1 = null;
		for (ILotBib obj : lotBibMng.getList()) {
			if (BIB_LOT_CODE_1.equals(obj.getCode())) {
				lotBib1 = obj;
			}
		}
		lotBib1 = lotBibMng.getWithChildren(lotBib1);
		Assert.assertNotNull(lotBib1);
		startTimer();
		lotBib1.getListLigne();
		assertTimer(TIMER_MAX_LOT_DETAIL);

		// Tache Bib
		ITacheBibManager tacBibMng = app.getTacheBibManager();
		startTimer();
		tacBibMng.getList();
		assertTimer(TIMER_MAX_TACHE);
		ITacheBib tacBib1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_1.equals(obj.getCode())) {
				tacBib1 = obj;
			}
		}
		tacBib1 = tacBibMng.getWithChildren(tacBib1);
		Assert.assertNotNull(tacBib1);
		startTimer();
		tacBib1.getListLigne();
		assertTimer(TIMER_MAX_TACHE_DETAIL);
		Assert.assertTrue(!tacBib1.getListLigne().isEmpty());
		IEnginBib engBibTac1 = (IEnginBib) tacBib1.getListLigne().get(0);
		startTimer();
		app.getEnginBibManager().getListTacheParente(engBibTac1);
		assertTimer(TIMER_MAX_GET_LIST_TACHES_PARENTE);

		// ////////
		// Affaires - Devis - Liste étude
		startTimer();
		app.getDevisManager().getList();
		assertTimer(TIMER_MAX_DEVIS);
		IDevis devis1 = null;
		for (IDevis obj : app.getDevisManager().getList()) {
			if (DEVIS_CODE_1.equals(obj.getCode())) {
				devis1 = obj;
			}
		}
		Assert.assertNotNull(devis1);
		startTimer();
		List<IEtude> listeEtudeDevis1 = devis1.getListEtude();
		assertTimer(TIMER_MAX_DEVIS_ETUDE);
		for (IEtude etude : listeEtudeDevis1) {
			startTimer();
			etude.getListBibliotheque();
			assertTimer(TIMER_MAX_DEVIS_ETUDE_MATERIAUX);
		}

		// Affaire Facture : Liste étude
		startTimer();
		app.getFactureManager().getList();
		assertTimer(TIMER_MAX_FACTURE);

		// Affaires - Situation
		startTimer();
		app.getSituationManager().getList();
		assertTimer(TIMER_MAX_SITUATION);

		// Affaires - Avoir
		startTimer();
		app.getAvoirManager().getList();
		assertTimer(TIMER_MAX_AVOIR);

		// Affaires - Acompte
		startTimer();
		app.getAcompteManager().getList();
		assertTimer(TIMER_MAX_ACOMPTE);

		// //////////
		// Reglement - EchancierReglement
		startTimer();
		app.getReglementManager().getList();
		assertTimer(TIMER_MAX_REGLEMENT);

		// ////////
		// Clients avec liste affaires
		IClientManager clientMng = app.getClientManager();
		startTimer();
		clientMng.getList();
		assertTimer(TIMER_MAX_CLIENT);
		IClient client1 = null;
		for (IClient obj : clientMng.getList()) {
			if (CLIENT_CODE_1.equals(obj.getCode())) {
				client1 = obj;
			}
		}
		Assert.assertNotNull(client1);
		startTimer();
		client1.getListAffaire();
		assertTimer(TIMER_MAX_CLIENT_AFFAIRE);

		// Divers Contact
		startTimer();
		app.getDiversCntManager().getList();
		assertTimer(TIMER_MAX_DIVERS_CONTACT);

		// Groupe Contact
		startTimer();
		app.getGroupeCntManager().getList();
		assertTimer(TIMER_MAX_GROUPE_CONTACT);
	}

	private void testDeleteAll() throws WebbatiException {
		// beginTransaction();
		try {
			app.getFournisseurMateriauxManager().deleteAll();

			app.getMateriauxBibManager().deleteAll();
			Assert.assertEquals(0, app.getMateriauxBibManager().getList().size());
			app.getMainOeuvreBibManager().deleteAll();
			Assert.assertEquals(0, app.getMainOeuvreBibManager().getList().size());
			app.getEnginBibManager().deleteAll();
			Assert.assertEquals(0, app.getEnginBibManager().getList().size());
			app.getSousTraitantBibManager().deleteAll();
			Assert.assertEquals(0, app.getSousTraitantBibManager().getList().size());
			app.getTacheBibManager().deleteAll();
			Assert.assertEquals(0, app.getTacheBibManager().getList().size());
			app.getLotBibManager().deleteAll();
			Assert.assertEquals(0, app.getLotBibManager().getList().size());

			app.getEtudeManager().deleteAll();
			Assert.assertEquals(0, app.getEtudeManager().getList().size());

			app.getFamilleManager().deleteAll();
			Assert.assertEquals(0, app.getFamilleManager().getList().size());
			app.getTvaManager().deleteAll();
			Assert.assertEquals(0, app.getTvaManager().getList().size());

			app.getEcheancierReglementManager().deleteAll();
			app.getReglementManager().deleteAll();
			Assert.assertEquals(0, app.getReglementManager().getList().size());
			app.getEcheancierManager().deleteAll();
			Assert.assertEquals(0, app.getEcheancierManager().getList().size());
			app.getModePaiementManager().deleteAll();

			app.getAvoirManager().deleteAll();
			app.getFactureManager().deleteAll();
			Assert.assertEquals(0, app.getFactureManager().getList().size());
			app.getSituationManager().deleteAll();
			app.getAcompteManager().deleteAll();
			app.getDevisManager().deleteAll();
			Assert.assertEquals(0, app.getDevisManager().getList().size());

			app.getEtatManager().deleteAll();
			Assert.assertEquals(0, app.getEtatManager().getList().size());

			app.getClientManager().deleteAll();
			Assert.assertEquals(0, app.getClientManager().getList().size());
			app.getFournisseurManager().deleteAll();
			Assert.assertEquals(0, app.getFournisseurManager().getList().size());
			app.getDiversCntManager().deleteAll();

			app.getCoordonneeCntManager().deleteAll();
			app.getGroupeCntManager().deleteAll();

			app.getPaysManager().deleteAll();
			app.getLocalisationManager().deleteAll();
			app.getCiviliteManager().deleteAll();
			app.getActiviteManager().deleteAll();
			app.getCategorieManager().deleteAll();
			Assert.assertEquals(0, app.getCategorieManager().getList().size());

			app.getBinaireManager().deleteAll();
			Assert.assertEquals(0, app.getBinaireManager().getList().size());
			app.getImageManager().deleteAll();
			Assert.assertEquals(0, app.getImageManager().getList().size());

			app.getChantierManager().deleteAll();
			Assert.assertEquals(0, app.getChantierManager().getList().size());

			// throw new WebbatiException("Error pour non commit");

			// commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	/**
	 * -> Mx <br/>
	 * -> Mo <br/>
	 * -> Engin <br/>
	 * -> SousTraitant <br/>
	 * -> Lot <br/>
	 * ----> SousTraitant <br/>
	 * -> Tache <br/>
	 * ----> Engin <br/>
	 */
	private void showArboBib() {
	}

	@Test
	public void manageBeansList() throws WebbatiException {
		// testDeleteAll();

		// testAddAll();

		testGetList();

		// testDeleteAll();
	}

	/*
	@Test
	public void testGetListBoucle() throws WebbatiException {
		for (int i = 0; i < 100; i++) {
			testGetList();
		}
	}*/
}
