/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ITacheManager;
import webbati.api.metier.interfaces.ITache;
import webbati.api.metier.interfaces.ITacheBib;
import webbati.api.metier.interfaces.ITacheEtude;

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
	protected <IT extends ITache, TM extends ITacheManager<IT>> TM getTacheManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getTacheBibManager();
	}

	@Override
	public ITacheEtude getTacheEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getTacheBibManager().getTacheEtudeFromBib(this);
	}
}
