/***********************************************************************
 * Module: IRoleDao.java Author: Kero Purpose: Defines the Interface IRoleDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IRoleDao</b><br/>
 */
public interface IRoleDao extends IDao<IRole, Integer> {

	/**
	 * Retourne la liste des utilisateurs associés au rôle.
	 * 
	 * @param pRole le rôle
	 * @return liste des userrole associés au rôle
	 * @throws BatifreeException BatifreeException
	 */
	List<IUserAppli> getListUser(IRole pRole) throws BatifreeException;

}