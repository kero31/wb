/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IMainOeuvreManager;
import batifree.api.metier.interfaces.IMainOeuvre;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

import common.api.exception.BatifreeException;

/**
 * Classe <MainOeuvreEtudeImpl>.
 * 
 */
public class MainOeuvreEtudeImpl extends MainOeuvreImpl implements IMainOeuvreEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public MainOeuvreEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getMainOeuvreEtudeManager();
	}

}
