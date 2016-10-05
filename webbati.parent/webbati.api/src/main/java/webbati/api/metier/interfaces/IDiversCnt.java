/***********************************************************************
 * Module: IDiversCnt.java Author: Kero Purpose: Defines the Interface IDiversCnt
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IDiversCnt</b><br/>
 */
public interface IDiversCnt extends IContact {

	/**
	 * Get List GroupeContact
	 * 
	 * @return List GroupeContact
	 * @throws WebbatiException WebbatiException
	 */
	List<IGroupeCnt> getListGroupeContact() throws WebbatiException;

	/**
	 * Set List GroupeContact
	 * 
	 * @param pListGroupeCnt liste groupe contact
	 */
	void setListGroupeContact(List<IGroupeCnt> pListGroupeCnt);

}