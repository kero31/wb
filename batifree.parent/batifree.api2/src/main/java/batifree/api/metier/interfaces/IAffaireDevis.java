/***********************************************************************
 * Module: IAffaireDevis.java Author: Kero Purpose: Defines the Interface IAffaireDevis
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IAffaireDevis</b><br/>
 */
public interface IAffaireDevis {

	/**
	 * Get Devis
	 * 
	 * @return Devis
	 * @throws BatifreeException BatifreeException
	 */
	IDevis getDevis() throws BatifreeException;

	/**
	 * Set Devis
	 * 
	 * @param pDevis Devis
	 */
	void setDevis(IDevis pDevis);

}