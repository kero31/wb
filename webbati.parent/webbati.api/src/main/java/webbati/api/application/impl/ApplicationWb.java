package webbati.api.application.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admin.api.application.impl.ApplicationAdmin;
import common.api.application.impl.ApplicationCommun;
import common.api.application.impl.UserAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.application.interfaces.IUserService;
import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.ServiceBeanFactory;
import webbati.api.application.interfaces.IApplication;
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
 * 
 * Classe <b>ApplicationWb</b>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_Application")
public class ApplicationWb extends ApplicationCommun implements IApplication {

	public static final String CODE_PROJECT = "WB";
	private static final Logger LOGGER = Logger.getLogger(ApplicationWb.class);

	/** Le User service. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_UserServiceHibernate")
	private IUserService userService;

	/** Le acompteManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_AcompteManager")
	private IAcompteManager acompteManager;

	/** Le activiteManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ActiviteManager")
	private IActiviteManager activiteManager;

	/** Le avoirManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_AvoirManager")
	private IAvoirManager avoirManager;

	/** Le binaireManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_BinaireManager")
	private IBinaireManager binaireManager;

	/** Le categorieManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CategorieManager")
	private ICategorieManager categorieManager;

	/** Le chantierManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ChantierManager")
	private IChantierManager chantierManager;

	/** Le civiliteManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CiviliteManager")
	private ICiviliteManager civiliteManager;

	/** Le clientManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ClientManager")
	private IClientManager clientManager;

	/** Le coordonneeCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	/** Le detailCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_DetailCntManager")
	private IDetailCntManager detailCntManager;

	/** Le devisManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_DevisManager")
	private IDevisManager devisManager;

	/** Le diversCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_DiversCntManager")
	private IDiversCntManager diversCntManager;

	/** Le echeancierManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierManager")
	private IEcheancierManager echeancierManager;

	/** Le echeancierReglementManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierReglementManager")
	private IEcheancierReglementManager echeancierReglementManager;

	/** Le enginBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EnginBibManager")
	private IEnginBibManager enginBibManager;

	/** Le enginEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EnginEtudeManager")
	private IEnginEtudeManager enginEtudeManager;

	/** Le etatManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EtatManager")
	private IEtatManager etatManager;

	/** Le etudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EtudeManager")
	private IEtudeManager etudeManager;

	/** Le factureManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_FactureManager")
	private IFactureManager factureManager;

	/** Le familleManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_FamilleManager")
	private IFamilleManager familleManager;

	/** Le fournisseurManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_FournisseurManager")
	private IFournisseurManager fournisseurManager;

	/** Le fournisseurMateriauxManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_FournisseurMateriauxManager")
	private IFournisseurMateriauxManager fournisseurMateriauxManager;

	/** Le groupeCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_GroupeCntManager")
	private IGroupeCntManager groupeCntManager;

	/** Le imageManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ImageManager")
	private IImageManager imageManager;

	/** Le localisationManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_LocalisationManager")
	private ILocalisationManager localisationManager;

	/** Le lotBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_LotBibManager")
	private ILotBibManager lotBibManager;

	/** Le lotEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_LotEtudeManager")
	private ILotEtudeManager lotEtudeManager;

	/** Le mainOeuvreBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_MainOeuvreBibManager")
	private IMainOeuvreBibManager mainOeuvreBibManager;

	/** Le mainOeuvreEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_MainOeuvreEtudeManager")
	private IMainOeuvreEtudeManager mainOeuvreEtudeManager;

	/** Le materiauxBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_MateriauxBibManager")
	private IMateriauxBibManager materiauxBibManager;

	/** Le materiauxEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_MateriauxEtudeManager")
	private IMateriauxEtudeManager materiauxEtudeManager;

	/** Le paysManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_PaysManager")
	private IPaysManager paysManager;

	/** Le reglementManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ReglementManager")
	private IReglementManager reglementManager;

	/** Le situationManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_SituationManager")
	private ISituationManager situationManager;

	/** Le sousTraitantBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_SousTraitantBibManager")
	private ISousTraitantBibManager sousTraitantBibManager;

	/** Le sousTraitantEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_SousTraitantEtudeManager")
	private ISousTraitantEtudeManager sousTraitantEtudeManager;

	/** Le tacheBibManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_TacheBibManager")
	private ITacheBibManager tacheBibManager;

	/** Le tacheEtudeManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_TacheEtudeManager")
	private ITacheEtudeManager tacheEtudeManager;

	/** Le tvaManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_TvaManager")
	private ITvaManager tvaManager;

	/** Le tvaManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_ModePaiementManager")
	private IModePaiementManager modePaiementManager;

	/** Le factory. */
	private final FactoryWbImpl factory = new FactoryWbImpl();

	/**
	 * 
	 * Constructeur.
	 */
	public ApplicationWb() {
		super(CODE_PROJECT);
		LOGGER.info("Code projet = " + CODE_PROJECT);
	}

	@Override
	public FactoryWbImpl getFactory() {
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
	 * @throws WebbatiException
	 */
	public static IApplication getApplication() throws WebbatiException {
		return ServiceBeanFactory.getServiceBean(ApplicationWb.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException {
		LOGGER.info("Before : loadUserByUsername(" + pUsername + ") avec code project = " + getCodeProject());

		try {
			// Properties
			IPropertiesApp prop = ApplicationWb.getApplication().getProperties();

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
		} catch (WebbatiException | WebbatiUserException e) {
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