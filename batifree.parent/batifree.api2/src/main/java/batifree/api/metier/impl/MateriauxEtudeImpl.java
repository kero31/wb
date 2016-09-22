/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IMateriauxManager;
import batifree.api.metier.interfaces.IMateriaux;
import batifree.api.metier.interfaces.IMateriauxEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <MateriauxEtudeImpl>.
 * 
 */
public class MateriauxEtudeImpl extends MateriauxImpl implements IMateriauxEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public MateriauxEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMateriaux, TM extends IMateriauxManager<IT>> TM getMateriauxManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getMateriauxEtudeManager();
	}
}
