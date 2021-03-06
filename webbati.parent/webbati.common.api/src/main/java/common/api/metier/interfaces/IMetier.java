/***********************************************************************
 * Module: IMetier.java Author: Kero Purpose: Defines the Interface IMetier
 ***********************************************************************/

package common.api.metier.interfaces;

import java.io.Serializable;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IMetier</b><br/>
 * 
 * @param <ID> Serializable
 */
public interface IMetier<ID extends Serializable> extends Serializable {

	/**
	 * Get Id
	 * 
	 * @return Id
	 */
	ID getId();

	/**
	 * Get a new instance
	 * 
	 * @param <METIER> IMetier<ID>
	 * @return a new instance
	 * @throws WebbatiException WebbatiException
	 */
	<METIER extends IMetier<ID>> METIER getNewInstance() throws WebbatiException;

}