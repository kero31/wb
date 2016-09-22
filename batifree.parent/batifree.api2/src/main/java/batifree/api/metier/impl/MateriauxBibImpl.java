/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IMateriauxManager;
import batifree.api.metier.interfaces.IMateriaux;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <MateriauxBibImpl>.
 * 
 */
public class MateriauxBibImpl extends MateriauxImpl implements IMateriauxBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMateriaux, TM extends IMateriauxManager<IT>> TM getMateriauxManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getMateriauxBibManager();
	}

	@Override
	public IMateriauxEtude getMateriauxEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getMateriauxBibManager().getMateriauxEtudeFromBib(this);
	}
}
