/***********************************************************************
 * Module: IAvoir.java Author: Kero Purpose: Defines the Interface IAvoir
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IAvoir</b><br/>
 */
public interface IAvoir extends IAffaire {

	/**
	 * Met à jour le lien avec la facture.
	 * 
	 * @param pFacture Facture d'origine
	 */
	void setFacture(IFacture pFacture);

	/**
	 * Retourne la facture d'origine.
	 * 
	 * @return facture d'origine
	 * @throws BatifreeException BatifreeException
	 */
	IFacture getFacture() throws BatifreeException;

}