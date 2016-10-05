/***********************************************************************
 * Module: IReglementManager.java Author: Kero Purpose: Defines the Interface IReglementManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IReglement;

/**
 * Interface <b>IReglementManager</b><br/>
 */
public interface IReglementManager extends IManager<IReglement, Integer> {

	/**
	 * Retourne la liste des EcheancierReglement.
	 * 
	 * @param pReglement Reglement
	 * @return liste des EcheancierReglement.
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws WebbatiException;

}