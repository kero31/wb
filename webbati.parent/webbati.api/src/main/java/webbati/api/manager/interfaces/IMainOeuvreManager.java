/***********************************************************************
 * Module: IMainOeuvreManager.java Author: Kero Purpose: Defines the Interface IMainOeuvreManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.IMainOeuvre;

/**
 * Interface <b>IMainOeuvreManager</b><br/>
 * 
 * @param <IT> IMainOeuvre
 */
public interface IMainOeuvreManager<IT extends IMainOeuvre> extends IBibliothequeElementManager<IT> {
}