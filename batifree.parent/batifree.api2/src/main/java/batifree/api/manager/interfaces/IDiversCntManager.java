/***********************************************************************
 * Module: IDiversCntManager.java Author: Kero Purpose: Defines the Interface IDiversCntManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IDiversCntManager</b><br/>
 */
public interface IDiversCntManager extends IContactManager<IDiversCnt> {

	/**
	 * Retourne la liste des groupes contact.
	 * 
	 * @param pDiversCnt Divers Contact
	 * @return liste des groupes contact.
	 * @throws BatifreeException BatifreeException
	 */
	List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws BatifreeException;

}