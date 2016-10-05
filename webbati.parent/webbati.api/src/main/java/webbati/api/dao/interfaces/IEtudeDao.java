/***********************************************************************
 * Module: IEtudeDao.java Author: Kero Purpose: Defines the Interface IEtudeDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IEtude;

/**
 * Interface <b>IEtudeDao</b><br/>
 */
public interface IEtudeDao extends IDao<IEtude, Integer> {

	/**
	 * Retourne la liste des bibliothèques de l'étude.
	 * 
	 * @param pEtude Etude
	 * @return @return Liste des bibliothèques de l'étude.
	 * @throws WebbatiException WebbatiException
	 */
	List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws WebbatiException;

}