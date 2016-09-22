/***********************************************************************
 * Module: ISousTraitantBibManager.java Author: Kero Purpose: Defines the Interface ISousTraitantBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ISousTraitantBibManager</b><br/>
 */
public interface ISousTraitantBibManager extends ISousTraitantManager<ISousTraitantBib>, ISousTacheManager<ISousTraitantBib> {

	/**
	 * Retourne la SousTraitantEtude à partir de la SousTraitantBib.
	 * 
	 * @param pBib Bib
	 * @return SousTraitantEtude
	 * @throws BatifreeException BatifreeException
	 */
	ISousTraitantEtude getTacheEtudeFromBib(ISousTraitantBib pBib) throws BatifreeException;

}