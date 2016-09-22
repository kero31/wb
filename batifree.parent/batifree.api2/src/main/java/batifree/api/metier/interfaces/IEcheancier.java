/***********************************************************************
 * Module: IEcheancier.java Author: Kero Purpose: Defines the Interface IEcheancier
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IEcheancier</b><br/>
 */
public interface IEcheancier extends IMetier<Integer> {

	/**
	 * Get List Echeancier Reglement
	 * 
	 * @return List Echeancier Reglement
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement() throws BatifreeException;

	/**
	 * Set Affaire
	 * 
	 * @param pAffaire Affaire
	 */
	void setAffaire(IAffaire pAffaire);

	/**
	 * Get Affaire
	 * 
	 * @return Affaire
	 * @throws BatifreeException BatifreeException
	 */
	IAffaire getAffaire() throws BatifreeException;

	/**
	 * Get clone Echeancier
	 * 
	 * @param pAffaire Affaire Destination
	 * @return Clone Echeancier
	 * @throws BatifreeException BatifreeException
	 */
	IEcheancier getClone(IAffaire pAffaire) throws BatifreeException;

}