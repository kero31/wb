/***********************************************************************
 * Module: ILotBibManager.java Author: Kero Purpose: Defines the Interface ILotBibManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.ILotBib;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Interface <b>ILotBibManager</b><br/>
 */
public interface ILotBibManager extends ILotManager<ILotBib> {

	/**
	 * Retourne la LotEtude à partir de la LotBib.
	 * 
	 * @param pBib Bib
	 * @return LotEtude
	 * @throws WebbatiException WebbatiException
	 */
	ILotEtude getLotEtudeFromBib(ILotBib pBib) throws WebbatiException;

}