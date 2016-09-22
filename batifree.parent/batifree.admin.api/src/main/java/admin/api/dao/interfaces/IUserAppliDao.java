/***********************************************************************
 * Module: IUserAppliDao.java Author: Kero Purpose: Defines the Interface IUserAppliDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IUserAppliDao</b><br/>
 */
public interface IUserAppliDao extends IDao<IUserAppli, Integer> {

	/**
	 * Retourne la liste des roles associé à l'utilisateur.
	 * 
	 * @param pUserAppli l'utilisateur
	 * @return liste des roles associé à l'utilisateur.
	 * @throws BatifreeException BatifreeException
	 */
	List<IRole> getListRole(IUserAppli pUserAppli) throws BatifreeException;

	/**
	 * Retourne la liste des Userproject associé à l'utilisateur.
	 * 
	 * @param pUserAppli l'utilisateur
	 * @return liste des Userproject associé à l'utilisateur.
	 * @throws BatifreeException BatifreeException
	 */
	List<IUserproject> getListUserproject(IUserAppli pUserAppli) throws BatifreeException;

}