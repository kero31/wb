/***********************************************************************
 * Module: ISession.java Author: Kero Purpose: Defines the Interface ISession
 ***********************************************************************/

package common.api.application.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ITransaction</b><br/>
 */
public interface ITransaction {

	/** Commence une transaction. */
	void beginTransaction();

	/**
	 * Fait un rollback.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void rollback() throws BatifreeException;

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void commit() throws BatifreeException;

	/**
	 * Ferme la transaction.
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void close() throws BatifreeException;

}