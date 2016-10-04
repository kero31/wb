/***********************************************************************
 * Module: IBibliothequeElementManager.java Author: Kero Purpose: Defines the Interface IBibliothequeElementManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.IBibliothequeElement;

/**
 * Interface <b>IBibliothequeElementManager</b><br/>
 * 
 * @param <IT> IBibliothequeElement
 */
public interface IBibliothequeElementManager<IT extends IBibliothequeElement> extends IBibliothequeManager<IT> {
}