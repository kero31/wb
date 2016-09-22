/***********************************************************************
 * Module: IMainOeuvreBibManager.java Author: Kero Purpose: Defines the Interface IMainOeuvreBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMainOeuvreBibManager</b><br/>
 */
public interface IMainOeuvreBibManager extends IMainOeuvreManager<IMainOeuvreBib>, ISousTacheManager<IMainOeuvreBib> {

	/**
	 * Retourne la MainOeuvreEtude à partir de la MainOeuvreBib.
	 * 
	 * @param pBib Bib
	 * @return MainOeuvreEtude
	 * @throws BatifreeException BatifreeException
	 */
	IMainOeuvreEtude getMainOeuvreEtudeFromBib(IMainOeuvreBib pBib) throws BatifreeException;

}