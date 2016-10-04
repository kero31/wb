/**
 * 
 */
package webbati.api.manager.impl;

import webbati.api.manager.interfaces.ILotManager;
import webbati.api.metier.interfaces.ILot;

/**
 * 
 * Classe/Interface <b>LotManagerImpl</b><br/>
 *
 * @param <IT> ILot
 */
public abstract class LotManagerImpl<IT extends ILot> extends BibliothequeManagerImpl<IT> implements ILotManager<IT> {

}
