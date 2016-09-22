/***********************************************************************
 * Module: IGroupeCntManager.java Author: Kero Purpose: Defines the Interface IGroupeCntManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IGroupeCntManager</b><br/>
 */
public interface IGroupeCntManager extends IManager<IGroupeCnt, Integer> {

	/**
	 * Retourne la liste des Detail Contact.
	 * 
	 * @param pGroupeCnt Groupe Contact
	 * @return liste des Detail Contact.
	 * @throws BatifreeException BatifreeException
	 */
	List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws BatifreeException;

}