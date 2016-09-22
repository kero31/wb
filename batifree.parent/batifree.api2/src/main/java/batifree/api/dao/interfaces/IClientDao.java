/***********************************************************************
 * Module: IClientDao.java Author: Kero Purpose: Defines the Interface IClientDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IClientDao</b><br/>
 */
public interface IClientDao extends IContactDao<IClient> {

	/**
	 * Retourne la liste des Coordonnee contact
	 * 
	 * @param pClient Client
	 * @return liste des Coordonnee contact
	 * @throws BatifreeException BatifreeException
	 */
	List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws BatifreeException;

	/**
	 * Retourne la liste des affaires
	 * 
	 * @param pClient Client
	 * @return List Affaire
	 * @throws BatifreeException BatifreeException
	 */
	List<IAffaire> getListAffaire(IClient pClient) throws BatifreeException;

	/**
	 * Retourne la liste des règlements
	 * 
	 * @param pClient Client
	 * @return liste des règlements
	 * @throws BatifreeException BatifreeException
	 */
	List<IReglement> getListReglement(IClient pClient) throws BatifreeException;

}