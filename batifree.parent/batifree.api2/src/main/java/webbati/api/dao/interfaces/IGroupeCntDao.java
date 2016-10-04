/***********************************************************************
 * Module: IGroupeCntDao.java Author: Kero Purpose: Defines the Interface IGroupeCntDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Interface <b>IGroupeCntDao</b><br/>
 */
public interface IGroupeCntDao extends IDao<IGroupeCnt, Integer> {

	/**
	 * Retourne la liste des Detail Contact.
	 * 
	 * @param pGroupeCnt Groupe Contact
	 * @return liste des Detail Contact.
	 * @throws WebbatiException WebbatiException
	 */
	List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws WebbatiException;

}