/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IMainOeuvreManager;
import batifree.api.metier.interfaces.IMainOeuvre;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

import common.api.exception.BatifreeException;

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
	protected <IT extends IMainOeuvre, TM extends IMainOeuvreManager<IT>> TM getMainOeuvreManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getMainOeuvreBibManager();
	}

	@Override
	public IMainOeuvreEtude getMainOeuvreEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getMainOeuvreBibManager().getMainOeuvreEtudeFromBib(this);
	}
}
