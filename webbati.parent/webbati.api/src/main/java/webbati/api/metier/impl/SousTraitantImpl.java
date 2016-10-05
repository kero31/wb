/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.manager.interfaces.IBibliothequeManager;
import webbati.api.manager.interfaces.ISousTraitantManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.ISousTraitant;

/**
 * Classe <SousTraitantImpl>.
 * 
 */
public abstract class SousTraitantImpl extends BibliothequeElementImpl implements ISousTraitant {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface SousTraitant
	 * @param <TM> interface SousTraitant manager
	 * @return manager
	 */
	protected abstract <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws WebbatiException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException {
		return (TM) getSousTraitantManager();
	}
}
