/***********************************************************************
 * Module: IAffaireDevis.java Author: Kero Purpose: Defines the Interface IAffaireDevis
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IAffaireDevis</b><br/>
 */
public interface IAffaireDevis {

	/**
	 * Get Devis
	 * 
	 * @return Devis
	 * @throws WebbatiException WebbatiException
	 */
	IDevis getDevis() throws WebbatiException;

	/**
	 * Set Devis
	 * 
	 * @param pDevis Devis
	 */
	void setDevis(IDevis pDevis);

}