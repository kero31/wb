/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IEnginManager;
import webbati.api.metier.interfaces.IEngin;
import webbati.api.metier.interfaces.IEnginEtude;

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
	protected <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getEnginEtudeManager();
	}
}
