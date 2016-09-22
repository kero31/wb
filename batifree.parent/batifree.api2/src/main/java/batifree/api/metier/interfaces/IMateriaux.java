/***********************************************************************
 * Module: IMateriaux.java Author: Kero Purpose: Defines the Interface IMateriaux
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMateriaux</b><br/>
 */
public interface IMateriaux extends IBibliothequeElement {

	/**
	 * Get Prix Tarif
	 * 
	 * @return Prix Tarif
	 */
	Float getPrixTarif();

	/**
	 * Set Prix Tarif
	 * 
	 * @param pPrixTarif Prix Tarif
	 */
	void setPrixTarif(Float pPrixTarif);

	/**
	 * Get Remise
	 * 
	 * @return Remise
	 */
	Float getRemise();

	/**
	 * Set Remise
	 * 
	 * @param pRemise Remise
	 */
	void setRemise(Float pRemise);

	/**
	 * Get Fournisseur Defaut
	 * 
	 * @return Fournisseur Defaut
	 * @throws BatifreeException BatifreeException
	 */
	IFournisseur getFournisseurDefaut() throws BatifreeException;

	/**
	 * Set Fournisseur Defaut
	 * 
	 * @param pFournisseurDefaut Fournisseur Defaut
	 */
	void setFournisseurDefaut(IFournisseur pFournisseurDefaut);

	/**
	 * Get List Fournisseur Materiaux
	 * 
	 * @return List Fournisseur Materiaux
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux() throws BatifreeException;

	/** @param pListFrnMx liste fournisseur materiaux */
	void setListFournisseurMateriaux(List<IFournisseurMateriaux> pListFrnMx);

}