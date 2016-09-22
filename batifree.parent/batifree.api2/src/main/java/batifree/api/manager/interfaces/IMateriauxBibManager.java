/***********************************************************************
 * Module: IMateriauxBibManager.java Author: Kero Purpose: Defines the Interface IMateriauxBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMateriauxBibManager</b><br/>
 */
public interface IMateriauxBibManager extends IMateriauxManager<IMateriauxBib>, ISousTacheManager<IMateriauxBib> {

	/**
	 * Retourne la MateriauxEtude à partir de la MainOeuvreBib.
	 * 
	 * @param pBib Bib
	 * @return MateriauxEtude
	 * @throws BatifreeException BatifreeException
	 */
	IMateriauxEtude getMateriauxEtudeFromBib(IMateriauxBib pBib) throws BatifreeException;

}