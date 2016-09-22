/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.ILotManager;
import batifree.api.metier.interfaces.ILot;
import batifree.api.metier.interfaces.ILotEtude;

import common.api.exception.BatifreeException;

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
	protected <IT extends ILot, TM extends ILotManager<IT>> TM getLotManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getLotEtudeManager();
	}

}
