/***********************************************************************
 * Module: IMainOeuvreBib.java Author: Kero Purpose: Defines the Interface IMainOeuvreBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IMainOeuvreBib</b><br/>
 */
public interface IMainOeuvreBib extends IMainOeuvre, ISousTache, IBibEltBib {

	/**
	 * Retourne le MainOeuvreEtude.
	 * 
	 * @return le MainOeuvreEtude
	 * @throws WebbatiException WebbatiException
	 */
	IMainOeuvreEtude getMainOeuvreEtude() throws WebbatiException;

}