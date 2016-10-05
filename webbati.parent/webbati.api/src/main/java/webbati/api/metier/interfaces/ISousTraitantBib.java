/***********************************************************************
 * Module: ISousTraitantBib.java Author: Kero Purpose: Defines the Interface ISousTraitantBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>ISousTraitantBib</b><br/>
 */
public interface ISousTraitantBib extends ISousTraitant, ISousTache, IBibEltBib {

	/**
	 * Retourne le SousTraitantEtude.
	 * 
	 * @return le SousTraitantEtude
	 * @throws WebbatiException WebbatiException
	 */
	ISousTraitantEtude getSousTraitantEtude() throws WebbatiException;

}