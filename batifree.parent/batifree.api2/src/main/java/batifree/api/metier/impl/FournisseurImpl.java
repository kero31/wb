/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IDetailCnt;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.exception.BatifreeException;

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
	public List<IFournisseurMateriaux> getListFournisseurMateriaux() throws BatifreeException {
		return ApplicationBf.getApplication().getFournisseurManager().getListFournisseurMateriaux(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws BatifreeException {
		return ApplicationBf.getApplication().getFournisseurManager().getListDetailContact(this);
	}

}
