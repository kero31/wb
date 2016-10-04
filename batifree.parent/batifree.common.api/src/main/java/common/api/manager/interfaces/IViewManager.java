package common.api.manager.interfaces;

import java.util.List;

import java.io.Serializable;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IViewManager</b><br/>
 * 
 * @param <IT>
 * @param <ID> Serializable
 */
public interface IViewManager<IT, ID extends Serializable> {

	/**
	 * Retourne un objet par rapport à son ID.
	 * 
	 * @param pId Id de l'objet
	 * @return Objet par rapport à son ID
	 * @throws WebbatiException WebbatiException
	 */
	IT getById(ID pId) throws WebbatiException;

	/**
	 * Retourne une liste d'objets.
	 * 
	 * @return Liste d'objets
	 * @throws WebbatiException WebbatiException
	 */
	List<IT> getList() throws WebbatiException;

	/**
	 * Retourne les pMax premiers de la liste d'objets.
	 * 
	 * @param pMaxResult Nombre max de résultat à retourner
	 * @return pMax premiers de la liste d'objets
	 * @throws WebbatiException WebbatiException
	 */
	List<IT> getList(int pMaxResult) throws WebbatiException;

	/**
	 * Retourne les pMax premiers de la liste d'objets à partir de l'index pFirstResult
	 * 
	 * @param pMaxResult Nombre max de résultat à retourner
	 * @param pFirstResult Index du premier objet à récupérer
	 * @return pMax premiers de la liste d'objets à partir de l'index pFirstResult
	 * @throws WebbatiException WebbatiException
	 */
	List<IT> getList(int pMaxResult, int pFirstResult) throws WebbatiException;

	/**
	 * Retourne le nombre d'enregistrement
	 * 
	 * @return nombre d'enregistrement
	 * @throws WebbatiException WebbatiException
	 */
	long getRowCount() throws WebbatiException;

	/**
	 * Met à jour l'objet avec les nouvelles infos de la BD
	 * 
	 * @param pObject objet à mettre à jour
	 * @return objet mis à jour
	 * @throws WebbatiException WebbatiException
	 */
	IT refresh(IT pObject) throws WebbatiException;

}