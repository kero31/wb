/***********************************************************************
 * Module: IEcheancierReglementDao.java Author: Kero Purpose: Defines the Interface IEcheancierReglementDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import batifree.api.metier.ejb.EcheancierReglementId;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.dao.interfaces.IDao;

/**
 * Interface <b>IEcheancierReglementDao</b><br/>
 */
public interface IEcheancierReglementDao extends IDao<IEcheancierReglement, EcheancierReglementId> {
}