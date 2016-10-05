/***********************************************************************
 * Module: IEngin.java Author: Kero Purpose: Defines the Interface IEngin
 ***********************************************************************/

package webbati.api.metier.interfaces;

/**
 * Interface <b>IEngin</b><br/>
 */
public interface IEngin extends IBibliothequeElement {

	/**
	 * Get Immatriculation
	 * 
	 * @return Immatriculation
	 */
	java.lang.String getImmatriculation();

	/**
	 * Set Immatriculation
	 * 
	 * @param pImmatriculation Immatriculation
	 */
	void setImmatriculation(java.lang.String pImmatriculation);

	/**
	 * Get Immatriculation Date
	 * 
	 * @return ImmatriculationDate
	 */
	java.util.Date getImmatriculationDate();

	/**
	 * Set Immatriculation Date
	 * 
	 * @param pImmatriculationDate Immatriculation Date
	 */
	void setImmatriculationDate(java.util.Date pImmatriculationDate);

}