/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ISousTraitantManager;
import webbati.api.metier.interfaces.ISousTraitant;
import webbati.api.metier.interfaces.ISousTraitantBib;
import webbati.api.metier.interfaces.ISousTraitantEtude;

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
	protected <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getSousTraitantBibManager();
	}

	@Override
	public ISousTraitantEtude getSousTraitantEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getSousTraitantBibManager().getTacheEtudeFromBib(this);
	}
}
