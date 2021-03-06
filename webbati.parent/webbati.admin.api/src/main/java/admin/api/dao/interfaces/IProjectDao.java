/***********************************************************************
 * Module: IProjectDao.java Author: Kero Purpose: Defines the Interface IProjectDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;

/**
 * Interface <b>IProjectDao</b><br/>
 */
public interface IProjectDao extends IDao<IProject, Integer> {

	/**
	 * Retourne la liste des rôles à partir du projet.
	 * 
	 * @param pProject le projet
	 * @return liste des rôles à partir du projet.
	 * @throws WebbatiException WebbatiException
	 */
	List<IRole> getListRole(IProject pProject) throws WebbatiException;

	/**
	 * Retourne la liste des scripts à partir du projet.
	 * 
	 * @param pProject le projet
	 * @return liste des scripts à partir du projet
	 * @throws WebbatiException WebbatiException
	 */
	List<IProjectscript> getListProjectscript(IProject pProject) throws WebbatiException;

}