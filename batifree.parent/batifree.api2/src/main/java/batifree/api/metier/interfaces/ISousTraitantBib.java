/***********************************************************************
 * Module: ISousTraitantBib.java Author: Kero Purpose: Defines the Interface ISousTraitantBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ISousTraitantBib</b><br/>
 */
public interface ISousTraitantBib extends ISousTraitant, ISousTache, IBibEltBib {

	/**
	 * Retourne le SousTraitantEtude.
	 * 
	 * @return le SousTraitantEtude
	 * @throws BatifreeException BatifreeException
	 */
	ISousTraitantEtude getSousTraitantEtude() throws BatifreeException;

}