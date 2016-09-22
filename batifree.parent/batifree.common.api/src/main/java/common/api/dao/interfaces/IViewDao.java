package common.api.dao.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	List<IT> getList(int pMaxResult, int pFirstResult) throws BatifreeException;

	/**
	 * Retourne le nombre d'enregistrement
	 * 
	 * @return nombre d'enregistrement
	 * @throws BatifreeException BatifreeException
	 */
	long getRowCount() throws BatifreeException;

	/**
	 * Ferme le dao
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void close() throws BatifreeException;

}