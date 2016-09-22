/***********************************************************************
 * Module: IEcheancierReglement.java Author: Kero Purpose: Defines the Interface IEcheancierReglement
 ***********************************************************************/

package batifree.api.metier.interfaces;

import batifree.api.metier.ejb.EcheancierReglementId;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

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
	 * @throws BatifreeException BatifreeException
	 */
	IEcheancier getEcheancier() throws BatifreeException;

	/**
	 * Set Echeancier
	 * 
	 * @param pEcheancier Echeancier
	 * @throws BatifreeException BatifreeException
	 */
	void setEcheancier(IEcheancier pEcheancier) throws BatifreeException;

	/**
	 * Get Reglement
	 * 
	 * @return Reglement
	 * @throws BatifreeException BatifreeException
	 */
	IReglement getReglement() throws BatifreeException;

	/**
	 * Set Reglement
	 * 
	 * @param pReglement Reglement
	 * @throws BatifreeException BatifreeException
	 */
	void setReglement(IReglement pReglement) throws BatifreeException;

}