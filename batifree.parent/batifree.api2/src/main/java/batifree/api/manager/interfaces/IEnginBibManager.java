/***********************************************************************
 * Module: IEnginBibManager.java Author: Kero Purpose: Defines the Interface IEnginBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IEnginBibManager</b><br/>
 */
public interface IEnginBibManager extends IEnginManager<IEnginBib>, ISousTacheManager<IEnginBib> {

	/**
	 * Retourne la EnginEtude à partir de la EnginBib.
	 * 
	 * @param pBib Bib
	 * @return EnginEtude
	 * @throws BatifreeException BatifreeException
	 */
	IEnginEtude getEnginEtudeFromBib(IEnginBib pBib) throws BatifreeException;

}