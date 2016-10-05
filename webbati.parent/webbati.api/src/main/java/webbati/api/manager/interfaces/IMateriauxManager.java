/***********************************************************************
 * Module: IMateriauxManager.java Author: Kero Purpose: Defines the Interface IMateriauxManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IMateriaux;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws WebbatiException;

}