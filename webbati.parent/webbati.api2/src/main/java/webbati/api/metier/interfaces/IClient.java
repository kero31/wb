/***********************************************************************
 * Module: IClient.java Author: Kero Purpose: Defines the Interface IClient
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<ICoordonneeCnt> getListCoordonnee() throws WebbatiException;

	/**
	 * Retourne la liste des affaires
	 * 
	 * @return List Affaire
	 * @throws WebbatiException WebbatiException
	 */
	List<IAffaire> getListAffaire() throws WebbatiException;

	/**
	 * Retourne la liste des règlements
	 * 
	 * @return liste des règlements
	 * @throws WebbatiException WebbatiException
	 */
	List<IReglement> getListReglement() throws WebbatiException;

	/**
	 * Retourne la liste des échéanciers dûs
	 * 
	 * @return liste des échéanciers dûs
	 * @throws WebbatiException WebbatiException
	 */
	Integer getEncours() throws WebbatiException;

	/**
	 * Retourne le dépassement : Plafond autorise - Encours = getMontantPlafond - getEncours
	 * 
	 * @return dépassement
	 * @throws WebbatiException WebbatiException
	 */
	Float getDepassement() throws WebbatiException;

}