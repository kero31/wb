/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.manager.interfaces.IBibliothequeManager;
import batifree.api.manager.interfaces.ISousTraitantManager;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.ISousTraitant;

import common.api.exception.BatifreeException;

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
	protected abstract <IT extends ISousTraitant, TM extends ISousTraitantManager<IT>> TM getSousTraitantManager() throws BatifreeException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws BatifreeException {
		return (TM) getSousTraitantManager();
	}
}
