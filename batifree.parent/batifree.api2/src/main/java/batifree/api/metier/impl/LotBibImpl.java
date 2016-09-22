/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ILotManager;
import batifree.api.metier.interfaces.ILot;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;

import common.api.exception.BatifreeException;

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
	protected <IT extends ILot, TM extends ILotManager<IT>> TM getLotManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getLotBibManager();
	}

	@Override
	public ILotEtude getLotEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getLotBibManager().getLotEtudeFromBib(this);
	}
}
