/***********************************************************************
 * Module: IFournisseur.java Author: Kero Purpose: Defines the Interface IFournisseur
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IFournisseur</b><br/>
 */
public interface IFournisseur extends IContact {

	/**
	 * Get List Fournisseur Materiaux
	 * 
	 * @return List Fournisseur Materiaux
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux() throws BatifreeException;

}