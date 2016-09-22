package batifree.api.application.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admin.api.application.impl.ApplicationAdmin;
import batifree.api.application.interfaces.IApplication;
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

import common.api.application.impl.ApplicationCommun;
import common.api.application.impl.UserAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.application.interfaces.IUserService;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.ServiceBeanFactory;

/**
 * 
 * Classe <ApplicationBf>.
 * 
 */
@Service("BF_Application")
public class ApplicationBf extends ApplicationCommun implements IApplication {

	public static final String CODE_PROJECT = "BF";
	private static final Logger LOGGER = Logger.getLogger(ApplicationBf.class);

	/** Le User service. */
	@Resource(name = "BF_UserServiceHibernate")
	private IUserService userService;

	/** Le acompteManager. */
	@Resource(name = "BF_AcompteManager")
	private IAcompteManager acompteManager;

	/** Le activiteManager. */
	@Resource(name = "BF_ActiviteManager")
	private IActiviteManager activiteManager;

	/** Le avoirManager. */
	@Resource(name = "BF_AvoirManager")
	private IAvoirManager avoirManager;

	/** Le binaireManager. */
	@Resource(name = "BF_BinaireManager")
	private IBinaireManager binaireManager;

	/** Le categorieManager. */
	@Resource(name = "BF_CategorieManager")
	private ICategorieManager categorieManager;

	/** Le chantierManager. */
	@Resource(name = "BF_ChantierManager")
	private IChantierManager chantierManager;

	/** Le civiliteManager. */
	@Resource(name = "BF_CiviliteManager")
	private ICiviliteManager civiliteManager;

	/** Le clientManager. */
	@Resource(name = "BF_ClientManager")
	private IClientManager clientManager;

