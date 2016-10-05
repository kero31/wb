/***********************************************************************
 * Module: IAvoir.java Author: Kero Purpose: Defines the Interface IAvoir
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IFacture getFacture() throws WebbatiException;

}