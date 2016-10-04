/***********************************************************************
 * Module: ITacheManager.java Author: Kero Purpose: Defines the Interface ITacheManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.ITache;

/**
 * Interface <b>ITacheManager</b><br/>
 * 
 * @param <IT> ITache
 */
public interface ITacheManager<IT extends ITache> extends IBibliothequeElementManager<IT>, ISousTacheManager<IT> {
}