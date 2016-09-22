/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ISousTraitantManager;
import batifree.api.metier.interfaces.ISousTraitant;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <SousTraitantBibImpl>.
 * 
 */
public class SousTraitantBibImpl extends SousTraitantImpl implements ISousTraitantBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getSousTraitantBibManager();
	}

	@Override
	public ISousTraitantEtude getSousTraitantEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getSousTraitantBibManager().getTacheEtudeFromBib(this);
	}
}
