/***********************************************************************
 * Module: IEnginDao.java Author: Kero Purpose: Defines the Interface IEnginDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import batifree.api.metier.interfaces.IEngin;

/**
 * Interface <b>IEnginDao</b><br/>
 * 
 * @param <IT> IEngin
 */
public interface IEnginDao<IT extends IEngin> extends IBibliothequeDao<IT> {
}