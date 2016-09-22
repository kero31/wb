/**
 * 
 */
package batifree.api.manager.impl;

import batifree.api.manager.interfaces.IEnginManager;
import batifree.api.metier.interfaces.IEngin;

/**
 * 
 * Classe/Interface <b>EnginManagerImpl</b><br/>
 *
 * @param <IT> IEngin
 */
public abstract class EnginManagerImpl<IT extends IEngin> extends BibliothequeElementManagerImpl<IT> implements IEnginManager<IT> {

}
