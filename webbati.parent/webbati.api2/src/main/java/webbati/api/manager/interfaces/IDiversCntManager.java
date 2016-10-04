/***********************************************************************
 * Module: IDiversCntManager.java Author: Kero Purpose: Defines the Interface IDiversCntManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Interface <b>IDiversCntManager</b><br/>
 */
public interface IDiversCntManager extends IContactManager<IDiversCnt> {

	/**
	 * Retourne la liste des groupes contact.
	 * 
	 * @param pDiversCnt Divers Contact
	 * @return liste des groupes contact.
	 * @throws WebbatiException WebbatiException
	 */
	List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws WebbatiException;

}