	/** Le coordonneeCntManager. */
	@Resource(name = "BF_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	/** Le detailCntManager. */
	@Resource(name = "BF_DetailCntManager")
	private IDetailCntManager detailCntManager;

	/** Le devisManager. */
	@Resource(name = "BF_DevisManager")
	private IDevisManager devisManager;

	/** Le diversCntManager. */
	@Resource(name = "BF_DiversCntManager")
	private IDiversCntManager diversCntManager;

	/** Le echeancierManager. */
	@Resource(name = "BF_EcheancierManager")
	private IEcheancierManager echeancierManager;

	/** Le echeancierReglementManager. */
	@Resource(name = "BF_EcheancierReglementManager")
	private IEcheancierReglementManager echeancierReglementManager;

	/** Le enginBibManager. */
	@Resource(name = "BF_EnginBibManager")
	private IEnginBibManager enginBibManager;

	/** Le enginEtudeManager. */
	@Resource(name = "BF_EnginEtudeManager")
	private IEnginEtudeManager enginEtudeManager;

	/** Le etatManager. */
	@Resource(name = "BF_EtatManager")
	private IEtatManager etatManager;

	/** Le etudeManager. */
	@Resource(name = "BF_EtudeManager")
	private IEtudeManager etudeManager;

	/** Le factureManager. */
	@Resource(name = "BF_FactureManager")
	private IFactureManager factureManager;

	/** Le familleManager. */
	@Resource(name = "BF_FamilleManager")
	private IFamilleManager familleManager;

	/** Le fournisseurManager. */
	@Resource(name = "BF_FournisseurManager")
	private IFournisseurManager fournisseurManager;

	/** Le fournisseurMateriauxManager. */
	@Resource(name = "BF_FournisseurMateriauxManager")
	private IFournisseurMateriauxManager fournisseurMateriauxManager;

	/** Le groupeCntManager. */
	@Resource(name = "BF_GroupeCntManager")
	private IGroupeCntManager groupeCntManager;

	/** Le imageManager. */
	@Resource(name = "BF_ImageManager")
	private IImageManager imageManager;

	/** Le localisationManager. */
	@Resource(name = "BF_LocalisationManager")
	private ILocalisationManager localisationManager;

	/** Le lotBibManager. */
	@Resource(name = "BF_LotBibManager")
	private ILotBibManager lotBibManager;

	/** Le lotEtudeManager. */
	@Resource(name = "BF_LotEtudeManager")
	private ILotEtudeManager lotEtudeManager;

	/** Le mainOeuvreBibManager. */
	@Resource(name = "BF_MainOeuvreBibManager")
	private IMainOeuvreBibManager mainOeuvreBibManager;

	/** Le mainOeuvreEtudeManager. */
	@Resource(name = "BF_MainOeuvreEtudeManager")
	private IMainOeuvreEtudeManager mainOeuvreEtudeManager;

	/** Le materiauxBibManager. */
	@Resource(name = "BF_MateriauxBibManager")
	private IMateriauxBibManager materiauxBibManager;

	/** Le materiauxEtudeManager. */
	@Resource(name = "BF_MateriauxEtudeManager")
	private IMateriauxEtudeManager materiauxEtudeManager;

	/** Le paysManager. */
	@Resource(name = "BF_PaysManager")
	private IPaysManager paysManager;

	/** Le reglementManager. */
	@Resource(name = "BF_ReglementManager")
	private IReglementManager reglementManager;

	/** Le situationManager. */
	@Resource(name = "BF_SituationManager")
	private ISituationManager situationManager;

	/** Le sousTraitantBibManager. */
	@Resource(name = "BF_SousTraitantBibManager")
	private ISousTraitantBibManager sousTraitantBibManager;

	/** Le sousTraitantEtudeManager. */
	@Resource(name = "BF_SousTraitantEtudeManager")
	private ISousTraitantEtudeManager sousTraitantEtudeManager;

	/** Le tacheBibManager. */
	@Resource(name = "BF_TacheBibManager")
	private ITacheBibManager tacheBibManager;

	/** Le tacheEtudeManager. */
	@Resource(name = "BF_TacheEtudeManager")
	private ITacheEtudeManager tacheEtudeManager;

	/** Le tvaManager. */
	@Resource(name = "BF_TvaManager")
	private ITvaManager tvaManager;

	/** Le tvaManager. */
	@Resource(name = "BF_ModePaiementManager")
	private IModePaiementManager modePaiementManager;

	/** Le factory. */
	private final FactoryBfImpl factory = new FactoryBfImpl();

	/**
	 * 
	 * Constructeur.
	 */
	public ApplicationBf() {
		super(CODE_PROJECT);
		LOGGER.info("Code projet = " + CODE_PROJECT);
	}

	@Override
	public FactoryBfImpl getFactory() {
		return factory;
	}

	@Override
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Retourne l'application courante
	 * 
	 * @return application courante
	 * @throws BatifreeException
	 */
	public static IApplication getApplication() throws BatifreeException {
		return ServiceBeanFactory.getServiceBean(ApplicationBf.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException {
		LOGGER.info("Before : loadUserByUsername(" + pUsername + ") avec code project = " + getCodeProject());

		try {
			// Properties
			IPropertiesApp prop = ApplicationBf.getApplication().getProperties();

			// Mise à jour des infos de connexion à la bd d'admin à partir du fichier properties
			UserAppImpl userAdmin = new UserAppImpl();
			// userAdmin.setUsername("TEST");
			userAdmin.setBdDriver("com.mysql.jdbc.Driver");
			userAdmin.setBdURL(prop.getProperty(IPropertiesApp.BD_ADMIN_URL));
			userAdmin.setBdShema(prop.getProperty(IPropertiesApp.BD_ADMIN_SCHEMA));
			userAdmin.setBdLogin(prop.getProperty(IPropertiesApp.BD_ADMIN_USERNAME));
			userAdmin.setBdPassword(prop.getProperty(IPropertiesApp.BD_ADMIN_PASSWORD));
			userAdmin.setBdDialect("org.hibernate.dialect.MySQLDialect");

			// Récup de l'appli admin
			admin.api.application.interfaces.IApplication appAdmin = ApplicationAdmin.getApplication();

			// Enregistrement de l'user
			appAdmin.setUserApp(userAdmin);

			// Récup de l'user courant dans l'appli admin
			IUserApp userApp = appAdmin.getUserAppFromUsernameProject(pUsername, getCodeProject());
			return getUserDetailsByUserApp(userApp);
		} catch (BatifreeException | BatifreeUserException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	@Override
	public IAcompteManager getAcompteManager() {
		return acompteManager;
	}

	@Override
	public IActiviteManager getActiviteManager() {
		return activiteManager;
	}

	@Override
	public IAvoirManager getAvoirManager() {
		return avoirManager;
	}

	@Override
	public IBinaireManager getBinaireManager() {
		return binaireManager;
	}

	@Override
	public ICategorieManager getCategorieManager() {
		return categorieManager;
	}

	@Override
	public IChantierManager getChantierManager() {
		return chantierManager;
	}

	@Override
	public ICiviliteManager getCiviliteManager() {
		return civiliteManager;
	}

	@Override
	public IClientManager getClientManager() {
		return clientManager;
	}

	@Override
	public ICoordonneeCntManager getCoordonneeCntManager() {
		return coordonneeCntManager;
	}

	@Override
	public IDetailCntManager getDetailCntManager() {
		return detailCntManager;
	}

	@Override
	public IDevisManager getDevisManager() {
		return devisManager;
	}

	@Override
	public IDiversCntManager getDiversCntManager() {
		return diversCntManager;
	}

	@Override
	public IEcheancierManager getEcheancierManager() {
		return echeancierManager;
	}

	@Override
	public IEcheancierReglementManager getEcheancierReglementManager() {
		return echeancierReglementManager;
	}

	@Override
	public IEnginEtudeManager getEnginEtudeManager() {
		return enginEtudeManager;
	}

	@Override
	public IEnginBibManager getEnginBibManager() {
		return enginBibManager;
	}

	@Override
	public IEtatManager getEtatManager() {
		return etatManager;
	}

	@Override
	public IEtudeManager getEtudeManager() {
		return etudeManager;
	}

	@Override
	public IFactureManager getFactureManager() {
		return factureManager;
	}

	@Override
	public IFamilleManager getFamilleManager() {
		return familleManager;
	}

	@Override
	public IFournisseurManager getFournisseurManager() {
		return fournisseurManager;
	}

	@Override
	public IFournisseurMateriauxManager getFournisseurMateriauxManager() {
		return fournisseurMateriauxManager;
	}

	@Override
	public IGroupeCntManager getGroupeCntManager() {
		return groupeCntManager;
	}

	@Override
	public IImageManager getImageManager() {
		return imageManager;
	}

	@Override
	public ILocalisationManager getLocalisationManager() {
		return localisationManager;
	}

	@Override
	public ILotEtudeManager getLotEtudeManager() {
		return lotEtudeManager;
	}

	@Override
	public ILotBibManager getLotBibManager() {
		return lotBibManager;
	}

	@Override
	public IMainOeuvreEtudeManager getMainOeuvreEtudeManager() {
		return mainOeuvreEtudeManager;
	}

	@Override
	public IMainOeuvreBibManager getMainOeuvreBibManager() {
		return mainOeuvreBibManager;
	}

	@Override
	public IMateriauxEtudeManager getMateriauxEtudeManager() {
		return materiauxEtudeManager;
	}

	@Override
	public IMateriauxBibManager getMateriauxBibManager() {
		return materiauxBibManager;
	}

	@Override
	public IPaysManager getPaysManager() {
		return paysManager;
	}

	@Override
	public IReglementManager getReglementManager() {
		return reglementManager;
	}

	@Override
	public ISituationManager getSituationManager() {
		return situationManager;
	}

	@Override
	public ISousTraitantEtudeManager getSousTraitantEtudeManager() {
		return sousTraitantEtudeManager;
	}

	@Override
	public ISousTraitantBibManager getSousTraitantBibManager() {
		return sousTraitantBibManager;
	}

	@Override
	public ITacheEtudeManager getTacheEtudeManager() {
		return tacheEtudeManager;
	}

	@Override
	public ITacheBibManager getTacheBibManager() {
		return tacheBibManager;
	}

	@Override
	public ITvaManager getTvaManager() {
		return tvaManager;
	}

	@Override
	public IModePaiementManager getModePaiementManager() {
		return modePaiementManager;
	}

}