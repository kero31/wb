package common.api.manager.interfaces;

import java.util.List;

import java.io.Serializable;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IManager</b><br/>
 * 
 * @param <IT> IMetier<ID>
 * @param <ID> Serializable
 */
public interface IManager<IT extends IMetier<ID>, ID extends Serializable> extends IViewManager<IT, ID> {

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour
	 * 
	 * @param pObject Objet à créer ou à mettre à jour
	 * @return Objet créé ou modifié
	 * @throws WebbatiException WebbatiException
	 */
	IT save(IT pObject) throws WebbatiException;

	/**
	 * Supprime un objet à partir de son ID
	 * 
	 * @param pId Id de l'objet à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(ID pId) throws WebbatiException;

	/**
	 * Supprime l'objet pObject
	 * 
	 * @param pObject Objet à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(IT pObject) throws WebbatiException;

	/**
	 * Crée ou met à jour la liste des objets pListObjects. Si pour chaque objet, son ID vaut NULL ou 0, alors c'est une création, sinon c'est une
	 * mise à jour
	 * 
	 * @param pListObjects Liste des objets à créer ou à modifier.
	 * @throws WebbatiException WebbatiException
	 */
	void save(List<IT> pListObjects) throws WebbatiException;

	/**
	 * Supprime la liste des objets pListObjects.
	 * 
	 * @param pListObjects Liste des objets à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(List<IT> pListObjects) throws WebbatiException;

	/**
	 * Supprime tous les objets
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void deleteAll() throws WebbatiException;

}