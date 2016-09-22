/***********************************************************************
 * Module: IEnginManager.java Author: Kero Purpose: Defines the Interface IEnginManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.IEngin;

/**
 * Interface <b>IEnginManager</b><br/>
 * 
 * @param <IT> IEngin
 */
public interface IEnginManager<IT extends IEngin> extends IBibliothequeElementManager<IT> {
}