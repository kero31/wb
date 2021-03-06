/***********************************************************************
 * Module: ISousTraitantManager.java Author: Kero Purpose: Defines the Interface ISousTraitantManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import webbati.api.metier.interfaces.ISousTraitant;

/**
 * Interface <b>ISousTraitantManager</b><br/>
 * 
 * @param <IT> ISousTraitant
 */
public interface ISousTraitantManager<IT extends ISousTraitant> extends IBibliothequeElementManager<IT> {
}