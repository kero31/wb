/***********************************************************************
 * Module: IMateriauxDao.java Author: Kero Purpose: Defines the Interface IMateriauxDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IMateriaux;

import common.api.exception.BatifreeException;

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
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws BatifreeException;

}