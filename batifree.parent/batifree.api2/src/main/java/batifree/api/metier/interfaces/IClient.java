/***********************************************************************
 * Module: IClient.java Author: Kero Purpose: Defines the Interface IClient
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IClient</b><br/>
 */
public interface IClient extends IContact {

	/**
	 * Get Prospect
	 * 
	 * @return TRUE si Prospect, FALSE sinon
	 */
	Boolean isProspect();

	/**
	 * Set Prospect
	 * 
	 * @param pProspect TRUE si Prospect, FALSE sinon
	 */
	void setProspect(Boolean pProspect);

	/**
	 * Get MontantPlafond
	 * 
	 * @return MontantPlafond
	 */
	Float getMontantPlafond();

	/**
	 * Set MontantPlafond
	 * 
	 * @param pMontantPlafond Montant Plafond
	 */
	void setMontantPlafond(Float pMontantPlafond);

	/**
	 * Retourne la liste des Coordonnees
	 * 
	 * @return List Coordonnee
	 * @throws BatifreeException BatifreeException
	 */
	List<ICoordonneeCnt> getListCoordonnee() throws BatifreeException;

	/**
	 * Retourne la liste des affaires
	 * 
	 * @return List Affaire
	 * @throws BatifreeException BatifreeException
	 */
	List<IAffaire> getListAffaire() throws BatifreeException;

	/**
	 * Retourne la liste des règlements
	 * 
	 * @return liste des règlements
	 * @throws BatifreeException BatifreeException
	 */
	List<IReglement> getListReglement() throws BatifreeException;

	/**
	 * Retourne la liste des échéanciers dûs
	 * 
	 * @return liste des échéanciers dûs
	 * @throws BatifreeException BatifreeException
	 */
	Integer getEncours() throws BatifreeException;

	/**
	 * Retourne le dépassement : Plafond autorise - Encours = getMontantPlafond - getEncours
	 * 
	 * @return dépassement
	 * @throws BatifreeException BatifreeException
	 */
	Float getDepassement() throws BatifreeException;

}