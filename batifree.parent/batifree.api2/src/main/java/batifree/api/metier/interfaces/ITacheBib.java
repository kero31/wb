/***********************************************************************
 * Module: ITacheBib.java Author: Kero Purpose: Defines the Interface ITacheBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ITacheBib</b><br/>
 */
public interface ITacheBib extends ITache, IBibEltBib {

	/**
	 * Retourne le TacheEtude.
	 * 
	 * @return le TacheEtude
	 * @throws BatifreeException BatifreeException
	 */
	ITacheEtude getTacheEtude() throws BatifreeException;

}