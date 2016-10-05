/***********************************************************************
 * Module: IEnginManager.java Author: Kero Purpose: Defines the Interface IEnginManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.IEngin;

/**
 * Interface <b>IEnginManager</b><br/>
 * 
 * @param <IT> IEngin
 */
public interface IEnginManager<IT extends IEngin> extends IBibliothequeElementManager<IT> {
}