/***********************************************************************
 * Module: IContactManager.java Author: Kero Purpose: Defines the Interface IContactManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import webbati.api.metier.interfaces.IContact;
import webbati.api.metier.interfaces.IDetailCnt;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<IDetailCnt> getListDetailContact(IContact pContact) throws WebbatiException;

}