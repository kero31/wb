/***********************************************************************
 * Module: ILotBib.java Author: Kero Purpose: Defines the Interface ILotBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>ILotBib</b><br/>
 */
public interface ILotBib extends ILot, IBibEltBib {

	/**
	 * Retourne le LotEtude.
	 * 
	 * @return le LotEtude
	 * @throws WebbatiException WebbatiException
	 */
	ILotEtude getLotEtude() throws WebbatiException;

}