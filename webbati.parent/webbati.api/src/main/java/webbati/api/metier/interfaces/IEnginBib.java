/***********************************************************************
 * Module: IEnginBib.java Author: Kero Purpose: Defines the Interface IEnginBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IEnginBib</b><br/>
 */
public interface IEnginBib extends IEngin, ISousTache, IBibEltBib {

	/**
	 * Retourne le EnginEtude.
	 * 
	 * @return le EnginEtude
	 * @throws WebbatiException WebbatiException
	 */
	IEnginEtude getEnginEtude() throws WebbatiException;

}