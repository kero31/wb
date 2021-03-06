/***********************************************************************
 * Module: IMainOeuvreDao.java Author: Kero Purpose: Defines the Interface IMainOeuvreDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import webbati.api.metier.interfaces.IMainOeuvre;

/**
 * Interface <b>IMainOeuvreDao</b><br/>
 * 
 * @param <IT> IMainOeuvre
 */
public interface IMainOeuvreDao<IT extends IMainOeuvre> extends IBibliothequeDao<IT> {
}