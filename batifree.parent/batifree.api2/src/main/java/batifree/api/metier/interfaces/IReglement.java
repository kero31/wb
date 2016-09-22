/***********************************************************************
 * Module: IReglement.java Author: Didier Purpose: Defines the Interface IReglement
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.Date;
import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IReglement</b><br/>
 */
public interface IReglement extends IMetier<Integer> {

	/**
	 * Get List Echeancier Reglement
	 * 
	 * @return List Echeancier Reglement
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement() throws BatifreeException;

	/**
	 * Retourne le code
	 * 
	 * @return code
	 */
	String getCode();

	/**
	 * Met à jour le code
	 * 
	 * @param pCode code
	 */
	void setCode(String pCode);

	/**
	 * Retourne le Descriptif
	 * 
	 * @return Descriptif
	 */
	String getDescriptif();

	/**
	 * Met à jour le Descriptif
	 * 
	 * @param pDescriptif code
	 */
	void setDescriptif(String pDescriptif);

	/**
	 * Retourne le Date Paiement
	 * 
	 * @return Date Paiement
	 */
	Date getDatePaiement();

	/**
	 * Met à jour le Date Paiement
	 * 
	 * @param pDatePaiement Date Paiement
	 */
	void setDatePaiement(Date pDatePaiement);

	/**
	 * Retourne la Banque
	 * 
	 * @return Banque
	 */
	String getBanque();

	/**
	 * Met à jour la Banque
	 * 
	 * @param pBanque Banque
	 */
	void setBanque(String pBanque);

	/**
	 * Retourne le Num Cheque
	 * 
	 * @return Num Cheque
	 */
	String getNumCheque();

	/**
	 * Met à jour le Num Cheque
	 * 
	 * @param pNumCheque Num Cheque
	 */
	void setNumCheque(String pNumCheque);

	/**
	 * Retourne le Mode Paiement
	 * 
	 * @return Mode Paiement
	 * @throws BatifreeException BatifreeException
	 */
	IModePaiement getModePaiement() throws BatifreeException;

	/**
	 * Met à jour le Mode Paiement
	 * 
	 * @param pModePaiement Mode Paiement
	 */
	void setModePaiement(IModePaiement pModePaiement);

}