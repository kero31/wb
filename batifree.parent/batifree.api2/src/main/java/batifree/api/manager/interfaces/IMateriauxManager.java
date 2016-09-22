/***********************************************************************
 * Module: IMateriauxManager.java Author: Kero Purpose: Defines the Interface IMateriauxManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IMateriaux;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IMateriauxManager</b><br/>
 * 
 * @param <IT> IMateriaux
 */
public interface IMateriauxManager<IT extends IMateriaux> extends IBibliothequeElementManager<IT> {

	/**
	 * Retourne la liste des FournisseurMateriaux.
	 * 
	 * @param pMateriaux Materiaux
	 * @return liste des FournisseurMateriaux.
	 * @throws BatifreeException BatifreeException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws BatifreeException;

}