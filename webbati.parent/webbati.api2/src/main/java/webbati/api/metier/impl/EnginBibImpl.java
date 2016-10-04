/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IEnginManager;
import webbati.api.metier.interfaces.IEngin;
import webbati.api.metier.interfaces.IEnginBib;
import webbati.api.metier.interfaces.IEnginEtude;

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
	protected <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getEnginBibManager();
	}

	@Override
	public IEnginEtude getEnginEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getEnginBibManager().getEnginEtudeFromBib(this);
	}
}
