/***********************************************************************
 * Module: IGroupeCnt.java Author: Kero Purpose: Defines the Interface IGroupeCnt
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IGroupeCnt</b><br/>
 */
public interface IGroupeCnt extends IIdLibelle {

	/**
	 * Get List DetailContact
	 * 
	 * @return List DetailContact
	 * @throws BatifreeException BatifreeException
	 */
	List<IDiversCnt> getListDiversContact() throws BatifreeException;

}