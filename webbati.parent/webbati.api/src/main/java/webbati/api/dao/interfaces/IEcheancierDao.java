/***********************************************************************
 * Module: IEcheancierDao.java Author: Kero Purpose: Defines the Interface IEcheancierDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Interface <b>IEcheancierDao</b><br/>
 */
public interface IEcheancierDao extends IDao<IEcheancier, Integer> {

	/**
	 * Retourne la liste des Echeancier Reglement.
	 * 
	 * @param pEcheancier Echeancier
	 * @return liste des Echeancier Reglement.
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws WebbatiException;

}