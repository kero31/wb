package common.api.dao.interfaces;

import java.util.List;

import java.io.Serializable;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IDao</b><br/>
 * 
 * @param <IT> IMetier<ID>
 * @param <ID> Serializable
 */
public interface IDao<IT extends IMetier<ID>, ID extends Serializable> extends IViewDao<IT> {

	/**
	 * Retourne un objet par rapport à son ID
	 * 
	 * @param pId Id de l'objet
	 * @return Objet par rapport à son ID
	 * @throws WebbatiException WebbatiException
	 */
	IT getById(ID pId) throws WebbatiException;

	/**
	 * Crée ou met à jour l'objet pObjet, si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour
	 * 
	 * @param pMetier Objet métier à créer ou à mettre à jour
	 * @return Objet créé ou modifié
	 * @throws WebbatiException WebbatiException
	 */
	IT save(IT pMetier) throws WebbatiException;

	/**
	 * Supprime un objet à partir de son ID
	 * 
	 * @param pId Id de l'objet à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(ID pId) throws WebbatiException;

	/**
	 * Supprime l'objet pObjet
	 * 
	 * @param pMetier Objet métier à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(IT pMetier) throws WebbatiException;

	/**
	 * Supprime tous les éléments de la liste actuelle qui ne font pas parti des éléments de la nouvelle liste.
	 * 
	 * @param pListActual liste actuelle
	 * @param pListNew nouvelle liste
	 * @param pDao dao
	 * @param <IMETIER> IMetier<IDD>
	 * @param <IDD> Serializable
	 * @throws WebbatiException WebbatiException
	 */
	<IMETIER extends IMetier<IDD>, IDD extends Serializable> void deleteMetierFromNewListMetier(List<IMETIER> pListActual, List<IMETIER> pListNew,
	        IDao<IMETIER, IDD> pDao) throws WebbatiException;

}