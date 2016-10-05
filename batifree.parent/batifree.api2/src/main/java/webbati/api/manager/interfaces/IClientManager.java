/***********************************************************************
 * Module: IClientManager.java Author: Kero Purpose: Defines the Interface IClientManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IReglement;

/**
 * Interface <b>IClientManager</b><br/>
 */
public interface IClientManager extends IContactManager<IClient> {

	/**
	 * Retourne la liste des Coordonnee contact
	 * 
	 * @param pClient Client
	 * @return liste des Coordonnee contact
	 * @throws WebbatiException WebbatiException
	 */
	List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws WebbatiException;

	/**
	 * Retourne la liste des affaires
	 * 
	 * @param pClient Client
	 * @return liste des Affaires
	 * @throws WebbatiException WebbatiException
	 */
	List<IAffaire> getListAffaire(IClient pClient) throws WebbatiException;

	/**
	 * Retourne la liste des règlements
	 * 
	 * @param pClient Client
	 * @return liste des règlements
	 * @throws WebbatiException WebbatiException
	 */
	List<IReglement> getListReglement(IClient pClient) throws WebbatiException;

}