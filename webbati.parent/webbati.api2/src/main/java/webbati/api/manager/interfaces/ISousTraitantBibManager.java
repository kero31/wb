/***********************************************************************
 * Module: ISousTraitantBibManager.java Author: Kero Purpose: Defines the Interface ISousTraitantBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.ISousTraitantBib;
import webbati.api.metier.interfaces.ISousTraitantEtude;

/**
 * Interface <b>ISousTraitantBibManager</b><br/>
 */
public interface ISousTraitantBibManager extends ISousTraitantManager<ISousTraitantBib>, ISousTacheManager<ISousTraitantBib> {

	/**
	 * Retourne la SousTraitantEtude à partir de la SousTraitantBib.
	 * 
	 * @param pBib Bib
	 * @return SousTraitantEtude
	 * @throws WebbatiException WebbatiException
	 */
	ISousTraitantEtude getTacheEtudeFromBib(ISousTraitantBib pBib) throws WebbatiException;

}