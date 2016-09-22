/**
 * 
 */
package common.api.manager.impl;

import java.util.Collections;
import java.util.List;

import java.io.Serializable;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IViewManager;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe <ViewManagerImpl>.
 * 
 * @author Kero
 * 
 * @param <IT>
 * @param <ID>
 */
public abstract class ViewManagerImpl<IT extends IMetier<ID>, ID extends Serializable> extends SuperManager implements IViewManager<IT, ID> {

	/**
	 * Nombre max de lignes max renvoyés par la recherche pour des questions de performances.
	 */
	public static final int NB_ROW_MAX = 1000;

	/**
	 * Nombre max de lignes renvoyés par la recherche.
	 */
	public static final int NB_ROW_DEFAULT = 20;

	/**
	 * Retourne le mainDao. UTILISEZ plutôt le getDao().
	 * 
	 * @return le mainDao
	 */
	protected abstract IDao<IT, ID> getMainDao();

	/**
	 * Retourne le mainDao en gérant l'exception si le mainDao est NULL.
	 * 
	 * @return le mainDao
	 */
	protected IDao<IT, ID> getDao() throws BatifreeException {
		IDao<IT, ID> dao = getMainDao();
		if (dao == null) {
			throw new BatifreeException("Le main DAO est NULL !");
		}

		return dao;
	}

	@Override
	public IT getById(ID pId) throws BatifreeException {
		try {
			return getDao().getById(pId);
		} catch (BatifreeException e) {
			throw new BatifreeException("Erreur récupération de l'objet avec l'id " + pId.toString() + " échoué à cause de : ", e);
		}
	}

	/**
	 * Retrourne le nombre max de ligne retournée.
	 * 
	 * @return nombre max de ligne retournée
	 */
	protected int getNbRowMax() {
		return NB_ROW_MAX;
	}

	@Override
	public List<IT> getList() throws BatifreeException {
		return getList(NB_ROW_DEFAULT, 0);
	}

	@Override
	public List<IT> getList(int pMaxResult) throws BatifreeException {
		return getList(pMaxResult, 0);
	}

	@Override
	public List<IT> getList(int pMaxResult, int pFirstResult) throws BatifreeException {
		int maxResult = pMaxResult;
		try {

			// Si le nombre de lignes demandé est supérieur au max, on force la limite du nombre de lignes retournés au max
			if (pMaxResult > getNbRowMax()) {
				maxResult = getNbRowMax();
			}

			return getDao().getList(maxResult, pFirstResult);
		} catch (BatifreeException e) {
			throw new BatifreeException("Erreur récupération de la liste des objets avec comme paramètres pMaxResult=" + pMaxResult
			        + ", maxResultNew=" + maxResult + " et pFirstResult=" + pFirstResult, e);
		}
	}

	@Override
	public long getRowCount() throws BatifreeException {
		try {
			return getDao().getRowCount();
		} catch (BatifreeException e) {
			throw new BatifreeException("Erreur récupération du nombre d'objets", e);
		}
	}

	/**
	 * Retourne une liste formattée (= non nulle) à partir de cette même liste.
	 * 
	 * @param pList liste à formatter
	 * @param <T> Classe
	 * @return liste formattée
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> getListFormattedFromList(List<T> pList) {
		return ((List<T>) ((pList == null) ? Collections.emptyList() : pList));
	}
}
