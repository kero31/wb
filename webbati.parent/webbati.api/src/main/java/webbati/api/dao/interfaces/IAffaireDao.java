/***********************************************************************
 * Module: IAffaireDao.java Author: Kero Purpose: Defines the Interface IAffaireDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEtude;

/**
 * Interface <b>IAffaireDao</b><br/>
 * 
 * @param <IT> IAffaire
 */
public interface IAffaireDao<IT extends IAffaire> extends IDao<IT, Integer> {

	/**
	 * Retourne la liste des Echeanciers.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Echeanciers
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws WebbatiException;

	/**
	 * Retourne la liste des Etudes.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Etude
	 * @throws WebbatiException WebbatiException
	 */
	List<IEtude> getListEtude(IAffaire pAffaire) throws WebbatiException;

}