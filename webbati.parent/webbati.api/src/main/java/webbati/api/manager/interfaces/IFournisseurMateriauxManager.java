/***********************************************************************
 * Module: IFournisseurMateriauxManager.java Author: Kero Purpose: Defines the Interface IFournisseurMateriauxManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.manager.interfaces.IManager;
import webbati.api.metier.ejb.FournisseurMateriauxId;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Interface <b>IFournisseurMateriauxManager</b><br/>
 */
public interface IFournisseurMateriauxManager extends IManager<IFournisseurMateriaux, FournisseurMateriauxId> {
}