/***********************************************************************
 * Module: IBibEltEtude.java Author: Kero Purpose: Defines the Interface IBibEltEtude
 ***********************************************************************/

package batifree.api.metier.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IBibEltEtude</b><br/>
 */
public interface IBibEltEtude {

	/**
	 * Get Metre
	 * 
	 * @return Metre
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getMetre() throws BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	IEtude getEtude() throws BatifreeException;

	/**
	 * Set Etude
	 * 
	 * @param pEtude Etude
	 */
	void setEtude(IEtude pEtude);

}