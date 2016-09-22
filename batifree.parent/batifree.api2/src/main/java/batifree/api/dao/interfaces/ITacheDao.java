/***********************************************************************
 * Module: ITacheDao.java Author: Kero Purpose: Defines the Interface ITacheDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import batifree.api.metier.interfaces.ITache;

/**
 * Interface <b>ITacheDao</b><br/>
 * 
 * @param <IT> ITache
 */
public interface ITacheDao<IT extends ITache> extends IBibliothequeDao<IT> {
}