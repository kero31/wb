/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ITacheManager;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <TacheBibImpl>.
 * 
 */
public class TacheBibImpl extends TacheImpl implements ITacheBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ITache, TM extends ITacheManager<IT>> TM getTacheManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getTacheBibManager();
	}

	@Override
	public ITacheEtude getTacheEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getTacheBibManager().getTacheEtudeFromBib(this);
	}
}
