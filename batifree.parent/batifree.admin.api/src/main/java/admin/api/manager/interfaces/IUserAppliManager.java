/***********************************************************************
 * Module: IUserAppliManager.java Author: Kero Purpose: Defines the Interface IUserAppliManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IUserAppliManager</b><br/>
 */
public interface IUserAppliManager extends IManager<IUserAppli, Integer> {

	/**
	 * Retourne l'utilisateur à partir de son login.
	 * 
	 * @param pUsername login de l'utilisateur
	 * @return utilisateur à partir de son login.
	 * @throws BatifreeException BatifreeException
	 */
	IUserAppli getUserByUsername(String pUsername) throws BatifreeException;

	/**
	 * Retourne la liste des Userproject associé à l'utilisateur.
	 * 
	 * @param pUserAppli l'utilisateur
	 * @return liste des Userproject associé à l'utilisateur.
	 * @throws BatifreeException BatifreeException
	 */
	List<IUserproject> getListUserproject(IUserAppli pUserAppli) throws BatifreeException;

	/**
	 * Retourne la liste des roles associé à l'utilisateur.
	 * 
	 * @param pUserAppli l'utilisateur
	 * @return liste des roles associé à l'utilisateur.
	 * @throws BatifreeException BatifreeException
	 */
	List<IRole> getListRole(IUserAppli pUserAppli) throws BatifreeException;

}