/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IMainOeuvreManager;
import webbati.api.metier.interfaces.IMainOeuvre;
import webbati.api.metier.interfaces.IMainOeuvreBib;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Classe <MainOeuvreBibImpl>.
 * 
 */
public class MainOeuvreBibImpl extends MainOeuvreImpl implements IMainOeuvreBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getMainOeuvreBibManager();
	}

	@Override
	public IMainOeuvreEtude getMainOeuvreEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getMainOeuvreBibManager().getMainOeuvreEtudeFromBib(this);
	}
}
