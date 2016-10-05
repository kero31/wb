/**
 * 
 */
package webbati.api.manager.impl;

import webbati.api.manager.interfaces.ISousTraitantManager;
import webbati.api.metier.interfaces.ISousTraitant;

/**
 * 
 * Classe/Interface <b>SousTraitantManagerImpl</b><br/>
 *
 * @param <IT> ISousTraitant
 */
public abstract class SousTraitantManagerImpl<IT extends ISousTraitant> extends BibliothequeElementManagerImpl<IT> implements
        ISousTraitantManager<IT> {

}
