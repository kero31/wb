/***********************************************************************
 * Module: IDiversCntDao.java Author: Kero Purpose: Defines the Interface IDiversCntDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IDiversCntDao</b><br/>
 */
public interface IDiversCntDao extends IContactDao<IDiversCnt> {

	/**
	 * Retourne la liste des groupes contact.
	 * 
	 * @param pDiversCnt Divers Contact
	 * @return liste des groupes contact.
	 * @throws BatifreeException BatifreeException
	 */
	List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws BatifreeException;

}