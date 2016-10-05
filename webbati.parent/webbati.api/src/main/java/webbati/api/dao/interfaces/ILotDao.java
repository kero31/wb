/***********************************************************************
 * Module: ILotDao.java Author: Kero Purpose: Defines the Interface ILotDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import webbati.api.metier.interfaces.ILot;

/**
 * Interface <b>ILotDao</b><br/>
 * 
 * @param <IT> ILot
 */
public interface ILotDao<IT extends ILot> extends IBibliothequeDao<IT> {
}