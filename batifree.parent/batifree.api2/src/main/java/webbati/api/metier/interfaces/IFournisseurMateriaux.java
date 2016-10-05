/***********************************************************************
 * Module: IFournisseurMateriaux.java Author: Kero Purpose: Defines the Interface IFournisseurMateriaux
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;
import webbati.api.metier.ejb.FournisseurMateriauxId;

/**
 * Interface <b>IFournisseurMateriaux</b><br/>
 */
public interface IFournisseurMateriaux extends IMetier<FournisseurMateriauxId> {

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
	 * Get Quantite Mini
	 * 
	 * @return Quantite Mini
	 */
	Float getQuantiteMini();

	/**
	 * Set Quantite Mini
	 * 
	 * @param pQuantiteMini Quantite Mini
	 */
	void setQuantiteMini(Float pQuantiteMini);

	/**
	 * Get Tva
	 * 
	 * @return Tva
	 * @throws WebbatiException WebbatiException
	 */
	IMateriaux getMateriaux() throws WebbatiException;

	/**
	 * Set Tva
	 * 
	 * @param pMateriaux Materiaux
	 * @throws WebbatiException WebbatiException
	 */
	void setMateriaux(IMateriaux pMateriaux) throws WebbatiException;

	/**
	 * Get Fournisseur
	 * 
	 * @return Fournisseur
	 * @throws WebbatiException WebbatiException
	 */
	IFournisseur getFournisseur() throws WebbatiException;

	/**
	 * Set Fournisseur
	 * 
	 * @param pFournisseur Fournisseur
	 * @throws WebbatiException WebbatiException
	 */
	void setFournisseur(IFournisseur pFournisseur) throws WebbatiException;

}