/***********************************************************************
 * Module: ITacheManager.java Author: Kero Purpose: Defines the Interface ITacheManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.interfaces.ITache;

/**
 * Interface <b>ITacheManager</b><br/>
 * 
 * @param <IT> ITache
 */
public interface ITacheManager<IT extends ITache> extends IBibliothequeElementManager<IT>, ISousTacheManager<IT> {
}