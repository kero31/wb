/**
 * 
 */
package admin.api.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import admin.api.application.impl.PropertiesAppAdminImpl;
import admin.api.application.interfaces.IApplication;
import admin.api.dao.interfaces.IAdminDatabaseDao;
import admin.api.dao.interfaces.IVScriptUpdateDao;
import admin.api.manager.interfaces.IAdminDatabaseManager;
import admin.api.manager.interfaces.IUserAppliManager;
import admin.api.manager.interfaces.IUserprojectManager;
import admin.api.metier.impl.UserAppliImpl;
import admin.api.metier.impl.UserprojectImpl;
import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;
import admin.api.metier.interfaces.IVScriptUpdate;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.WebbatiException;
import common.api.manager.impl.SuperManager;
import common.api.util.EncodingTools;
import common.api.util.Mail;
import common.api.util.QueryUtil;

/**
 * 
 * Classe <AdminDatabaseManagerImpl>. Gère les méthodes admin pour la bd
 * 
 */
@Service("ADMIN_AdminDatabaseManager")
public class AdminDatabaseManagerImpl extends SuperManager implements IAdminDatabaseManager {

	private static final Logger LOGGER = Logger.getLogger(AdminDatabaseManagerImpl.class);

	/** Dao admin . */
	@Resource(name = "ADMIN_AdminDatabaseDao")
	private IAdminDatabaseDao adminDatabaseDao;

	/** Dao vScriptUpdate. */
	@Resource(name = "ADMIN_VScriptUpdateDao")
	private IVScriptUpdateDao vScriptUpdateDao;

	/** Application. */
	@Resource(name = "ADMIN_Application")
	private IApplication application;

	/** TRUE si le mot de passe de la base de données est encodé, FALSE sinon. */
	private boolean isBdPasswordEncoded = false;

	/** Client host de la base de données. */
	private String bdClientHost;

	/**
	 * Init PostConstruct
	 * 
	 * @throws WebbatiException
	 */
	@PostConstruct
	private void init() throws WebbatiException {
		try {
			isBdPasswordEncoded = new Boolean(application.getProperties().getProperty(IPropertiesApp.BD_ADMIN_PASSWORD_ENCODE, "false"));
		} catch (WebbatiException e) {
			isBdPasswordEncoded = false;
		}
		bdClientHost = application.getProperties().getProperty(IPropertiesApp.BD_CLIENT_HOST);
	}

