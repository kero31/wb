/***********************************************************************
 * Module: IEnginBib.java Author: Kero Purpose: Defines the Interface IEnginBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IEnginBib</b><br/>
 */
public interface IEnginBib extends IEngin, ISousTache, IBibEltBib {

	/**
	 * Retourne le EnginEtude.
	 * 
	 * @return le EnginEtude
	 * @throws BatifreeException BatifreeException
	 */
	IEnginEtude getEnginEtude() throws BatifreeException;

}