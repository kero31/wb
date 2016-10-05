/***********************************************************************
 * Module: IMainOeuvreBibManager.java Author: Kero Purpose: Defines the Interface IMainOeuvreBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IMainOeuvreBib;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Interface <b>IMainOeuvreBibManager</b><br/>
 */
public interface IMainOeuvreBibManager extends IMainOeuvreManager<IMainOeuvreBib>, ISousTacheManager<IMainOeuvreBib> {

	/**
	 * Retourne la MainOeuvreEtude à partir de la MainOeuvreBib.
	 * 
	 * @param pBib Bib
	 * @return MainOeuvreEtude
	 * @throws WebbatiException WebbatiException
	 */
	IMainOeuvreEtude getMainOeuvreEtudeFromBib(IMainOeuvreBib pBib) throws WebbatiException;

}