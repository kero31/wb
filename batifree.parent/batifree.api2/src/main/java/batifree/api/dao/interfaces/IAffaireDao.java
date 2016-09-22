/***********************************************************************
 * Module: IAffaireDao.java Author: Kero Purpose: Defines the Interface IAffaireDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws BatifreeException;

	/**
	 * Retourne la liste des Etudes.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Etude
	 * @throws BatifreeException BatifreeException
	 */
	List<IEtude> getListEtude(IAffaire pAffaire) throws BatifreeException;

}