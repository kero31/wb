package batifree.api.application.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import batifree.api.manager.interfaces.IAcompteManager;
import batifree.api.manager.interfaces.IActiviteManager;
import batifree.api.manager.interfaces.IAvoirManager;
import batifree.api.manager.interfaces.IBinaireManager;
import batifree.api.manager.interfaces.ICategorieManager;
import batifree.api.manager.interfaces.IChantierManager;
import batifree.api.manager.interfaces.ICiviliteManager;
import batifree.api.manager.interfaces.IClientManager;
import batifree.api.manager.interfaces.ICoordonneeCntManager;
import batifree.api.manager.interfaces.IDetailCntManager;
import batifree.api.manager.interfaces.IDevisManager;
import batifree.api.manager.interfaces.IDiversCntManager;
import batifree.api.manager.interfaces.IEcheancierManager;
import batifree.api.manager.interfaces.IEcheancierReglementManager;
import batifree.api.manager.interfaces.IEnginBibManager;
import batifree.api.manager.interfaces.IEnginEtudeManager;
import batifree.api.manager.interfaces.IEtatManager;
import batifree.api.manager.interfaces.IEtudeManager;
import batifree.api.manager.interfaces.IFactureManager;
import batifree.api.manager.interfaces.IFamilleManager;
import batifree.api.manager.interfaces.IFournisseurManager;
import batifree.api.manager.interfaces.IFournisseurMateriauxManager;
import batifree.api.manager.interfaces.IGroupeCntManager;
import batifree.api.manager.interfaces.IImageManager;
import batifree.api.manager.interfaces.ILocalisationManager;
import batifree.api.manager.interfaces.ILotBibManager;
import batifree.api.manager.interfaces.ILotEtudeManager;
import batifree.api.manager.interfaces.IMainOeuvreBibManager;
import batifree.api.manager.interfaces.IMainOeuvreEtudeManager;
import batifree.api.manager.interfaces.IMateriauxBibManager;
import batifree.api.manager.interfaces.IMateriauxEtudeManager;
import batifree.api.manager.interfaces.IModePaiementManager;
import batifree.api.manager.interfaces.IPaysManager;
import batifree.api.manager.interfaces.IReglementManager;
import batifree.api.manager.interfaces.ISituationManager;
import batifree.api.manager.interfaces.ISousTraitantBibManager;
import batifree.api.manager.interfaces.ISousTraitantEtudeManager;
import batifree.api.manager.interfaces.ITacheBibManager;
import batifree.api.manager.interfaces.ITacheEtudeManager;
import batifree.api.manager.interfaces.ITvaManager;

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