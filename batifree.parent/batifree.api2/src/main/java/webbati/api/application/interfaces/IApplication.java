package webbati.api.application.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import webbati.api.manager.interfaces.IAcompteManager;
import webbati.api.manager.interfaces.IActiviteManager;
import webbati.api.manager.interfaces.IAvoirManager;
import webbati.api.manager.interfaces.IBinaireManager;
import webbati.api.manager.interfaces.ICategorieManager;
import webbati.api.manager.interfaces.IChantierManager;
import webbati.api.manager.interfaces.ICiviliteManager;
import webbati.api.manager.interfaces.IClientManager;
import webbati.api.manager.interfaces.ICoordonneeCntManager;
import webbati.api.manager.interfaces.IDetailCntManager;
import webbati.api.manager.interfaces.IDevisManager;
import webbati.api.manager.interfaces.IDiversCntManager;
import webbati.api.manager.interfaces.IEcheancierManager;
import webbati.api.manager.interfaces.IEcheancierReglementManager;
import webbati.api.manager.interfaces.IEnginBibManager;
import webbati.api.manager.interfaces.IEnginEtudeManager;
import webbati.api.manager.interfaces.IEtatManager;
import webbati.api.manager.interfaces.IEtudeManager;
import webbati.api.manager.interfaces.IFactureManager;
import webbati.api.manager.interfaces.IFamilleManager;
import webbati.api.manager.interfaces.IFournisseurManager;
import webbati.api.manager.interfaces.IFournisseurMateriauxManager;
import webbati.api.manager.interfaces.IGroupeCntManager;
import webbati.api.manager.interfaces.IImageManager;
import webbati.api.manager.interfaces.ILocalisationManager;
import webbati.api.manager.interfaces.ILotBibManager;
import webbati.api.manager.interfaces.ILotEtudeManager;
import webbati.api.manager.interfaces.IMainOeuvreBibManager;
import webbati.api.manager.interfaces.IMainOeuvreEtudeManager;
import webbati.api.manager.interfaces.IMateriauxBibManager;
import webbati.api.manager.interfaces.IMateriauxEtudeManager;
import webbati.api.manager.interfaces.IModePaiementManager;
import webbati.api.manager.interfaces.IPaysManager;
import webbati.api.manager.interfaces.IReglementManager;
import webbati.api.manager.interfaces.ISituationManager;
import webbati.api.manager.interfaces.ISousTraitantBibManager;
import webbati.api.manager.interfaces.ISousTraitantEtudeManager;
import webbati.api.manager.interfaces.ITacheBibManager;
import webbati.api.manager.interfaces.ITacheEtudeManager;
import webbati.api.manager.interfaces.ITvaManager;

/**
 * Interface <b>IApplication</b><br/>
 */
public interface IApplication extends common.api.application.interfaces.IApplicationCommun {

	/**
	 * Retourne l'utilisateur en fonction de son login
	 * 
	 * @param pUsername Login
	 * @return Utilisateur Spring en fonction de son login
	 * @throws UsernameNotFoundException UsernameNotFoundException
	 */
	UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException;

	/**
	 * Retourne la classe Manager de Acompte
	 * 
	 * 
	 * @return Classe Manager de Acompte
	 */
	IAcompteManager getAcompteManager();

	/**
	 * Retourne la classe Manager de Activite
	 * 
	 * 
	 * @return Classe Manager de Activite
	 */
	IActiviteManager getActiviteManager();

	/**
	 * Retourne la classe Manager de Avoir
	 * 
	 * 
	 * @return Classe Manager de Avoir
	 */
	IAvoirManager getAvoirManager();

	/**
	 * Retourne la classe Manager de Binaire
	 * 
	 * 
	 * @return Classe Manager de Binaire
	 */
	IBinaireManager getBinaireManager();

	/**
	 * Retourne la classe Manager de Categorie
	 * 
	 * 
	 * @return Classe Manager de Categorie
	 */
	ICategorieManager getCategorieManager();

	/**
	 * Retourne la classe Manager de Chantier
	 * 
	 * 
	 * @return Classe Manager de Chantier
	 */
	IChantierManager getChantierManager();

	/**
	 * Retourne la classe Manager de Civilite
	 * 
	 * 
	 * @return Classe Manager de Civilite
	 */
	ICiviliteManager getCiviliteManager();

	/**
	 * Retourne la classe Manager de Client
	 * 
	 * 
	 * @return Classe Manager de Client
	 */
	IClientManager getClientManager();

	/**
	 * Retourne la classe Manager de CoordonneeCnt
	 * 
	 * 
	 * @return Classe Manager de CoordonneeCnt
	 */
	ICoordonneeCntManager getCoordonneeCntManager();

	/**
	 * Retourne la classe Manager de DetailCnt
	 * 
	 * 
	 * @return Classe Manager de DetailCnt
	 */
	IDetailCntManager getDetailCntManager();

	/**
	 * Retourne la classe Manager de Devis
	 * 
	 * 
	 * @return Classe Manager de Devis
	 */
	IDevisManager getDevisManager();

	/**
	 * Retourne la classe Manager de DiversCnt
	 * 
	 * 
	 * @return Classe Manager de DiversCnt
	 */
	IDiversCntManager getDiversCntManager();

	/**
	 * Retourne la classe Manager de Echeancier
	 * 
	 * 
	 * @return Classe Manager de Echeancier
	 */
	IEcheancierManager getEcheancierManager();

