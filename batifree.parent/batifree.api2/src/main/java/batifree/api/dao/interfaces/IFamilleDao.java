/***********************************************************************
 * Module: IFamilleDao.java Author: Kero Purpose: Defines the Interface IFamilleDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFamille;

import common.api.dao.interfaces.ILigneDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IFamilleDao</b><br/>
 */
public interface IFamilleDao extends ILigneDao<IFamille, Integer, IFamille> {

	/**
	 * Retourne la liste des Bibliotheques.
	 * 
	 * @param pFamille Famille
	 * @return liste des Bibliotheques.
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws BatifreeException;
}