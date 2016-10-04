/***********************************************************************
 * Module: IFamilleDao.java Author: Kero Purpose: Defines the Interface IFamilleDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.ILigneDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IFamille;

/**
 * Interface <b>IFamilleDao</b><br/>
 */
public interface IFamilleDao extends ILigneDao<IFamille, Integer, IFamille> {

	/**
	 * Retourne la liste des Bibliotheques.
	 * 
	 * @param pFamille Famille
	 * @return liste des Bibliotheques.
	 * @throws WebbatiException WebbatiException
	 */
	List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws WebbatiException;
}