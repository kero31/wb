/***********************************************************************
 * Module: IUserproject.java Author: Kero Purpose: Defines the Interface IUserproject
 ***********************************************************************/

package admin.api.metier.interfaces;

import admin.api.metier.id.UserprojectId;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IUserproject</b><br/>
 */
public interface IUserproject extends IMetier<UserprojectId> {

	/**
	 * Récupère le mot de passe de la BD.
	 * 
	 * @return mot de passe de la BD.
	 */
	String getBdPassword();

	/**
	 * Met à jour le mot de passe de la BD.
	 * 
	 * @param pBdPassword le mot de passe de la BD.
	 */
	void setBdPassword(String pBdPassword);

	/**
	 * Récupère le login de la BD.
	 * 
	 * @return login de la BD.
	 */
	String getBdLogin();

	/**
	 * Met à jour le login de la BD.
	 * 
	 * @param pBdLogin le login de la BD.
	 */
	void setBdLogin(String pBdLogin);

	/**
	 * Récupère le nom de la BD.
	 * 
	 * @return nom de la BD.
	 */
	String getBdDbname();

	/**
	 * Met à jour le nom de la BD.
	 * 
	 * @param pBdUsername le nom de la BD.
	 */
	void setBdDbname(String pBdUsername);

	/**
	 * Récupère l'utilisateur.
	 * 
	 * @return l'utilisateur.
	 * @throws WebbatiException WebbatiException
	 */
	IUserAppli getUserappli() throws WebbatiException;

	/**
	 * Met à jour l'utilisateur.
	 * 
	 * @param pUserAppli l'utiliateur
	 * @throws WebbatiException WebbatiException
	 */
	void setUserappli(IUserAppli pUserAppli) throws WebbatiException;

	/**
	 * Récupère le projet.
	 * 
	 * @return projet.
	 * @throws WebbatiException WebbatiException
	 */
	IProject getProject() throws WebbatiException;

	/**
	 * Met à jour le projet.
	 * 
	 * @param pProject le projet
	 * @throws WebbatiException WebbatiException
	 */
	void setProject(IProject pProject) throws WebbatiException;

	/**
	 * Récupère la connection BD.
	 * 
	 * @return connection BD.
	 * @throws WebbatiException WebbatiException
	 */
	IConnectiondb getConnectiondb() throws WebbatiException;

	/**
	 * Met à jour la connection BD.
	 * 
	 * @param pConnectiondb la Connection à la base de données
	 */
	void setConnectiondb(IConnectiondb pConnectiondb);

	/**
	 * Récupère le script du projet.
	 * 
	 * @return script du projet.
	 * @throws WebbatiException WebbatiException
	 */
	IProjectscript getProjectscript() throws WebbatiException;

	/**
	 * Met à jour le script du projet.
	 * 
	 * @param pProjectscript le script du projet
	 */
	void setProjectscript(IProjectscript pProjectscript);

}