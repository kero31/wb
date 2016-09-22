/***********************************************************************
 * Module: ILotBib.java Author: Kero Purpose: Defines the Interface ILotBib
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ILotBib</b><br/>
 */
public interface ILotBib extends ILot, IBibEltBib {

	/**
	 * Retourne le LotEtude.
	 * 
	 * @return le LotEtude
	 * @throws BatifreeException BatifreeException
	 */
	ILotEtude getLotEtude() throws BatifreeException;

}