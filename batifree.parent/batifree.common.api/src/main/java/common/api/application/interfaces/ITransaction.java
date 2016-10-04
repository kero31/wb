/***********************************************************************
 * Module: ISession.java Author: Kero Purpose: Defines the Interface ISession
 ***********************************************************************/

package common.api.application.interfaces;

import common.api.exception.WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	void rollback() throws WebbatiException;

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void commit() throws WebbatiException;

	/**
	 * Ferme la transaction.
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void close() throws WebbatiException;

}