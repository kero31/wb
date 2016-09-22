/***********************************************************************
 * Module: IContactManager.java Author: Kero Purpose: Defines the Interface IContactManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IContact;
import batifree.api.metier.interfaces.IDetailCnt;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IContactManager</b><br/>
 * 
 * @param <IT> IContact
 */
public interface IContactManager<IT extends IContact> extends IManager<IT, Integer> {

	/**
	 * Retourne la liste des détail contact.
	 * 
	 * @param pContact Contact
	 * @return liste des détail contact.
	 * @throws BatifreeException BatifreeException
	 */
	List<IDetailCnt> getListDetailContact(IContact pContact) throws BatifreeException;

}