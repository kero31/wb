/***********************************************************************
 * Module: IFournisseurMateriauxManager.java Author: Kero Purpose: Defines the Interface IFournisseurMateriauxManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.ejb.FournisseurMateriauxId;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IFournisseurMateriauxManager</b><br/>
 */
public interface IFournisseurMateriauxManager extends IManager<IFournisseurMateriaux, FournisseurMateriauxId> {
}