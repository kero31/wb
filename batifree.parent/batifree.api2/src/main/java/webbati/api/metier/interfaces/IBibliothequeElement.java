/***********************************************************************
 * Module: IBibliothequeElement.java Author: Didier Purpose: Defines the Interface IBibliothequeElement
 ***********************************************************************/

package webbati.api.metier.interfaces;

/**
 * Interface <b>IBibliothequeElement</b><br/>
 */
public interface IBibliothequeElement extends IBibliotheque {

	/**
	 * Get Bar Code
	 * 
	 * @return Bar Code
	 */
	java.lang.String getBarCode();

	/**
	 * Set Bar Code
	 * 
	 * @param pBarCode Bar Code
	 */
	void setBarCode(java.lang.String pBarCode);

	/**
	 * Set Frais Generaux
	 * 
	 * @param pFraisGeneraux Frais Generaux
	 */
	void setFraisGeneraux(Float pFraisGeneraux);

	/**
	 * Set Num Serie
	 * 
	 * @param pNumSerie Num Serie
	 */
	void setNumSerie(java.lang.String pNumSerie);

	/**
	 * Set Prix Achat
	 * 
	 * @param pPrixAchat Prix Achat
	 */
	void setPrixAchatUnitaire(Float pPrixAchat);

	/**
	 * Set Benefice
	 * 
	 * @param pBenefice Benefice
	 */
	void setBenefice(Float pBenefice);

	/**
	 * Set Prix Revient
	 * 
	 * @param pPrixRevient Prix Revient
	 */
	void setPrixRevientUnitaire(Float pPrixRevient);

	/**
	 * Set Prix Vente
	 * 
	 * @param pPrixVente Prix Vente
	 */
	void setPrixVenteUnitaire(Float pPrixVente);

}