package common.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.lang.reflect.InvocationTargetException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import common.api.application.interfaces.IApplicationCommun;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.dao.interfaces.IViewDao;
import common.api.exception.BatifreeException;
import common.api.util.MyBeanUtils;

/**
 * Classe <GenericHibernateDaoImpl> comprenant toutes les classes génériques DAO.
 * 
 * @param <T> classe ejb
 * @param <TI> classe metier
 * @param <ITI> interface metier
 */
public abstract class HibernateViewDaoImpl<T, TI, ITI> implements IViewDao<ITI> {

	private final Class<T> persistentClass;
	private final Class<TI> persistentClassI;

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public HibernateViewDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		this.persistentClass = pClazz;
		this.persistentClassI = pClazzI;
	}

	/**
	 * Retourne l'application courante.
	 * 
	 * @return l'application courante
	 */
	protected abstract IApplicationCommun getApplication() throws BatifreeException;

	/**
	 * Retourne la session courante.
	 * 
	 * @return Session
	 * @throws BatifreeException
	 */
	protected Session getSession() throws BatifreeException {
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) getApplication().getUserService();
		return ush.getSessionHibernate();
	}

	/**
	 * Retourne la classe T.
	 * 
	 * @return la classe du T
	 */
	protected Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * Retourne la classe TI.
	 * 
	 * @return la classe du TI
	 */
	protected Class<TI> getPersistentClassI() {
		return persistentClassI;
	}

	/**
	 * Retourne une liste d'objets Metier <TMETIER> à partir d'une liste d'EJB "Collection<TEJB>".
	 * 
	 * @param pListEjb liste d'EJB
	 * @param pClazzMetier classe du Metier
	 * @param pInterfaceMetier interface Metier
	 * @param <TMETIER> Classe Metier
	 * @param <IMETIER> Interface Metier
	 * @param <TEJB> Classe Ejb
	 * @return liste d'objets Metier à partir d'une liste d'EJB
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	protected <TMETIER, IMETIER, TEJB> List<IMETIER> getListMetierFromListEjb(Collection<TEJB> pListEjb, Class<TMETIER> pClazzMetier,
	        Class<IMETIER> pInterfaceMetier) throws BatifreeException {
		if (pListEjb != null && pClazzMetier != null) {
			return ((List<IMETIER>) MyBeanUtils.getInstance().copyPropertiesEJBList(pClazzMetier, pListEjb));
		}
		return null;
	}

	/**
	 * Retourne un objet Metier <TMETIER> à partir d'un EJB <TEJB>.
	 * 
	 * @param pEjb objet à transformer
	 * @param pClazzMetier classe du Metier
	 * @param <TMETIER> Classe Metier
	 * @param <TEJB> Classe Ejb
	 * @return objet Metier à partir d'un EJB
	 * @throws BatifreeException
	 */
	protected <TMETIER, TEJB> TMETIER getMetierFromEjb(TEJB pEjb, Class<TMETIER> pClazzMetier) throws BatifreeException {
		if (pEjb != null) {
			try {
				TMETIER metier = pClazzMetier.newInstance();
				MyBeanUtils.getInstance().copyPropertiesEJB(metier, pEjb);

				return metier;
			} catch (HibernateException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
				throw new BatifreeException("Erreur getMetierFromEjb à cause de : ", e);
			}
		}
		return null;
	}

	/**
	 * Retourne un objet Metier <IMETIER> à partir d'un EJB <TEJB>.
	 * 
	 * @param pEjb objet à transformer
	 * @param pClazzMetier classe du Metier
	 * @param pInterfaceMetier interface du Metier
	 * @param <TMETIER> Classe Metier
	 * @param <IMETIER> Interface Metier
	 * @param <TEJB> Classe Ejb
	 * @return objet Metier à partir d'un EJB
	 * @throws BatifreeException
	 */
	protected <TMETIER, IMETIER, TEJB> IMETIER getMetierFromEjb(TEJB pEjb, Class<TMETIER> pClazzMetier, Class<IMETIER> pInterfaceMetier)
	        throws BatifreeException {
		if (pEjb != null) {
			try {
				// Récupère la class MetierImpl
				@SuppressWarnings("unchecked")
				Class<TMETIER> clazzMetier = (Class<TMETIER>) getClassMetierFromEjb(pEjb);
				if (clazzMetier == null) {
					clazzMetier = pClazzMetier;
				}

				// Crée une nouvelle instance
				@SuppressWarnings("unchecked")
				IMETIER metier = (IMETIER) clazzMetier.newInstance();

				// Copie les données de EJB vers METIER
				MyBeanUtils.getInstance().copyPropertiesEJB(metier, pEjb);

				return metier;
			} catch (InstantiationException | HibernateException | InvocationTargetException | IllegalAccessException e) {
				throw new BatifreeException("Erreur getMetierFromEjb à cause de : ", e);
			}
		}
		return null;
	}

	/**
	 * Retourne la class Metier <TMETIER> à partir d'un EJB <TEJB>.
	 * 
	 * @param pEjb objet à transformer
	 * @param <TEJB> Classe Ejb
	 * @return class Metier à partir d'un EJB
	 * @throws BatifreeException
	 */
	protected <TEJB> Class<?> getClassMetierFromEjb(TEJB pEjb) {
		return null;
	}

	/**
	 * Retourne un objet Metier à partir d'un EJB.
	 * 
	 * @param pEjb objet à transformer
	 * @return objet Metier à partir d'un EJB
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	protected ITI getMetierFromEjb(T pEjb) throws BatifreeException {
		return (ITI) getMetierFromEjb(pEjb, persistentClassI);
	}

	@Override
	public List<ITI> getList(int pMaxResult, int pFirstResult) throws BatifreeException {
		return getList(getCriteria(pMaxResult, pFirstResult));
	}

	/**
	 * Retourne criteria en fonction du max result et du first result.
	 * 
	 * @param pMaxResult max result
	 * @param pFirstResult first result
	 * @return criteria
	 * @throws BatifreeException
	 */
	protected Criteria getCriteria(int pMaxResult, int pFirstResult) throws BatifreeException {
		Criteria criteria = getCriteriaSession();
		if (pMaxResult > 0) {
			criteria.setMaxResults(pMaxResult);
		}
		if (pFirstResult > 0) {
			criteria.setFirstResult(pFirstResult);
		}

		return criteria;
	}

	/**
	 * Retourne le criteria de la session en prenant en compte l'ouverture de la session.
	 * 
	 * @return criteria de la session
	 * @throws BatifreeException
	 */
	protected Criteria getCriteriaSession() throws BatifreeException {
		return getCriteriaSession(persistentClass);
	}

	/**
	 * Retourne le criteria de l'entité de la classe de la session en prenant en compte l'ouverture de la session.
	 * 
	 * @param pClass entité de la classe
	 * @param <TEJB> Classe Ejb
	 * @return criteria de la session
	 * @throws BatifreeException
	 */
	protected <TEJB> Criteria getCriteriaSession(Class<TEJB> pClass) throws BatifreeException {
		return getCriteriaSession(pClass, null);
	}

	/**
	 * Retourne le criteria de l'entité de la classe de la session en prenant en compte l'ouverture de la session.
	 * 
	 * @param pClass entité de la classe
	 * @param pAlias alias
	 * @param <TEJB> Classe Ejb
	 * @return criteria de la session
	 * @throws BatifreeException
	 */
	protected <TEJB> Criteria getCriteriaSession(Class<TEJB> pClass, String pAlias) throws BatifreeException {
		try {
			Session sess = getSession();
			Criteria crit = null;
			if (pAlias != null && !pAlias.equals("")) {
				crit = sess.createCriteria(pClass, pAlias);
			} else {
				crit = sess.createCriteria(pClass);
			}

			if (crit == null) {
				throw new BatifreeException("Le criteria de la classe" + persistentClass.getSimpleName() + "est NULL");
			}
			return crit;
		} catch (BatifreeException e) {
			throw new BatifreeException("Erreur de récupération du criteria " + persistentClass.getSimpleName() + " à cause de : ", e);
		}
	}

	@Override
	public long getRowCount() throws BatifreeException {
		Criteria criteria = getCriteriaSession();
		if (criteria == null) {
			throw new BatifreeException("Le criteria en paramètre est NULL");
		}

		try {
			criteria.setProjection(Projections.rowCount());
			criteria.setMaxResults(5);
			Long result = (Long) criteria.uniqueResult();

			return result.longValue();
		} catch (HibernateException e) {
			throw new BatifreeException("Erreur de récupération du nombre d'enregistrement " + persistentClass.getSimpleName() + " à cause de : ", e);
		}
	}

	/**
	 * Retourne la liste des objets à partir d'un criteria.
	 * 
	 * @param pCriteria criteria permettant de filtrer
	 * @return liste des objets à partir d'un criteria
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	protected List<ITI> getList(Criteria pCriteria) throws BatifreeException {
		List<T> ts = getListEJB(pCriteria);
		if (ts != null && !ts.isEmpty()) {
			return (List<ITI>) getListMetierFromListEjb(ts, persistentClassI, persistentClassI);
		} else {
			return new ArrayList<ITI>();
		}
	}

	/**
	 * Retourne la liste des objets en EJB à partir d'un criteria.
	 * 
	 * @param pCriteria criteria permettant de filtrer
	 * @return liste des objets en EJB à partir d'un criteria
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getListEJB(Criteria pCriteria) throws BatifreeException {
		return (List<T>) getListEJBGeneric(pCriteria);
	}

	/**
	 * Retourne la liste des objets en EJB à partir d'un criteria.
	 * 
	 * @param pCriteria criteria permettant de filtrer
	 * @return liste des objets en EJB à partir d'un criteria
	 * @throws BatifreeException
	 */
	protected List<?> getListEJBGeneric(Criteria pCriteria) throws BatifreeException {
		if (pCriteria == null) {
			throw new BatifreeException("Le criteria en paramètre est NULL");
		}

		try {
			return pCriteria.list();
		} catch (HibernateException e) {
			throw new BatifreeException("Erreur de récupération des " + persistentClass.getSimpleName() + " à cause de : ", e);
		}
	}

	@Override
	public void close() throws BatifreeException {
		try {
			getSession().close();
		} catch (HibernateException e) {
			new BatifreeException("Erreur fermeture session hibernate", e);
		}
	}
}
