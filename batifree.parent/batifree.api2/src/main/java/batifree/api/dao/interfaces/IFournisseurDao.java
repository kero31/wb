/***********************************************************************
 * Module: IFournisseurDao.java Author: Kero Purpose: Defines the Interface IFournisseurDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IFournisseurDao</b><br/>
 */
public interface IFournisseurDao extends IContactDao<IFournisseur> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pFournisseur Fournisseur
	 * @return liste des FournisseurMateriaux.
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws BatifreeException;

}