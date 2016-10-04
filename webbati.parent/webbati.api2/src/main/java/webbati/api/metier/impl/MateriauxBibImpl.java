/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IMateriauxManager;
import webbati.api.metier.interfaces.IMateriaux;
import webbati.api.metier.interfaces.IMateriauxBib;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxBibImpl>.
 * 
 */
public class MateriauxBibImpl extends MateriauxImpl implements IMateriauxBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMateriaux, TM extends IMateriauxManager<IT>> TM getMateriauxManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getMateriauxBibManager();
	}

	@Override
	public IMateriauxEtude getMateriauxEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getMateriauxBibManager().getMateriauxEtudeFromBib(this);
	}
}
