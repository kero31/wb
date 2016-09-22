/***********************************************************************
 * Module: IIdLibelle.java Author: Kero Purpose: Defines the Interface IIdLibelle
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IIdLibelle</b><br/>
 */
public interface IIdLibelle extends IMetier<Integer> {

	/**
	 * Get Libelle
	 * 
	 * @return Libelle
	 */
	java.lang.String getLibelle();

	/**
	 * Set Libelle
	 * 
	 * @param pLibelle Libelle
	 */
	void setLibelle(java.lang.String pLibelle);

}