	@Override
	public String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername)
			throws WebbatiException {
		return createUserFromUsernameProject(pUsername, pCodeProject, pDateExpired, getConnectionDefault(), pMailUsername, null, null);
	}

	@Override
	public String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId, String pMailUsername)
			throws WebbatiException {
		return createUserFromUsernameProject(pUsername, pCodeProject, pDateExpired, pConnectionId, pMailUsername, null, null);
	}

	@Override
	public String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername,
			String pUsernameParent, String pPasswordUsernameParent) throws WebbatiException {

		if (pCodeProject == null || pCodeProject.isEmpty()) {
			throw new WebbatiException("codeProject est vide");
		}
		if (StringUtils.isEmpty(pUsernameParent)) {
			throw new WebbatiException("username parent est vide");
		}
		if (StringUtils.isEmpty(pPasswordUsernameParent)) {
			throw new WebbatiException("mot de passe username parent est vide");
		}

		// Recherche le userappli parent si le UsernameParent ainsi que sont mot de passe a été saisi
		IUserAppli userParent = application.getUserAppliManager().getUserByUsername(pUsernameParent);
		String passwordUsernameParentEncoded = EncodingTools.encode(pPasswordUsernameParent, EncodingTools.ENCODING_MD5);
		// Si le mot de passe de l'user trouvé correspond à celui donné en paramètre, on enregistre le user appli parent
		// Sinon on gère les erreurs
		if (userParent == null) {
			throw new WebbatiException("le username du parent'" + pUsernameParent + "' n'existe pas");
		}
		if (passwordUsernameParentEncoded == null || !passwordUsernameParentEncoded.equals(userParent.getPassword())) {
			throw new WebbatiException("le mot de passe du username parent'" + pUsernameParent + "' n'est pas correct");
		}

		// Récup du project
		IProject project = application.getProjectManager().getProjectByCode(pCodeProject);
		if (project == null) {
			throw new WebbatiException("Le project '" + pCodeProject + "' n'existe pas");
		}

		// A partir de ce user parent, recherche la connection
		IUserproject userproject = application.getUserprojectManager().getUserprojectFromUserAppliAndProject(userParent, project);
		if (userproject == null) {
			throw new WebbatiException("Le userproject avec username '" + pUsernameParent + " et project '" + pCodeProject + "' n'existe pas");
		}
		IConnectiondb connection = userproject.getConnectiondb();

		return createUserFromUsernameProject(pUsername, pCodeProject, pDateExpired, connection, pMailUsername, pUsernameParent,
				pPasswordUsernameParent);
	}

	@Override
	public String createUserDemoFromProject(String pCodeProject, String pMailUsername) throws WebbatiException {
		// Crée une date d'expiration aujourd'hui + DEMO_NB_JOURS
		Calendar dateExpired = new GregorianCalendar();
		dateExpired.add(Calendar.DAY_OF_YEAR, DEMO_NB_JOURS);

		// Récupère la connection db de la démo
		Integer connectionId = null;
		try {
			connectionId = new Integer(application.getProperties().getProperty(PropertiesAppAdminImpl.DEMO_CONNECTION_ID));
		} catch (NumberFormatException e) {
			throw new WebbatiException("Récupération de la connection démo impossible", e);
		}

		// Crée le user démo
		return createUserFromUsernameProject(getUsernameDemo(), pCodeProject, dateExpired.getTime(), connectionId, pMailUsername);
	}

	@Override
	public String createUserTestFromProject(String pCodeProject) throws WebbatiException {
		// Crée une date d'expiration aujourd'hui + TEST_NB_JOURS
		Calendar dateExpired = new GregorianCalendar();
		dateExpired.add(Calendar.DAY_OF_YEAR, TEST_NB_JOURS);

		// Récup de l'user de test
		IUserAppli user = application.getUserAppliManager().getUserByUsername(TEST_USERNAME);

		// Supprime le user de test s'il existe
		if (user != null) {
			deleteUserAndDatabase(user);
		}

		// Récupère la connection db de la démo
		Integer connectionId = null;
		try {
			connectionId = new Integer(application.getProperties().getProperty(PropertiesAppAdminImpl.TEST_CONNECTION_ID));
		} catch (NumberFormatException e) {
			throw new WebbatiException("Récupération de la connection test impossible", e);
		}

		// Récupère la connection db
		IConnectiondb connection = application.getConnectiondbManager().getById(connectionId);
		if (connection == null) {
			throw new WebbatiException("La connection '" + connectionId.toString() + "' n existe pas");
		}

		// Crée le user démo
		return createUserFromUsernameProject(TEST_USERNAME, TEST_PASSWORD_USERNAME, pCodeProject, dateExpired.getTime(), connection, null, null,
				null);
	}

	@Override
	public String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId,
			String pMailUsername, String pUsernameParent, String pPasswordUsernameParent) throws WebbatiException {
		// Récupère la connection db
		IConnectiondb connection = application.getConnectiondbManager().getById(pConnectionId);
		if (connection == null) {
			String conn = "";
			if (pConnectionId == null) {
				conn = "NULL";
			} else {
				conn = pConnectionId.toString();
			}
			throw new WebbatiException("La connection '" + conn + "' n existe pas");
		}

		// Crée le user avec connection spécifique
		return createUserFromUsernameProject(pUsername, pCodeProject, pDateExpired, connection, pMailUsername, pUsernameParent,
				pPasswordUsernameParent);
	}

	/**
	 * Génère le username démo avec le prefixe et une chaine alétoire On vérifie aussi s'il n'existe pas
	 * 
	 * @return username démo
	 * @throws WebbatiException
	 */
	private String getUsernameDemo() throws WebbatiException {
		String username = DEMO_USERNAME_PREFIXE + EncodingTools.generateUsername();
		IUserAppli user = application.getUserAppliManager().getUserByUsername(username);
		while (user != null) {
			username = DEMO_USERNAME_PREFIXE + "_" + EncodingTools.generateUsername();
			user = application.getUserAppliManager().getUserByUsername(username);
		}

		return username;
	}

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet
	 * 
	 * 
	 * @param pUsername username
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pConnection connection
	 * @param pMailUsername email username
	 * @param pUsernameParent username parent
	 * @param pPasswordUsernameParent password de l'username parent
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	private String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, IConnectiondb pConnection,
			String pMailUsername, String pUsernameParent, String pPasswordUsernameParent) throws WebbatiException {
		return createUserFromUsernameProject(pUsername, null, pCodeProject, pDateExpired, pConnection, pMailUsername, pUsernameParent,
				pPasswordUsernameParent);
	}

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet
	 * 
	 * 
	 * @param pUsername username
	 * @param pPasswordUsername password de l'username. Peut être NULL si on veut générer le password
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pConnection connection
	 * @param pMailUsername email username
	 * @param pUsernameParent username parent
	 * @param pPasswordUsernameParent password de l'username parent
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	private String createUserFromUsernameProject(String pUsername, String pPasswordUsername, String pCodeProject, Date pDateExpired,
			IConnectiondb pConnection, String pMailUsername, String pUsernameParent, String pPasswordUsernameParent) throws WebbatiException {

		if (pUsername == null || pUsername.isEmpty()) {
			throw new WebbatiException("username est vide");
		}
		if (pCodeProject == null || pCodeProject.isEmpty()) {
			throw new WebbatiException("codeProject est vide");
		}
		if (pDateExpired == null) {
			throw new WebbatiException("dateExpired est vide");
		}
		if (pConnection == null) {
			throw new WebbatiException("connection est vide");
		}

		IUserAppli user = null;
		String password = "";

		try {
			// Démarre la transaction
			beginTransaction();

			// Recherche le userappli parent si le UsernameParent ainsi que sont mot de passe a été saisi
			IUserAppli userParent = null;
			if (!StringUtils.isEmpty(pUsernameParent) && !StringUtils.isEmpty(pPasswordUsernameParent)) {
				IUserAppli userParentFound = application.getUserAppliManager().getUserByUsername(pUsernameParent);
				String passwordUsernameParentEncoded = EncodingTools.encode(pPasswordUsernameParent, EncodingTools.ENCODING_MD5);
				// Si le mot de passe de l'user trouvé correspond à celui donné en paramètre, on enregistre le user appli parent
				// Sinon on gère les erreurs
				if (userParentFound == null) {
					throw new WebbatiException("le username du parent'" + pUsernameParent + "' n'existe pas");

				}
				if (passwordUsernameParentEncoded != null && passwordUsernameParentEncoded.equals(userParentFound.getPassword())) {
					userParent = userParentFound;
				} else {
					throw new WebbatiException("le mot de passe du username parent'" + pUsernameParent + "' n'est pas correct");
				}
			}

			// Crée le user
			if (pPasswordUsername == null) {
				password = getUserPasswordRandom();
			} else {
				password = pPasswordUsername;
			}

			user = createUserFromUsername(pUsername, password, pDateExpired, pMailUsername, userParent);

			// Ajoute le projet avec le codeProject au user
			addProjectToUser(user, pCodeProject, pConnection);

			// Commit si pas d'erreur
			commitTransaction();

			LOGGER.info("L'utilisateur " + user.getUsername() + " sur le projet " + pCodeProject + " a été créé");
		} catch (WebbatiException e) {
			// Fait le rollback si erreur
			rollbackTransaction();
			throw new WebbatiException("Création de l'utilisateur impossible", e);
		} finally {
			closeTransaction();
		}

		// Envoie du mail indiquant le login et mot de passe
		if (pMailUsername != null && !pMailUsername.isEmpty()) {
			try {
				sendEmailCreateUser(user.getUsername(), password, pMailUsername);
			} catch (WebbatiException e) {
				LOGGER.error("Email non envoyé : " + e);
			}
		}
		LOGGER.info("Création de l'utilisateur : Email envoyé");

		return user.getUsername() + "/" + password;
	}

	/**
	 * Envoie un mail à mailUsername pour indiquer son username et son password
	 * 
	 * @param pUsername username
	 * @param pPassword password
	 * @param pMailUsername mailde l'username
	 * @throws WebbatiException
	 */
	private void sendEmailCreateUser(String pUsername, String pPassword, String pMailUsername) throws WebbatiException {
		String subject = "Webbati - Connection à l'application web";
		String message = "Bonjour" + "\nVoici ci-dessous les identifiants pour vous connecter à webbati web" + "\n\tLogin : " + pUsername
				+ "\n\tMot de passe : " + pPassword + "\n\nBonne journée," + "\nCordialement" + "\n\nWebbati";
		Mail.sendMail(pMailUsername, message, subject);
	}

	@Override
	public void addProjectToUser(IUserAppli pUser, String pCodeProject) throws WebbatiException {
		addProjectToUser(pUser, pCodeProject, getConnectionDefault());
	}

	@Override
	public IUserproject addProjectToUser(IUserAppli pUser, String pCodeProject, IConnectiondb pConnection) throws WebbatiException {
		if (pUser == null) {
			throw new WebbatiException("user est vide");
		}
		if (pCodeProject == null || pCodeProject.isEmpty()) {
			throw new WebbatiException("codeProject est vide");
		}
		if (pConnection == null) {
			throw new WebbatiException("connection est vide");
		}

		try {
			// Démarre la transaction
			beginTransaction();

			// Récup du project
			IProject project = application.getProjectManager().getProjectByCode(pCodeProject);

			// Crée le user project
			IUserproject userProject = createUserProjectFromUserAndProject(pUser, project, pConnection);

			// Récup role défault
			IRole role = getRoleDefault(project);

			// Crée le user role
			createUserRoleFromUserAndRole(pUser, role);

			// Crée la base de données à partir des infos du user project
			createDatabaseForUserProject(userProject);

			// Commit si pas d'erreur
			commitTransaction();

			LOGGER.info("L'utilisateur " + pUser.getUsername() + " a été ajouté au projet " + pCodeProject + " ainsi que sa base de données");

			return userProject;
		} catch (WebbatiException e) {
			// Fait le rollback si erreur
			rollbackTransaction();
			throw new WebbatiException("Ajout de l'utilisateur " + pUser.getUsername() + " impossible au projet " + pCodeProject, e);
		} finally {
			closeTransaction();
		}
	}

	@Override
	public void checkValidityUsers() throws WebbatiException {
		Calendar sysDate = new GregorianCalendar();
		Calendar sysDateLock = new GregorianCalendar();
		sysDateLock.add(Calendar.DAY_OF_YEAR, -USER_NB_JOURS_DELETED);
		for (IUserAppli user : application.getUserAppliManager().getList()) {
			LOGGER.debug(user.getDateExpired());
			try {
				// Démarre la transaction
				beginTransaction();

				if (sysDateLock.getTime().after(user.getDateExpired())) {
					// Si le délai d'expiration est largement dépassée, on supprime tout son compte (données + bd)
					deleteUserAndDatabase(user);
				} else if (sysDate.getTime().after(user.getDateExpired())) {
					// Bloque l'utilisateur
					user.setLocked(true);
					application.getUserAppliManager().save(user);
				}

				// Commit si pas d'erreur
				commitTransaction();
			} catch (WebbatiException e) {
				// Fait le rollback si erreur
				rollbackTransaction();
				LOGGER.error("Erreur de checkValidityUsers - ", e);
			} finally {
				closeTransaction();
			}
		}
	}

	/**
	 * Supprime la database du userproject.
	 * 
	 * @param pUserproject userproject à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	private void dropDataseUserProject(IUserproject pUserproject) throws WebbatiException {
		if (pUserproject != null) {
			// Récupère les infos du user project
			String bdDbName = pUserproject.getBdDbname();
			if (bdDbName == null || bdDbName.isEmpty()) {
				throw new WebbatiException("La databasename du userproject ne peut pas être vide");
			}
			String bdLogin = pUserproject.getBdLogin();
			if (bdLogin == null || bdLogin.isEmpty()) {
				throw new WebbatiException("Le login admin de la connection du userproject ne peut pas être vide");
			}

			// Drop database
			adminDatabaseDao.dropDatase(bdDbName, bdLogin, pUserproject.getConnectiondb(), bdClientHost, isBdPasswordEncoded);
		}
	}

	/**
	 * Supprime les databases appartennant à cet utilisateur.
	 * 
	 * @param user utilisateur à supprimer ses database
	 * @throws WebbatiException WebbatiException
	 */
	/*private void dropDataseUser(IUserAppli user) throws WebbatiException {
		if (user == null) {
			throw new WebbatiException("Le user ne peut pas être vide");
		}

		// Parcours les databases appartennant à l'utilisateur
		for (IUserproject userproject : user.getListUserproject()) {
			dropDataseUserProject(userproject);
		}
	}*/

	@Override
	public void deleteUserProjectAndDatabase(IUserproject pUserproject) throws WebbatiException {
		try {
			// Démarre la transaction
			beginTransaction();

			// Supprime la database
			dropDataseUserProject(pUserproject);

			// Supprime le userproject
			application.getUserprojectManager().delete(pUserproject);

			// Commit si pas d'erreur
			commitTransaction();
		} catch (WebbatiException e) {
			// Fait le rollback si erreur
			rollbackTransaction();
			throw new WebbatiException("Suppression de l'userproject impossible", e);
		} finally {
			closeTransaction();
		}
	}

	@Override
	public void deleteUserAndDatabase(IUserAppli pUser) throws WebbatiException {
		// Vérifie les infos en entrées
		if (pUser == null) {
			throw new WebbatiException("Le user ne peut pas être vide");
		}

		// Supprime les user project associés à ce user
		List<IUserproject> userprojectList = pUser.getListUserproject();
		if (userprojectList != null) {
			for (IUserproject userproject : userprojectList) {
				deleteUserProjectAndDatabase(userproject);
			}
		}

		// Supprime le user
		application.getUserAppliManager().delete(pUser);
	}

	/**
	 * Crée un utilisateur à partir de son username
	 * 
	 * @param pUsername username
	 * @param pPassword password
	 * @param pDateExpired date expired
	 * @param pMailUsername mail username
	 * @param pUserAppliParent UserAppli Parent
	 * @return utilisateur
	 * @throws WebbatiException
	 */
	private IUserAppli createUserFromUsername(String pUsername, String pPassword, Date pDateExpired, String pMailUsername,
			IUserAppli pUserAppliParent) throws WebbatiException {
		if (pUsername == null || pUsername.isEmpty()) {
			throw new WebbatiException("Le username est vide");
		}

		// Recherche si le username existe déjà
		IUserAppliManager manager = application.getUserAppliManager();
		for (IUserAppli user : manager.getList()) {
			if (pUsername.equals(user.getUsername())) {
				throw new WebbatiException("Le username '" + pUsername + "' existe déjà");
			}
		}

		// Crée le user
		IUserAppli user = new UserAppliImpl();
		user.setUsername(pUsername);
		String passwordEncoded = EncodingTools.encode(pPassword, EncodingTools.ENCODING_MD5);
		user.setPassword(passwordEncoded);
		user.setDateExpired(pDateExpired);
		user.setMail(pMailUsername);
		user.setDateCreate(new Date());
		user.setLocked(false);
		user.setUserappliParent(pUserAppliParent);

		// Save
		return manager.save(user);
	}

	/**
	 * Crée un userproject à partir des infos user et project
	 * 
	 * @param pUser user servant à créer le userproject
	 * @param pProject project servant à créer le userproject
	 * @param pConnectionDefault connection default
	 * @return userproject
	 * @throws WebbatiException
	 */
	private IUserproject createUserProjectFromUserAndProject(IUserAppli pUser, IProject pProject, IConnectiondb pConnectionDefault)
			throws WebbatiException {
		// Vérifie les infos en entrées
		if (pUser == null) {
			throw new WebbatiException("Le user ne peut pas être vide");
		}
		if (pProject == null) {
			throw new WebbatiException("Le project ne peut pas être vide");
		}

		// Crée user project
		IUserproject usp = new UserprojectImpl(pUser, pProject);
		usp.setConnectiondb(pConnectionDefault);
		String bdLogin = getBdLoginFromUserProject(pUser, pProject);
		usp.setBdLogin(bdLogin);
		String bdDbName = getBdDbNameFromUserProject(pUser, pProject);
		usp.setBdDbname(bdDbName);
		usp.setBdPassword(getBdPasswordFromBdLogin(bdLogin, bdDbName));

		// Save
		IUserprojectManager manager = application.getUserprojectManager();
		usp = manager.save(usp);

		// Envoi message alerte en fonction du nombre de user par connection
		// S'il y a une erreur, alors on ne bloque pas la fonction
		try {
			alertNbUserConnection(pConnectionDefault);
		} catch (WebbatiException e) {
			LOGGER.error(e);
		}

		return usp;
	}

	/**
	 * Retourne le login de la bd à partir des infos du user et du project
	 * 
	 * @param pUser user
	 * @param pProject project
	 * @return login de la bd
	 */
	private String getBdLoginFromUserProject(IUserAppli pUser, IProject pProject) {
		return pUser.getId() + "_" + pProject.getCode();
	}

	/**
	 * Retourne le password de la bd
	 * 
	 * @param pBdLogin login user
	 * @param pBdDbName db name
	 * @return password de la bd
	 * @throws WebbatiException
	 */
	private String getBdPasswordFromBdLogin(String pBdLogin, String pBdDbName) throws WebbatiException {
		if (isBdPasswordEncoded) {
			return EncodingTools.encode(getBdPasswordClearFromBdLogin(pBdLogin, pBdDbName), EncodingTools.ENCODING_MD5);
		}
		return EncodingTools.generatePassword();
	}

	/**
	 * Retourne le password de la bd en clair.
	 * 
	 * @param pBdLogin login user
	 * @param pBdDbName db name
	 * @return password password de la bd en clair
	 * @throws WebbatiException
	 */
	private String getBdPasswordClearFromBdLogin(String pBdLogin, String pBdDbName) throws WebbatiException {
		return pBdLogin + "_" + EncodingTools.ENCODING_KEY + "_" + pBdDbName;
	}

	/**
	 * Retourne le password aléatoire de l'user.
	 * 
	 * @return password aléatoire de l'user
	 * @throws WebbatiException
	 */
	private String getUserPasswordRandom() throws WebbatiException {
		return EncodingTools.generatePassword();

	}

	/**
	 * Retourne le db name de la bd à partir des infos du user et du project
	 * 
	 * @param pUser user
	 * @param pProject project
	 * @return db name de la bd
	 */
	private String getBdDbNameFromUserProject(IUserAppli pUser, IProject pProject) {
		return pUser.getId() + "_" + pProject.getCode();
	}

	/**
	 * Envoie un message d'alerte si le nombre de user pour la connection dépasse la limite alerte
	 * 
	 * @param pConnection connection à tester
	 * @throws WebbatiException
	 */
	private void alertNbUserConnection(IConnectiondb pConnection) throws WebbatiException {
		String subject = "Webbati - La connection '" + pConnection.getUrl() + "' a atteint la limite";
		String message = "Connection : " + pConnection.getUrl() + "\nDriver : " + pConnection.getDriver() + "\nLimite : "
				+ pConnection.getLimitUserAlert();
		Mail.sendMail(EMAIL_ADMIN_DATABASE, message, subject);
	}

	@Override
	public IConnectiondb getConnectionDefault() throws WebbatiException {
		Integer idConn = adminDatabaseDao.getConnectionIdDefault();
		if (idConn == null) {
			throw new WebbatiException("Pas de base trouvée");
		}
		IConnectiondb conn = application.getConnectiondbManager().getById(idConn);
		return conn;
	}

	/**
	 * Crée la base de données à partir des infos du userproject
	 * 
	 * @param pUserproject user project
	 * @throws WebbatiException
	 */
	private void createDatabaseForUserProject(IUserproject pUserproject) throws WebbatiException {
		if (pUserproject == null) {
			throw new WebbatiException("Le userproject ne peut pas être vide");
		}

		// Récupère les infos du user project
		String bdDbName = pUserproject.getBdDbname();
		if (bdDbName == null || bdDbName.isEmpty()) {
			throw new WebbatiException("La databasename du userproject ne peut pas être vide");
		}
		String bdLogin = pUserproject.getBdLogin();
		if (bdLogin == null || bdLogin.isEmpty()) {
			throw new WebbatiException("Le login admin de la connection du userproject ne peut pas être vide");
		}
		String bdPassword = pUserproject.getBdPassword();
		if (isBdPasswordEncoded) {
			String bdPasswordEncoded = getBdPasswordFromBdLogin(bdLogin, bdDbName);
			if (bdPasswordEncoded == null || !bdPasswordEncoded.equals(bdPassword)) {
				throw new WebbatiException("createDatabaseForUserProject - Le mot de passe userproject est incorrect");
			}
			bdPassword = getBdPasswordClearFromBdLogin(bdLogin, bdDbName);
		}

		// Récupère les infos de la connection du user project
		IConnectiondb conn = pUserproject.getConnectiondb();
		if (conn == null) {
			throw new WebbatiException("La connection du userproject ne peut pas être vide");
		}
		String rootDbName = conn.getRootDbname();
		if (rootDbName == null || rootDbName.isEmpty()) {
			throw new WebbatiException("La db admin de la connection du userproject ne peut pas être vide");
		}
		String url = conn.getUrl();
		if (url == null || url.isEmpty()) {
			throw new WebbatiException("L'url de la connection du userproject ne peut pas être vide");
		}
		String rootLogin = conn.getRootLogin();
		if (rootLogin == null || rootLogin.isEmpty()) {
			throw new WebbatiException("Le login admin de la connection du userproject ne peut pas être vide");
		}
		String rootPassword = conn.getRootPassword();
		if (isBdPasswordEncoded) {
			String rootPasswordClear = rootLogin + "_" + EncodingTools.ENCODING_KEY + "_" + rootDbName;
			String rootPasswordEncoded = EncodingTools.encode(rootPasswordClear, EncodingTools.ENCODING_MD5);
			if (rootPasswordEncoded == null || !rootPasswordEncoded.equals(rootPassword)) {
				throw new WebbatiException("createDatabaseForUserProject - Le mot de passe connection est incorrect");
			}
			rootPassword = rootPasswordClear;
		}

		try {
			// Crée un user et une base de données pour ce user
			adminDatabaseDao.createUserDatabase(bdDbName, bdLogin, bdPassword, conn.getDriver(), url + rootDbName, rootLogin, rootPassword,
					bdClientHost);

			// Importe les scripts SQL depuis la 1ère version dans cette base
			importAllScriptSQLIntoDatabaseFromUserProject(pUserproject, conn.getDriver(), url + bdDbName, rootLogin, rootPassword);
		} catch (WebbatiException e) {
			dropDataseUserProject(pUserproject);
			throw new WebbatiException("Erreur sur la création et import de script SQL pour la bdName=" + bdDbName + " avec le bdLogin=" + bdLogin
					+ " sur l'url " + url, e);
		}
	}

	/**
	 * Exécute l'ensemble des scripts SQL depuis la 1ère version pour un utilisateur
	 * 
	 * @param pUserproject userproject
	 * @param pDriver driver
	 * @param pUrl url
	 * @param pLogin login
	 * @param pPassword password
	 * @throws WebbatiException
	 */
	private void importAllScriptSQLIntoDatabaseFromUserProject(IUserproject pUserproject, String pDriver, String pUrl, String pLogin,
			String pPassword) throws WebbatiException {
		if (pUserproject == null) {
			throw new WebbatiException("Le userproject ne peut pas être vide");
		}
		IProject project = pUserproject.getProject();
		if (project == null) {
			throw new WebbatiException("Le project ne peut pas être vide");
		}

		// Pour chaque fichier trouvé, exécute le script et enregistre dans le user project dans la version courante du script
		List<IProjectscript> listScript = project.getListProjectscript();
		// Tri cette liste par id
		Collections.sort(listScript, new Comparator<IProjectscript>() {
			@Override
			public int compare(IProjectscript pArg0, IProjectscript pArg1) {
				if (pArg0 != null) {
					Integer id1 = pArg0.getId();
					Integer id2 = pArg1.getId();
					if (id2 != null) {
						return id2.compareTo(id1);
					} else {
						return 1;
					}
				} else {
					return -1;
				}
			}

		});
		for (IProjectscript pS : listScript) {
			// exécute le script
			String filename = pS.getFileName();
			if (filename != null && !filename.isEmpty()) {
				new QueryUtil().executeScript(pDriver, pUrl, pLogin, pPassword, filename);
			}

			// enregistre dans le user project, la version courante du script
			pUserproject.setProjectscript(pS);
			application.getUserprojectManager().save(pUserproject);
		}
	}

	@Override
	public void updateDatabases(String pCodeProject) throws WebbatiException {
		if (pCodeProject == null || pCodeProject.isEmpty()) {
			throw new WebbatiException("Le code project ne peut pas être vide");
		}

		// Récup du projet à partir de son code
		IProject project = application.getProjectManager().getProjectByCode(pCodeProject);
		if (project == null) {
			throw new WebbatiException("Le project n'existe pas");
		}

		// Récupère tous les éléments de la vue
		List<IVScriptUpdate> list = vScriptUpdateDao.getListByProjectId(project.getId());

		String erreurs = "";

		// Parcours tous les scripts
		for (IVScriptUpdate script : list) {
			try {
				String filename = script.getFilename();
				// exécute le script
				if (filename != null && !filename.isEmpty()) {
					new QueryUtil().executeScript(script.getDriver(), script.getUrl(), script.getLogin(), script.getPassword(), filename);
				}

				// Met à jour le projectscript du userproject
				int nbUpdated = adminDatabaseDao.updateProjectscriptFromUserprojectId(script.getUserAppliId(), project.getId(),
						script.getProjectscriptId());

				// Si pas de mise à effectuée, on envoie une exception
				if (nbUpdated == 0) {
					throw new WebbatiException("Aucune mise à jour effectuée sur le USERPROJECT UserAppli_ID=" + script.getUserAppliId()
							+ " et Project_ID=" + project.getId() + " avec ProjectScript_ID=" + script.getProjectscriptId());
				}
			} catch (WebbatiException e) {
				LOGGER.error(e);
				String info = "Login:" + script.getLogin() + "; URL:" + script.getUrl() + "; DRIVER:" + script.getDriver() + "; FILENAME:"
						+ script.getFilename();
				erreurs = erreurs + " - " + info + " - " + e.getMessage() + "\n";
			}
		}

		if (!erreurs.isEmpty()) {
			throw new WebbatiException("Erreur dans la mise à jour de la base + \n" + erreurs);
		}
	}

	/**
	 * Crée un user role à partir des infos de user et de role
	 * 
	 * @param pUser user
	 * @param pRole role
	 * @throws WebbatiException
	 */
	private void createUserRoleFromUserAndRole(IUserAppli pUser, IRole pRole) throws WebbatiException {
		// Vérifie les infos en entrées
		if (pUser == null) {
			throw new WebbatiException("Le user ne peut pas être vide");
		}
		if (pRole == null) {
			throw new WebbatiException("Le role ne peut pas être vide");
		}

		// Crée le user role
		List<IRole> listRole = new ArrayList<>();
		listRole.add(pRole);
		pUser.setListRole(listRole);

		// Save
		IUserAppliManager manager = application.getUserAppliManager();
		manager.save(pUser);
	}

	/**
	 * Retourne le role par défaut en fonction du projet.
	 * 
	 * @param pProject project
	 * @return role par défaut
	 * @throws WebbatiException
	 */
	private IRole getRoleDefault(IProject pProject) throws WebbatiException {
		if (pProject != null) {
			List<IRole> listRoleFromProject = pProject.getListRole();
			if (listRoleFromProject != null) {
				for (IRole role : listRoleFromProject) {
					if (ROLE_DEFAULT.equals(role.getCode())) {
						return role;
					}
				}
			}
		}
		return null;
	}

	@Override
	protected IApplicationCommun getApplication() throws WebbatiException {
		return application;
	}

}
