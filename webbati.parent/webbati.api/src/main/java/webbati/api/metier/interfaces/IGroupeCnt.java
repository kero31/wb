/***********************************************************************
 * Module: IGroupeCnt.java Author: Kero Purpose: Defines the Interface IGroupeCnt
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IGroupeCnt</b><br/>
 */
public interface IGroupeCnt extends IIdLibelle {

	/**
	 * Get List DetailContact
	 * 
	 * @return List DetailContact
	 * @throws WebbatiException WebbatiException
	 */
	List<IDiversCnt> getListDiversContact() throws WebbatiException;

}