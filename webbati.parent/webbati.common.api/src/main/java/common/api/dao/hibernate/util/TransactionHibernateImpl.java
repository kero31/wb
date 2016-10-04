/**
 * 
 */
package common.api.dao.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import common.api.application.interfaces.ITransaction;
import common.api.exception.WebbatiException;

/**
 * Classe <TransactionHibernateImpl> qui permet de gérer les transactions pour hibernate.
 * 
 * 
 */
@Service("TransactionHibernate")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TransactionHibernateImpl implements ITransaction {

	/** La session hibernate. */
	private Session sessionHibernate = null;

	/** La transaction Hibernate. */
	private Transaction transactionHibernate = null;

	/** Nombre de transaction Hibernate demandé à démarrer. */
	private int nbTransactionAsked = 0;

	/**
	 * Retourne la sessionHibernate.
	 * 
	 * @return la sessionHibernate
	 */
	public Session getSessionHibernate() {
		return sessionHibernate;
	}

	/**
	 * Met à jour la sessionHibernate.
	 * 
	 * @param pSessionHibernate le sessionHibernate à mettre à jour
	 */
	public void setSessionHibernate(Session pSessionHibernate) {
		sessionHibernate = pSessionHibernate;
	}

	@Override
	public void beginTransaction() {
		if (sessionHibernate != null && nbTransactionAsked == 0) {
			transactionHibernate = sessionHibernate.beginTransaction();
		}
		nbTransactionAsked++;
	}

	@Override
	public void rollback() throws WebbatiException {
		try {
			if (nbTransactionAsked == 1 && sessionHibernate != null && transactionHibernate != null) {
				transactionHibernate.rollback();
			}
		} catch (HibernateException e) {
			throw new WebbatiException("Erreur rollback", e);
		}
	}

	@Override
	public void commit() throws WebbatiException {
		try {
			if (nbTransactionAsked == 1 && sessionHibernate != null && transactionHibernate != null) {
				transactionHibernate.commit();
			}
		} catch (HibernateException e) {
			throw new WebbatiException("Erreur commit", e);
		}
	}

	@Override
	public void close() throws WebbatiException {
		try {
			if (nbTransactionAsked <= 1 && sessionHibernate != null && sessionHibernate.isOpen()) {
				sessionHibernate.close();
				nbTransactionAsked = 1;
			}
		} catch (HibernateException e) {
			throw new WebbatiException("Erreur close", e);
		} finally {
			nbTransactionAsked--;
		}

	}
}
