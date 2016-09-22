/***********************************************************************
 * Module: IVScriptUpdateDao.java Author: Kero Purpose: Defines the Interface IVScriptUpdateDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import java.util.List;

import admin.api.metier.interfaces.IVScriptUpdate;

import common.api.dao.interfaces.IViewDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IVScriptUpdateDao</b><br/>
 */
public interface IVScriptUpdateDao extends IViewDao<IVScriptUpdate> {

	/**
	 * Retourne la liste de la vue en fonction de l'id du projet.
	 * 
	 * @param pProjectId id du projet
	 * @return liste de la vue en fonction de l'id du projet.
	 * @throws BatifreeException BatifreeException
	 */
	List<IVScriptUpdate> getListByProjectId(Integer pProjectId) throws BatifreeException;

}