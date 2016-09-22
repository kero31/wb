/***********************************************************************
 * Module: ILotManager.java Author: Kero Purpose: Defines the Interface ILotManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.ILot;

/**
 * Interface <b>ILotManager</b><br/>
 * 
 * @param <IT> ILot
 */
public interface ILotManager<IT extends ILot> extends IBibliothequeManager<IT> {
}