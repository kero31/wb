/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.manager.interfaces.IBibliothequeManager;
import batifree.api.manager.interfaces.IMainOeuvreManager;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IMainOeuvre;

import common.api.exception.BatifreeException;

/**
 * Classe <MainOeuvreImpl>.
 * 
 */
public abstract class MainOeuvreImpl extends BibliothequeElementImpl implements IMainOeuvre {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface MainOeuvre
	 * @param <TM> interface MainOeuvre manager
	 * @return manager
	 */
	protected abstract <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws BatifreeException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws BatifreeException {
		return (TM) getMainOeuvreManager();
	}

}
