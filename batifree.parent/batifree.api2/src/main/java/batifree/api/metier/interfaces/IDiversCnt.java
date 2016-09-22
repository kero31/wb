/***********************************************************************
 * Module: IDiversCnt.java Author: Kero Purpose: Defines the Interface IDiversCnt
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IDiversCnt</b><br/>
 */
public interface IDiversCnt extends IContact {

	/**
	 * Get List GroupeContact
	 * 
	 * @return List GroupeContact
	 * @throws BatifreeException BatifreeException
	 */
	List<IGroupeCnt> getListGroupeContact() throws BatifreeException;

	/**
	 * Set List GroupeContact
	 * 
	 * @param pListGroupeCnt liste groupe contact
	 */
	void setListGroupeContact(List<IGroupeCnt> pListGroupeCnt);

}