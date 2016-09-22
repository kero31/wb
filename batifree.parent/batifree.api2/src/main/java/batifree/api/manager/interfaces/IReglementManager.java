/***********************************************************************
 * Module: IReglementManager.java Author: Kero Purpose: Defines the Interface IReglementManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IReglementManager</b><br/>
 */
public interface IReglementManager extends IManager<IReglement, Integer> {

	/**
	 * Retourne la liste des EcheancierReglement.
	 * 
	 * @param pReglement Reglement
	 * @return liste des EcheancierReglement.
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws BatifreeException;

}