/***********************************************************************
 * Module: ILigneDao.java Author: Kero Purpose: Defines the Interface ILigneDao
 ***********************************************************************/

package common.api.dao.interfaces;

import java.util.List;

import java.io.Serializable;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.ILigne;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>ILigneDao</b><br/>
 * 
 * @param <IT> IMetier<ID>
 * @param <ID> Serializable
 * @param <ITLIGNE> ILigne<ITLIGNE, ID>
 */
public interface ILigneDao<IT extends IMetier<ID>, ID extends Serializable, ITLIGNE extends ILigne<ITLIGNE, ID>> extends IDao<IT, ID> {

	/**
	 * Retourne la liste des lignes avec tous leurs enfants en fonction des critères.
	 * 
	 * @param pMaxResult pMaxResult
	 * @param pFirstResult Index du premier objet à récupérer
	 * @param pWithChildren TRUE si on charge avec les enfants, FALSE sinon
	 * @return liste des lignes
	 * @throws BatifreeException BatifreeException
	 */
	List<IT> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException;

}