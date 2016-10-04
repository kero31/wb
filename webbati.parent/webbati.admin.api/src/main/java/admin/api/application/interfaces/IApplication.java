package admin.api.application.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import admin.api.manager.interfaces.IAdminDatabaseManager;
import admin.api.manager.interfaces.IConnectiondbManager;
import admin.api.manager.interfaces.IProjectManager;
import admin.api.manager.interfaces.IProjectscriptManager;
import admin.api.manager.interfaces.IRoleManager;
import admin.api.manager.interfaces.IUserAppliManager;
import admin.api.manager.interfaces.IUserprojectManager;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IUserApp;

/**
 * Interface <b>IApplication</b><br/>
 */
public interface IApplication extends common.api.application.interfaces.IApplicationCommun {

	/**
	 * Retourne l'utilisateur à partir du login et du code projet. Renvoie le user en fonction du login et du code projet
	 * 
	 * 
	 * @param pUsername login
	 * @param pCodeProject code du projet
	 * @return user en fonction du login et du code projet
	 * @throws WebbatiException WebbatiException
	 */
	IUserApp getUserAppFromUsernameProject(String pUsername, String pCodeProject) throws WebbatiException;

	/**
	 * Retourne le manager de l'administration de la base de données.
	 * 
	 * 
	 * @return Manager de l'administration de la base de données
	 */
	IAdminDatabaseManager getAdminDatabaseManager();

	/**
	 * Charge l'utilisateur en fonction de son login.
	 * 
	 * @param pUsername login
	 * @return utilisateur details
	 * @throws UsernameNotFoundException UsernameNotFoundException
	 */
	UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException;

	/**
	 * Retourne le manager de Connection.
	 * 
	 * @return le manager de Connection.
	 */
	IConnectiondbManager getConnectiondbManager();

	/**
	 * Retourne le manager de Project.
	 * 
	 * 
	 * @return le manager de Project.
	 */
	IProjectManager getProjectManager();

	/**
	 * Retourne le manager de Projectscript.
	 * 
	 * 
	 * @return le manager de Projectscript.
	 */
	IProjectscriptManager getProjectscriptManager();

	/**
	 * Retourne le manager de Role.
	 * 
	 * 
	 * @return le manager de Role.
	 */
	IRoleManager getRoleManager();

	/**
	 * Retourne le manager de Userappli.
	 * 
	 * 
	 * @return le manager de Userappli.
	 */
	IUserAppliManager getUserAppliManager();

	/**
	 * Retourne le manager de Userproject.
	 * 
	 * 
	 * @return le manager de Userproject.
	 */
	IUserprojectManager getUserprojectManager();

}