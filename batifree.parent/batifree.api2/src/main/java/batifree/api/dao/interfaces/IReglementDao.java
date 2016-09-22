/***********************************************************************
 * Module: IReglementDao.java Author: Kero Purpose: Defines the Interface IReglementDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IReglement;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IReglementDao</b><br/>
 */
public interface IReglementDao extends IDao<IReglement, Integer> {

	/**
	 * Retourne la liste des Echeancier Reglement.
	 * 
	 * @param pReglement Reglement
	 * @return liste des Echeancier Reglement
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws BatifreeException;

}