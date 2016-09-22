/***********************************************************************
 * Module: IEcheancierReglementManager.java Author: Kero Purpose: Defines the Interface IEcheancierReglementManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import batifree.api.metier.ejb.EcheancierReglementId;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IEcheancierReglementManager</b><br/>
 */
public interface IEcheancierReglementManager extends IManager<IEcheancierReglement, EcheancierReglementId> {
}