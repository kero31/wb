package admin.api.application.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admin.api.application.interfaces.IApplication;
import admin.api.manager.interfaces.IAdminDatabaseManager;
import admin.api.manager.interfaces.IConnectiondbManager;
import admin.api.manager.interfaces.IProjectManager;
import admin.api.manager.interfaces.IProjectscriptManager;
import admin.api.manager.interfaces.IRoleManager;
import admin.api.manager.interfaces.IUserAppliManager;
import admin.api.manager.interfaces.IUserprojectManager;
import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.application.impl.ApplicationCommun;
import common.api.application.impl.UserAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.application.interfaces.IUserService;
import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.ServiceBeanFactory;

/**
 * 
 * Classe/Interface <b>ApplicationAdmin</b><br/>
 *
 */
@Service("ADMIN_Application")
public class ApplicationAdmin extends ApplicationCommun implements IApplication {

	private static final Logger LOGGER = Logger.getLogger(ApplicationAdmin.class);
	public static final String CODE_PROJECT = "ADMIN";

	/** Le User service. */
	@Resource(name = "ADMIN_UserServiceHibernate")
	private IUserService userService;

	/** Le UserAppliManager. */
	@Resource(name = "ADMIN_UserAppliManager")
	private IUserAppliManager userAppliManager;

	/** Le RoleManager. */
	@Resource(name = "ADMIN_RoleManager")
	private IRoleManager roleManager;

	/** Le ProjectManager. */
	@Resource(name = "ADMIN_ProjectManager")
	private IProjectManager projectManager;

	/** Le ProjectscriptManager. */
	@Resource(name = "ADMIN_ProjectscriptManager")
	private IProjectscriptManager projectscriptManager;

	/** Le UserprojectManager. */
	@Resource(name = "ADMIN_UserprojectManager")
	private IUserprojectManager userprojectManager;

	/** Le ConnectiondbManager. */
	@Resource(name = "ADMIN_ConnectiondbManager")
	private IConnectiondbManager connectiondbManager;

	/** Le AdminDatabaseManager. */
	@Resource(name = "ADMIN_AdminDatabaseManager")
	private IAdminDatabaseManager adminDatabaseManager;

	/**
	 * 
	 * Constructeur.
	 */
	public ApplicationAdmin() {
		super(CODE_PROJECT);
		LOGGER.info("Code projet = " + CODE_PROJECT);
	}

	@Override
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Retourne l'application courante.
	 * 
	 * @return application courante
	 * @throws BatifreeException
	 */
	public static IApplication getApplication() throws BatifreeException {
		return ServiceBeanFactory.getServiceBean(IApplication.class, "ADMIN_Application");
	}

	/**
	 * Retourne l'application courante pour le singleton (no web session)
	 * 
	 * @return application courante
	 * @throws BatifreeException
	 */
	public static IApplication getApplicationSingleton() throws BatifreeException {
		IApplication app = ServiceBeanFactory.getServiceBean(IApplication.class, "ADMIN_Application");
		app.loadUserByUsername("singleton");
		return app;
	}

	// Autres Méthodes

