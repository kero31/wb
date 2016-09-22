/**
 * 
 */
package batifree.api.manager.impl;

import batifree.api.manager.interfaces.ITacheManager;
import batifree.api.metier.interfaces.ITache;

/**
 * 
 * Classe/Interface <b>TacheManagerImpl</b><br/>
 *
 * @param <IT> ITache
 */
public abstract class TacheManagerImpl<IT extends ITache> extends BibliothequeElementManagerImpl<IT> implements ITacheManager<IT> {

}
