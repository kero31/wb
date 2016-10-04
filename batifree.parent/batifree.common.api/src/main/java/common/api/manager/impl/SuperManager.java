/**
 * 
 */
package common.api.manager.impl;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.ITransaction;
import common.api.exception.WebbatiException;

/**
 * Classe <SuperManager>.
 * 
 */
public abstract class SuperManager {

	/**
	 * Retourne l'application courante.
	 * 
	 * @return l'application courante
	 */
	protected abstract IApplicationCommun getApplication() throws WebbatiException;

	/**
	 * Retourne la transaction.
	 * 
	 * @return la transaction
	 */
	private ITransaction getTransaction() throws WebbatiException {
		return getApplication().getUserService().getTransaction();
	}

	/**
	 * Ferme la transaction.
	 * 
	 * @throws WebbatiException
	 */
	protected void closeTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.close();
		}
	}

	/**
	 * Commence une transaction.
	 * 
	 * @throws WebbatiException
	 */
	protected void beginTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.beginTransaction();
		}
	}

	/**
	 * Fait un rollback.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	protected void rollbackTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.rollback();
		}
	}

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	protected void commitTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.commit();
		}
	}

}
