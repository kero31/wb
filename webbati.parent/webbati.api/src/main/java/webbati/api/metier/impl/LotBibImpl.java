/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.ILotManager;
import webbati.api.metier.interfaces.ILot;
import webbati.api.metier.interfaces.ILotBib;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotBibImpl>.
 * 
 */
public class LotBibImpl extends LotImpl implements ILotBib {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur.
	 */
	public LotBibImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends ILot, TM extends ILotManager<IT>> TM getLotManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getLotBibManager();
	}

	@Override
	public ILotEtude getLotEtude() throws WebbatiException {
		return ApplicationWb.getApplication().getLotBibManager().getLotEtudeFromBib(this);
	}
}
