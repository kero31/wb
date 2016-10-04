/***********************************************************************
 * Module: IEcheancierReglementDao.java Author: Kero Purpose: Defines the Interface IEcheancierReglementDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import common.api.dao.interfaces.IDao;
import webbati.api.metier.ejb.EcheancierReglementId;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Interface <b>IEcheancierReglementDao</b><br/>
 */
public interface IEcheancierReglementDao extends IDao<IEcheancierReglement, EcheancierReglementId> {
}