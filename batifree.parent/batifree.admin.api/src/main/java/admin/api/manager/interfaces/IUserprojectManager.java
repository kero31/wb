/***********************************************************************
 * Module: IUserprojectManager.java Author: Kero Purpose: Defines the Interface IUserprojectManager
 ***********************************************************************/

package admin.api.manager.interfaces;

import admin.api.metier.id.UserprojectId;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IUserprojectManager</b><br/>
 */
public interface IUserprojectManager extends IManager<IUserproject, UserprojectId> {

	/**
	 * Retourne le userproject à partir de l'utilisateur et du projet.
	 * 
	 * @param pUserAppli utilisateur
	 * @param pProject projet
	 * @return userproject à partir de l'utilisateur et du projet.
	 * @throws BatifreeException BatifreeException
	 */
	IUserproject getUserprojectFromUserAppliAndProject(IUserAppli pUserAppli, IProject pProject) throws BatifreeException;

}