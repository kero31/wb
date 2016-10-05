package common.api.dao.hibernate.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.api.exception.WebbatiException;
import common.api.util.QueryUtil;

/**
 * 
 * Classe/Interface <b>QueryHibernateUtil</b><br/>
 *
 */
public class QueryHibernateUtil extends QueryUtil {

	/** Le UserServiceHibernate. */
	private UserServiceHibernateImpl userService;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pUserService User Service
	 * @throws WebbatiException
	 */
	public QueryHibernateUtil(UserServiceHibernateImpl pUserService) throws WebbatiException {
		userService = pUserService;

		// Génére une exception si le userService est NULL
		if (userService == null) {
			throw new WebbatiException("Le userService est NULL.");
		}
	}

	/**
	 * Retourne la session
	 * 
	 * @return session
	 * @throws WebbatiException
	 */
	private Session getSession() throws WebbatiException {
		Session sess = userService.getSessionHibernate();

		// Génére une exception si la session hibernate est NULL
		if (sess == null) {
			throw new WebbatiException("La session hibernate est NULL.");
		}

		return sess;
	}

	/**
	 * Exécute une requête SQL de type Class<T> en renvoyant une liste de données
	 * 
	 * @param <T> classe
	 * @param pQuery requête SQL
	 * @param pClazz classe de retour
	 * @return liste de données
	 * @throws WebbatiException
	 */
	public <T> List<T> executeQuery(String pQuery, Class<T> pClazz) throws WebbatiException {
		try {
			Query que = getSession().createSQLQuery(pQuery).addEntity(pClazz);
			@SuppressWarnings("unchecked")
			List<T> list = que.list();
			// return que.list();
			return list;
		} catch (HibernateException | WebbatiException e) {
			throw new WebbatiException("Erreur executeQuery", e);
		}
	}

	/**
	 * Exécute une requête SQL en renvoyant une liste de données
	 * 
	 * @param pQuery requête SQL
	 * @return liste de données
	 * @throws WebbatiException
	 */
	public List<?> executeQuery(String pQuery) throws WebbatiException {
		try {
			Query que = getSession().createSQLQuery(pQuery);
			return que.list();
		} catch (HibernateException | WebbatiException e) {
			throw new WebbatiException("Erreur executeQuery", e);
		}
	}

	/**
	 * Exécute une requête SQL de type UPDATE
	 * 
	 * @param pQuery requête SQL
	 * @return The number of entities updated or deleted.
	 * @throws WebbatiException
	 */
	public int executeUpdateQuery(String pQuery) throws WebbatiException {
		Session session = getSession();
		if (session == null) {
			throw new WebbatiException("Session ne peut pas être vide");
		}

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Query que = session.createSQLQuery(pQuery);
			int nbRes = que.executeUpdate();
			transaction.commit();

			return nbRes;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new WebbatiException("Erreur executeUpdateQuery", e);
		}
	}

	/**
	 * Exécute une requête SQL en renvoyant une donnée unique
	 * 
	 * @param pQuery requête SQL
	 * @return donnée unique
	 * @throws WebbatiException
	 */
	public Object executeQueryUniqueResult(String pQuery) throws WebbatiException {
		try {
			Query que = getSession().createSQLQuery(pQuery);
			return que.uniqueResult();
		} catch (HibernateException | WebbatiException e) {
			throw new WebbatiException("Erreur executeQueryUniqueResult", e);
		}
	}

	/**
	 * Exécute une requête SQL en renvoyant une donnée unique de type Class<T>
	 * 
	 * @param pQuery requête SQL
	 * @param pClazz classe de retour
	 * @param <T> classe
	 * @return donnée unique
	 * @throws WebbatiException
	 */
	@SuppressWarnings("unchecked")
	public <T> T executeQueryUniqueResult(String pQuery, Class<T> pClazz) throws WebbatiException {
		Query que = getSession().createSQLQuery(pQuery);
		return (T) que.uniqueResult();
	}

}
