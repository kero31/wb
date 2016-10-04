package common.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import common.api.metier.interfaces.IMetier;
import common.api.util.MyBeanUtils;

/**
 * 
 * Classe <b>HibernateDaoImpl</b> comprenant toutes les classes génériques DAO..
 * 
 * @param <T> Classe EJB
 * @param <TI> Classe métier implémentation
 * @param <ITI> Interface métier implémentation
 * @param <ID> Classe ID
 */
public abstract class HibernateDaoImpl<T, TI extends MetierImpl<ID>, ITI extends IMetier<ID>, ID extends Serializable> extends
        HibernateViewDaoImpl<T, TI, ITI> implements IDao<ITI, ID> {

	private static final Logger LOGGER = Logger.getLogger(HibernateDaoImpl.class);

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public HibernateDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	/**
	 * Retourne un EJB à partir d'un objet Metier.
	 * 
	 * @param pMetier objet à transformer
	 * @return EJB à partir d'un objet Metier
	 * @param <ITIE> IMetier
	 * @throws WebbatiException
	 */
	protected <ITIE extends IMetier<ID>> T getEjbFromMetier(ITIE pMetier) throws WebbatiException {
		if (pMetier != null && pMetier.getId() != null) {

			// Récupère les infos d'hibernate dans l'EJB à partir de l'ID
			@SuppressWarnings("unchecked")
			T ejb = (T) getSession().get(getPersistentClass(), pMetier.getId());

			return ejb;
		}
		return null;
	}

	/**
	 * Permet de vérifier si l'objet métier est un nouveau.
	 * 
	 * @param pMetier objet métier
	 * @return TRUE si l'objet métier est un nouveau, FALSE sinon
	 * @throws WebbatiException
	 */
	protected boolean isMetierNew(ITI pMetier) throws WebbatiException {
		if (pMetier != null) {
			return pMetier.getId() == null;
		}
		return false;
	}

	/**
	 * Retourne un EJB mis à jour d'un Metier à partir d'un objet Metier.
	 * 
	 * @param pMetier objet à transformer
	 * @return EJB à partir d'un objet Metier
	 * @throws WebbatiException
	 */
	@SuppressWarnings("unchecked")
	protected T getEjbUpdatedFromMetier(ITI pMetier) throws WebbatiException {
		if (pMetier != null) {

			try {
				T ejb = null;

				// Crée un EJB si l'objet métier est un nouveau
				if (isMetierNew(pMetier)) {
					ejb = getPersistentClass().newInstance();
				} else {
					// Récupère les infos d'hibernate dans l'EJB à partir de l'ID
					ejb = (T) getSession().get(getPersistentClass(), pMetier.getId());
				}

				// Si l'objet correspondant à l'ID métier est NULL, alors c'est un nouveau
				if (ejb == null) {
					ejb = getPersistentClass().newInstance();
				}

				// Copie toutes les propriétés du métier vers l'EJB
				MyBeanUtils.getInstance().copyPropertiesEJB(ejb, pMetier);

				return ejb;
			} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
				throw new WebbatiException("Erreur getEjbUpdatedFromMetier à cause de : ", e);
			}
		}
		return null;
	}

	/**
	 * Retourne un nouvel EJB à partir d'un objet Metier.
	 * 
	 * @param pMetier objet à transformer
	 * @param pEjbClass Classe EJB
	 * @param <IMETIER> Metier
	 * @param <TEJB> Ejb
	 * @return EJB à partir d'un objet Metier
	 * @throws WebbatiException
	 */
	public static <IMETIER extends IMetier<?>, TEJB> TEJB getEjbNewFromMetier(IMETIER pMetier, Class<TEJB> pEjbClass) throws WebbatiException {
		if (pMetier != null) {
			try {
				TEJB ejb = pEjbClass.newInstance();
				MyBeanUtils.getInstance().copyPropertiesEJB(ejb, pMetier);

				return ejb;
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				throw new WebbatiException("Erreur getEjbFromMetier à cause de : ", e);
			}
		}
		return null;
	}

	/**
	 * Met à jour l'objet métier avec les infos de l'objet EJB.
	 * 
	 * @param pMetierToUpdate objet métier à mettre à jour
	 * @param pEjb ejb source
	 * @param <IMETIER> Metier
	 * @param <TEJB> Ejb
	 */
	public static <IMETIER extends IMetier<?>, TEJB> void updateMetierFromEjb(IMETIER pMetierToUpdate, TEJB pEjb) throws WebbatiException {
		if (pMetierToUpdate != null && pEjb != null) {
			try {
				MyBeanUtils.getInstance().copyPropertiesEJB(pMetierToUpdate, pEjb);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new WebbatiException("Erreur updateMetierFromEjb à cause de : ", e);
			}
		}
	}

	/**
	 * Met à jour (ajoute ou supprime) une liste d'EJB à partir d'une liste d'objet Metier.
	 * 
	 * @param pMetierList liste d'objets à transformer
	 * @param pEjbMap map <id, ejb> de la liste des ejb
	 * @param pEjbList list des ejb
	 * @param pEjbClass Classe EJB
	 * @param <IMETIER> Metier
	 * @param <TEJB> Ejb
	 * @throws WebbatiException
	 */
	protected <IMETIER extends IMetier<?>, TEJB> void updateEjbListFromMetier(List<IMETIER> pMetierList, Map<Serializable, TEJB> pEjbMap,
	        Set<TEJB> pEjbList, Class<TEJB> pEjbClass) throws WebbatiException {

		try {
			List<IMETIER> listMetier = new ArrayList<>();
			if (pMetierList != null) {
				listMetier.addAll(pMetierList);
			}

			// Add
			Set<TEJB> listEjbToAdd = new HashSet<>();
			for (IMETIER metier : listMetier) {
				boolean bFindInEjbList = false;
				for (Serializable ejbId : pEjbMap.keySet()) {
					if (ejbId.equals(metier.getId())) {
						bFindInEjbList = true;
					}
				}
				if (!bFindInEjbList) {
					listEjbToAdd.add(getEjbNewFromMetier(metier, pEjbClass));
				}
			}
			pEjbList.addAll(listEjbToAdd);

			// Remove
			Set<TEJB> listEjbToDelete = new HashSet<>();
			for (Entry<Serializable, TEJB> ejbEntry : pEjbMap.entrySet()) {
				Serializable ejbId = ejbEntry.getKey();
				TEJB ejb = ejbEntry.getValue();
				boolean bFindInMetierList = false;
				for (IMETIER role : listMetier) {
					if (ejbId == role.getId()) {
						bFindInMetierList = true;
					}
				}
				if (!bFindInMetierList) {
					listEjbToDelete.add(ejb);
				}
			}
			pEjbList.removeAll(listEjbToDelete);

		} catch (WebbatiException e) {
			throw new WebbatiException("Erreur getEjbListNewFromMetier à cause de : ", e);
		}
	}

	@Override
	public ITI getById(ID pId) throws WebbatiException {
		ITI objectEJBI = null;
		if (pId != null) {
			try {
				Session session = getSession();
				@SuppressWarnings("unchecked")
				T ejb = (T) session.get(getPersistentClass(), pId);
				if (ejb == null) {
					LOGGER.info("Le " + getPersistentClass().getSimpleName() + " avec l'id=" + pId.toString() + " est introuvable");
				} else {
					objectEJBI = getMetierFromEjb(ejb);
				}
			} catch (HibernateException e) {
				throw new WebbatiException("Erreur de récupération du " + getPersistentClass().getSimpleName() + " avec l'id " + pId
				        + " à cause de : ", e);
			}
		}

		return objectEJBI;
	}

	/**
	 * Retourne un objet par rapport à son ID
	 * 
	 * @param pId Id de l'objet
	 * @param pEjbClass classe ejb
	 * @param pClazzMetier classe métier de l'objet de retour
	 * @param <TMETIER> classe metier
	 * @param <IDD> classe id
	 * @param <TEJB> classe ejb
	 * @return Objet par rapport à son ID
	 * @throws WebbatiException
	 */
	protected <TMETIER, IDD extends Serializable, TEJB> TMETIER getByIdGeneric(IDD pId, Class<TEJB> pEjbClass, Class<TMETIER> pClazzMetier)
	        throws WebbatiException {
		TMETIER objectEJBI = null;
		if (pId != null && pEjbClass != null) {
			try {
				Session session = getSession();
				@SuppressWarnings("unchecked")
				T ejb = (T) session.get(pEjbClass, pId);
				if (ejb == null) {
					LOGGER.info("Le " + pEjbClass.getSimpleName() + " avec l'id=" + pId.toString() + " est introuvable");
				} else {
					objectEJBI = getMetierFromEjb(ejb, pClazzMetier);
				}
			} catch (HibernateException e) {
				throw new WebbatiException("Erreur de récupération du " + getPersistentClass().getSimpleName() + " avec l'id " + pId
				        + " à cause de : ", e);
			}
		}

		return objectEJBI;
	}

	/**
	 * Action faite après un save de l'objet métier.
	 * 
	 * @param pMetierToSave objet métier
	 * @param pEjbSaved ejb sauvé
	 */
	protected void actionAfterSave(ITI pMetierToSave, T pEjbSaved) throws WebbatiException {

	}

	@Override
	public ITI save(ITI pMetier) throws WebbatiException {
		ITI ejbIReturn = null;
		if (pMetier != null) {
			T ejb = null;

			// Récup de l'ejb
			ejb = getEjbUpdatedFromMetier(pMetier);

			try {
				// save or update
				saveOrUpdateEjb(ejb);

				// Action faite après le save
				actionAfterSave(pMetier, ejb);
			} catch (HibernateException e) {
				throw new WebbatiException("Enregistrement du " + getPersistentClass().getSimpleName() + " échoué à cause de : ", e);
			}

			// Récup de l'ejbI
			ejbIReturn = getMetierFromEjb(ejb);
		}

		return ejbIReturn;
	}

	/**
	 * Fait la sauvegarde de l'objet EJB.
	 * 
	 * @param pEjb objet EJB
	 * @throws WebbatiException
	 */
	protected void saveOrUpdateEjb(Object pEjb) throws WebbatiException {
		getSession().saveOrUpdate(pEjb);
	}

	@Override
	public void delete(ID pId) throws WebbatiException {
		deleteGeneric(pId, getPersistentClass());
	}

	/**
	 * Supprime un objet à partir de son IDD
	 * 
	 * @param pId IDD
	 * @param pClazzEjb classe ejb
	 * @param <IDD> classe id
	 * @param <TEJB> classe ejb
	 * @throws WebbatiException
	 */
	public <TEJB, IDD extends Serializable> void deleteGeneric(IDD pId, Class<TEJB> pClazzEjb) throws WebbatiException {
		if (pId != null) {
			try {
				Session session = getSession();
				@SuppressWarnings("unchecked")
				T objectEJB = (T) session.get(pClazzEjb, pId);
				if (objectEJB != null) {
					session.delete(objectEJB);
				}
			} catch (HibernateException e) {
				throw new WebbatiException(
				        "Suppression du " + getPersistentClass().getSimpleName() + " avec l'id=" + pId + " échoué à cause de : ", e);
			}
		}
	}

	@Override
	public void delete(ITI pMetier) throws WebbatiException {
		if (pMetier != null) {
			delete(pMetier.getId());
		}
	}

	@Override
	public <IMETIER extends IMetier<IDD>, IDD extends Serializable> void deleteMetierFromNewListMetier(List<IMETIER> pListActual,
	        List<IMETIER> pListNew, IDao<IMETIER, IDD> pDao) throws WebbatiException {
		if (pListActual != null && pListNew != null) {
			for (IMETIER actual : pListActual) {
				boolean bActualFindInNewMetier = pListNew.contains(actual);

				// Si l'objet actual n'a pas été trouvé dans la nouvelle liste, alors il faut le supprimer
				if (!bActualFindInNewMetier) {
					pDao.delete(actual);
				}
			}
		}
	}
}
