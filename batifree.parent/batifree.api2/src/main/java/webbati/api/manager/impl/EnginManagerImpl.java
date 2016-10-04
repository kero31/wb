/**
 * 
 */
package webbati.api.manager.impl;

import webbati.api.manager.interfaces.IEnginManager;
import webbati.api.metier.interfaces.IEngin;

/**
 * 
 * Classe/Interface <b>EnginManagerImpl</b><br/>
 *
 * @param <IT> IEngin
 */
public abstract class EnginManagerImpl<IT extends IEngin> extends BibliothequeElementManagerImpl<IT> implements IEnginManager<IT> {

}
