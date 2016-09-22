/**
 * 
 */
package common.api.dao.hibernate.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

import common.api.application.impl.UserServiceSessionImpl;
import common.api.application.interfaces.ITransaction;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.util.ServiceBeanFactory;

/**
 * Classe <UserServiceHibernateImpl>.
 * 
 * 
 */
public abstract class UserServiceHibernateImpl extends UserServiceSessionImpl {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "TransactionHibernate")
	private TransactionHibernateImpl transaction;

	@Override
	public ITransaction getTransaction() throws BatifreeException {
		transaction.setSessionHibernate(getSessionHibernate());
		return transaction;
	}

	/**
	 * Retourne le hibernate util.
	 * 
	 * @return hibernate util
	 */
	public abstract HibernateUtil getHibernateUtil();

	/**
	 * Retourne la session Hibernate en fonction du l'user courant et du projet.
	 * 
	 * @return session Hibernate
	 * @throws BatifreeException
	 */
	public Session getSessionHibernate() throws BatifreeException {
		Session session = null;
		HibernateUtil util = null;
		try {
			if (isSessionWeb()) {
				util = getHibernateUtil();
			} else {
				util = ServiceBeanFactory.getServiceBean(HibernateUtilSingleton.class);
			}

			util.setBdPasswordEncoded(isBdPasswordEncoded());
			session = util.currentSession(getUser());
			if (session == null) {
				throw new BatifreeUserException("Récupération de la session SPRING impossible");
			}
			if (!session.isOpen()) {
				throw new BatifreeUserException("Ouverture de la session impossible");
			}
		} catch (BatifreeUserException e) {
			throw new BatifreeException("Erreur sur la récupération de la session : " + e.getMessage());
		}

		return session;
	}

	@Override
	public void closeSessions() throws BatifreeException {
		// Ferme la session Hibernate
		Session sessionHibernate = getSessionHibernate();
		if (sessionHibernate != null) {
			try {
				sessionHibernate.disconnect();
				sessionHibernate.close();
			} catch (HibernateException e) {
				new BatifreeException("Erreur fermeture session hibernate", e);
			}
		}

		// Ferme la session du parent
		super.closeSessions();
	}

	/**
	 * Crée une connection à partir du session hibernate.
	 * 
	 * @return connection à partir du session hibernate
	 * @throws BatifreeException
	 */
	@Override
	public Connection getConnectionSQL() throws BatifreeException {
		SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor) getSessionHibernate().getSessionFactory();
		@SuppressWarnings("deprecation")
		ConnectionProvider connectionProvider = sessionFactory.getConnectionProvider();
		try {
			return connectionProvider.getConnection();
		} catch (SQLException e) {
			throw new BatifreeException("Erreur récup connection", e);
		}
	}

}
