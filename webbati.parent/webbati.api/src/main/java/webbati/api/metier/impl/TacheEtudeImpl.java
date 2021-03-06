/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ITacheManager;
import webbati.api.metier.interfaces.ITache;
import webbati.api.metier.interfaces.ITacheEtude;

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
	protected <IT extends ITache, TM extends ITacheManager<IT>> TM getTacheManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getTacheEtudeManager();
	}
}
