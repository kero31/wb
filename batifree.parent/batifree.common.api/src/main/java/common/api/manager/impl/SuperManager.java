/**
 * 
 */
package common.api.manager.impl;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.ITransaction;
import common.api.exception.BatifreeException;

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
	protected abstract IApplicationCommun getApplication() throws BatifreeException;

	/**
	 * Retourne la transaction.
	 * 
	 * @return la transaction
	 */
	private ITransaction getTransaction() throws BatifreeException {
		return getApplication().getUserService().getTransaction();
	}

	/**
	 * Ferme la transaction.
	 * 
	 * @throws BatifreeException
	 */
	protected void closeTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.close();
		}
	}

	/**
	 * Commence une transaction.
	 * 
	 * @throws BatifreeException
	 */
	protected void beginTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.beginTransaction();
		}
	}

	/**
	 * Fait un rollback.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	protected void rollbackTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.rollback();
		}
	}

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	protected void commitTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.commit();
		}
	}

}