	@Override
	public UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException {
		LOGGER.info("Before : loadUserByUsername(" + pUsername + ") avec code project = " + getCodeProject());

		UserDetails userdetails = null;
		try {
			// Properties
			IPropertiesApp prop = ApplicationAdmin.getApplication().getProperties();

			// Mise à jour des infos de connexion à la bd d'admin à partir du fichier properties
			UserAppImpl userAdmin = new UserAppImpl();
			userAdmin.setUsername(prop.getProperty(PropertiesAppAdminImpl.ADMIN_USERNAME));
			userAdmin.setPassword(prop.getProperty(PropertiesAppAdminImpl.ADMIN_PASSWORD));
			userAdmin.setBdDriver(prop.getProperty(IPropertiesApp.BD_ADMIN_DRIVER));
			userAdmin.setBdURL(prop.getProperty(IPropertiesApp.BD_ADMIN_URL));
			userAdmin.setBdShema(prop.getProperty(IPropertiesApp.BD_ADMIN_SCHEMA));
			userAdmin.setBdLogin(prop.getProperty(IPropertiesApp.BD_ADMIN_USERNAME));
			userAdmin.setBdPassword(prop.getProperty(IPropertiesApp.BD_ADMIN_PASSWORD));
			userAdmin.setBdDialect(prop.getProperty(IPropertiesApp.BD_ADMIN_DIALECT));
			List<String> listRole = new ArrayList<>();
			listRole.add("ROLE_USER");
			userAdmin.setListRole(listRole);

			userdetails = getUserDetailsByUserApp(userAdmin);
		} catch (BatifreeException e) {
			throw new UsernameNotFoundException("Erreur loadUserByUsername(" + pUsername + ") avec code project = " + getCodeProject()
					+ e.getMessage());
		}

		LOGGER.info("After : loadUserByUsername(" + pUsername + ") avec code project = " + getCodeProject() + ", userdetails est NULL ? "
				+ (userdetails == null ? "OUI" : "NON"));

		return userdetails;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IUserApp getUserAppFromUsernameProject(String pUsername, String pCodeProject) throws BatifreeException {
		LOGGER.info("Before : getUserAppFromUsernameProject(" + pUsername + ", " + pCodeProject + ")");

		// Récupération des infos de la base
		IUserAppli user = getUserAppliManager().getUserByUsername(pUsername);
		if (user == null) {
			String sException = "L'utilisateur " + pUsername + " n'existe pas";
			LOGGER.info(sException);
			throw new BatifreeException(sException);
		}
		LOGGER.info("User trouvé");
		IProject project = getProjectManager().getProjectByCode(pCodeProject);
		if (project == null) {
			String sException = "Le projet " + pCodeProject + " n'existe pas";
			LOGGER.info(sException);
			throw new BatifreeException(sException);
		}
		LOGGER.info("Project trouvé");
		IUserproject userProject = getUserprojectManager().getUserprojectFromUserAppliAndProject(user, project);
		if (userProject == null) {
			String sException = "L'utilisateur " + pUsername + " n'est pas rattaché au projet " + pCodeProject;
			LOGGER.info(sException);
			throw new BatifreeException(sException);
		}
		LOGGER.info("UserProject trouvé");
		IConnectiondb conn = userProject.getConnectiondb();
		if (conn == null) {
			String sException = "Aucune connection n'est rattaché à ce profil";
			LOGGER.info(sException);
			throw new BatifreeException(sException);
		}
		LOGGER.info("Connection trouvé");

		// Récup de la liste des roles
		LOGGER.info("Récup de la liste des roles");
		List<IRole> lRu = user.getListRole();

		List<String> listeRoles = new ArrayList<String>();
		List<IRole> lRp = project.getListRole();
		for (IRole ru : lRu) {
			for (IRole rp : lRp) {
				if (ru.getId().equals(rp.getId())) {
					listeRoles.add(ru.getCode());
				}
			}
		}

		// Saisi des infos de user app
		LOGGER.info("Saisi des infos de user");
		UserAppImpl userApp = new UserAppImpl();
		userApp.setUsername(user.getUsername());
		userApp.setPassword(user.getPassword());
		userApp.setBdLogin(userProject.getBdLogin());
		userApp.setBdPassword(userProject.getBdPassword());
		userApp.setBdURL(conn.getUrl());
		userApp.setBdShema(userProject.getBdDbname());
		userApp.setBdDialect(conn.getDialect());
		userApp.setBdDriver(conn.getDriver());
		userApp.setListRole(listeRoles);
		userApp.setLocked(user.isLocked());

		// Close Session
		deconnection();

		return userApp;
	}

	@Override
	public IAdminDatabaseManager getAdminDatabaseManager() {
		return adminDatabaseManager;
	}

	@Override
	public IConnectiondbManager getConnectiondbManager() {
		return connectiondbManager;
	}

	@Override
	public IProjectManager getProjectManager() {
		return projectManager;
	}

	@Override
	public IProjectscriptManager getProjectscriptManager() {
		return projectscriptManager;
	}

	@Override
	public IRoleManager getRoleManager() {
		return roleManager;
	}

	@Override
	public IUserAppliManager getUserAppliManager() {
		return userAppliManager;
	}

	@Override
	public IUserprojectManager getUserprojectManager() {
		return userprojectManager;
	}
}