/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ISousTraitantManager;
import webbati.api.metier.interfaces.ISousTraitant;
import webbati.api.metier.interfaces.ISousTraitantEtude;

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
	protected <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getSousTraitantEtudeManager();
	}
}
