/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.manager.interfaces.IBibliothequeManager;
import webbati.api.manager.interfaces.IMainOeuvreManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IMainOeuvre;

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
	protected abstract <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws WebbatiException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException {
		return (TM) getMainOeuvreManager();
	}

}
