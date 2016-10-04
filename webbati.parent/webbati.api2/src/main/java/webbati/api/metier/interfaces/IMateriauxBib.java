/***********************************************************************
 * Module: IMateriauxBib.java Author: Kero Purpose: Defines the Interface IMateriauxBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IMateriauxBib</b><br/>
 */
public interface IMateriauxBib extends IMateriaux, ISousTache, IBibEltBib {

	/**
	 * Retourne le MateriauxEtude.
	 * 
	 * @return le MateriauxEtude
	 * @throws WebbatiException WebbatiException
	 */
	IMateriauxEtude getMateriauxEtude() throws WebbatiException;

}