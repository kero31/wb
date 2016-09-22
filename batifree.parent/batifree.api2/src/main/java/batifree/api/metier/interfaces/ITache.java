/***********************************************************************
 * Module: ITache.java Author: Didier Purpose: Defines the Interface ITache
 ***********************************************************************/

package batifree.api.metier.interfaces;

/**
 * Interface <b>ITache</b><br/>
 */
public interface ITache extends IBibliothequeElement, ISousTache, ILotTache {

	/**
	 * Get Prix Vente Fixe
	 * 
	 * @return TRUE si Prix Vente Fixe FALSE else
	 */
	Boolean isPrixVenteFixe();

	/**
	 * Set Prix Vente Fixe
	 * 
	 * @param pPrixVenteFixe TRUE si Prix Vente Fixe, FALSE else
	 */
	void setPrixVenteFixe(Boolean pPrixVenteFixe);

	/**
	 * Get Frais Generaux Mx
	 * 
	 * @return Frais Generaux Mx
	 */
	Float getFraisGenerauxMx();

	/**
	 * Set Frais Generaux Mx
	 * 
	 * @param pFraisGenerauxMx Frais Generaux Mx
	 */
	void setFraisGenerauxMx(Float pFraisGenerauxMx);

	/**
	 * Get Benefice Mx
	 * 
	 * @return Benefice Mx
	 */
	Float getBeneficeMx();

	/**
	 * Set Benefice Mx
	 * 
	 * @param pBeneficeMx Benefice Mx
	 */
	void setBeneficeMx(Float pBeneficeMx);

	/**
	 * Get Frais Generaux Mo
	 * 
	 * @return Frais Generaux Mo
	 */
	Float getFraisGenerauxMo();

	/**
	 * Set Frais Generaux Mo
	 * 
	 * @param pFraisGenerauxMo Frais Generaux Mo
	 */
	void setFraisGenerauxMo(Float pFraisGenerauxMo);

	/**
	 * Get Benefice Mo
	 * 
	 * @return Benefice Mo
	 */
	Float getBeneficeMo();

	/**
	 * Set Benefice Mo
	 * 
	 * @param pBeneficeMo Benefice Mo
	 */
	void setBeneficeMo(Float pBeneficeMo);

	/**
	 * Get Frais Generaux St
	 * 
	 * @return Frais Generaux St
	 */
	Float getFraisGenerauxSt();

	/**
	 * Set Frais Generaux St
	 * 
	 * @param pFraisGenerauxSt Frais Generaux St
	 */
	void setFraisGenerauxSt(Float pFraisGenerauxSt);

	/**
	 * Get Benefice St
	 * 
	 * @return Benefice St
	 */
	Float getBeneficeSt();

	/**
	 * Set Benefice St
	 * 
	 * @param pBeneficeSt Benefice St
	 */
	void setBeneficeSt(Float pBeneficeSt);

	/**
	 * Get Frais Generaux Eng
	 * 
	 * @return Frais Generaux Eng
	 */
	Float getFraisGenerauxEng();

	/**
	 * Set Frais Generaux Eng
	 * 
	 * @param pFraisGenerauxEng Frais Generaux Eng
	 */
	void setFraisGenerauxEng(Float pFraisGenerauxEng);

	/**
	 * Get Benefice Eng
	 * 
	 * @return Benefice Eng
	 */
	Float getBeneficeEng();

	/**
	 * Set Benefice Eng
	 * 
	 * @param pBeneficeEng Benefice Eng
	 */
	void setBeneficeEng(Float pBeneficeEng);

}