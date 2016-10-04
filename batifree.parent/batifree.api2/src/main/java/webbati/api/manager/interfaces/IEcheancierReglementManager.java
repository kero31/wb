/***********************************************************************
 * Module: IEcheancierReglementManager.java Author: Kero Purpose: Defines the Interface IEcheancierReglementManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.manager.interfaces.IManager;
import webbati.api.metier.ejb.EcheancierReglementId;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Interface <b>IEcheancierReglementManager</b><br/>
 */
public interface IEcheancierReglementManager extends IManager<IEcheancierReglement, EcheancierReglementId> {
}