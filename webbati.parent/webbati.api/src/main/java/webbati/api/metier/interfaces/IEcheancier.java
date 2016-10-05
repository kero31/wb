/***********************************************************************
 * Module: IEcheancier.java Author: Kero Purpose: Defines the Interface IEcheancier
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IEcheancier</b><br/>
 */
public interface IEcheancier extends IMetier<Integer> {

	/**
	 * Get List Echeancier Reglement
	 * 
	 * @return List Echeancier Reglement
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancierReglement> getListEcheancierReglement() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IAffaire getAffaire() throws WebbatiException;

	/**
	 * Get clone Echeancier
	 * 
	 * @param pAffaire Affaire Destination
	 * @return Clone Echeancier
	 * @throws WebbatiException WebbatiException
	 */
	IEcheancier getClone(IAffaire pAffaire) throws WebbatiException;

}