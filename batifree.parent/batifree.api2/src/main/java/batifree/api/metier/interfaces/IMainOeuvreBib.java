/***********************************************************************
 * Module: IMainOeuvreBib.java Author: Kero Purpose: Defines the Interface IMainOeuvreBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMainOeuvreBib</b><br/>
 */
public interface IMainOeuvreBib extends IMainOeuvre, ISousTache, IBibEltBib {

	/**
	 * Retourne le MainOeuvreEtude.
	 * 
	 * @return le MainOeuvreEtude
	 * @throws BatifreeException BatifreeException
	 */
	IMainOeuvreEtude getMainOeuvreEtude() throws BatifreeException;

}