/**
 * 
 */
package batifree.api.manager.impl;

import batifree.api.manager.interfaces.ISousTraitantManager;
import batifree.api.metier.interfaces.ISousTraitant;

/**
 * 
 * Classe/Interface <b>SousTraitantManagerImpl</b><br/>
 *
 * @param <IT> ISousTraitant
 */
public abstract class SousTraitantManagerImpl<IT extends ISousTraitant> extends BibliothequeElementManagerImpl<IT> implements
        ISousTraitantManager<IT> {

}
