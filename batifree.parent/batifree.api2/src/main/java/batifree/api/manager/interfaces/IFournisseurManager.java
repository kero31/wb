/***********************************************************************
 * Module: IFournisseurManager.java Author: Kero Purpose: Defines the Interface IFournisseurManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IFournisseurManager</b><br/>
 */
public interface IFournisseurManager extends IContactManager<IFournisseur> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pFournisseur Fournisseur
	 * @return liste des FournisseurMateriaux.
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws BatifreeException;

}