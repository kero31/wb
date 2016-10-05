/***********************************************************************
 * Module: ITva.java Author: Kero Purpose: Defines the Interface ITva
 ***********************************************************************/

package webbati.api.metier.interfaces;

/**
 * Interface <b>ITva</b><br/>
 */
public interface ITva extends IIdLibelle {

	/**
	 * Get Taux
	 * 
	 * @return Taux
	 */
	Float getTaux();

	/**
	 * Set Taux
	 * 
	 * @param pTaux Taux
	 */
	void setTaux(Float pTaux);

	/**
	 * Get Hide, savoir si la TVA est caché
	 * 
	 * @return TRUE si caché, FALSE sinon
	 */
	Boolean isHide();

	/**
	 * Set Hide, cache ou non la TVA
	 * 
	 * @param pHide TRUE si caché, FALSE sinon
	 */
	void setHide(Boolean pHide);

}