/***********************************************************************
 * Module: IAdminDatabaseManager.java Author: Kero Purpose: Defines the Interface IAdminDatabaseManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import java.util.Date;

import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IAdminDatabaseManager</b><br/>
 */
public interface IAdminDatabaseManager {
	String ROLE_DEFAULT = "ROLE_USER";
	int USER_NB_JOURS_DELETED = 30;
	String TEST_USERNAME = "test_unitaire";
	String TEST_PASSWORD_USERNAME = "test_unitaire";
	int TEST_NB_JOURS = 2;
	String DEMO_USERNAME_PREFIXE = "demo_";
	int DEMO_NB_JOURS = 2;
	String EMAIL_ADMIN_DATABASE = "kero31@gmail.com";

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet en utilisant la connection par défault
	 * 
	 * 
	 * @param pUsername username
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pMailUsername Mail Username
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername) throws WebbatiException;

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet en utilisant la connection par défault Utilisateur qui
	 * veut une connection propre a lui
	 * 
	 * 
	 * @param pUsername username
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pConnectionId connection Id
	 * @param pMailUsername email username
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId, String pMailUsername)
	        throws WebbatiException;

	/**
	 * Crée toutes les données user - project à partir d'un code projet en utilisant la connection de démo. Envoie le résultat des infos de connexions
	 * par mail.
	 * 
	 * 
	 * @param pCodeProject code projet
	 * @param pMailUsername email username
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserDemoFromProject(String pCodeProject, String pMailUsername) throws WebbatiException;

	/**
	 * Crée toutes les données user - project à partir d'un code projet en utilisant la connection de test. Cet utilisateur contiendra les données
	 * pour les tests unitaires. Si cet utilisateur existe déjà, il sera supprimé puis recréé.
	 * 
	 * 
	 * @param pCodeProject code projet
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserTestFromProject(String pCodeProject) throws WebbatiException;

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet en spéciafiant le user parent. La connection sera
	 * spécifique et est donné en paramètre.
	 * 
	 * @param pUsername username
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pConnectionId connection id
	 * @param pMailUsername email username
	 * @param pUsernameParent username parent
	 * @param pPasswordUsernameParent password de l'username parent
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId, String pMailUsername,
	        String pUsernameParent, String pPasswordUsernameParent) throws WebbatiException;

	/**
	 * Crée toutes les données user - project à partir de son username et de son code projet en spéciafiant le user parent. La connection sera
	 * identique à celle du user parent
	 * 
	 * 
	 * @param pUsername username
	 * @param pCodeProject code projet
	 * @param pDateExpired date expiration
	 * @param pMailUsername email username
	 * @param pUsernameParent username parent
	 * @param pPasswordUsernameParent password de l'username parent
	 * @return login/password
	 * @throws WebbatiException WebbatiException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername, String pUsernameParent,
	        String pPasswordUsernameParent) throws WebbatiException;

	/**
	 * Ajoute à l'utilisateur user le projet avec le codeProject sur une connection par défaut et crée la base de données du projet pour cet
	 * utilisateur
	 * 
	 * 
	 * @param pUser user
	 * @param pCodeProject codeProject
	 * @throws WebbatiException WebbatiException
	 */
	void addProjectToUser(IUserAppli pUser, String pCodeProject) throws WebbatiException;

	/**
	 * Ajoute à l'utilisateur user le projet avec le codeProject et crée la base de données du projet pour cet utilisateur
	 * 
	 * 
	 * @param pUser user
	 * @param pCodeProject codeProject
	 * @param pConnection connection
	 * @return userproject IUserproject
	 * @throws WebbatiException WebbatiException
	 */
	IUserproject addProjectToUser(IUserAppli pUser, String pCodeProject, IConnectiondb pConnection) throws WebbatiException;

	/**
	 * Vérifie la validité des comptes des utilisateurs Si la date d'expiration est supérieure à celle du jour, alors on bloque : LOCK Si la date
	 * d'expiration est supérieure de + de USER_NB_JOURS_DELETED jours, alors on supprime l'utilisateur
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void checkValidityUsers() throws WebbatiException;

	/**
	 * Supprime le userproject et sa database appartennant à cet utilisateur
	 * 
	 * 
	 * @param pUserproject userproject à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void deleteUserProjectAndDatabase(IUserproject pUserproject) throws WebbatiException;

	/**
	 * Supprime l'utilisateur (avec tous ses projets) et ses databases appartennant à cet utilisateur
	 * 
	 * 
	 * @param pUser utilisateur à supprimer ses database
	 * @throws WebbatiException WebbatiException
	 */
	void deleteUserAndDatabase(IUserAppli pUser) throws WebbatiException;

	/**
	 * Retourne la connection la plus appropriée => Celle qui a le plus petit nombre d'utilisateur restant avant d'atteindre la limite user alert =>
	 * Si même nombre de user, alors on prend la première => Si la limite user alert est atteinte sur tous les serveurs, alors on prend celui qui a le
	 * plus nombre d'utilisateur qui dépasse la limite
	 * 
	 * 
	 * @return connection la plus appropriée
	 * @throws WebbatiException WebbatiException
	 */
	IConnectiondb getConnectionDefault() throws WebbatiException;

	/**
	 * Mets à jour toutes les database des users appartenant au projet codeProject
	 * 
	 * 
	 * @param pCodeProject code projet sur lequel va s'appliquer les mises à jour
	 * @throws WebbatiException WebbatiException
	 */
	void updateDatabases(String pCodeProject) throws WebbatiException;

}