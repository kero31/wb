/***********************************************************************
 * Module: IImage.java Author: Kero Purpose: Defines the Interface IImage
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IImage</b><br/>
 */
public interface IImage extends IMetier<Integer> {

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