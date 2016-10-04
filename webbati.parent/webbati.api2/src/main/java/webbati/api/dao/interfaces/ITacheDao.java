/***********************************************************************
 * Module: ITacheDao.java Author: Kero Purpose: Defines the Interface ITacheDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import webbati.api.metier.interfaces.ITache;

/**
 * Interface <b>ITacheDao</b><br/>
 * 
 * @param <IT> ITache
 */
public interface ITacheDao<IT extends ITache> extends IBibliothequeDao<IT> {
}