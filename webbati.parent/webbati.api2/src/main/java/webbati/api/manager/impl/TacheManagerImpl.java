/**
 * 
 */
package webbati.api.manager.impl;

import webbati.api.manager.interfaces.ITacheManager;
import webbati.api.metier.interfaces.ITache;

/**
 * 
 * Classe/Interface <b>TacheManagerImpl</b><br/>
 *
 * @param <IT> ITache
 */
public abstract class TacheManagerImpl<IT extends ITache> extends BibliothequeElementManagerImpl<IT> implements ITacheManager<IT> {

}
