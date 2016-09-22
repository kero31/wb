/***********************************************************************
 * Module: IEtudeDao.java Author: Kero Purpose: Defines the Interface IEtudeDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IEtudeDao</b><br/>
 */
public interface IEtudeDao extends IDao<IEtude, Integer> {

	/**
	 * Retourne la liste des bibliothèques de l'étude.
	 * 
	 * @param pEtude Etude
	 * @return @return Liste des bibliothèques de l'étude.
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws BatifreeException;

}