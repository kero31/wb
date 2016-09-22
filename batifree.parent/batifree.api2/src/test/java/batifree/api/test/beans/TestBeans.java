package batifree.api.test.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import batifree.api.application.interfaces.IFactoryBf;
import batifree.api.manager.interfaces.IAcompteManager;
import batifree.api.manager.interfaces.IActiviteManager;
import batifree.api.manager.interfaces.IAvoirManager;
import batifree.api.manager.interfaces.IBinaireManager;
import batifree.api.manager.interfaces.ICategorieManager;
import batifree.api.manager.interfaces.IChantierManager;
import batifree.api.manager.interfaces.ICiviliteManager;
import batifree.api.manager.interfaces.IClientManager;
import batifree.api.manager.interfaces.IDevisManager;
import batifree.api.manager.interfaces.IDiversCntManager;
import batifree.api.manager.interfaces.IEcheancierManager;
import batifree.api.manager.interfaces.IEcheancierReglementManager;
import batifree.api.manager.interfaces.IEnginBibManager;
import batifree.api.manager.interfaces.IEtatManager;
import batifree.api.manager.interfaces.IFactureManager;
import batifree.api.manager.interfaces.IFamilleManager;
import batifree.api.manager.interfaces.IFournisseurManager;
import batifree.api.manager.interfaces.IGroupeCntManager;
import batifree.api.manager.interfaces.IImageManager;
import batifree.api.manager.interfaces.ILocalisationManager;
import batifree.api.manager.interfaces.ILotBibManager;
import batifree.api.manager.interfaces.IMainOeuvreBibManager;
import batifree.api.manager.interfaces.IMateriauxBibManager;
import batifree.api.manager.interfaces.IModePaiementManager;
import batifree.api.manager.interfaces.IPaysManager;
import batifree.api.manager.interfaces.IReglementManager;
import batifree.api.manager.interfaces.ISituationManager;
import batifree.api.manager.interfaces.ISousTraitantBibManager;
import batifree.api.manager.interfaces.ITacheBibManager;
import batifree.api.manager.interfaces.ITvaManager;
import batifree.api.metier.interfaces.IAcompte;
import batifree.api.metier.interfaces.IActivite;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IAvoir;
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IBinaire;
import batifree.api.metier.interfaces.ICategorie;
import batifree.api.metier.interfaces.IChantier;
import batifree.api.metier.interfaces.ICivilite;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;
import batifree.api.metier.interfaces.IEtat;
import batifree.api.metier.interfaces.IEtude;
import batifree.api.metier.interfaces.IFacture;
import batifree.api.metier.interfaces.IFamille;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IGroupeCnt;
import batifree.api.metier.interfaces.IImage;
import batifree.api.metier.interfaces.ILocalisation;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;
import batifree.api.metier.interfaces.IModePaiement;
import batifree.api.metier.interfaces.IPays;
import batifree.api.metier.interfaces.IReglement;
import batifree.api.metier.interfaces.ISituation;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;
import batifree.api.metier.interfaces.ITva;
import batifree.api.test.commun.TestCommunBfApi;

import common.api.exception.BatifreeException;

public class TestBeans extends TestCommunBfApi {

	private static final Logger LOGGER = Logger.getLogger(TestBeans.class);

