/***********************************************************************
 * Module: IProjectManager.java Author: Kero Purpose: Defines the Interface IProjectManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IProjectManager</b><br/>
 */
public interface IProjectManager extends IManager<IProject, Integer> {

	/**
	 * Retourne le projet en fonction du code projet.
	 * 
	 * @param pCodeProject code projet
	 * @return projet en fonction du code projet.
	 * @throws BatifreeException BatifreeException
	 */
	IProject getProjectByCode(String pCodeProject) throws BatifreeException;

	/**
	 * Retourne la liste des rôles à partir du projet.
	 * 
	 * @param pProject le projet
	 * @return liste des rôles à partir du projet.
	 * @throws BatifreeException BatifreeException
	 */
	List<IRole> getListRole(IProject pProject) throws BatifreeException;

	/**
	 * Retourne la liste des scripts à partir du projet.
	 * 
	 * @param pProject le projet
	 * @return liste des scripts à partir du projet.
	 * @throws BatifreeException BatifreeException
	 */
	List<IProjectscript> getListProjectscript(IProject pProject) throws BatifreeException;

}