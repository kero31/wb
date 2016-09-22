/***********************************************************************
 * Module: IFournisseurMateriaux.java Author: Kero Purpose: Defines the Interface IFournisseurMateriaux
 ***********************************************************************/

package batifree.api.metier.interfaces;

import batifree.api.metier.ejb.FournisseurMateriauxId;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

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
	 * @throws BatifreeException BatifreeException
	 */
	IMateriaux getMateriaux() throws BatifreeException;

	/**
	 * Set Tva
	 * 
	 * @param pMateriaux Materiaux
	 * @throws BatifreeException BatifreeException
	 */
	void setMateriaux(IMateriaux pMateriaux) throws BatifreeException;

	/**
	 * Get Fournisseur
	 * 
	 * @return Fournisseur
	 * @throws BatifreeException BatifreeException
	 */
	IFournisseur getFournisseur() throws BatifreeException;

	/**
	 * Set Fournisseur
	 * 
	 * @param pFournisseur Fournisseur
	 * @throws BatifreeException BatifreeException
	 */
	void setFournisseur(IFournisseur pFournisseur) throws BatifreeException;

}