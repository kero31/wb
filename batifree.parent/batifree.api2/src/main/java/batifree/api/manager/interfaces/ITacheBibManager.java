/***********************************************************************
 * Module: ITacheBibManager.java Author: Kero Purpose: Defines the Interface ITacheBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ITacheBibManager</b><br/>
 */
public interface ITacheBibManager extends ITacheManager<ITacheBib> {

	/**
	 * Retourne la TacheEtude à partir de la TacheBib.
	 * 
	 * @param pBib Bib
	 * @return TacheEtude
	 * @throws BatifreeException BatifreeException
	 */
	ITacheEtude getTacheEtudeFromBib(ITacheBib pBib) throws BatifreeException;

}