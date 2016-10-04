/***********************************************************************
 * Module: IEnginBibManager.java Author: Kero Purpose: Defines the Interface IEnginBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IEnginBib;
import webbati.api.metier.interfaces.IEnginEtude;

/**
 * Interface <b>IEnginBibManager</b><br/>
 */
public interface IEnginBibManager extends IEnginManager<IEnginBib>, ISousTacheManager<IEnginBib> {

	/**
	 * Retourne la EnginEtude à partir de la EnginBib.
	 * 
	 * @param pBib Bib
	 * @return EnginEtude
	 * @throws WebbatiException WebbatiException
	 */
	IEnginEtude getEnginEtudeFromBib(IEnginBib pBib) throws WebbatiException;

}