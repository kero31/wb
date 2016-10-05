/***********************************************************************
 * Module: IFournisseurMateriauxDao.java Author: Kero Purpose: Defines the Interface IFournisseurMateriauxDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import common.api.dao.interfaces.IDao;
import webbati.api.metier.ejb.FournisseurMateriauxId;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Interface <b>IFournisseurMateriauxDao</b><br/>
 */
public interface IFournisseurMateriauxDao extends IDao<IFournisseurMateriaux, FournisseurMateriauxId> {
}