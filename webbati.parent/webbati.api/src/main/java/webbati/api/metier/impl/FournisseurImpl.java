/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IDetailCnt;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurImpl>.
 * 
 */
public class FournisseurImpl extends ContactImpl implements IFournisseur {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux() throws WebbatiException {
		return ApplicationWb.getApplication().getFournisseurManager().getListFournisseurMateriaux(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws WebbatiException {
		return ApplicationWb.getApplication().getFournisseurManager().getListDetailContact(this);
	}

}
