/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IEnginManager;
import batifree.api.metier.interfaces.IEngin;
import batifree.api.metier.interfaces.IEnginEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <EnginEtudeImpl>.
 * 
 */
public class EnginEtudeImpl extends EnginImpl implements IEnginEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public EnginEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getEnginEtudeManager();
	}
}
