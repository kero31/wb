/**
 * 
 */
package batifree.api.manager.impl;

import batifree.api.manager.interfaces.ILotManager;
import batifree.api.metier.interfaces.ILot;

/**
 * 
 * Classe/Interface <b>LotManagerImpl</b><br/>
 *
 * @param <IT> ILot
 */
public abstract class LotManagerImpl<IT extends ILot> extends BibliothequeManagerImpl<IT> implements ILotManager<IT> {

}
