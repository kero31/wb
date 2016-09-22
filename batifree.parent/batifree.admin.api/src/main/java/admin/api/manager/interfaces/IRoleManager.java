/***********************************************************************
 * Module: IRoleManager.java Author: Kero Purpose: Defines the Interface IRoleManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IRoleManager</b><br/>
 */
public interface IRoleManager extends IManager<IRole, Integer> {

	/**
	 * Retourne la liste des utilisateurs associés au rôle.
	 * 
	 * @param pRole le rôle
	 * @return liste des userrole associés au rôle
	 * @throws BatifreeException BatifreeException
	 */
	List<IUserAppli> getListUser(IRole pRole) throws BatifreeException;

}