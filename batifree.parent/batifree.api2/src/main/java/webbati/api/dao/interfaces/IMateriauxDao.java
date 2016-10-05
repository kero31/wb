/***********************************************************************
 * Module: IMateriauxDao.java Author: Kero Purpose: Defines the Interface IMateriauxDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IMateriaux;

/**
 * Interface <b>IMateriauxDao</b><br/>
 * 
 * @param <IT> IMateriaux
 */
public interface IMateriauxDao<IT extends IMateriaux> extends IBibliothequeDao<IT> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pMateriaux Materiaux
	 * @return liste des FournisseurMateriaux.
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws WebbatiException;

}