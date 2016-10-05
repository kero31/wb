/***********************************************************************
 * Module: IReglementDao.java Author: Kero Purpose: Defines the Interface IReglementDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IReglement;

/**
 * Interface <b>IReglementDao</b><br/>
 */
public interface IReglementDao extends IDao<IReglement, Integer> {

	/**
	 * Retourne la liste des Echeancier Reglement.
	 * 
	 * @param pReglement Reglement
	 * @return liste des Echeancier Reglement
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws WebbatiException;

}