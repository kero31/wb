/***********************************************************************
 * Module: IBibEltEtude.java Author: Kero Purpose: Defines the Interface IBibEltEtude
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IBibEltEtude</b><br/>
 */
public interface IBibEltEtude {

	/**
	 * Get Metre
	 * 
	 * @return Metre
	 * @throws WebbatiException WebbatiException
	 */
	IBinaire getMetre() throws WebbatiException;

	/**
	 * Set Metre
	 * 
	 * @param pMetre Metre
	 */
	void setMetre(IBinaire pMetre);

	/**
	 * Get Etude
	 * 
	 * @return Etude
	 * @throws WebbatiException WebbatiException
	 */
	IEtude getEtude() throws WebbatiException;

	/**
	 * Set Etude
	 * 
	 * @param pEtude Etude
	 */
	void setEtude(IEtude pEtude);

}