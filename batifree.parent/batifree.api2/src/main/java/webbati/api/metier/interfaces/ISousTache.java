/***********************************************************************
 * Module: ISousTache.java Author: Kero Purpose: Defines the Interface ISousTache
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>ISousTache</b><br/>
 */
public interface ISousTache {

	/**
	 * Retourne la liste des Tache parente
	 * 
	 * @return List Tache
	 * @throws WebbatiException WebbatiException
	 */
	List<ITache> getListTacheParente() throws WebbatiException;

}