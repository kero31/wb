/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ITacheManager;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <TacheEtudeImpl>.
 * 
 */
public class TacheEtudeImpl extends TacheImpl implements ITacheEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public TacheEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ITache, TM extends ITacheManager<IT>> TM getTacheManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getTacheEtudeManager();
	}
}
