/***********************************************************************
 * Module: ILigneManager.java Author: Kero Purpose: Defines the Interface ILigneManager
 ***********************************************************************/

package common.api.manager.interfaces;

import java.util.List;

import java.io.Serializable;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.ILigne;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>ILigneManager</b><br/>
 * 
 * @param <IT> IMetier<ID>
 * @param <ID> Serializable
 * @param <ITLIGNE> ILigne<ITLIGNE, ID>
 */
public interface ILigneManager<IT extends IMetier<ID>, ID extends Serializable, ITLIGNE extends ILigne<ITLIGNE, ID>> extends IViewManager<IT, ID> {

	/**
	 * Crée ou met à jour la liste des objets pListObjects. Si pour chaque objet, son ID vaut NULL ou 0, alors c'est une création, sinon c'est une
	 * mise à jour
	 * 
	 * @param pListObjects Liste des objets à créer ou à modifier.
	 * @throws BatifreeException BatifreeException
	 */
	void save(List<IT> pListObjects) throws BatifreeException;

	/**
	 * Retourne la liste des lignes avec tous leurs enfants en fonction des critères.
	 * 
	 * @param pMaxResult pMaxResult
	 * @param pFirstResult Index du premier objet à récupérer
	 * @param pWithChildren TRUE si on charge avec les enfants, FALSE sinon
	 * @return liste des lignes
	 * @throws BatifreeException BatifreeException
	 */
	List<IT> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException;

	/**
	 * Retourne la liste des lignes avec tous leurs enfants en fonction des critères.
	 * 
	 * @param pWithChildren TRUE si on charge avec les enfants, FALSE sinon
	 * @return liste des lignes
	 * @throws BatifreeException BatifreeException
	 */
	List<IT> getList(boolean pWithChildren) throws BatifreeException;

	/**
	 * Retourne l'objet avec sa liste des enfants et sous enfants
	 * 
	 * @param pObject objet à mettre à jour
	 * @return objet avec sa liste des enfants et sous enfants
	 * @throws BatifreeException BatifreeException
	 */
	IT getWithChildren(IT pObject) throws BatifreeException;

}