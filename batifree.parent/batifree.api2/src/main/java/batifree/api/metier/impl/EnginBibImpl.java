/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IEnginManager;
import batifree.api.metier.interfaces.IEngin;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <EnginBibImpl>.
 * 
 */
public class EnginBibImpl extends EnginImpl implements IEnginBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getEnginBibManager();
	}

	@Override
	public IEnginEtude getEnginEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getEnginBibManager().getEnginEtudeFromBib(this);
	}
}
