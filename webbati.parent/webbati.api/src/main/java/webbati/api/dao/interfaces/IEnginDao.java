/***********************************************************************
 * Module: IEnginDao.java Author: Kero Purpose: Defines the Interface IEnginDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import webbati.api.metier.interfaces.IEngin;

/**
 * Interface <b>IEnginDao</b><br/>
 * 
 * @param <IT> IEngin
 */
public interface IEnginDao<IT extends IEngin> extends IBibliothequeDao<IT> {
}