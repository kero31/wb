/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IMainOeuvreManager;
import webbati.api.metier.interfaces.IMainOeuvre;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

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
	protected <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getMainOeuvreEtudeManager();
	}

}
