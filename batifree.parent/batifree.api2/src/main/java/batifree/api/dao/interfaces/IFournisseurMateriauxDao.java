/***********************************************************************
 * Module: IFournisseurMateriauxDao.java Author: Kero Purpose: Defines the Interface IFournisseurMateriauxDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import batifree.api.metier.ejb.FournisseurMateriauxId;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.dao.interfaces.IDao;

/**
 * Interface <b>IFournisseurMateriauxDao</b><br/>
 */
public interface IFournisseurMateriauxDao extends IDao<IFournisseurMateriaux, FournisseurMateriauxId> {
}