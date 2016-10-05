/***********************************************************************
 * Module: ITacheBib.java Author: Kero Purpose: Defines the Interface ITacheBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>ITacheBib</b><br/>
 */
public interface ITacheBib extends ITache, IBibEltBib {

	/**
	 * Retourne le TacheEtude.
	 * 
	 * @return le TacheEtude
	 * @throws WebbatiException WebbatiException
	 */
	ITacheEtude getTacheEtude() throws WebbatiException;

}