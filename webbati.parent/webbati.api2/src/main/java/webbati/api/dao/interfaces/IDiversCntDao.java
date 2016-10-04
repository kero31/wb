/***********************************************************************
 * Module: IDiversCntDao.java Author: Kero Purpose: Defines the Interface IDiversCntDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Interface <b>IDiversCntDao</b><br/>
 */
public interface IDiversCntDao extends IContactDao<IDiversCnt> {

	/**
	 * Retourne la liste des groupes contact.
	 * 
	 * @param pDiversCnt Divers Contact
	 * @return liste des groupes contact.
	 * @throws WebbatiException WebbatiException
	 */
	List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws WebbatiException;

}