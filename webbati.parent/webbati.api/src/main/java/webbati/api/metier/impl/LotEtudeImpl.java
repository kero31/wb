/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ILotManager;
import webbati.api.metier.interfaces.ILot;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotEtudeImpl>.
 * 
 */
public class LotEtudeImpl extends LotImpl implements ILotEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public LotEtudeImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ILot, TM extends ILotManager<IT>> TM getLotManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getLotEtudeManager();
	}

}
