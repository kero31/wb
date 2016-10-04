/***********************************************************************
 * Module: IFournisseurDao.java Author: Kero Purpose: Defines the Interface IFournisseurDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Interface <b>IFournisseurDao</b><br/>
 */
public interface IFournisseurDao extends IContactDao<IFournisseur> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pFournisseur Fournisseur
	 * @return liste des FournisseurMateriaux.
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws WebbatiException;

}