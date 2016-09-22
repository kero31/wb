/***********************************************************************
 * Module: IBinaire.java Author: Kero Purpose: Defines the Interface IBinaire
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IBinaire</b><br/>
 */
public interface IBinaire extends IMetier<Integer> {

	/**
	 * Get Objet
	 * 
	 * @return Objet
	 */
	byte[] getObjet();

	/**
	 * Set Objet
	 * 
	 * @param pObjet Objet
	 */
	void setObjet(byte[] pObjet);

}