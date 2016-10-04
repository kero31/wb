/***********************************************************************
 * Module: ILotManager.java Author: Kero Purpose: Defines the Interface ILotManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.ILot;

/**
 * Interface <b>ILotManager</b><br/>
 * 
 * @param <IT> ILot
 */
public interface ILotManager<IT extends ILot> extends IBibliothequeManager<IT> {
}