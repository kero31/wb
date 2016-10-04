/***********************************************************************
 * Module: IEcheancierReglement.java Author: Kero Purpose: Defines the Interface IEcheancierReglement
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;
import webbati.api.metier.ejb.EcheancierReglementId;

/**
 * Interface <b>IEcheancierReglement</b><br/>
 */
public interface IEcheancierReglement extends IMetier<EcheancierReglementId> {

	/**
	 * Get Montant
	 * 
	 * @return Montant
	 */
	Float getMontant();

	/**
	 * Set Montant
	 * 
	 * @param pMontant Montant
	 */
	void setMontant(Float pMontant);

	/**
	 * Get Echeancier
	 * 
	 * @return Echeancier
	 * @throws WebbatiException WebbatiException
	 */
	IEcheancier getEcheancier() throws WebbatiException;

	/**
	 * Set Echeancier
	 * 
	 * @param pEcheancier Echeancier
	 * @throws WebbatiException WebbatiException
	 */
	void setEcheancier(IEcheancier pEcheancier) throws WebbatiException;

	/**
	 * Get Reglement
	 * 
	 * @return Reglement
	 * @throws WebbatiException WebbatiException
	 */
	IReglement getReglement() throws WebbatiException;

	/**
	 * Set Reglement
	 * 
	 * @param pReglement Reglement
	 * @throws WebbatiException WebbatiException
	 */
	void setReglement(IReglement pReglement) throws WebbatiException;

}