	@SuppressWarnings("unused")
	private void testGetOne() throws BatifreeException {
		ITacheBibManager tacBibMng = app.getTacheBibManager();
		ITacheBib tacBibForUpdateElt1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_1.equals(obj.getCode())) {
				tacBibForUpdateElt1 = obj;
			}
		}
		Assert.assertNotNull(tacBibForUpdateElt1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, tacBibForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, tacBibForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, tacBibForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, tacBibForUpdateElt1.getPrixAchatUnitaire());
		Assert.assertEquals(tacBibForUpdateElt1.getListLigne().size(), 2);
		IEnginBib engBibTacForUpdateElt1 = (IEnginBib) tacBibForUpdateElt1.getListLigne().get(0);
		Assert.assertEquals(BIB_ENG_QUANTITE_1, engBibTacForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_ENG_BENEFICE_1, engBibTacForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_ENG_FRAIS_GENERAUX_1, engBibTacForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_ENG_PRIX_ACHAT_1, engBibTacForUpdateElt1.getPrixAchatUnitaire());
		IMainOeuvreBib moBibTacForUpdateElt1 = (IMainOeuvreBib) tacBibForUpdateElt1.getListLigne().get(1);
		Assert.assertEquals(BIB_MO_QUANTITE_1, moBibTacForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_MO_BENEFICE_1, moBibTacForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_MO_FRAIS_GENRERAUX_1, moBibTacForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_MO_PRIX_ACHAT_1, moBibTacForUpdateElt1.getPrixAchatUnitaire());

		// Met à jour les propriétés sur tous les éléments et ses sous éléments à partir de l'élément passé en paramètre
		tacBibForUpdateElt1 = tacBibMng.getBibEltUpdated(tacBibForUpdateElt1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, tacBibForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, tacBibForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, tacBibForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, tacBibForUpdateElt1.getPrixAchatUnitaire());
		Assert.assertEquals(tacBibForUpdateElt1.getListLigne().size(), 2);
		IEnginBib engBibTacForUpdateElt11 = (IEnginBib) tacBibForUpdateElt1.getListLigne().get(0);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, engBibTacForUpdateElt11.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, engBibTacForUpdateElt11.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, engBibTacForUpdateElt11.getFraisGeneraux());
		Assert.assertEquals(BIB_ENG_PRIX_ACHAT_1, engBibTacForUpdateElt11.getPrixAchatUnitaire());
		IMainOeuvreBib moBibTacForUpdateElt11 = (IMainOeuvreBib) tacBibForUpdateElt1.getListLigne().get(1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, moBibTacForUpdateElt11.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, moBibTacForUpdateElt11.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, moBibTacForUpdateElt11.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, moBibTacForUpdateElt11.getPrixAchatUnitaire());
	}

	private void testGet() throws BatifreeException {

		// /////////
		// Objets divers
		ITvaManager tvaMng = app.getTvaManager();
		List<ITva> listTva = tvaMng.getList();
		Assert.assertNotNull(listTva);
		Assert.assertEquals(listTva.size(), 4);
		ITva tva2 = null;
		for (ITva tva : listTva) {
			if (TVA_LIBELLE_2.equals(tva.getLibelle())) {
				tva2 = tva;
			}
		}
		Assert.assertNotNull(tva2);
		Assert.assertEquals(tva2.getTaux(), TVA_TAUX_2);

		IFamilleManager familleMng = app.getFamilleManager();
		List<IFamille> listFamille = familleMng.getList();
		Assert.assertNotNull(listFamille);
		IFamille famille2 = null;
		for (IFamille fam : listFamille) {
			if (FAMILLE_DESC_2.equals(fam.getDescriptif())) {
				famille2 = fam;
			}
		}
		Assert.assertNotNull(famille2);
		Assert.assertNotNull(famille2);
		Assert.assertEquals(FAMILLE_TYPE_2, famille2.getType());
		Assert.assertEquals(1, famille2.getListLigne().size());
		IFamille famille22 = famille2.getListLigne().get(0);
		Assert.assertEquals(FAMILLE_DESC_22, famille22.getDescriptif());
		Assert.assertEquals(FAMILLE_TYPE_22, famille22.getType());
		Assert.assertNotNull(famille22.getListLigne());
		Assert.assertTrue(famille22.getListLigne().isEmpty());

		IPaysManager paysMng = app.getPaysManager();
		List<IPays> listPays = paysMng.getList();
		Assert.assertNotNull(listPays);
		IPays pays2 = null;
		for (IPays pays : listPays) {
			if (PAYS_LIBELLE_2.equals(pays.getLibelle())) {
				pays2 = pays;
			}
		}
		Assert.assertNotNull(pays2);

		ILocalisationManager localMng = app.getLocalisationManager();
		List<ILocalisation> listLocalisation = localMng.getList();
		Assert.assertNotNull(listLocalisation);
		ILocalisation localisation2 = null;
		for (ILocalisation pays : listLocalisation) {
			if (LOCALISATION_LIBELLE_2.equals(pays.getLibelle())) {
				localisation2 = pays;
			}
		}
		Assert.assertNotNull(localisation2);

		IActiviteManager actMng = app.getActiviteManager();
		IActivite act2 = null;
		for (IActivite obj : actMng.getList()) {
			if (ACTIVITE_LIBELLE_2.equals(obj.getLibelle())) {
				act2 = obj;
			}
		}
		Assert.assertNotNull(act2);

		ICategorieManager categorieMng = app.getCategorieManager();
		ICategorie cat2 = null;
		for (ICategorie obj : categorieMng.getList()) {
			if (CATEGORIE_LIBELLE_2.equals(obj.getLibelle())) {
				cat2 = obj;
			}
		}
		Assert.assertNotNull(cat2);

		IChantierManager chantierMng = app.getChantierManager();
		IChantier cht1 = null;
		for (IChantier obj : chantierMng.getList()) {
			cht1 = obj;
		}
		Assert.assertNotNull(cht1);

		IEtatManager etatMng = app.getEtatManager();
		IEtat etat2 = null;
		for (IEtat obj : etatMng.getList()) {
			if (ETAT_LIBELLE_2.equals(obj.getLibelle())) {
				etat2 = obj;
			}
		}
		Assert.assertNotNull(etat2);

		ICiviliteManager civMng = app.getCiviliteManager();
		ICivilite civ2 = null;
		for (ICivilite obj : civMng.getList()) {
			if (CIVILITE_LIBELLE_2.equals(obj.getLibelle())) {
				civ2 = obj;
			}
		}
		Assert.assertNotNull(civ2);

		IModePaiementManager mdpMng = app.getModePaiementManager();
		IModePaiement mdp1 = null;
		for (IModePaiement obj : mdpMng.getList()) {
			if (MODE_PAIEMENT_LIBELLE.equals(obj.getLibelle())) {
				mdp1 = obj;
			}
		}
		Assert.assertNotNull(mdp1);

		// /////////
		// Fournisseur
		IFournisseurManager fourMng = app.getFournisseurManager();
		IFournisseur four1 = null;
		for (IFournisseur obj : fourMng.getList()) {
			if (FOUR_CODE_1.equals(obj.getCode())) {
				four1 = obj;
			}
		}
		Assert.assertNotNull(four1);
		Assert.assertEquals(four1.getActivite().getLibelle(), ACTIVITE_LIBELLE_1);
		Assert.assertEquals(four1.getCategorie().getLibelle(), CATEGORIE_LIBELLE_1);
		Assert.assertEquals(four1.getCodeNaf(), FOUR_CODE_NAF_1);
		ICoordonneeCnt coo1 = four1.getCoordonnee();
		Assert.assertNotNull(coo1);
		Assert.assertEquals(coo1.getCivilite().getLibelle(), CIVILITE_LIBELLE_1);
		Assert.assertEquals(coo1.getComplementaire(), COO_COMPLEMENTAIRE_1);
		Assert.assertEquals(coo1.getCp(), COO_CP_1);
		Assert.assertEquals(coo1.getFax(), COO_FAX_1);
		Assert.assertEquals(coo1.getLocalisation().getLibelle(), LOCALISATION_LIBELLE_1);
		Assert.assertEquals(coo1.getMail(), COO_MAIL_1);
		Assert.assertEquals(coo1.getMail2(), COO_MAIL2_1);
		Assert.assertEquals(coo1.getMobile(), COO_MOBILE_1);
		Assert.assertEquals(coo1.getNom(), COO_NOM_1);
		Assert.assertEquals(coo1.getPays().getLibelle(), PAYS_LIBELLE_1);
		Assert.assertEquals(four1.isHide(), FOUR_HIDE_1);
		Assert.assertEquals(four1.getNomSociete(), FOUR_NOM_SOCIETE_1);
		assertEqualsDate(four1.getRappelDate(), FOUR_RAPPEL_DATE_1);
		Assert.assertNotNull(four1.getRappelMotif());
		Assert.assertNotNull(four1.getRemarques());

		// Fournisseur Materiaux
		List<IFournisseurMateriaux> listFrnMxFromFrn1 = four1.getListFournisseurMateriaux();
		Assert.assertNotNull(coo1);
		Assert.assertNotNull(listFrnMxFromFrn1);
		Assert.assertEquals(listFrnMxFromFrn1.size(), 1);
		IFournisseurMateriaux frnMxFromFrn = listFrnMxFromFrn1.get(0);
		Assert.assertNotNull(frnMxFromFrn.getFournisseur());
		Assert.assertNotNull(frnMxFromFrn.getMateriaux());
		Assert.assertEquals(frnMxFromFrn.getFournisseur().getCode(), FOUR_CODE_1);
		Assert.assertEquals(frnMxFromFrn.getMateriaux().getCode(), BIB_MX_CODE_1);
		Assert.assertEquals(frnMxFromFrn.getPrixTarif(), FOURNISSEUR_MATERIAUX_PRIX_TARIF_1);
		Assert.assertEquals(frnMxFromFrn.getQuantiteMini(), FOURNISSEUR_MATERIAUX_QTE_MINI_1);
		Assert.assertEquals(frnMxFromFrn.getRemise(), FOURNISSEUR_MATERIAUX_REMISE_1);

		// /////////
		// Mx Bib
		showArboBib();
		IMateriauxBibManager mxbibMng = app.getMateriauxBibManager();
		IMateriauxBib mxBib1 = null;
		for (IMateriauxBib obj : mxbibMng.getList()) {
			if (BIB_MX_CODE_1.equals(obj.getCode())) {
				mxBib1 = obj;
			}
		}
		Assert.assertNotNull(mxBib1);
		Assert.assertEquals(mxBib1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(mxBib1.getDescriptif());
		Assert.assertNotNull(mxBib1.getDescriptionCommerciale());
		Assert.assertNotNull(mxBib1.getDescriptionTechnique());
		Assert.assertNotNull(mxBib1.getNotes());
		Assert.assertEquals(mxBib1.getBarCode(), BIB_MX_BAR_CODE_1);
		Assert.assertNotNull(mxBib1.getImage());
		IFamille fam2 = mxBib1.getFamille();
		Assert.assertNotNull(fam2);
		Assert.assertEquals(fam2.getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(mxBib1.getUnite(), BIB_MX_UNITE_1);
		Assert.assertEquals(mxBib1.getRemise(), BIB_MX_REMISE_1);
		Assert.assertEquals(mxBib1.getFournisseurDefaut().getCode(), FOUR_CODE_1);
		Assert.assertEquals(mxBib1.getPrixTarif(), BIB_MX_PRIX_TARIF_1);
		Assert.assertEquals(mxBib1.getListLigne().size(), 0);
		List<ITache> listTachesParente = app.getMateriauxBibManager().getListTacheParente(mxBib1);
		Assert.assertNotNull(listTachesParente);
		Assert.assertEquals(0, listTachesParente.size());

		// Fournisseur Materiaux
		List<IFournisseurMateriaux> listFrnMxFromMx1 = mxBib1.getListFournisseurMateriaux();
		Assert.assertNotNull(listFrnMxFromMx1);
		Assert.assertEquals(listFrnMxFromMx1.size(), 1);
		IFournisseurMateriaux frnMxFromMx = listFrnMxFromMx1.get(0);
		Assert.assertEquals(frnMxFromMx.getFournisseur().getCode(), FOUR_CODE_1);
		Assert.assertEquals(frnMxFromMx.getMateriaux().getCode(), BIB_MX_CODE_1);
		Assert.assertEquals(frnMxFromMx.getPrixTarif(), FOURNISSEUR_MATERIAUX_PRIX_TARIF_1);
		Assert.assertEquals(frnMxFromMx.getQuantiteMini(), FOURNISSEUR_MATERIAUX_QTE_MINI_1);
		Assert.assertEquals(frnMxFromMx.getRemise(), FOURNISSEUR_MATERIAUX_REMISE_1);

		// /////////
		// Autre Bib
		IMainOeuvreBibManager mobibMng = app.getMainOeuvreBibManager();
		IMainOeuvreBib moBib1 = null;
		for (IMainOeuvreBib obj : mobibMng.getList()) {
			if (BIB_MO_CODE_1.equals(obj.getCode())) {
				moBib1 = obj;
			}
		}
		Assert.assertNotNull(moBib1);
		Assert.assertEquals(moBib1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(moBib1.getDescriptif());
		Assert.assertNotNull(moBib1.getDescriptionCommerciale());
		Assert.assertNotNull(moBib1.getDescriptionTechnique());
		Assert.assertNotNull(moBib1.getNotes());
		Assert.assertEquals(moBib1.getBarCode(), BIB_MO_BAR_CODE_1);
		Assert.assertNotNull(moBib1.getImage());
		Assert.assertEquals(moBib1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(moBib1.getMotCle(), BIB_MO_MOT_CLE_1);
		Assert.assertEquals(moBib1.getUnite(), BIB_MO_UNITE_1);
		Assert.assertEquals(moBib1.getListLigne().size(), 0);

		IEnginBibManager engBibMng = app.getEnginBibManager();
		IEnginBib engBib1 = null;
		for (IEnginBib obj : engBibMng.getList()) {
			if (BIB_ENG_CODE_1.equals(obj.getCode())) {
				engBib1 = obj;
			}
		}
		Assert.assertNotNull(engBib1);
		Assert.assertEquals(engBib1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(engBib1.getDescriptif());
		Assert.assertNotNull(engBib1.getDescriptionCommerciale());
		Assert.assertNotNull(engBib1.getDescriptionTechnique());
		Assert.assertNotNull(engBib1.getNotes());
		Assert.assertNotNull(engBib1.getImage());
		Assert.assertEquals(engBib1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(engBib1.getBarCode(), BIB_ENG_BAR_CODE_1);
		Assert.assertEquals(engBib1.getMotCle(), BIB_ENG_MOT_CLE_1);
		Assert.assertEquals(engBib1.getUnite(), BIB_ENG_UNITE_1);
		Assert.assertEquals(engBib1.getImmatriculation(), BIB_ENG_IMMATRICULATION);
		assertEqualsDate(engBib1.getImmatriculationDate(), BIB_ENG_IMMATRICULATION_DATE);
		Assert.assertEquals(engBib1.getListLigne().size(), 0);

		ISousTraitantBibManager sstBibMng = app.getSousTraitantBibManager();
		ISousTraitantBib sstBib1 = null;
		for (ISousTraitantBib obj : sstBibMng.getList()) {
			if (BIB_SST_CODE_1.equals(obj.getCode())) {
				sstBib1 = obj;
			}
		}
		Assert.assertNotNull(sstBib1);
		Assert.assertEquals(sstBib1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(sstBib1.getDescriptif());
		Assert.assertNotNull(sstBib1.getDescriptionCommerciale());
		Assert.assertNotNull(sstBib1.getDescriptionTechnique());
		Assert.assertNotNull(sstBib1.getNotes());
		Assert.assertNotNull(sstBib1.getImage());
		Assert.assertEquals(sstBib1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(sstBib1.getBarCode(), BIB_SST_BAR_CODE_1);
		Assert.assertEquals(sstBib1.getMotCle(), BIB_SST_MOT_CLE_1);
		Assert.assertEquals(sstBib1.getUnite(), BIB_SST_UNITE_1);
		Assert.assertEquals(sstBib1.getListLigne().size(), 0);

		showArboBib();
		ILotBibManager lotBibMng = app.getLotBibManager();
		ILotBib lotBib1 = null;
		for (ILotBib obj : lotBibMng.getList()) {
			if (BIB_LOT_CODE_1.equals(obj.getCode())) {
				lotBib1 = obj;
			}
		}
		Assert.assertNotNull(lotBib1);
		Assert.assertEquals(lotBib1.getTva().getLibelle(), TVA_LIBELLE_1);
		Assert.assertNotNull(lotBib1.getDescriptif());
		Assert.assertNotNull(lotBib1.getDescriptionCommerciale());
		Assert.assertNotNull(lotBib1.getDescriptionTechnique());
		Assert.assertNotNull(lotBib1.getNotes());
		Assert.assertNotNull(lotBib1.getImage());
		Assert.assertEquals(lotBib1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(lotBib1.getMotCle(), BIB_LOT_MOT_CLE_1);
		Assert.assertEquals(lotBib1.getUnite(), BIB_LOT_UNITE_1);
		Assert.assertEquals(lotBib1.getListLigne().size(), 1);
		ISousTraitantBib sstBibLot1 = (ISousTraitantBib) lotBib1.getListLigne().get(0);
		Assert.assertNotNull(sstBibLot1);
		Assert.assertEquals(sstBibLot1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(sstBibLot1.getDescriptif());
		Assert.assertNotNull(sstBibLot1.getDescriptionCommerciale());
		Assert.assertNotNull(sstBibLot1.getDescriptionTechnique());
		Assert.assertNotNull(sstBibLot1.getNotes());
		Assert.assertNotNull(sstBibLot1.getImage());
		Assert.assertEquals(sstBibLot1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(sstBibLot1.getBarCode(), BIB_SST_BAR_CODE_1);
		Assert.assertEquals(sstBibLot1.getMotCle(), BIB_SST_MOT_CLE_1);
		Assert.assertEquals(sstBibLot1.getUnite(), BIB_SST_UNITE_1);
		Assert.assertEquals(sstBibLot1.getListLigne().size(), 0);
		listTachesParente = app.getSousTraitantBibManager().getListTacheParente(sstBibLot1);
		Assert.assertNotNull(listTachesParente);
		Assert.assertEquals(0, listTachesParente.size());

		ITacheBibManager tacBibMng = app.getTacheBibManager();
		ITacheBib tacBib1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_1.equals(obj.getCode())) {
				tacBib1 = obj;
			}
		}
		Assert.assertNotNull(tacBib1);
		Assert.assertEquals(TVA_LIBELLE_1, tacBib1.getTva().getLibelle());
		Assert.assertNotNull(tacBib1.getDescriptif());
		Assert.assertNotNull(tacBib1.getDescriptionCommerciale());
		Assert.assertNotNull(tacBib1.getDescriptionTechnique());
		Assert.assertNotNull(tacBib1.getNotes());
		Assert.assertNotNull(tacBib1.getImage());
		Assert.assertEquals(FAMILLE_DESC_2, tacBib1.getFamille().getDescriptif());
		Assert.assertEquals(BIB_TAC_BAR_CODE_1, tacBib1.getBarCode());
		Assert.assertEquals(BIB_TAC_MOT_CLE_1, tacBib1.getMotCle());
		Assert.assertEquals(BIB_TAC_UNITE_1, tacBib1.getUnite());
		Assert.assertEquals(BIB_TAC_PRIX_VENTE_FIXE_1, tacBib1.isPrixVenteFixe());
		Assert.assertEquals(BIB_TAC_BENEFICE_ENG_1, tacBib1.getBeneficeEng());
		Assert.assertEquals(BIB_TAC_BENEFICE_MO_1, tacBib1.getBeneficeMo());
		Assert.assertEquals(BIB_TAC_BENEFICE_MX_1, tacBib1.getBeneficeMx());
		Assert.assertEquals(BIB_TAC_BENEFICE_SST_1, tacBib1.getBeneficeSt());
		Assert.assertEquals(BIB_TAC_FRAIS_GENRERAUX_ENG_1, tacBib1.getFraisGenerauxEng());
		Assert.assertEquals(BIB_TAC_FRAIS_GENRERAUX_MO_1, tacBib1.getFraisGenerauxMo());
		Assert.assertEquals(BIB_TAC_FRAIS_GENRERAUX_MX_1, tacBib1.getFraisGenerauxMx());
		Assert.assertEquals(BIB_TAC_FRAIS_GENRERAUX_SST_1, tacBib1.getFraisGenerauxSt());
		Assert.assertEquals(BIB_TAC_QUANTITE_1, tacBib1.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, tacBib1.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, tacBib1.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, tacBib1.getPrixAchatUnitaire());
		showArboBib();
		Assert.assertEquals(2, tacBib1.getListLigne().size());
		IEnginBib engBibTac1 = (IEnginBib) tacBib1.getListLigne().get(0);
		Assert.assertEquals(engBibTac1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(engBibTac1.getDescriptif());
		Assert.assertNotNull(engBibTac1.getDescriptionCommerciale());
		Assert.assertNotNull(engBibTac1.getDescriptionTechnique());
		Assert.assertNotNull(engBibTac1.getNotes());
		Assert.assertNotNull(engBibTac1.getImage());
		Assert.assertEquals(engBibTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(engBibTac1.getBarCode(), BIB_ENG_BAR_CODE_1);
		Assert.assertEquals(engBibTac1.getMotCle(), BIB_ENG_MOT_CLE_1);
		Assert.assertEquals(engBibTac1.getUnite(), BIB_ENG_UNITE_1);
		Assert.assertEquals(BIB_ENG_QUANTITE_1, engBibTac1.getQuantite());
		Assert.assertEquals(BIB_ENG_BENEFICE_1, engBibTac1.getBenefice());
		Assert.assertEquals(BIB_ENG_FRAIS_GENERAUX_1, engBibTac1.getFraisGeneraux());
		Assert.assertEquals(BIB_ENG_PRIX_ACHAT_1, engBibTac1.getPrixAchatUnitaire());
		Assert.assertEquals(engBibTac1.getImmatriculation(), BIB_ENG_IMMATRICULATION);
		assertEqualsDate(engBibTac1.getImmatriculationDate(), BIB_ENG_IMMATRICULATION_DATE);
		Assert.assertEquals(engBibTac1.getListLigne().size(), 0);
		listTachesParente = app.getEnginBibManager().getListTacheParente(engBibTac1);
		Assert.assertNotNull(listTachesParente);
		Assert.assertEquals(1, listTachesParente.size());
		Assert.assertEquals(listTachesParente.get(0).getCode(), BIB_TAC_CODE_1);
		IMainOeuvreBib moBibTac1 = (IMainOeuvreBib) tacBib1.getListLigne().get(1);
		Assert.assertEquals(moBibTac1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(moBibTac1.getDescriptif());
		Assert.assertNotNull(moBibTac1.getDescriptionCommerciale());
		Assert.assertNotNull(moBibTac1.getDescriptionTechnique());
		Assert.assertNotNull(moBibTac1.getNotes());
		Assert.assertEquals(moBibTac1.getBarCode(), BIB_MO_BAR_CODE_1);
		Assert.assertNotNull(moBibTac1.getImage());
		Assert.assertEquals(moBibTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(moBibTac1.getMotCle(), BIB_MO_MOT_CLE_1);
		Assert.assertEquals(moBibTac1.getUnite(), BIB_MO_UNITE_1);
		Assert.assertEquals(BIB_MO_QUANTITE_1, moBibTac1.getQuantite());
		Assert.assertEquals(BIB_MO_BENEFICE_1, moBibTac1.getBenefice());
		Assert.assertEquals(BIB_MO_FRAIS_GENRERAUX_1, moBibTac1.getFraisGeneraux());
		Assert.assertEquals(BIB_MO_PRIX_ACHAT_1, moBibTac1.getPrixAchatUnitaire());
		Assert.assertEquals(moBibTac1.getListLigne().size(), 0);
		listTachesParente = app.getMainOeuvreBibManager().getListTacheParente(moBibTac1);
		Assert.assertNotNull(listTachesParente);
		Assert.assertEquals(1, listTachesParente.size());
		Assert.assertEquals(listTachesParente.get(0).getCode(), BIB_TAC_CODE_1);

		// Tâche copie de tache1
		ITacheBib tacBib1ToTac1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_4.equals(obj.getCode())) {
				tacBib1ToTac1 = obj;
			}
		}
		Assert.assertNotNull(tacBib1ToTac1);
		Assert.assertEquals(tacBib1ToTac1.getTva().getLibelle(), TVA_LIBELLE_1);
		Assert.assertNotNull(tacBib1ToTac1.getDescriptif());
		Assert.assertNotNull(tacBib1ToTac1.getDescriptionCommerciale());
		Assert.assertNotNull(tacBib1ToTac1.getDescriptionTechnique());
		Assert.assertNotNull(tacBib1ToTac1.getNotes());
		Assert.assertNotNull(tacBib1ToTac1.getImage());
		Assert.assertEquals(tacBib1ToTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(tacBib1ToTac1.getBarCode(), BIB_TAC_BAR_CODE_1);
		Assert.assertEquals(tacBib1ToTac1.getMotCle(), BIB_TAC_MOT_CLE_1);
		Assert.assertEquals(tacBib1ToTac1.getUnite(), BIB_TAC_UNITE_1);
		Assert.assertEquals(tacBib1ToTac1.isPrixVenteFixe(), BIB_TAC_PRIX_VENTE_FIXE_1);
		Assert.assertEquals(tacBib1ToTac1.getBeneficeEng(), BIB_TAC_BENEFICE_ENG_1);
		Assert.assertEquals(tacBib1ToTac1.getBeneficeMo(), BIB_TAC_BENEFICE_MO_1);
		Assert.assertEquals(tacBib1ToTac1.getBeneficeMx(), BIB_TAC_BENEFICE_MX_1);
		Assert.assertEquals(tacBib1ToTac1.getBeneficeSt(), BIB_TAC_BENEFICE_SST_1);
		Assert.assertEquals(tacBib1ToTac1.getFraisGenerauxEng(), BIB_TAC_FRAIS_GENRERAUX_ENG_1);
		Assert.assertEquals(tacBib1ToTac1.getFraisGenerauxMo(), BIB_TAC_FRAIS_GENRERAUX_MO_1);
		Assert.assertEquals(tacBib1ToTac1.getFraisGenerauxMx(), BIB_TAC_FRAIS_GENRERAUX_MX_1);
		Assert.assertEquals(tacBib1ToTac1.getFraisGenerauxSt(), BIB_TAC_FRAIS_GENRERAUX_SST_1);
		showArboBib();
		Assert.assertEquals(tacBib1ToTac1.getListLigne().size(), 2);
		IEnginBib engBib1ToTac1 = (IEnginBib) tacBib1ToTac1.getListLigne().get(0);
		Assert.assertEquals(engBib1ToTac1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(engBib1ToTac1.getDescriptif());
		Assert.assertNotNull(engBib1ToTac1.getDescriptionCommerciale());
		Assert.assertNotNull(engBib1ToTac1.getDescriptionTechnique());
		Assert.assertNotNull(engBib1ToTac1.getNotes());
		Assert.assertNotNull(engBib1ToTac1.getImage());
		Assert.assertEquals(engBib1ToTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(engBib1ToTac1.getBarCode(), BIB_ENG_BAR_CODE_1);
		Assert.assertEquals(engBib1ToTac1.getMotCle(), BIB_ENG_MOT_CLE_1);
		Assert.assertEquals(engBib1ToTac1.getUnite(), BIB_ENG_UNITE_1);
		Assert.assertEquals(engBib1ToTac1.getImmatriculation(), BIB_ENG_IMMATRICULATION);
		assertEqualsDate(engBib1ToTac1.getImmatriculationDate(), BIB_ENG_IMMATRICULATION_DATE);
		Assert.assertEquals(engBib1ToTac1.getListLigne().size(), 0);
		IMainOeuvreBib moBib1ToTac1 = (IMainOeuvreBib) tacBib1ToTac1.getListLigne().get(1);
		Assert.assertEquals(moBib1ToTac1.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertNotNull(moBib1ToTac1.getDescriptif());
		Assert.assertNotNull(moBib1ToTac1.getDescriptionCommerciale());
		Assert.assertNotNull(moBib1ToTac1.getDescriptionTechnique());
		Assert.assertNotNull(moBib1ToTac1.getNotes());
		Assert.assertEquals(moBib1ToTac1.getBarCode(), BIB_MO_BAR_CODE_1);
		Assert.assertNotNull(moBib1ToTac1.getImage());
		Assert.assertEquals(moBib1ToTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(moBib1ToTac1.getMotCle(), BIB_MO_MOT_CLE_1);
		Assert.assertEquals(moBib1ToTac1.getUnite(), BIB_MO_UNITE_1);
		Assert.assertEquals(moBib1ToTac1.getListLigne().size(), 0);

		// //////////
		// List Tache parente
		List<ITache> listTacheParente = engBibMng.getListTacheParente(engBib1);
		Assert.assertEquals(2, listTacheParente.size());
		ITache tacParent1 = listTacheParente.get(0);
		Assert.assertEquals(tacParent1.getTva().getLibelle(), TVA_LIBELLE_1);
		Assert.assertNotNull(tacParent1.getDescriptif());
		Assert.assertNotNull(tacParent1.getDescriptionCommerciale());
		Assert.assertNotNull(tacParent1.getDescriptionTechnique());
		Assert.assertNotNull(tacParent1.getNotes());
		Assert.assertNotNull(tacParent1.getImage());
		Assert.assertEquals(tacParent1.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(tacParent1.getBarCode(), BIB_TAC_BAR_CODE_1);
		Assert.assertEquals(tacParent1.getMotCle(), BIB_TAC_MOT_CLE_1);
		Assert.assertEquals(tacParent1.getUnite(), BIB_TAC_UNITE_1);
		Assert.assertEquals(tacParent1.isPrixVenteFixe(), BIB_TAC_PRIX_VENTE_FIXE_1);
		Assert.assertEquals(tacParent1.getBeneficeEng(), BIB_TAC_BENEFICE_ENG_1);
		Assert.assertEquals(tacParent1.getBeneficeMo(), BIB_TAC_BENEFICE_MO_1);
		Assert.assertEquals(tacParent1.getBeneficeMx(), BIB_TAC_BENEFICE_MX_1);
		Assert.assertEquals(tacParent1.getBeneficeSt(), BIB_TAC_BENEFICE_SST_1);
		Assert.assertEquals(tacParent1.getFraisGenerauxEng(), BIB_TAC_FRAIS_GENRERAUX_ENG_1);
		Assert.assertEquals(tacParent1.getFraisGenerauxMo(), BIB_TAC_FRAIS_GENRERAUX_MO_1);
		Assert.assertEquals(tacParent1.getFraisGenerauxMx(), BIB_TAC_FRAIS_GENRERAUX_MX_1);
		Assert.assertEquals(tacParent1.getFraisGenerauxSt(), BIB_TAC_FRAIS_GENRERAUX_SST_1);

		List<ITache> listTacheParente2 = engBib1.getListTacheParente();
		Assert.assertEquals(2, listTacheParente2.size());
		ITache tacParent11 = listTacheParente2.get(0);
		Assert.assertEquals(tacParent11.getTva().getLibelle(), TVA_LIBELLE_1);
		Assert.assertNotNull(tacParent11.getDescriptif());
		Assert.assertNotNull(tacParent11.getDescriptionCommerciale());
		Assert.assertNotNull(tacParent11.getDescriptionTechnique());
		Assert.assertNotNull(tacParent11.getNotes());
		Assert.assertNotNull(tacParent11.getImage());
		Assert.assertEquals(tacParent11.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(tacParent11.getBarCode(), BIB_TAC_BAR_CODE_1);
		Assert.assertEquals(tacParent11.getMotCle(), BIB_TAC_MOT_CLE_1);
		Assert.assertEquals(tacParent11.getUnite(), BIB_TAC_UNITE_1);
		Assert.assertEquals(tacParent11.isPrixVenteFixe(), BIB_TAC_PRIX_VENTE_FIXE_1);
		Assert.assertEquals(tacParent11.getBeneficeEng(), BIB_TAC_BENEFICE_ENG_1);
		Assert.assertEquals(tacParent11.getBeneficeMo(), BIB_TAC_BENEFICE_MO_1);
		Assert.assertEquals(tacParent11.getBeneficeMx(), BIB_TAC_BENEFICE_MX_1);
		Assert.assertEquals(tacParent11.getBeneficeSt(), BIB_TAC_BENEFICE_SST_1);
		Assert.assertEquals(tacParent11.getFraisGenerauxEng(), BIB_TAC_FRAIS_GENRERAUX_ENG_1);
		Assert.assertEquals(tacParent11.getFraisGenerauxMo(), BIB_TAC_FRAIS_GENRERAUX_MO_1);
		Assert.assertEquals(tacParent11.getFraisGenerauxMx(), BIB_TAC_FRAIS_GENRERAUX_MX_1);
		Assert.assertEquals(tacParent11.getFraisGenerauxSt(), BIB_TAC_FRAIS_GENRERAUX_SST_1);

		// /////////////////
		// Teste la mise à jour d'une tva sur un élément de bib et ses sous éléments
		ITacheBib tacBibForUpdateTva1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_1.equals(obj.getCode())) {
				tacBibForUpdateTva1 = obj;
			}
		}
		Assert.assertNotNull(tacBibForUpdateTva1);
		Assert.assertEquals(tacBibForUpdateTva1.getTva().getLibelle(), TVA_LIBELLE_1);
		Assert.assertEquals(((IEnginBib) tacBibForUpdateTva1.getListLigne().get(0)).getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertEquals(((IMainOeuvreBib) tacBibForUpdateTva1.getListLigne().get(1)).getTva().getLibelle(), TVA_LIBELLE_2);

		List<ITva> listTvaForBibUpdateTva = tvaMng.getList();
		Assert.assertNotNull(listTvaForBibUpdateTva);
		ITva tva3 = null;
		for (ITva tva : listTvaForBibUpdateTva) {
			if (TVA_LIBELLE_3.equals(tva.getLibelle())) {
				tva3 = tva;
			}
		}
		Assert.assertNotNull(tva3);

		// Met à jour la tva3 sur tous les éléments et ses sous éléments
		tacBibForUpdateTva1 = tacBibMng.getBibEltUpdatedForTVA(tacBibForUpdateTva1, tva3);
		Assert.assertEquals(tacBibForUpdateTva1.getTva().getLibelle(), TVA_LIBELLE_3);
		Assert.assertEquals(((IEnginBib) tacBibForUpdateTva1.getListLigne().get(0)).getTva().getLibelle(), TVA_LIBELLE_3);
		Assert.assertEquals(((IMainOeuvreBib) tacBibForUpdateTva1.getListLigne().get(1)).getTva().getLibelle(), TVA_LIBELLE_3);

		// //////////////////////
		// Teste la mise à jour des propriétés d'un élément sur ses sous éléments
		ITacheBib tacBibForUpdateElt1 = null;
		for (ITacheBib obj : tacBibMng.getList()) {
			if (BIB_TAC_CODE_1.equals(obj.getCode())) {
				tacBibForUpdateElt1 = obj;
			}
		}
		Assert.assertNotNull(tacBibForUpdateElt1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, tacBibForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, tacBibForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, tacBibForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, tacBibForUpdateElt1.getPrixAchatUnitaire());
		Assert.assertEquals(tacBibForUpdateElt1.getListLigne().size(), 2);
		IEnginBib engBibTacForUpdateElt1 = (IEnginBib) tacBibForUpdateElt1.getListLigne().get(0);
		Assert.assertEquals(BIB_ENG_QUANTITE_1, engBibTacForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_ENG_BENEFICE_1, engBibTacForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_ENG_FRAIS_GENERAUX_1, engBibTacForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_ENG_PRIX_ACHAT_1, engBibTacForUpdateElt1.getPrixAchatUnitaire());
		IMainOeuvreBib moBibTacForUpdateElt1 = (IMainOeuvreBib) tacBibForUpdateElt1.getListLigne().get(1);
		Assert.assertEquals(BIB_MO_QUANTITE_1, moBibTacForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_MO_BENEFICE_1, moBibTacForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_MO_FRAIS_GENRERAUX_1, moBibTacForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_MO_PRIX_ACHAT_1, moBibTacForUpdateElt1.getPrixAchatUnitaire());

		// Met à jour les propriétés sur tous les éléments et ses sous éléments à partir de l'élément passé en paramètre
		tacBibForUpdateElt1 = tacBibMng.getBibEltUpdated(tacBibForUpdateElt1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, tacBibForUpdateElt1.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, tacBibForUpdateElt1.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, tacBibForUpdateElt1.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, tacBibForUpdateElt1.getPrixAchatUnitaire());
		Assert.assertEquals(tacBibForUpdateElt1.getListLigne().size(), 2);
		IEnginBib engBibTacForUpdateElt11 = (IEnginBib) tacBibForUpdateElt1.getListLigne().get(0);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, engBibTacForUpdateElt11.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, engBibTacForUpdateElt11.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, engBibTacForUpdateElt11.getFraisGeneraux());
		Assert.assertEquals(BIB_ENG_PRIX_ACHAT_1, engBibTacForUpdateElt11.getPrixAchatUnitaire());
		IMainOeuvreBib moBibTacForUpdateElt11 = (IMainOeuvreBib) tacBibForUpdateElt1.getListLigne().get(1);
		Assert.assertEquals(BIB_TAC_QUANTITE_1, moBibTacForUpdateElt11.getQuantite());
		Assert.assertEquals(BIB_TAC_BENEFICE_1, moBibTacForUpdateElt11.getBenefice());
		Assert.assertEquals(BIB_TAC_FRAIS_GENERAUX_1, moBibTacForUpdateElt11.getFraisGeneraux());
		Assert.assertEquals(BIB_TAC_PRIX_ACHAT_1, moBibTacForUpdateElt11.getPrixAchatUnitaire());

		// /////////////////
		// Mx Bib qui copie de mx etude
		mxbibMng = app.getMateriauxBibManager();
		IMateriauxBib mxBib3 = null;
		for (IMateriauxBib obj : mxbibMng.getList()) {
			if (BIB_MX_CODE_3.equals(obj.getCode())) {
				mxBib3 = obj;
			}
		}
		Assert.assertNotNull(mxBib3);
		Assert.assertEquals(mxBib3.getCode(), BIB_MX_CODE_3);
		Assert.assertEquals(mxBib3.getTva().getLibelle(), TVA_LIBELLE_2);
		Assert.assertEquals(mxBib3.getBarCode(), BIB_MX_BAR_CODE_2);
		Assert.assertNotNull(mxBib3.getFamille());
		Assert.assertEquals(mxBib3.getFamille().getDescriptif(), FAMILLE_DESC_2);
		Assert.assertEquals(mxBib3.getUnite(), BIB_MX_UNITE_2);
		Assert.assertEquals(mxBib3.getRemise(), BIB_MX_REMISE_2);
		Assert.assertEquals(mxBib3.getFournisseurDefaut().getCode(), FOUR_CODE_1);
		Assert.assertEquals(mxBib3.getPrixTarif(), BIB_MX_PRIX_TARIF_1);

		// Fournisseur Materiaux
		List<IFournisseurMateriaux> listFrnMxFromBibMx3 = mxBib3.getListFournisseurMateriaux();
		Assert.assertNotNull(listFrnMxFromBibMx3);
		Assert.assertEquals(listFrnMxFromBibMx3.size(), 0);

		// /////////////////
		// Devis Bib
		IDevisManager devisMng = app.getDevisManager();
		IDevis devisBib1 = null;
		for (IDevis obj : devisMng.getList()) {
			if (DEVIS_BIB_CODE_2.equals(obj.getCode())) {
				devisBib1 = obj;
			}
		}
		Assert.assertNotNull(devisBib1);
		List<IEtude> listeEtudeDevisBib = devisBib1.getListEtude();
		Assert.assertEquals(listeEtudeDevisBib.size(), 2);
		for (IEtude etude : listeEtudeDevisBib) {
			if (etude.getTvaDefaut() != null) {
				// Etude 2
				Assert.assertEquals(etude.getTvaDefaut().getLibelle(), TVA_LIBELLE_3);
				List<IBibEltEtude> listBibEltEtude = etude.getListBibliotheque();
				Assert.assertEquals(listBibEltEtude.size(), 6);

				// Mx
				IBibEltEtude bibEltEtude = listBibEltEtude.get(0);
				showArboBib();
				Assert.assertTrue(bibEltEtude instanceof IMateriauxEtude);
				IMateriauxEtude mxEtude1 = (IMateriauxEtude) bibEltEtude;
				// Fournisseur Materiaux
				List<IFournisseurMateriaux> listFrnMxFromEtudeMx1 = mxEtude1.getListFournisseurMateriaux();
				Assert.assertNotNull(listFrnMxFromEtudeMx1);
				Assert.assertEquals(listFrnMxFromEtudeMx1.size(), 0);

				// Autre Bib
				bibEltEtude = listBibEltEtude.get(1);
				Assert.assertTrue(bibEltEtude instanceof IMainOeuvreEtude);

				bibEltEtude = listBibEltEtude.get(2);
				Assert.assertTrue(bibEltEtude instanceof IEnginEtude);

				bibEltEtude = listBibEltEtude.get(3);
				Assert.assertTrue(bibEltEtude instanceof ISousTraitantEtude);

				bibEltEtude = listBibEltEtude.get(4);
				Assert.assertTrue(bibEltEtude instanceof ILotEtude);

				bibEltEtude = listBibEltEtude.get(5);
				Assert.assertTrue(bibEltEtude instanceof ITacheEtude);

			} else {
				// Etude 3
				List<IBibEltEtude> listBibEltEtude = etude.getListBibliotheque();
				Assert.assertEquals(listBibEltEtude.size(), 6);

				// Mx
				IBibEltEtude bibEltEtude = listBibEltEtude.get(0);
				showArboBib();
				Assert.assertTrue(bibEltEtude instanceof IMateriauxEtude);
				IMateriauxEtude mxEtude1 = (IMateriauxEtude) bibEltEtude;
				Assert.assertEquals(mxEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(mxEtude1.getBarCode(), BIB_MX_BAR_CODE_2);
				Assert.assertNotNull(mxEtude1.getFamille());
				Assert.assertEquals(mxEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(mxEtude1.getUnite(), BIB_MX_UNITE_2);
				Assert.assertEquals(mxEtude1.getRemise(), BIB_MX_REMISE_2);
				Assert.assertEquals(mxEtude1.getFournisseurDefaut().getCode(), FOUR_CODE_1);
				Assert.assertEquals(mxEtude1.getPrixTarif(), BIB_MX_PRIX_TARIF_1);

				// Fournisseur Materiaux
				List<IFournisseurMateriaux> listFrnMxFromEtudeMx1 = mxEtude1.getListFournisseurMateriaux();
				Assert.assertNotNull(listFrnMxFromEtudeMx1);
				Assert.assertEquals(listFrnMxFromEtudeMx1.size(), 0);

				// Autre Bib
				bibEltEtude = listBibEltEtude.get(1);
				Assert.assertTrue(bibEltEtude instanceof IMainOeuvreEtude);
				IMainOeuvreEtude moEtude1 = (IMainOeuvreEtude) bibEltEtude;
				Assert.assertNotNull(moEtude1);
				Assert.assertEquals(moEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(moEtude1.getBarCode(), BIB_MO_BAR_CODE_2);
				Assert.assertEquals(moEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(moEtude1.getMotCle(), BIB_MO_MOT_CLE_2);
				Assert.assertEquals(moEtude1.getUnite(), BIB_MO_UNITE_2);
				Assert.assertEquals(moEtude1.getListLigne().size(), 0);

				bibEltEtude = listBibEltEtude.get(2);
				Assert.assertTrue(bibEltEtude instanceof IEnginEtude);
				IEnginEtude engEtude1 = (IEnginEtude) bibEltEtude;
				Assert.assertEquals(engEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(engEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(engEtude1.getBarCode(), BIB_ENG_BAR_CODE_2);
				Assert.assertEquals(engEtude1.getMotCle(), BIB_ENG_MOT_CLE_2);
				Assert.assertEquals(engEtude1.getUnite(), BIB_ENG_UNITE_2);
				Assert.assertNull(engEtude1.getImmatriculation());
				Assert.assertNull(engEtude1.getImmatriculationDate());
				Assert.assertEquals(engEtude1.getListLigne().size(), 0);

				bibEltEtude = listBibEltEtude.get(3);
				Assert.assertTrue(bibEltEtude instanceof ISousTraitantEtude);
				ISousTraitantEtude sstEtude1 = (ISousTraitantEtude) bibEltEtude;
				Assert.assertEquals(sstEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(sstEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(sstEtude1.getBarCode(), BIB_SST_BAR_CODE_2);
				Assert.assertEquals(sstEtude1.getMotCle(), BIB_SST_MOT_CLE_2);
				Assert.assertEquals(sstEtude1.getUnite(), BIB_SST_UNITE_2);
				Assert.assertEquals(sstEtude1.getListLigne().size(), 0);

				bibEltEtude = listBibEltEtude.get(4);
				Assert.assertTrue(bibEltEtude instanceof ILotEtude);
				ILotEtude lotEtude1 = (ILotEtude) bibEltEtude;
				Assert.assertEquals(lotEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(lotEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(lotEtude1.getMotCle(), BIB_LOT_MOT_CLE_2);
				Assert.assertEquals(lotEtude1.getUnite(), BIB_LOT_UNITE_2);
				Assert.assertEquals(lotEtude1.getListLigne().size(), 1);
				ISousTraitantEtude sstEtudeLot1 = (ISousTraitantEtude) lotEtude1.getListLigne().get(0);
				Assert.assertNotNull(sstEtudeLot1);
				Assert.assertEquals(sstEtudeLot1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(sstEtudeLot1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(sstEtudeLot1.getBarCode(), BIB_SST_BAR_CODE_2);
				Assert.assertEquals(sstEtudeLot1.getMotCle(), BIB_SST_MOT_CLE_2);
				Assert.assertEquals(sstEtudeLot1.getUnite(), BIB_SST_UNITE_2);
				Assert.assertEquals(sstEtudeLot1.getListLigne().size(), 0);

				bibEltEtude = listBibEltEtude.get(5);
				Assert.assertTrue(bibEltEtude instanceof ITacheEtude);
				ITacheEtude tacEtude1 = (ITacheEtude) bibEltEtude;
				Assert.assertEquals(tacEtude1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(tacEtude1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(tacEtude1.getBarCode(), BIB_TAC_BAR_CODE_2);
				Assert.assertEquals(tacEtude1.getMotCle(), BIB_TAC_MOT_CLE_2);
				Assert.assertEquals(tacEtude1.getUnite(), BIB_TAC_UNITE_2);
				Assert.assertFalse(tacEtude1.isPrixVenteFixe());
				Assert.assertNull(tacEtude1.getBeneficeEng());
				Assert.assertNull(tacEtude1.getBeneficeMo());
				Assert.assertNull(tacEtude1.getBeneficeMx());
				Assert.assertNull(tacEtude1.getBeneficeSt());
				Assert.assertNull(tacEtude1.getFraisGenerauxEng());
				Assert.assertNull(tacEtude1.getFraisGenerauxMo());
				Assert.assertNull(tacEtude1.getFraisGenerauxMx());
				Assert.assertNull(tacEtude1.getFraisGenerauxSt());
				showArboBib();
				Assert.assertEquals(tacEtude1.getListLigne().size(), 2);
				IEnginEtude engEtudeTac1 = (IEnginEtude) tacEtude1.getListLigne().get(0);
				Assert.assertEquals(engEtudeTac1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(engEtudeTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(engEtudeTac1.getBarCode(), BIB_ENG_BAR_CODE_2);
				Assert.assertEquals(engEtudeTac1.getMotCle(), BIB_ENG_MOT_CLE_2);
				Assert.assertEquals(engEtudeTac1.getUnite(), BIB_ENG_UNITE_2);
				Assert.assertEquals(engEtudeTac1.getListLigne().size(), 0);
				IMainOeuvreEtude moEtudeTac1 = (IMainOeuvreEtude) tacEtude1.getListLigne().get(1);
				Assert.assertEquals(moEtudeTac1.getTva().getLibelle(), TVA_LIBELLE_2);
				Assert.assertEquals(moEtudeTac1.getBarCode(), BIB_MO_BAR_CODE_2);
				Assert.assertEquals(moEtudeTac1.getFamille().getDescriptif(), FAMILLE_DESC_2);
				Assert.assertEquals(moEtudeTac1.getMotCle(), BIB_MO_MOT_CLE_2);
				Assert.assertEquals(moEtudeTac1.getUnite(), BIB_MO_UNITE_2);
				Assert.assertEquals(moEtudeTac1.getListLigne().size(), 0);
			}
		}

		// ////////
		// Affaires - Devis - Liste étude
		IDevis devis1 = null;
		for (IDevis obj : devisMng.getList()) {
			if (DEVIS_CODE_1.equals(obj.getCode())) {
				devis1 = obj;
			}
		}
		Assert.assertNotNull(devis1);
		Assert.assertNotNull(devis1.getConclusion());
		assertEqualsDate(devis1.getDateCloture(), SITUATION_DATE_CLOTURE_1);
		Assert.assertEquals(devis1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(devis1.isTermine(), SITUATION_TERMINE_1);
		Assert.assertEquals(devis1.isValide(), SITUATION_VALIDE_1);
		Assert.assertNull(devis1.getDevis());
		Assert.assertEquals(devis1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(devis1.getChantier());
		List<IEtude> listeEtudeDevis1 = devis1.getListEtude();
		Assert.assertEquals(listeEtudeDevis1.size(), 1);
		List<IBibEltEtude> listBibEtudeDevis1 = listeEtudeDevis1.get(0).getListBibliotheque();
		Assert.assertEquals(listBibEtudeDevis1.size(), 1);
		IBibEltEtude bibEtudeDevis1 = listBibEtudeDevis1.get(0);
		Assert.assertTrue(bibEtudeDevis1 instanceof IMateriauxEtude);
		IMateriauxEtude mxEtudeDevis1 = (IMateriauxEtude) bibEtudeDevis1;
		Assert.assertEquals(mxEtudeDevis1.getCode(), BIB_MX_ETUDE_CODE_1);

		// Affaire Facture : Liste étude
		IFactureManager factureMng = app.getFactureManager();
		IFacture facture2 = null;
		for (IFacture obj : factureMng.getList()) {
			if (FACTURE_CODE_2.equals(obj.getCode())) {
				facture2 = obj;
			}
		}
		Assert.assertNotNull(facture2);
		Assert.assertNotNull(facture2.getConclusion());
		assertEqualsDate(facture2.getDateCloture(), FACTURE_DATE_CLOTURE_1);
		Assert.assertEquals(facture2.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(facture2.isTermine(), FACTURE_TERMINE_1);
		Assert.assertEquals(facture2.isValide(), FACTURE_VALIDE_1);
		Assert.assertEquals(facture2.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertEquals(facture2.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(facture2.getChantier());
		List<IEtude> listeEtudeFacture2 = facture2.getListEtude();
		Assert.assertEquals(listeEtudeFacture2.size(), 1);
		List<IBibEltEtude> listBibEtudeFacture2 = listeEtudeFacture2.get(0).getListBibliotheque();
		Assert.assertEquals(listBibEtudeFacture2.size(), 1);
		IBibEltEtude bibEtudeFacture2 = listBibEtudeFacture2.get(0);
		Assert.assertTrue(bibEtudeFacture2 instanceof IMateriauxEtude);
		IMateriauxEtude mxEtudeFacture2 = (IMateriauxEtude) bibEtudeFacture2;
		Assert.assertEquals(mxEtudeFacture2.getCode(), BIB_MX_ETUDE_CODE_1);

		// Affaire Facture : Règlement - échéancier
		IFacture facture1 = null;
		for (IFacture obj : factureMng.getList()) {
			if (FACTURE_CODE_1.equals(obj.getCode())) {
				facture1 = obj;
			}
		}
		Assert.assertNotNull(facture1);
		Assert.assertNotNull(facture1.getConclusion());
		assertEqualsDate(facture1.getDateCloture(), FACTURE_DATE_CLOTURE_1);
		Assert.assertEquals(facture1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(facture1.isTermine(), FACTURE_TERMINE_1);
		Assert.assertEquals(facture1.isValide(), FACTURE_VALIDE_1);
		Assert.assertEquals(facture1.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertEquals(facture1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(facture1.getChantier());
		List<IEtude> listeEtudeFacture1 = facture1.getListEtude();
		Assert.assertEquals(listeEtudeFacture1.size(), 0);
		List<IEcheancier> listEcheancierFacture1 = facture1.getListEcheancier();
		Assert.assertEquals(listEcheancierFacture1.size(), 1);
		IEcheancier echeancier1Facture1 = listEcheancierFacture1.get(0);
		Assert.assertNotNull(echeancier1Facture1);
		List<IEcheancierReglement> listEcheancierRegltFacture1 = echeancier1Facture1.getListEcheancierReglement();
		Assert.assertEquals(listEcheancierRegltFacture1.size(), 1);
		IEcheancierReglement echRegltFacture1 = listEcheancierRegltFacture1.get(0);
		Assert.assertNotNull(echRegltFacture1);
		Assert.assertEquals(echRegltFacture1.getMontant(), ECHEANCIER_REGLEMENT_MONTANT_2);

		// Affaires - Situation
		ISituationManager situationMng = app.getSituationManager();
		ISituation situation1 = null;
		for (ISituation obj : situationMng.getList()) {
			if (SITUATION_CODE_1.equals(obj.getCode())) {
				situation1 = obj;
			}
		}
		Assert.assertNotNull(situation1);
		Assert.assertNotNull(situation1.getConclusion());
		assertEqualsDate(situation1.getDateCloture(), SITUATION_DATE_CLOTURE_1);
		Assert.assertEquals(situation1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(situation1.isTermine(), SITUATION_TERMINE_1);
		Assert.assertEquals(situation1.isValide(), SITUATION_VALIDE_1);
		Assert.assertEquals(situation1.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertEquals(situation1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(situation1.getChantier());
		List<IEtude> listeEtudeSituation1 = situation1.getListEtude();
		Assert.assertEquals(listeEtudeSituation1.size(), 0);

		// Affaires - Avoir
		IAvoirManager avoirMng = app.getAvoirManager();
		IAvoir avoir1 = null;
		for (IAvoir obj : avoirMng.getList()) {
			if (AVOIR_CODE_1.equals(obj.getCode())) {
				avoir1 = obj;
			}
		}
		Assert.assertNotNull(avoir1);
		Assert.assertNotNull(avoir1.getConclusion());
		assertEqualsDate(avoir1.getDateCloture(), AVOIR_DATE_CLOTURE_1);
		Assert.assertEquals(avoir1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(avoir1.isTermine(), AVOIR_TERMINE_1);
		Assert.assertEquals(avoir1.isValide(), AVOIR_VALIDE_1);
		Assert.assertEquals(avoir1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(avoir1.getChantier());
		List<IEtude> listeEtudeAvoir1 = avoir1.getListEtude();
		Assert.assertEquals(listeEtudeAvoir1.size(), 0);

		// Affaires - Acompte
		IAcompteManager acompteMng = app.getAcompteManager();
		IAcompte acompte1 = null;
		for (IAcompte obj : acompteMng.getList()) {
			if (ACOMPTE_CODE_1.equals(obj.getCode())) {
				acompte1 = obj;
			}
		}
		Assert.assertNotNull(acompte1);
		Assert.assertNotNull(acompte1.getConclusion());
		assertEqualsDate(acompte1.getDateCloture(), ACOMPTE_DATE_CLOTURE_1);
		Assert.assertEquals(acompte1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(acompte1.isTermine(), ACOMPTE_TERMINE_1);
		Assert.assertEquals(acompte1.isValide(), ACOMPTE_VALIDE_1);
		Assert.assertEquals(situation1.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertNull(acompte1.getClient());
		Assert.assertNotNull(acompte1.getChantier());
		List<IEtude> listeEtudeAcompte1 = acompte1.getListEtude();
		Assert.assertEquals(listeEtudeAcompte1.size(), 0);

		// //////////
		// Reglement - EchancierReglement
		IReglementManager rglMng = app.getReglementManager();
		IReglement rglt1 = null;
		for (IReglement obj : rglMng.getList()) {
			if (REGLEMENT_CODE.equals(obj.getCode())) {
				rglt1 = obj;
			}
		}
		Assert.assertNotNull(rglt1);
		Assert.assertEquals(rglt1.getBanque(), REGLEMENT_BANQUE);
		assertEqualsDate(rglt1.getDatePaiement(), REGLEMENT_DATE_PAIEMENT);
		Assert.assertEquals(rglt1.getDescriptif(), REGLEMENT_DESCRIPTIF);
		Assert.assertEquals(rglt1.getNumCheque(), REGLEMENT_NUM_CHEQUE);
		Assert.assertEquals(rglt1.getModePaiement().getLibelle(), MODE_PAIEMENT_LIBELLE);

		IEcheancierReglementManager echRglMng = app.getEcheancierReglementManager();
		IEcheancierReglement echRglt1 = null;
		List<IEcheancierReglement> listEchRglt = echRglMng.getList();
		for (IEcheancierReglement obj : listEchRglt) {
			Assert.assertNotNull(obj.getEcheancier());
			Assert.assertNotNull(obj.getReglement());
			if (obj.getEcheancier().getAffaire() != null && FACTURE_CODE_1.equals(obj.getEcheancier().getAffaire().getCode())
			        && REGLEMENT_CODE.equals(obj.getReglement().getCode())) {
				echRglt1 = obj;
			}
		}
		Assert.assertNotNull(echRglt1);
		Assert.assertEquals(echRglt1.getMontant(), ECHEANCIER_REGLEMENT_MONTANT_2);

		// ////////
		// Clients avec liste affaires
		IClientManager clientMng = app.getClientManager();
		IClient client1 = null;
		for (IClient obj : clientMng.getList()) {
			if (CLIENT_CODE_1.equals(obj.getCode())) {
				client1 = obj;
			}
		}
		Assert.assertNotNull(client1);
		Assert.assertEquals(client1.getCodeNaf(), CLIENT_CODE_NAF_1);
		Assert.assertEquals(client1.isHide(), CLIENT_HIDE_1);
		Assert.assertEquals(client1.getNomSociete(), CLIENT_NOM_SOCIETE_1);
		assertEqualsDate(client1.getRappelDate(), CLIENT_RAPPEL_DATE_1);
		Assert.assertEquals(client1.getSiren(), CLIENT_SIREN_1);
		Assert.assertEquals(client1.isProspect(), CLIENT_PROSPECT_1);
		Assert.assertEquals(client1.getMontantPlafond(), CLIENT_MONTANT_PLAFOND_1);
		Assert.assertEquals(client1.getTvaIntra(), CLIENT_TVA_INTRA_1);
		ICoordonneeCnt cooClient1 = client1.getCoordonnee();
		Assert.assertNotNull(cooClient1);
		Assert.assertEquals(cooClient1.getCivilite().getLibelle(), CIVILITE_LIBELLE_1);
		Assert.assertEquals(cooClient1.getComplementaire(), COO_COMPLEMENTAIRE_1);
		Assert.assertEquals(cooClient1.getCp(), COO_CP_1);
		Assert.assertEquals(cooClient1.getFax(), COO_FAX_1);
		Assert.assertEquals(cooClient1.getLocalisation().getLibelle(), LOCALISATION_LIBELLE_1);
		Assert.assertEquals(cooClient1.getMail(), COO_MAIL_1);
		Assert.assertEquals(cooClient1.getMail2(), COO_MAIL2_1);
		Assert.assertEquals(cooClient1.getMobile(), COO_MOBILE_1);
		Assert.assertEquals(cooClient1.getNom(), COO_NOM_1);
		Assert.assertEquals(cooClient1.getPays().getLibelle(), PAYS_LIBELLE_1);
		List<IAffaire> listAffaireClient1 = client1.getListAffaire();
		Assert.assertNotNull(listAffaireClient1);
		Assert.assertTrue(listAffaireClient1.size() > 0);
		// liste affaires
		IDevis dev1Client1 = null;
		IFacture facture1Client1 = null;
		ISituation situation1Client1 = null;
		IAvoir avoir1Client1 = null;
		for (IAffaire aff : listAffaireClient1) {
			if (aff instanceof IDevis && DEVIS_CODE_1.equals(aff.getCode())) {
				dev1Client1 = (IDevis) aff;
			} else if (aff instanceof IFacture && FACTURE_CODE_1.equals(aff.getCode())) {
				facture1Client1 = (IFacture) aff;
			} else if (aff instanceof ISituation && SITUATION_CODE_1.equals(aff.getCode())) {
				situation1Client1 = (ISituation) aff;
			} else if (aff instanceof IAvoir && AVOIR_CODE_1.equals(aff.getCode())) {
				avoir1Client1 = (IAvoir) aff;
			}
		}
		// facture
		Assert.assertNotNull(facture1Client1);
		assertEqualsDate(facture1Client1.getDateCloture(), FACTURE_DATE_CLOTURE_1);
		Assert.assertEquals(facture1Client1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(facture1Client1.isTermine(), FACTURE_TERMINE_1);
		Assert.assertEquals(facture1Client1.isValide(), FACTURE_VALIDE_1);
		Assert.assertEquals(facture1Client1.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertEquals(facture1Client1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(facture1Client1.getChantier());
		List<IEtude> listeEtudeFacture1Client1 = facture1Client1.getListEtude();
		Assert.assertEquals(listeEtudeFacture1Client1.size(), 0);
		List<IEcheancier> listEcheancierFacture1Client1 = facture1Client1.getListEcheancier();
		Assert.assertEquals(listEcheancierFacture1Client1.size(), 1);
		IEcheancier echeancierFacture1Client1 = listEcheancierFacture1Client1.get(0);
		Assert.assertNotNull(echeancierFacture1Client1);
		List<IEcheancierReglement> listEcheancierRegltFacture1Client1 = echeancierFacture1Client1.getListEcheancierReglement();
		Assert.assertEquals(listEcheancierRegltFacture1Client1.size(), 1);
		IEcheancierReglement echRegltFacture1Client1 = listEcheancierRegltFacture1Client1.get(0);
		Assert.assertNotNull(echRegltFacture1Client1);
		Assert.assertEquals(echRegltFacture1Client1.getMontant(), ECHEANCIER_REGLEMENT_MONTANT_2);

		// devis
		Assert.assertNotNull(dev1Client1);
		assertEqualsDate(dev1Client1.getDateCloture(), SITUATION_DATE_CLOTURE_1);
		Assert.assertEquals(dev1Client1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(dev1Client1.isTermine(), SITUATION_TERMINE_1);
		Assert.assertEquals(dev1Client1.isValide(), SITUATION_VALIDE_1);
		Assert.assertNull(dev1Client1.getDevis());
		Assert.assertEquals(dev1Client1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(dev1Client1.getChantier());
		List<IEtude> listeEtudeDevis1Client1 = dev1Client1.getListEtude();
		Assert.assertEquals(listeEtudeDevis1Client1.size(), 1);
		IEtude etudeDevis1Client1 = listeEtudeDevis1Client1.get(0);
		List<IBibEltEtude> listBibEtudeDevis1Client1 = etudeDevis1Client1.getListBibliotheque();
		Assert.assertEquals(listBibEtudeDevis1Client1.size(), 1);
		IBibEltEtude bibEtudeDevis1Client1 = listBibEtudeDevis1Client1.get(0);
		Assert.assertTrue(bibEtudeDevis1Client1 instanceof IMateriauxEtude);
		IMateriauxEtude mxEtudeDevis1Client1 = (IMateriauxEtude) bibEtudeDevis1Client1;
		Assert.assertEquals(mxEtudeDevis1Client1.getCode(), BIB_MX_ETUDE_CODE_1);

		// situation
		Assert.assertNotNull(situation1Client1);
		assertEqualsDate(situation1Client1.getDateCloture(), SITUATION_DATE_CLOTURE_1);
		Assert.assertEquals(situation1Client1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(situation1Client1.isTermine(), SITUATION_TERMINE_1);
		Assert.assertEquals(situation1Client1.isValide(), SITUATION_VALIDE_1);
		Assert.assertEquals(situation1Client1.getDevis().getCode(), DEVIS_CODE_1);
		Assert.assertEquals(situation1Client1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(situation1Client1.getChantier());
		List<IEtude> listeEtudeSituation1Client1 = situation1Client1.getListEtude();
		Assert.assertEquals(listeEtudeSituation1Client1.size(), 0);

		// avoir
		Assert.assertNotNull(avoir1Client1);
		assertEqualsDate(avoir1Client1.getDateCloture(), AVOIR_DATE_CLOTURE_1);
		Assert.assertEquals(avoir1Client1.getEtat().getLibelle(), ETAT_LIBELLE_1);
		Assert.assertEquals(avoir1Client1.isTermine(), AVOIR_TERMINE_1);
		Assert.assertEquals(avoir1Client1.isValide(), AVOIR_VALIDE_1);
		Assert.assertEquals(avoir1Client1.getClient().getCode(), CLIENT_CODE_1);
		Assert.assertNotNull(avoir1Client1.getChantier());
		List<IEtude> listeEtudeAvor1Client1 = avoir1Client1.getListEtude();
		Assert.assertEquals(listeEtudeAvor1Client1.size(), 0);

		// Clients
		IClient client2 = null;
		for (IClient obj : clientMng.getList()) {
			if (CLIENT_CODE_2.equals(obj.getCode())) {
				client2 = obj;
			}
		}
		Assert.assertNotNull(client2);
		Assert.assertEquals(client2.getCodeNaf(), CLIENT_CODE_NAF_2);
		Assert.assertEquals(client2.isHide(), CLIENT_HIDE_2);
		Assert.assertEquals(client2.getNomSociete(), CLIENT_NOM_SOCIETE_2);
		assertEqualsDate(client2.getRappelDate(), CLIENT_RAPPEL_DATE_2);
		Assert.assertEquals(client2.getSiren(), CLIENT_SIREN_2);
		Assert.assertEquals(client2.isProspect(), CLIENT_PROSPECT_2);
		Assert.assertEquals(client2.getMontantPlafond(), CLIENT_MONTANT_PLAFOND_2);
		Assert.assertEquals(client2.getTvaIntra(), CLIENT_TVA_INTRA_2);

		// Divers Contact
		IDiversCntManager diversCntMng = app.getDiversCntManager();
		IDiversCnt diversCnt1 = null;
		for (IDiversCnt obj : diversCntMng.getList()) {
			if (DIV_CNT_CODE_1.equals(obj.getCode())) {
				diversCnt1 = obj;
			}
		}
		Assert.assertNotNull(diversCnt1);
		Assert.assertEquals(diversCnt1.getCodeNaf(), DIV_CNT_CODE_NAF_1);
		Assert.assertEquals(diversCnt1.isHide(), DIV_CNT_HIDE_1);
		Assert.assertEquals(diversCnt1.getNomSociete(), DIV_CNT_NOM_SOCIETE_1);
		assertEqualsDate(diversCnt1.getRappelDate(), DIV_CNT_RAPPEL_DATE_1);
		Assert.assertNotNull(diversCnt1.getRappelMotif());
		Assert.assertEquals(diversCnt1.getSiren(), DIV_CNT_SIREN_1);
		Assert.assertEquals(diversCnt1.getTvaIntra(), DIV_CNT_TVA_INTRA_1);
		List<IGroupeCnt> listGrpCnt = diversCnt1.getListGroupeContact();
		Assert.assertEquals(listGrpCnt.size(), 1);
		Assert.assertEquals(listGrpCnt.get(0).getLibelle(), GROUPE_CNT_LIBELLE_1);

		// Groupe Contact
		IGroupeCntManager groupeCntMng = app.getGroupeCntManager();
		IGroupeCnt groupeCnt1 = null;
		for (IGroupeCnt obj : groupeCntMng.getList()) {
			if (GROUPE_CNT_LIBELLE_1.equals(obj.getLibelle())) {
				groupeCnt1 = obj;
			}
		}
		Assert.assertNotNull(groupeCnt1);
		List<IDiversCnt> listDiversCnt = groupeCnt1.getListDiversContact();
		Assert.assertEquals(listDiversCnt.size(), 1);
		Assert.assertEquals(listDiversCnt.get(0).getCode(), DIV_CNT_CODE_1);

	}

	private void testUpdate() throws BatifreeException {

		IFactoryBf factory = app.getFactory();

		// Récupère les familles
		IFamilleManager familleMng = app.getFamilleManager();
		List<IFamille> listFamille = familleMng.getList();
		Assert.assertNotNull(listFamille);
		IFamille famille2 = null;
		for (IFamille fam : listFamille) {
			if (FAMILLE_DESC_2.equals(fam.getDescriptif())) {
				famille2 = fam;
			}
		}
		Assert.assertNotNull(famille2);
		Assert.assertEquals(FAMILLE_TYPE_2, famille2.getType());
		List<IFamille> listFamille2 = famille2.getListLigne();
		Assert.assertEquals(1, listFamille2.size());

		// Récupère la 1ère famille de la famille 2
		IFamille famille22 = listFamille2.get(0);
		Assert.assertEquals(FAMILLE_DESC_22, famille22.getDescriptif());
		Assert.assertEquals(FAMILLE_TYPE_22, famille22.getType());

		// Crée une nouvelle famille et l'ajoute à la famille 2
		IFamille fam23 = factory.createNewInstance(IFamille.class);
		fam23.setDescriptif(FAMILLE_DESC_23);
		fam23.setType(FAMILLE_TYPE_23);
		fam23.setParent(famille2);
		listFamille2.add(fam23);

		// Sauvegarde la nouvelle famille
		IFamille famNew2 = familleMng.save(fam23);
		Assert.assertNotNull(famNew2);
		Assert.assertEquals(FAMILLE_TYPE_2, famNew2.getType());
		Assert.assertEquals(FAMILLE_DESC_2, famNew2.getDescriptif());

		// Récupère les familles
		List<IFamille> listFamilleNew = familleMng.getList();
		Assert.assertNotNull(listFamille);
		IFamille familleNew2 = null;
		for (IFamille fam : listFamilleNew) {
			if (FAMILLE_DESC_2.equals(fam.getDescriptif())) {
				familleNew2 = fam;
			}
		}
		Assert.assertNotNull(familleNew2);

		// Récupère la liste de famille de la famille 2
		List<IFamille> listFamilleNew2 = familleNew2.getListLigne();
		Assert.assertEquals(2, listFamilleNew2.size());

		// Supprime la 1ère famille
		listFamilleNew2.remove(0);

		// Sauvegarde la nouvelle famille
		IFamille famNewDelete2 = familleMng.save(familleNew2);
		Assert.assertNotNull(famNewDelete2);
		Assert.assertEquals(FAMILLE_TYPE_2, famNewDelete2.getType());
		Assert.assertEquals(FAMILLE_DESC_2, famNewDelete2.getDescriptif());
	}

	@Test
	public void testTransaction() throws BatifreeException {
		beginTransaction();
		try {
			commitTransaction();
		} catch (BatifreeException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private final String TVA_LIBELLE_1 = "tva1 - 19.6";
	private final Float TVA_TAUX_1 = 19.6F;
	private final String TVA_LIBELLE_2 = "tva2 - 10";
	private final Float TVA_TAUX_2 = 10F;
	private final String TVA_LIBELLE_3 = "tva3 - 0";
	private final Float TVA_TAUX_3 = 0F;
	private final String TVA_LIBELLE_4 = "tva4 - Hide";
	private final Float TVA_TAUX_4 = 5F;

	private final String FAMILLE_DESC_1 = "desc1";
	private final Short FAMILLE_TYPE_1 = 3;
	private final String FAMILLE_DESC_2 = "desc2";
	private final Short FAMILLE_TYPE_2 = 4;
	private final String FAMILLE_DESC_22 = "desc22";
	private final Short FAMILLE_TYPE_22 = 6;
	private final String FAMILLE_DESC_23 = "desc23";
	private final Short FAMILLE_TYPE_23 = 7;

	private final String PAYS_LIBELLE_1 = "pays libelle1";
	private final String PAYS_LIBELLE_2 = "pays libelle2";
	private final String LOCALISATION_LIBELLE_1 = "loc libelle1";
	private final String LOCALISATION_LIBELLE_2 = "loc libelle2";
	private final String ACTIVITE_LIBELLE_1 = "activite libelle1";
	private final String ACTIVITE_LIBELLE_2 = "activite libelle2";
	private final String CATEGORIE_LIBELLE_1 = "categorie libelle1";
	private final String CATEGORIE_LIBELLE_2 = "categorie libelle2";
	private final String ETAT_LIBELLE_1 = "etat libelle1";
	private final String ETAT_LIBELLE_2 = "etat libelle2";
	private final String CIVILITE_LIBELLE_1 = "civilite libelle1";
	private final String CIVILITE_LIBELLE_2 = "civilite libelle2";

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

	private final String BIB_MX_BAR_CODE_2 = "mx bar code 2";
	private final String BIB_MX_CODE_2 = "mx code 2";
	private final Float BIB_MX_BENEFICE_2 = 20F;
	private final Float BIB_MX_FRAIS_GENRERAUX_2 = 30F;
	private final String BIB_MX_MOT_CLE_2 = "mx mot cle 2";
	private final String BIB_MX_NUM_SERIE_2 = "mx num serie 2";
	private final Float BIB_MX_PRIX_ACHAT_2 = 40F;
	private final String BIB_MX_UNITE_2 = "mx un 2";
	private final Float BIB_MX_PRIX_TARIF_2 = 50F;
	private final Float BIB_MX_REMISE_2 = 10F;

	private final String BIB_MO_BAR_CODE_2 = "mo bar code 2";
	private final String BIB_MO_CODE_2 = "mo code 2";
	private final Float BIB_MO_BENEFICE_2 = 30F;
	private final Float BIB_MO_FRAIS_GENRERAUX_2 = 40F;
	private final String BIB_MO_MOT_CLE_2 = "mo mot cle 2";
	private final String BIB_MO_NUM_SERIE_2 = "mo num serie 2";
	private final Float BIB_MO_PRIX_ACHAT_2 = 50F;
	private final String BIB_MO_UNITE_2 = "mo un 2";

	private final String BIB_ENG_BAR_CODE_2 = "eng bar code 2";
	private final String BIB_ENG_CODE_2 = "eng code 2";
	private final Float BIB_ENG_BENEFICE_2 = 30F;
	private final Float BIB_ENG_FRAIS_GENRERAUX_2 = 40F;
	private final String BIB_ENG_MOT_CLE_2 = "eng mot cle 2";
	private final String BIB_ENG_NUM_SERIE_2 = "eng num serie 2";
	private final Float BIB_ENG_PRIX_ACHAT_2 = 50F;
	private final String BIB_ENG_UNITE_2 = "eng un 2";

	private final String BIB_SST_BAR_CODE_2 = "sst bar code 2";
	private final String BIB_SST_CODE_2 = "sst code 2";
	private final Float BIB_SST_BENEFICE_2 = 30F;
	private final Float BIB_SST_FRAIS_GENRERAUX_2 = 40F;
	private final String BIB_SST_MOT_CLE_2 = "sst mot cle 2";
	private final String BIB_SST_NUM_SERIE_2 = "sst num serie 2";
	private final Float BIB_SST_PRIX_ACHAT_2 = 50F;
	private final String BIB_SST_UNITE_2 = "sst un 2";

	private final String BIB_LOT_CODE_2 = "lot code 2";
	private final String BIB_LOT_MOT_CLE_2 = "lot mot cle 2";
	private final String BIB_LOT_UNITE_2 = "lot un 2";

	private final String BIB_TAC_BAR_CODE_2 = "tac bar code 2";
	private final String BIB_TAC_CODE_2 = "tac code 2";
	private final Float BIB_TAC_BENEFICE_2 = 30F;
	private final Float BIB_TAC_FRAIS_GENRERAUX_2 = 40F;
	private final String BIB_TAC_MOT_CLE_2 = "tac mot cle 2";
	private final String BIB_TAC_NUM_SERIE_2 = "tac num serie 2";
	private final Float BIB_TAC_PRIX_ACHAT_2 = 50F;
	private final String BIB_TAC_UNITE_2 = "tac un 2";

	private final String BIB_MX_CODE_3 = "mx code 3";
	private final String BIB_MO_CODE_3 = "mo code 3";
	private final String BIB_ENG_CODE_3 = "eng code 3";
	private final String BIB_SST_CODE_3 = "sst code 3";
	private final String BIB_LOT_CODE_3 = "lot code 3";
	private final String BIB_TAC_CODE_3 = "tac code 3";
	private final String BIB_TAC_CODE_4 = "tac code 4";

	private final String BIB_MX_ETUDE_CODE_2 = "mx code etude 2";
	private final String BIB_MO_ETUDE_CODE_2 = "mo code etude 2";
	private final String BIB_ENG_ETUDE_CODE_2 = "eng code etude 2";
	private final String BIB_SST_ETUDE_CODE_2 = "sst code etude 2";
	private final String BIB_LOT_ETUDE_CODE_2 = "lot code etude 2";
	private final String BIB_TAC_ETUDE_CODE_2 = "tac code etude 2";

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

	private final String CLIENT_CODE_2 = "code client2";
	private final String CLIENT_CODE_NAF_2 = "nafCl2";
	private final Boolean CLIENT_HIDE_2 = true;
	private final String CLIENT_NOM_SOCIETE_2 = "client2 nom societe";
	private final Date CLIENT_RAPPEL_DATE_2 = getDate();
	private final String CLIENT_SIREN_2 = "siren client2";
	private final String CLIENT_TVA_INTRA_2 = "tvaintraCl2";
	private final boolean CLIENT_PROSPECT_2 = false;
	private final Float CLIENT_MONTANT_PLAFOND_2 = 100F;

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

	private final byte[] BIN_LIG_ETU_METRE_OBJECT_1 = { 7, 8 };

	private final Float LIG_ETU_QUANTITE_1 = 3F;

	private final String MODE_PAIEMENT_LIBELLE = "mdp libelle 1";

	private final String REGLEMENT_CODE = "rgl code 1";
	private final String REGLEMENT_DESCRIPTIF = "rgl descriptif 1";
	private final Date REGLEMENT_DATE_PAIEMENT = getDate();
	private final String REGLEMENT_BANQUE = "rgl banque 1";
	private final String REGLEMENT_NUM_CHEQUE = "rgl num cheque 1";

	private final Float ECHEANCIER_REGLEMENT_MONTANT_1 = 51F;
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
	private final String DEVIS_BIB_CODE_2 = "devis bib code 2";
	private final String DEVIS_CODE_2 = "devis code 2";

	private final String FACTURE_CODE_1 = "facture code 1";
	private final Date FACTURE_DATE_CLOTURE_1 = getDate();
	private final Date FACTURE_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date FACTURE_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date FACTURE_DUREE_VALIDITE_1 = getDate();
	private final String FACTURE_REFERENCE_1 = "facture reference 1";
	private final Boolean FACTURE_TERMINE_1 = true;
	private final Boolean FACTURE_VALIDE_1 = true;
	private final String FACTURE_CODE_2 = "facture code 2";
	private final String FACTURE_CODE_3 = "facture code 3";

	private final String SITUATION_CODE_1 = "situation code 1";
	private final Date SITUATION_DATE_CLOTURE_1 = getDate();
	private final Date SITUATION_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date SITUATION_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date SITUATION_DUREE_VALIDITE_1 = getDate();
	private final String SITUATION_REFERENCE_1 = "situation reference 1";
	private final Boolean SITUATION_TERMINE_1 = true;
	private final Boolean SITUATION_VALIDE_1 = true;
	private final String SITUATION_CODE_2 = "situation code 2";
	private final String SITUATION_CODE_3 = "situation code 3";

	private final String AVOIR_CODE_1 = "avoir code 1";
	private final Date AVOIR_DATE_CLOTURE_1 = getDate();
	private final Date AVOIR_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date AVOIR_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date AVOIR_DUREE_VALIDITE_1 = getDate();
	private final String AVOIR_REFERENCE_1 = "avoir reference 1";
	private final Boolean AVOIR_TERMINE_1 = true;
	private final Boolean AVOIR_VALIDE_1 = true;
	private final String AVOIR_CODE_2 = "avoir code 2";

	private final String ACOMPTE_CODE_1 = "acompte code 1";
	private final Date ACOMPTE_DATE_CLOTURE_1 = getDate();
	private final Date ACOMPTE_DATE_DEB_TRAVAUX_1 = getDate();
	private final Date ACOMPTE_DATE_FIN_TRAVAUX_1 = getDate();
	private final Date ACOMPTE_DUREE_VALIDITE_1 = getDate();
	private final String ACOMPTE_REFERENCE_1 = "acompte reference 1";
	private final Boolean ACOMPTE_TERMINE_1 = true;
	private final Boolean ACOMPTE_VALIDE_1 = true;
	private final String ACOMPTE_CODE_2 = "acompte code 2";

	private final String GROUPE_CNT_LIBELLE_1 = "libelle grpCnt1";

	private final String DIV_CNT_CODE_1 = "code divCnt1";
	private final String DIV_CNT_CODE_NAF_1 = "nafDi1";
	private final Boolean DIV_CNT_HIDE_1 = false;
	private final String DIV_CNT_NOM_SOCIETE_1 = "divCnt1 nom societe";
	private final Date DIV_CNT_RAPPEL_DATE_1 = getDate();
	private final String DIV_CNT_SIREN_1 = "siren divCnt1";
	private final String DIV_CNT_TVA_INTRA_1 = "tvaintraDi1";

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
	 * @throws BatifreeException
	 */
	private void testAdd() throws BatifreeException {
		boolean isBeginTransaction = false;
		if (isBeginTransaction) {
			beginTransaction();
		}

		try {
			IFactoryBf factory = app.getFactory();

			ITva tva1 = factory.createNewInstance(ITva.class);
			tva1.setLibelle(TVA_LIBELLE_1);
			tva1.setTaux(TVA_TAUX_1);
			ITva tva2 = factory.createNewInstance(ITva.class);
			tva2.setLibelle(TVA_LIBELLE_2);
			tva2.setTaux(TVA_TAUX_2);
			ITva tva3 = factory.createNewInstance(ITva.class);
			tva3.setLibelle(TVA_LIBELLE_3);
			tva3.setTaux(TVA_TAUX_3);
			ITva tva4 = factory.createNewInstance(ITva.class);
			tva4.setLibelle(TVA_LIBELLE_4);
			tva4.setTaux(TVA_TAUX_4);
			ITvaManager tvaMng = app.getTvaManager();
			tva1 = tvaMng.save(tva1);
			tva2 = tvaMng.save(tva2);
			tva3 = tvaMng.save(tva3);
			tva4 = tvaMng.save(tva4);

			IFamille fam1 = factory.createNewInstance(IFamille.class);
			fam1.setDescriptif(FAMILLE_DESC_1);
			fam1.setType(FAMILLE_TYPE_1);
			IFamille fam2 = factory.createNewInstance(IFamille.class);
			fam2.setDescriptif(FAMILLE_DESC_2);
			fam2.setType(FAMILLE_TYPE_2);
			IFamille fam22 = factory.createNewInstance(IFamille.class);
			fam22.setDescriptif(FAMILLE_DESC_22);
			fam22.setType(FAMILLE_TYPE_22);
			List<IFamille> listFamille2 = new ArrayList<>();
			listFamille2.add(fam22);
			fam2.setListLigne(listFamille2);
			List<IFamille> listFamille = new ArrayList<>();
			listFamille.add(fam1);
			listFamille.add(fam2);
			IFamilleManager familleMng = app.getFamilleManager();
			familleMng.save(listFamille);

			// Recherche de fam1 et fam2 à partir de la liste
			List<IFamille> listFamilleNew = app.getFamilleManager().getList();
			for (IFamille iFamille : listFamilleNew) {
				if (FAMILLE_DESC_1.equals(iFamille.getDescriptif())) {
					fam1 = iFamille;
				} else if (FAMILLE_DESC_2.equals(iFamille.getDescriptif())) {
					fam22 = iFamille;
				}
			}

			IPays pays1 = factory.createNewInstance(IPays.class);
			pays1.setLibelle(PAYS_LIBELLE_1);
			IPays pays2 = factory.createNewInstance(IPays.class);
			pays2.setLibelle(PAYS_LIBELLE_2);
			IPaysManager paysMng = app.getPaysManager();
			pays1 = paysMng.save(pays1);
			pays2 = paysMng.save(pays2);

			ILocalisation loc1 = factory.createNewInstance(ILocalisation.class);
			loc1.setLibelle(LOCALISATION_LIBELLE_1);
			ILocalisation loc2 = factory.createNewInstance(ILocalisation.class);
			loc2.setLibelle(LOCALISATION_LIBELLE_2);
			ILocalisationManager locMng = app.getLocalisationManager();
			loc1 = locMng.save(loc1);
			loc2 = locMng.save(loc2);

			IActivite act1 = factory.createNewInstance(IActivite.class);
			act1.setLibelle(ACTIVITE_LIBELLE_1);
			IActivite act2 = factory.createNewInstance(IActivite.class);
			act2.setLibelle(ACTIVITE_LIBELLE_2);
			IActiviteManager actMng = app.getActiviteManager();
			act1 = actMng.save(act1);
			act2 = actMng.save(act2);

			ICategorie cat1 = factory.createNewInstance(ICategorie.class);
			cat1.setLibelle(CATEGORIE_LIBELLE_1);
			ICategorie cat2 = factory.createNewInstance(ICategorie.class);
			cat2.setLibelle(CATEGORIE_LIBELLE_2);
			ICategorieManager catMng = app.getCategorieManager();
			cat1 = catMng.save(cat1);
			cat2 = catMng.save(cat2);

			IChantier cht1 = factory.createNewInstance(IChantier.class);
			IChantierManager chtMng = app.getChantierManager();
			cht1 = chtMng.save(cht1);

			IEtat etat1 = factory.createNewInstance(IEtat.class);
			etat1.setLibelle(ETAT_LIBELLE_1);
			IEtat etat2 = factory.createNewInstance(IEtat.class);
			etat2.setLibelle(ETAT_LIBELLE_2);
			etat1 = app.getEtatManager().save(etat1);
			etat2 = app.getEtatManager().save(etat2);

			ICivilite civ1 = factory.createNewInstance(ICivilite.class);
			civ1.setLibelle(CIVILITE_LIBELLE_1);
			civ1 = app.getCiviliteManager().save(civ1);
			ICivilite civ2 = factory.createNewInstance(ICivilite.class);
			civ2.setLibelle(CIVILITE_LIBELLE_2);
			civ2 = app.getCiviliteManager().save(civ2);

			// Binaires
			IBinaireManager binaireMng = app.getBinaireManager();

			// Contact binaire
			IBinaire binRappelMotif1 = factory.createNewInstance(IBinaire.class);
			binRappelMotif1.setObjet(BIN_CONTACT_RAPPEL_MOTIF_OBJECT_1);
			binRappelMotif1 = binaireMng.save(binRappelMotif1);

			IBinaire binRemarques1 = factory.createNewInstance(IBinaire.class);
			binRemarques1.setObjet(BIN_CONTACT_REMARQUES_OBJECT_1);
			binRemarques1 = binaireMng.save(binRemarques1);

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
			// Fournisseur
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

			IFournisseur four1 = factory.createNewInstance(IFournisseur.class);
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
			IFournisseurMateriaux frnbMx = factory.createNewInstance(IFournisseurMateriaux.class);
			frnbMx.setFournisseur(four1);
			frnbMx.setPrixTarif(FOURNISSEUR_MATERIAUX_PRIX_TARIF_1);
			frnbMx.setQuantiteMini(FOURNISSEUR_MATERIAUX_QTE_MINI_1);
			frnbMx.setRemise(FOURNISSEUR_MATERIAUX_REMISE_1);

			// /////////
			// Mx Bib
			IMateriauxBib mxBib = factory.createNewInstance(IMateriauxBib.class);
			mxBib.setTva(tva2);
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
			mxBib.setFamille(fam22);
			mxBib.setRemise(BIB_MX_REMISE_1);
			mxBib.setFournisseurDefaut(four1);
			mxBib.setPrixTarif(BIB_MX_PRIX_TARIF_1);
			List<IFournisseurMateriaux> listFrnMx = new ArrayList<>();
			listFrnMx.add(frnbMx);
			mxBib.setListFournisseurMateriaux(listFrnMx);
			IMateriauxBibManager mxbibmng = app.getMateriauxBibManager();
			mxBib = mxbibmng.saveLigne(mxBib);

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
			IMainOeuvreBib moBib = factory.createNewInstance(IMainOeuvreBib.class);
			moBib.setTva(tva2);
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
			moBib.setFamille(fam22);
			moBib.setQuantite(BIB_MO_QUANTITE_1);
			moBib = app.getMainOeuvreBibManager().saveLigne(moBib);

			IEnginBib engBib = factory.createNewInstance(IEnginBib.class);
			engBib.setTva(tva2);
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
			engBib.setFamille(fam22);
			engBib.setQuantite(BIB_ENG_QUANTITE_1);
			engBib.setImmatriculation(BIB_ENG_IMMATRICULATION);
			engBib.setImmatriculationDate(BIB_ENG_IMMATRICULATION_DATE);
			engBib = app.getEnginBibManager().saveLigne(engBib);

			ISousTraitantBib sstBib = factory.createNewInstance(ISousTraitantBib.class);
			sstBib.setTva(tva2);
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
			sstBib.setFamille(fam22);
			sstBib = app.getSousTraitantBibManager().saveLigne(sstBib);

			ILotBib lotBib = factory.createNewInstance(ILotBib.class);
			lotBib.setTva(tva1);
			lotBib.setDescriptif(binDescriptif1);
			lotBib.setDescriptionCommerciale(binDescriptifCommercial1);
			lotBib.setDescriptionTechnique(binDescriptifTechnique1);
			lotBib.setNotes(binNote1);
			lotBib.setCode(BIB_LOT_CODE_1);
			lotBib.setImage(img1);
			lotBib.setMotCle(BIB_LOT_MOT_CLE_1);
			lotBib.setUnite(BIB_LOT_UNITE_1);
			lotBib.setFamille(fam22);
			List<IBibliotheque> listLigneLot = new ArrayList<>();
			ISousTraitantBib sstBibImport = sstBib.getCloneForImport();
			listLigneLot.add(sstBibImport);
			lotBib.setListLigne(listLigneLot);
			lotBib = app.getLotBibManager().saveLigne(lotBib);

			ITacheBib tacBib = factory.createNewInstance(ITacheBib.class);
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
			tacBib.setFamille(fam22);
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
			listLigneTache.add(engBib.getCloneForImport());
			listLigneTache.add(moBib.getCloneForImport());
			tacBib.setListLigne(listLigneTache);
			tacBib = app.getTacheBibManager().saveLigne(tacBib);

			// Etudes - lignes Etude
			IDevis devForBib = factory.createNewInstance(IDevis.class);
			devForBib.setCode(DEVIS_BIB_CODE_2);
			devForBib.setEtat(etat1);

			// List des lignes bib études
			List<IBibEltEtude> listLigDevForBibEtude = new ArrayList<>();

			// Ligne etude binaire
			IBinaire binLigEtudeMetre1 = factory.createNewInstance(IBinaire.class);
			binLigEtudeMetre1.setObjet(BIN_LIG_ETU_METRE_OBJECT_1);
			binLigEtudeMetre1 = binaireMng.save(binLigEtudeMetre1);

			showArboBib();
			// Bib Etude : Bib clone Etude
			IMateriauxEtude mxBibToEtude = mxBib.getMateriauxEtude();
			mxBibToEtude.setCode(BIB_MX_ETUDE_CODE_2);
			mxBibToEtude.setTva(tva1);
			mxBibToEtude.setQuantite(LIG_ETU_QUANTITE_1);
			mxBibToEtude.setMetre(binLigEtudeMetre1);
			listLigDevForBibEtude.add(mxBibToEtude);

			IMainOeuvreEtude moBibToEtude = moBib.getMainOeuvreEtude();
			mxBibToEtude.setCode(BIB_MO_ETUDE_CODE_2);
			moBibToEtude.setTva(tva1);
			listLigDevForBibEtude.add(moBibToEtude);

			IEnginEtude engBibToEtude = engBib.getEnginEtude();
			mxBibToEtude.setCode(BIB_ENG_ETUDE_CODE_2);
			engBibToEtude.setTva(tva1);
			listLigDevForBibEtude.add(engBibToEtude);

			ISousTraitantEtude sstBibToEtude = sstBib.getSousTraitantEtude();
			mxBibToEtude.setCode(BIB_SST_ETUDE_CODE_2);
			sstBibToEtude.setTva(tva1);
			listLigDevForBibEtude.add(sstBibToEtude);

			ILotEtude lotBibToEtude = lotBib.getLotEtude();
			mxBibToEtude.setCode(BIB_LOT_ETUDE_CODE_2);
			lotBibToEtude.setTva(tva1);
			listLigDevForBibEtude.add(lotBibToEtude);

			ITacheEtude tacBibToEtude = tacBib.getTacheEtude();
			tacBibToEtude.setCode(BIB_TAC_ETUDE_CODE_2);
			tacBibToEtude.setTva(tva1);
			listLigDevForBibEtude.add(tacBibToEtude);

			// Save de Affaire avec Etude, Lignes Bib de Etude
			devForBib = app.getDevisManager().save(devForBib);

			// Save de l'étude
			IEtude etude2 = factory.createNewInstanceEtude(devForBib);
			etude2.setTvaDefaut(tva3);
			etude2.setListBibliotheque(listLigDevForBibEtude);
			etude2 = app.getEtudeManager().save(etude2);

			// New Bib Etude
			List<IBibEltEtude> listLigEtude3 = new ArrayList<>();
			showArboBib();
			IMateriauxEtude mxNewEtude = factory.createNewInstance(IMateriauxEtude.class);
			mxNewEtude.setTva(tva2);
			mxNewEtude.setDescriptif(binDescriptif1);
			mxNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			mxNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			mxNewEtude.setNotes(binNote1);
			mxNewEtude.setBarCode(BIB_MX_BAR_CODE_2);
			mxNewEtude.setBenefice(BIB_MX_BENEFICE_2);
			mxNewEtude.setCode(BIB_MX_CODE_2);
			mxNewEtude.setFraisGeneraux(BIB_MX_FRAIS_GENRERAUX_2);
			mxNewEtude.setImage(img1);
			mxNewEtude.setMotCle(BIB_MX_MOT_CLE_2);
			mxNewEtude.setNumSerie(BIB_MX_NUM_SERIE_2);
			mxNewEtude.setPrixAchatUnitaire(BIB_MX_PRIX_ACHAT_2);
			mxNewEtude.setUnite(BIB_MX_UNITE_2);
			mxNewEtude.setFamille(fam22);
			mxNewEtude.setRemise(BIB_MX_REMISE_2);
			mxNewEtude.setFournisseurDefaut(four1);
			mxNewEtude.setPrixTarif(BIB_MX_PRIX_TARIF_2);
			listLigEtude3.add(mxNewEtude);

			IMainOeuvreEtude moNewEtude = factory.createNewInstance(IMainOeuvreEtude.class);
			moNewEtude.setTva(tva2);
			moNewEtude.setDescriptif(binDescriptif1);
			moNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			moNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			moNewEtude.setNotes(binNote1);
			moNewEtude.setBarCode(BIB_MO_BAR_CODE_2);
			moNewEtude.setBenefice(BIB_MO_BENEFICE_2);
			moNewEtude.setCode(BIB_MO_CODE_2);
			moNewEtude.setFraisGeneraux(BIB_MO_FRAIS_GENRERAUX_2);
			moNewEtude.setImage(img1);
			moNewEtude.setMotCle(BIB_MO_MOT_CLE_2);
			moNewEtude.setNumSerie(BIB_MO_NUM_SERIE_2);
			moNewEtude.setPrixAchatUnitaire(BIB_MO_PRIX_ACHAT_2);
			moNewEtude.setUnite(BIB_MO_UNITE_2);
			moNewEtude.setFamille(fam22);
			listLigEtude3.add(moNewEtude);

			IEnginEtude engNewEtude = factory.createNewInstance(IEnginEtude.class);
			engNewEtude.setTva(tva2);
			engNewEtude.setDescriptif(binDescriptif1);
			engNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			engNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			engNewEtude.setNotes(binNote1);
			engNewEtude.setBarCode(BIB_ENG_BAR_CODE_2);
			engNewEtude.setBenefice(BIB_ENG_BENEFICE_2);
			engNewEtude.setCode(BIB_ENG_CODE_2);
			engNewEtude.setFraisGeneraux(BIB_ENG_FRAIS_GENRERAUX_2);
			engNewEtude.setImage(img1);
			engNewEtude.setMotCle(BIB_ENG_MOT_CLE_2);
			engNewEtude.setNumSerie(BIB_ENG_NUM_SERIE_2);
			engNewEtude.setPrixAchatUnitaire(BIB_ENG_PRIX_ACHAT_2);
			engNewEtude.setUnite(BIB_ENG_UNITE_2);
			engNewEtude.setFamille(fam22);
			listLigEtude3.add(engNewEtude);

			ISousTraitantEtude sstNewEtude = factory.createNewInstance(ISousTraitantEtude.class);
			sstNewEtude.setTva(tva2);
			sstNewEtude.setDescriptif(binDescriptif1);
			sstNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			sstNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			sstNewEtude.setNotes(binNote1);
			sstNewEtude.setBarCode(BIB_SST_BAR_CODE_2);
			sstNewEtude.setBenefice(BIB_SST_BENEFICE_2);
			sstNewEtude.setCode(BIB_SST_CODE_2);
			sstNewEtude.setFraisGeneraux(BIB_SST_FRAIS_GENRERAUX_2);
			sstNewEtude.setImage(img1);
			sstNewEtude.setMotCle(BIB_SST_MOT_CLE_2);
			sstNewEtude.setNumSerie(BIB_SST_NUM_SERIE_2);
			sstNewEtude.setPrixAchatUnitaire(BIB_SST_PRIX_ACHAT_2);
			sstNewEtude.setUnite(BIB_SST_UNITE_2);
			sstNewEtude.setFamille(fam22);
			listLigEtude3.add(sstNewEtude);

			ILotEtude lotNewEtude = factory.createNewInstance(ILotEtude.class);
			lotNewEtude.setTva(tva2);
			lotNewEtude.setDescriptif(binDescriptif1);
			lotNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			lotNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			lotNewEtude.setNotes(binNote1);
			lotNewEtude.setCode(BIB_LOT_CODE_2);
			lotNewEtude.setImage(img1);
			lotNewEtude.setMotCle(BIB_LOT_MOT_CLE_2);
			lotNewEtude.setUnite(BIB_LOT_UNITE_2);
			lotNewEtude.setFamille(fam22);
			List<IBibliotheque> listLigneLotBib = new ArrayList<>();
			listLigneLotBib.add(sstNewEtude);
			lotNewEtude.setListLigne(listLigneLotBib);
			listLigEtude3.add(lotNewEtude);
			showArboBib();

			ITacheEtude tacNewEtude = factory.createNewInstance(ITacheEtude.class);
			tacNewEtude.setTva(tva2);
			tacNewEtude.setDescriptif(binDescriptif1);
			tacNewEtude.setDescriptionCommerciale(binDescriptifCommercial1);
			tacNewEtude.setDescriptionTechnique(binDescriptifTechnique1);
			tacNewEtude.setNotes(binNote1);
			tacNewEtude.setBarCode(BIB_TAC_BAR_CODE_2);
			tacNewEtude.setBenefice(BIB_TAC_BENEFICE_2);
			tacNewEtude.setCode(BIB_TAC_CODE_2);
			tacNewEtude.setFraisGeneraux(BIB_TAC_FRAIS_GENRERAUX_2);
			tacNewEtude.setImage(img1);
			tacNewEtude.setMotCle(BIB_TAC_MOT_CLE_2);
			tacNewEtude.setNumSerie(BIB_TAC_NUM_SERIE_2);
			tacNewEtude.setPrixAchatUnitaire(BIB_TAC_PRIX_ACHAT_2);
			tacNewEtude.setUnite(BIB_TAC_UNITE_2);
			tacNewEtude.setFamille(fam22);
			List<IBibliotheque> listLigneTacheBib = new ArrayList<>();
			listLigneTacheBib.add(engNewEtude);
			listLigneTacheBib.add(moNewEtude);
			tacNewEtude.setListLigne(listLigneTacheBib);
			listLigEtude3.add(tacNewEtude);
			showArboBib();

			// Save de Affaire avec Etude, Lignes Bib de Etude
			IEtude etude3 = factory.createNewInstanceEtude(devForBib);
			etude3.setListBibliotheque(listLigEtude3);
			etude3 = app.getEtudeManager().save(etude3);

			// Bib Etude : Etude clone Bib
			IMateriauxBib mxEtudeToBib = app.getMateriauxEtudeManager().getClone(mxNewEtude, factory.createNewInstance(IMateriauxBib.class));
			mxEtudeToBib.setCode(BIB_MX_CODE_3);
			mxEtudeToBib = app.getMateriauxBibManager().saveLigne(mxEtudeToBib);
			IMainOeuvreBib moEtudeToBib = app.getMainOeuvreEtudeManager().getClone(moNewEtude, factory.createNewInstance(IMainOeuvreBib.class));
			moEtudeToBib.setCode(BIB_MO_CODE_3);
			moEtudeToBib = app.getMainOeuvreBibManager().saveLigne(moEtudeToBib);
			IEnginBib engEtudeToBib = app.getEnginEtudeManager().getClone(engNewEtude, factory.createNewInstance(IEnginBib.class));
			engEtudeToBib.setCode(BIB_ENG_CODE_3);
			engEtudeToBib = app.getEnginBibManager().saveLigne(engEtudeToBib);
			ISousTraitantBib sstEtudeToBib = app.getSousTraitantEtudeManager().getClone(sstNewEtude,
			        factory.createNewInstance(ISousTraitantBib.class));
			sstEtudeToBib.setCode(BIB_SST_CODE_3);
			sstEtudeToBib = app.getSousTraitantBibManager().saveLigne(sstEtudeToBib);
			ILotBib lotEtudeToBib = app.getLotEtudeManager().getClone(lotNewEtude, factory.createNewInstance(ILotBib.class));
			lotEtudeToBib.setCode(BIB_LOT_CODE_3);
			lotEtudeToBib = app.getLotBibManager().saveLigne(lotEtudeToBib);
			ITacheBib tacEtudeToBib = app.getTacheEtudeManager().getClone(tacNewEtude, factory.createNewInstance(ITacheBib.class));
			tacEtudeToBib.setCode(BIB_TAC_CODE_3);
			tacEtudeToBib = app.getTacheBibManager().saveLigne(tacEtudeToBib);
			ITacheBib tacBibToBib = tacBib.getClone();
			tacBibToBib.setCode(BIB_TAC_CODE_4);
			tacBibToBib = app.getTacheBibManager().saveLigne(tacBibToBib);

			// ////////
			// Affaire : Règlement - échéancier - mode de paiement
			IEcheancier echeancier1 = factory.createNewInstance(IEcheancier.class);
			IEcheancierManager echMng = app.getEcheancierManager();
			echeancier1 = echMng.save(echeancier1);

			IModePaiement modePaiement1 = factory.createNewInstance(IModePaiement.class);
			modePaiement1.setLibelle(MODE_PAIEMENT_LIBELLE);
			IModePaiementManager modePaiementMng = app.getModePaiementManager();
			modePaiement1 = modePaiementMng.save(modePaiement1);

			IReglement reglement1 = factory.createNewInstance(IReglement.class);
			reglement1.setBanque(REGLEMENT_BANQUE);
			reglement1.setCode(REGLEMENT_CODE);
			reglement1.setDatePaiement(REGLEMENT_DATE_PAIEMENT);
			reglement1.setDescriptif(REGLEMENT_DESCRIPTIF);
			reglement1.setNumCheque(REGLEMENT_NUM_CHEQUE);
			reglement1.setModePaiement(modePaiement1);
			IReglementManager rgltMng = app.getReglementManager();
			reglement1 = rgltMng.save(reglement1);

			IEcheancierReglement echReglt1 = factory.createNewInstanceEcheancierReglement(echeancier1, reglement1);
			echReglt1.setMontant(ECHEANCIER_REGLEMENT_MONTANT_1);
			IEcheancierReglementManager echRegltMng = app.getEcheancierReglementManager();
			echReglt1 = echRegltMng.save(echReglt1);

			// ////////
			// Clients
			IClient client1 = factory.createNewInstance(IClient.class);
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
			IDevis dev1 = factory.createNewInstance(IDevis.class);
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
			IEtude etude4 = factory.createNewInstanceEtude(dev1);
			IMateriauxEtude mxDevisEtude1 = mxBib.getCloneForImport(IMateriauxEtude.class);
			mxDevisEtude1.setCode(BIB_MX_ETUDE_CODE_1);
			List<IBibEltEtude> listBibtoDevis1Etude = factory.createNewListInstance(IBibEltEtude.class);
			listBibtoDevis1Etude.add(mxDevisEtude1);
			etude4.setListBibliotheque(listBibtoDevis1Etude);
			etude4 = app.getEtudeManager().save(etude4);

			// Affaires - Facture
			IFacture facture1 = factory.createNewInstanceAffaire(IFacture.class, dev1);
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
			echRegltFacture1 = echRegltMng.save(echRegltFacture1);

			// Affaires - Situation
			ISituation situation1 = factory.createNewInstanceAffaire(ISituation.class, dev1);
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

			// Affaires - Avoir
			IAvoir avoir1 = factory.createNewInstanceAffaire(IAvoir.class, dev1);
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

			// Affaires - Acompte
			IAcompte acompte1 = factory.createNewInstanceAffaire(IAcompte.class, dev1);
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

			// Devis to Facture
			IFacture devisToFacture = dev1.getClone(factory.createNewInstance(IFacture.class));
			devisToFacture.setDevis(dev1);
			devisToFacture.setCode(FACTURE_CODE_2);
			devisToFacture = app.getFactureManager().save(devisToFacture);

			// Devis to Situation
			ISituation devisToSituation = dev1.getClone(factory.createNewInstance(ISituation.class));
			devisToSituation.setDevis(dev1);
			devisToSituation.setCode(SITUATION_CODE_2);
			devisToSituation = app.getSituationManager().save(devisToSituation);

			// Devis to Acompte
			IAcompte devisToAcompte = dev1.getClone(factory.createNewInstance(IAcompte.class));
			devisToAcompte.setDevis(dev1);
			devisToAcompte.setCode(ACOMPTE_CODE_2);
			devisToAcompte = app.getAcompteManager().save(devisToAcompte);

			// Devis to Devis
			IDevis devisToDevis = dev1.getClone(factory.createNewInstance(IDevis.class));
			devisToDevis.setCode(DEVIS_CODE_2);
			devisToDevis = app.getDevisManager().save(devisToDevis);

			// Facture to Avoir
			IAvoir factureToAvoir = facture1.getClone(factory.createNewInstance(IAvoir.class));
			factureToAvoir.setFacture(facture1);
			factureToAvoir.setCode(AVOIR_CODE_2);
			factureToAvoir = app.getAvoirManager().save(factureToAvoir);

			// Facture to Facture
			IFacture factureToFacture = facture1.getClone(factory.createNewInstance(IFacture.class));
			factureToFacture.setCode(FACTURE_CODE_3);
			factureToFacture = app.getFactureManager().save(factureToFacture);

			// Situation to Situation
			ISituation situationToSituation = situation1.getClone(factory.createNewInstance(ISituation.class));
			situationToSituation.setCode(SITUATION_CODE_3);
			situationToSituation = app.getSituationManager().save(situationToSituation);

			// ////////
			// Clients avec liste affaires
			IClient client2 = factory.createNewInstance(IClient.class);
			client2.setActivite(act2);
			client2.setCategorie(cat2);
			client2.setCode(CLIENT_CODE_2);
			client2.setCodeNaf(CLIENT_CODE_NAF_2);
			client2.setHide(CLIENT_HIDE_2);
			client2.setNomSociete(CLIENT_NOM_SOCIETE_2);
			client2.setRappelDate(CLIENT_RAPPEL_DATE_2);
			client2.setSiren(CLIENT_SIREN_2);
			client2.setTvaIntra(CLIENT_TVA_INTRA_2);
			client2.setProspect(CLIENT_PROSPECT_2);
			client2.setMontantPlafond(CLIENT_MONTANT_PLAFOND_2);
			client2 = app.getClientManager().save(client2);

			// Groupe contact
			IGroupeCnt groupeCnt1 = factory.createNewInstance(IGroupeCnt.class);
			groupeCnt1.setLibelle(GROUPE_CNT_LIBELLE_1);
			groupeCnt1 = app.getGroupeCntManager().save(groupeCnt1);

			// Divers Contact
			IDiversCnt diversCnt1 = factory.createNewInstance(IDiversCnt.class);
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

			if (isBeginTransaction) {
				commitTransaction();
			}
		} catch (BatifreeException e) {
			rollbackTransaction();
			LOGGER.error("testAdd", e);
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
	 * ----> Mo <br/>
	 */
	private void showArboBib() {
	}

	@SuppressWarnings("unused")
	private void testAddOne() throws BatifreeException {
		// beginTransaction();
		try {
			IFactoryBf factory = app.getFactory();

			IEnginBibManager engBibMng = app.getEnginBibManager();
			IEnginBib engBib1 = null;
			for (IEnginBib obj : engBibMng.getList()) {
				if (BIB_ENG_CODE_1.equals(obj.getCode())) {
					engBib1 = obj;
				}
			}
			Assert.assertNotNull(engBib1);
			IEnginBib engBib2 = engBib1.getCloneForImport();

			int i = 0;

		} catch (BatifreeException e) {
			// rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	@SuppressWarnings("unused")
	private void testUpdateOne() throws BatifreeException {
		beginTransaction();
		try {
			IBinaireManager mng = app.getBinaireManager();
			List<IBinaire> list = mng.getList();
			if (list.size() > 0) {
				IBinaire object = list.get(0);

				IMateriauxBibManager mxbibmng = app.getMateriauxBibManager();
				List<IMateriauxBib> listMxBib = mxbibmng.getList();
				if (listMxBib != null) {
					for (IMateriauxBib mxbib : listMxBib) {
						// mxbib.setCode(mxbib.getId().toString());
						mxbib.setDescriptif(object);
					}
					mxbibmng.save(listMxBib);
				}
			}
			commitTransaction();
		} catch (BatifreeException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	@SuppressWarnings("unused")
	private void testDeleteOne() throws BatifreeException {
		beginTransaction();
		try {
			// List<ILotBib> listLotBib = app.getLotBibManager().getList();

			IMateriauxBib mxBib = app.getMateriauxBibManager().getById(1);
			app.getMateriauxBibManager().delete(mxBib);
			// app.getMateriauxBibManager().deleteAll();

			// throw new BatifreeException("Error pour non commit");

			commitTransaction();
		} catch (BatifreeException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void testDeleteAll() throws BatifreeException {
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

			// throw new BatifreeException("Error pour non commit");

			// commitTransaction();
		} catch (BatifreeException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	@Test
	public void manageBeansList() throws BatifreeException {
		testDeleteAll();

		testAdd();

		testGet();

		testUpdate();

		testDeleteAll();
	}

}
