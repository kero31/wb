/***********************************************************************
 * Module: IMateriauxBib.java Author: Kero Purpose: Defines the Interface IMateriauxBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMateriauxBib</b><br/>
 */
public interface IMateriauxBib extends IMateriaux, ISousTache, IBibEltBib {

	/**
	 * Retourne le MateriauxEtude.
	 * 
	 * @return le MateriauxEtude
	 * @throws BatifreeException BatifreeException
	 */
	IMateriauxEtude getMateriauxEtude() throws BatifreeException;

}