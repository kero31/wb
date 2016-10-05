/***********************************************************************
 * Module: IFournisseurManager.java Author: Kero Purpose: Defines the Interface IFournisseurManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Interface <b>IFournisseurManager</b><br/>
 */
public interface IFournisseurManager extends IContactManager<IFournisseur> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pFournisseur Fournisseur
	 * @return liste des FournisseurMateriaux.
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws WebbatiException;

}