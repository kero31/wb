/***********************************************************************
 * Module: ITacheBibManager.java Author: Kero Purpose: Defines the Interface ITacheBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.ITacheBib;
import webbati.api.metier.interfaces.ITacheEtude;

/**
 * Interface <b>ITacheBibManager</b><br/>
 */
public interface ITacheBibManager extends ITacheManager<ITacheBib> {

	/**
	 * Retourne la TacheEtude à partir de la TacheBib.
	 * 
	 * @param pBib Bib
	 * @return TacheEtude
	 * @throws WebbatiException WebbatiException
	 */
	ITacheEtude getTacheEtudeFromBib(ITacheBib pBib) throws WebbatiException;

}