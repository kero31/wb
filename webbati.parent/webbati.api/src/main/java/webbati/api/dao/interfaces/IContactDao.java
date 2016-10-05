/***********************************************************************
 * Module: IContactDao.java Author: Kero Purpose: Defines the Interface IContactDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IContact;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * Interface <b>IContactDao</b><br/>
 * 
 * @param <IT> IContact
 */
public interface IContactDao<IT extends IContact> extends IDao<IT, Integer> {

	/**
	 * Retourne la liste des détail contact.
	 * 
	 * @param pContact Contact
	 * @return liste des détail contact.
	 * @throws WebbatiException WebbatiException
	 */
	List<IDetailCnt> getListDetailContact(IContact pContact) throws WebbatiException;

}