	/**
	 * Retourne la classe Manager de EcheancierReglement
	 * 
	 * 
	 * @return Classe Manager de EcheancierReglement
	 */
	IEcheancierReglementManager getEcheancierReglementManager();

	/**
	 * Retourne la classe Manager de Engin
	 * 
	 * 
	 * @return Classe Manager de Engin
	 */
	IEnginEtudeManager getEnginEtudeManager();

	/**
	 * Retourne la classe Manager de Engin
	 * 
	 * 
	 * @return Classe Manager de Engin
	 */
	IEnginBibManager getEnginBibManager();

	/**
	 * Retourne la classe Manager de Etat
	 * 
	 * 
	 * @return Classe Manager de Etat
	 */
	IEtatManager getEtatManager();

	/**
	 * Retourne la classe Manager de Etude
	 * 
	 * 
	 * @return Classe Manager de Etude
	 */
	IEtudeManager getEtudeManager();

	/**
	 * Retourne la classe Manager de Facture
	 * 
	 * 
	 * @return Classe Manager de Facture
	 */
	IFactureManager getFactureManager();

	/**
	 * Retourne la classe Manager de Famille
	 * 
	 * 
	 * @return Classe Manager de Famille
	 */
	IFamilleManager getFamilleManager();

	/**
	 * Retourne la classe Manager de Fournisseur
	 * 
	 * 
	 * @return Classe Manager de Fournisseur
	 */
	IFournisseurManager getFournisseurManager();

	/**
	 * Retourne la classe Manager de FournisseurMateriaux
	 * 
	 * 
	 * @return Classe Manager de FournisseurMateriaux
	 */
	IFournisseurMateriauxManager getFournisseurMateriauxManager();

	/**
	 * Retourne la classe Manager de GroupeCnt
	 * 
	 * 
	 * @return Classe Manager de GroupeCnt
	 */
	IGroupeCntManager getGroupeCntManager();

	/**
	 * Retourne la classe Manager de Image
	 * 
	 * 
	 * @return Classe Manager de Image
	 */
	IImageManager getImageManager();

	/**
	 * Retourne la classe Manager de Localisation
	 * 
	 * 
	 * @return Classe Manager de Localisation
	 */
	ILocalisationManager getLocalisationManager();

	/**
	 * Retourne la classe Manager de Lot
	 * 
	 * 
	 * @return Classe Manager de Lot
	 */
	ILotEtudeManager getLotEtudeManager();

	/**
	 * Retourne la classe Manager de Lot
	 * 
	 * 
	 * @return Classe Manager de Lot
	 */
	ILotBibManager getLotBibManager();

	/**
	 * Retourne la classe Manager de MainOeuvre
	 * 
	 * 
	 * @return Classe Manager de MainOeuvre
	 */
	IMainOeuvreEtudeManager getMainOeuvreEtudeManager();

	/**
	 * Retourne la classe Manager de MainOeuvre
	 * 
	 * 
	 * @return Classe Manager de MainOeuvre
	 */
	IMainOeuvreBibManager getMainOeuvreBibManager();

	/**
	 * Retourne la classe Manager de Materiaux
	 * 
	 * 
	 * @return Classe Manager de Materiaux
	 */
	IMateriauxEtudeManager getMateriauxEtudeManager();

	/**
	 * Retourne la classe Manager de Materiaux
	 * 
	 * 
	 * @return Classe Manager de Materiaux
	 */
	IMateriauxBibManager getMateriauxBibManager();

	/**
	 * Retourne la classe Manager de Pays
	 * 
	 * 
	 * @return Classe Manager de Pays
	 */
	IPaysManager getPaysManager();

	/**
	 * Retourne la classe Manager de Reglement
	 * 
	 * 
	 * @return Classe Manager de Reglement
	 */
	IReglementManager getReglementManager();

	/**
	 * Retourne la classe Manager de Situation
	 * 
	 * 
	 * @return Classe Manager de Situation
	 */
	ISituationManager getSituationManager();

	/**
	 * Retourne la classe Manager de SousTraitant
	 * 
	 * 
	 * @return Classe Manager de SousTraitant
	 */
	ISousTraitantEtudeManager getSousTraitantEtudeManager();

	/**
	 * Retourne la classe Manager de SousTraitant
	 * 
	 * 
	 * @return Classe Manager de SousTraitant
	 */
	ISousTraitantBibManager getSousTraitantBibManager();

	/**
	 * Retourne la classe Manager de Tache
	 * 
	 * 
	 * @return Classe Manager de Tache
	 */
	ITacheEtudeManager getTacheEtudeManager();

	/**
	 * Retourne la classe Manager de Tache
	 * 
	 * 
	 * @return Classe Manager de Tache
	 */
	ITacheBibManager getTacheBibManager();

	/**
	 * Retourne la classe Manager de Tva
	 * 
	 * 
	 * @return Classe Manager de Tva
	 */
	ITvaManager getTvaManager();

	/**
	 * Retourne la factory qui sert à renvoyer les nouvelles instances métier
	 * 
	 * @return Factory
	 */
	IFactoryBf getFactory();

	/**
	 * Retourne la classe Manager de ModePaiement
	 * 
	 * 
	 * @return Classe Manager de ModePaiement
	 */
	IModePaiementManager getModePaiementManager();

}