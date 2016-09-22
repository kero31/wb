/***********************************************************************
 * Module: IAdminDatabaseManager.java Author: Kero Purpose: Defines the Interface IAdminDatabaseManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import java.util.Date;

import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername) throws BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId, String pMailUsername)
	        throws BatifreeException;

	/**
	 * Crée toutes les données user - project à partir d'un code projet en utilisant la connection de démo. Envoie le résultat des infos de connexions
	 * par mail.
	 * 
	 * 
	 * @param pCodeProject code projet
	 * @param pMailUsername email username
	 * @return login/password
	 * @throws BatifreeException BatifreeException
	 */
	String createUserDemoFromProject(String pCodeProject, String pMailUsername) throws BatifreeException;

	/**
	 * Crée toutes les données user - project à partir d'un code projet en utilisant la connection de test. Cet utilisateur contiendra les données
	 * pour les tests unitaires. Si cet utilisateur existe déjà, il sera supprimé puis recréé.
	 * 
	 * 
	 * @param pCodeProject code projet
	 * @return login/password
	 * @throws BatifreeException BatifreeException
	 */
	String createUserTestFromProject(String pCodeProject) throws BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, Integer pConnectionId, String pMailUsername,
	        String pUsernameParent, String pPasswordUsernameParent) throws BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	String createUserFromUsernameProject(String pUsername, String pCodeProject, Date pDateExpired, String pMailUsername, String pUsernameParent,
	        String pPasswordUsernameParent) throws BatifreeException;

	/**
	 * Ajoute à l'utilisateur user le projet avec le codeProject sur une connection par défaut et crée la base de données du projet pour cet
	 * utilisateur
	 * 
	 * 
	 * @param pUser user
	 * @param pCodeProject codeProject
	 * @throws BatifreeException BatifreeException
	 */
	void addProjectToUser(IUserAppli pUser, String pCodeProject) throws BatifreeException;

	/**
	 * Ajoute à l'utilisateur user le projet avec le codeProject et crée la base de données du projet pour cet utilisateur
	 * 
	 * 
	 * @param pUser user
	 * @param pCodeProject codeProject
	 * @param pConnection connection
	 * @return userproject IUserproject
	 * @throws BatifreeException BatifreeException
	 */
	IUserproject addProjectToUser(IUserAppli pUser, String pCodeProject, IConnectiondb pConnection) throws BatifreeException;

	/**
	 * Vérifie la validité des comptes des utilisateurs Si la date d'expiration est supérieure à celle du jour, alors on bloque : LOCK Si la date
	 * d'expiration est supérieure de + de USER_NB_JOURS_DELETED jours, alors on supprime l'utilisateur
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void checkValidityUsers() throws BatifreeException;

	/**
	 * Supprime le userproject et sa database appartennant à cet utilisateur
	 * 
	 * 
	 * @param pUserproject userproject à supprimer
	 * @throws BatifreeException BatifreeException
	 */
	void deleteUserProjectAndDatabase(IUserproject pUserproject) throws BatifreeException;

	/**
	 * Supprime l'utilisateur (avec tous ses projets) et ses databases appartennant à cet utilisateur
	 * 
	 * 
	 * @param pUser utilisateur à supprimer ses database
	 * @throws BatifreeException BatifreeException
	 */
	void deleteUserAndDatabase(IUserAppli pUser) throws BatifreeException;

	/**
	 * Retourne la connection la plus appropriée => Celle qui a le plus petit nombre d'utilisateur restant avant d'atteindre la limite user alert =>
	 * Si même nombre de user, alors on prend la première => Si la limite user alert est atteinte sur tous les serveurs, alors on prend celui qui a le
	 * plus nombre d'utilisateur qui dépasse la limite
	 * 
	 * 
	 * @return connection la plus appropriée
	 * @throws BatifreeException BatifreeException
	 */
	IConnectiondb getConnectionDefault() throws BatifreeException;

	/**
	 * Mets à jour toutes les database des users appartenant au projet codeProject
	 * 
	 * 
	 * @param pCodeProject code projet sur lequel va s'appliquer les mises à jour
	 * @throws BatifreeException BatifreeException
	 */
	void updateDatabases(String pCodeProject) throws BatifreeException;

}