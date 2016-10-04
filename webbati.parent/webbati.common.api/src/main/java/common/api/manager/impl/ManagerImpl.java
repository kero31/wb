/**
 * 
 */
package common.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe <ManagerImpl>.
 * 
 * @author Kero
 * 
 * @param <IT>
 * @param <ID>
 */
public abstract class ManagerImpl<IT extends IMetier<ID>, ID extends Serializable> extends ViewManagerImpl<IT, ID> implements IManager<IT, ID> {

	/**
	 * Met à jour l'objet pObject lors d'une création de cet objet.
	 * 
	 * @param pObject nouvel objet
	 */
	protected void updateDataForCreation(IT pObject) {

	}

	/**
	 * Met à jour l'objet pObject lors d'une mise à jour de cet objet.
	 * 
	 * @param pObject nouvel objet
	 */
	protected void updateDataForUpdating(IT pObject) {

	}

	/**
	 * Permet de vérifier si l'objet métier est un nouveau.
	 * 
	 * @param pObject objet métier
	 * @return TRUE si l'objet métier est un nouveau, FALSE sinon
	 * @throws WebbatiException
	 */
	protected boolean isNewObject(IMetier<ID> pObject) {
		if (pObject != null) {
			return pObject.getId() == null;
		}
		return false;
	}

	@Override
	public IT save(IT pObjectMetier) throws WebbatiException {
		if (pObjectMetier != null && checkDataCorrect(pObjectMetier)) {

			// Met à jour l'objet en fonction d'une création ou d'une modification
			// if (isNewObject(pObjectMetier)) {
			//
			// } else {
			//
			// }
			beginTransaction();
			IT ejb = null;
			try {
				ejb = getDao().save(pObjectMetier);

				commitTransaction();

				return ejb;
			} catch (WebbatiException e) {
				rollbackTransaction();
				throw new WebbatiException("Enregistrement du " + pObjectMetier.getClass().getSimpleName() + " échoué à cause de : ", e);
			} finally {
				closeTransaction();
			}
		}

		return null;
	}

	@Override
	public void save(List<IT> pListObjects) throws WebbatiException {
		if (pListObjects != null && pListObjects.size() > 0) {
			List<IT> listNewObject = new ArrayList<>();
			beginTransaction();

			try {
				for (IT object : pListObjects) {
					// Sauvegarde sans commiter la transaction car un beginTransaction
					// a été fait mais un commit/rollback n'a pas encore été fait
					listNewObject.add(save(object));
				}

				commitTransaction();
				pListObjects.clear();
				pListObjects.addAll(listNewObject);
			} catch (WebbatiException e) {
				rollbackTransaction();
				throw new WebbatiException("Enregistrement de la liste des objets échoué à cause de : ", e);
			} finally {
				closeTransaction();
			}
		}
	}

	@Override
	public void delete(ID pId) throws WebbatiException {
		if (pId != null) {
			try {
				beginTransaction();

				getDao().delete(pId);

				commitTransaction();
			} catch (WebbatiException e) {
				rollbackTransaction();
				throw new WebbatiException("Suppression de l'objet avec l'id=" + pId + " échoué à cause de : ", e);
			} finally {
				closeTransaction();
			}
		}
	}

	@Override
	public void delete(IT pMetier) throws WebbatiException {
		if (pMetier != null) {
			beginTransaction();
			try {
				getDao().delete(pMetier);

				commitTransaction();
			} catch (WebbatiException e) {
				rollbackTransaction();
				throw new WebbatiException("Suppression du " + pMetier.getClass().getSimpleName() + " avec l'id=" + pMetier.getId()
				        + " échoué à cause de : ", e);
			} finally {
				closeTransaction();
			}
		}
	}

	@Override
	public void delete(List<IT> pListObjects) throws WebbatiException {
		if (pListObjects != null && pListObjects.size() > 0) {
			beginTransaction();

			try {
				for (IT object : pListObjects) {
					// Supprime sans commiter la transaction car un beginTransaction
					// a été fait mais un commit/rollback n'a pas encore été fait
					delete(object);
				}

				commitTransaction();
			} catch (WebbatiException e) {
				rollbackTransaction();
				throw new WebbatiException("Suppression de la liste des objets échoué à cause de : ", e);
			} finally {
				closeTransaction();
			}
		}
	}

	/**
	 * Supprime tous les éléments de la liste actuelle qui ne font pas parti des éléments de la nouvelle liste.
	 * 
	 * @param pListActual liste actuelle
	 * @param pListNew nouvelle liste
	 * @param pDao dao
	 * @param <IMETIER> IMetier
	 * @param <IDD> Serializable
	 * @throws WebbatiException
	 */
	protected <IMETIER extends IMetier<IDD>, IDD extends Serializable> void deleteMetierFromNewListMetier(List<IMETIER> pListActual,
	        List<IMETIER> pListNew, IDao<IMETIER, IDD> pDao) throws WebbatiException {
		if (pListActual != null && pListNew != null) {
			getDao().deleteMetierFromNewListMetier(pListActual, pListNew, pDao);
		}
	}

	/**
	 * Vérifie si les données sont correctes.
	 * 
	 * @param pObjectI objet à vérifier
	 * @return TRUE si l'objet est correct, FALSE sinon
	 */
	protected boolean checkDataCorrect(IT pObjectI) {
		return true;
	}

	/**
	 * Retourne la validité de la donnée métier lors de l'appel pour la récupération d'une liste métier à partir de cette donnée métier.
	 * 
	 * @param pMetier donnée métier
	 * @param <ITI> IMetier
	 * @return TRUE si la donnée métier est valide, FALSE sinon
	 */
	private <ITI extends IMetier<ID>> boolean isIdValidForGetList(ITI pMetier) {
		return pMetier != null && pMetier.getId() != null;
	}

	/**
	 * Retourne une liste formattée à partir de l'objet métier et d'une liste retournée du dao.
	 * 
	 * @param pMetier objet métier
	 * @param pList liste retournée du dao
	 * @param <T> Metier ejb
	 * @param <ITI> IMetier
	 * @return liste formattée
	 */
	protected <T, ITI extends IMetier<ID>> List<T> getListDaoFromObject(ITI pMetier, List<T> pList) {
		if (isIdValidForGetList(pMetier)) {
			return getListFormattedFromList(pList);
		}
		return new ArrayList<>();
	}

	@Override
	public void deleteAll() throws WebbatiException {
		delete(getList(0));
	}

	@Override
	public IT refresh(IT pObject) throws WebbatiException {
		if (pObject != null) {
			return getById(pObject.getId());
		}
		return null;
	}

}
