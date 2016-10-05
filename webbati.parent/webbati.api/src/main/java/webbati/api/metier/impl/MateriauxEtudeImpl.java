/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IMateriauxManager;
import webbati.api.metier.interfaces.IMateriaux;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxEtudeImpl>.
 * 
 */
public class MateriauxEtudeImpl extends MateriauxImpl implements IMateriauxEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public MateriauxEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IMateriaux, TM extends IMateriauxManager<IT>> TM getMateriauxManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getMateriauxEtudeManager();
	}
}
