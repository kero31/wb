/***********************************************************************
 * Module: IEcheancierDao.java Author: Kero Purpose: Defines the Interface IEcheancierDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IEcheancierDao</b><br/>
 */
public interface IEcheancierDao extends IDao<IEcheancier, Integer> {

	/**
	 * Retourne la liste des Echeancier Reglement.
	 * 
	 * @param pEcheancier Echeancier
	 * @return liste des Echeancier Reglement.
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws BatifreeException;

}