/***********************************************************************
 * Module: ILotBibManager.java Author: Kero Purpose: Defines the Interface ILotBibManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ILotBibManager</b><br/>
 */
public interface ILotBibManager extends ILotManager<ILotBib> {

	/**
	 * Retourne la LotEtude à partir de la LotBib.
	 * 
	 * @param pBib Bib
	 * @return LotEtude
	 * @throws BatifreeException BatifreeException
	 */
	ILotEtude getLotEtudeFromBib(ILotBib pBib) throws BatifreeException;

}