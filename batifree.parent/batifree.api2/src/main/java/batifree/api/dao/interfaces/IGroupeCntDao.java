/***********************************************************************
 * Module: IGroupeCntDao.java Author: Kero Purpose: Defines the Interface IGroupeCntDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IGroupeCntDao</b><br/>
 */
public interface IGroupeCntDao extends IDao<IGroupeCnt, Integer> {

	/**
	 * Retourne la liste des Detail Contact.
	 * 
	 * @param pGroupeCnt Groupe Contact
	 * @return liste des Detail Contact.
	 * @throws BatifreeException BatifreeException
	 */
	List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws BatifreeException;

}