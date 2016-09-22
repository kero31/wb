/***********************************************************************
 * Module: ISousTache.java Author: Kero Purpose: Defines the Interface ISousTache
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ISousTache</b><br/>
 */
public interface ISousTache {

	/**
	 * Retourne la liste des Tache parente
	 * 
	 * @return List Tache
	 * @throws BatifreeException BatifreeException
	 */
	List<ITache> getListTacheParente() throws BatifreeException;

}