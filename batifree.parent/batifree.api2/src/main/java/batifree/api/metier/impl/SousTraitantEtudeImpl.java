/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ISousTraitantManager;
import batifree.api.metier.interfaces.ISousTraitant;
import batifree.api.metier.interfaces.ISousTraitantEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <SousTraitantEtudeImpl>.
 * 
 */
public class SousTraitantEtudeImpl extends SousTraitantImpl implements ISousTraitantEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public SousTraitantEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getSousTraitantEtudeManager();
	}
}
