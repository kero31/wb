/***********************************************************************
 * Module: IGroupeCntManager.java Author: Kero Purpose: Defines the Interface IGroupeCntManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Interface <b>IGroupeCntManager</b><br/>
 */
public interface IGroupeCntManager extends IManager<IGroupeCnt, Integer> {

	/**
	 * Retourne la liste des Detail Contact.
	 * 
	 * @param pGroupeCnt Groupe Contact
	 * @return liste des Detail Contact.
	 * @throws WebbatiException WebbatiException
	 */
	List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws WebbatiException;

}