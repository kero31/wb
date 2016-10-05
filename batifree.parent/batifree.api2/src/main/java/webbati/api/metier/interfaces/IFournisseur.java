/***********************************************************************
 * Module: IFournisseur.java Author: Kero Purpose: Defines the Interface IFournisseur
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IFournisseur</b><br/>
 */
public interface IFournisseur extends IContact {

	/**
	 * Get List Fournisseur Materiaux
	 * 
	 * @return List Fournisseur Materiaux
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux() throws WebbatiException;

}