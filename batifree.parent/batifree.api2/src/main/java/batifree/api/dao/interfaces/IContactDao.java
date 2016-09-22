/***********************************************************************
 * Module: IContactDao.java Author: Kero Purpose: Defines the Interface IContactDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IContact;
import batifree.api.metier.interfaces.IDetailCnt;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	List<IDetailCnt> getListDetailContact(IContact pContact) throws BatifreeException;

}