/***********************************************************************
 * Module: IFamille.java Author: Kero Purpose: Defines the Interface IFamille
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.ILigne;

/**
 * Interface <b>IFamille</b><br/>
 */
public interface IFamille extends ILigne<IFamille, Integer> {

	/**
	 * Get Type
	 * 
	 * @return Type
	 */
	Short getType();

	/**
	 * Set Type
	 * 
	 * @param pType Type
	 */
	void setType(Short pType);

	/**
	 * Get Descriptif
	 * 
	 * @return Descriptif
	 */
	java.lang.String getDescriptif();

	/**
	 * Set Descriptif
	 * 
	 * @param pDescriptif Descriptif
	 */
	void setDescriptif(java.lang.String pDescriptif);

	/**
	 * Get List Bibliotheque
	 * 
	 * @return List Bibliotheque
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibliotheque> getListBibliotheque() throws BatifreeException;

}