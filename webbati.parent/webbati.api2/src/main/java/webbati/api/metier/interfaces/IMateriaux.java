/***********************************************************************
 * Module: IMateriaux.java Author: Kero Purpose: Defines the Interface IMateriaux
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IFournisseur getFournisseurDefaut() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux() throws WebbatiException;

	/** @param pListFrnMx liste fournisseur materiaux */
	void setListFournisseurMateriaux(List<IFournisseurMateriaux> pListFrnMx);

}