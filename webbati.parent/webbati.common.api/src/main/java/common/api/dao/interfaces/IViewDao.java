package common.api.dao.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IViewDao</b><br/>
 * 
 * @param <IT>
 */
public interface IViewDao<IT> {

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
	 * Ferme le dao
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void close() throws WebbatiException;

}