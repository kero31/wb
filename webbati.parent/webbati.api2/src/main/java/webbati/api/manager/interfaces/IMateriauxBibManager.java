/***********************************************************************
 * Module: IMateriauxBibManager.java Author: Kero Purpose: Defines the Interface IMateriauxBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IMateriauxBib;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Interface <b>IMateriauxBibManager</b><br/>
 */
public interface IMateriauxBibManager extends IMateriauxManager<IMateriauxBib>, ISousTacheManager<IMateriauxBib> {

	/**
	 * Retourne la MateriauxEtude à partir de la MainOeuvreBib.
	 * 
	 * @param pBib Bib
	 * @return MateriauxEtude
	 * @throws WebbatiException WebbatiException
	 */
	IMateriauxEtude getMateriauxEtudeFromBib(IMateriauxBib pBib) throws WebbatiException;

}