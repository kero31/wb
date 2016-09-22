/**
 * 
 */
package batifree.api.metier.impl;

import java.util.Date;

import batifree.api.manager.interfaces.IBibliothequeManager;
import batifree.api.manager.interfaces.IEnginManager;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IEngin;

import common.api.exception.BatifreeException;

/**
 * Classe <EnginImpl>.
 * 
 */
public abstract class EnginImpl extends BibliothequeElementImpl implements IEngin {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String immatriculation;
	private Date immatriculationDate;

	@Override
	public String getImmatriculation() {
		return immatriculation;
	}

	@Override
	public void setImmatriculation(String pImmatriculation) {
		immatriculation = pImmatriculation;
	}

	@Override
	public Date getImmatriculationDate() {
		return immatriculationDate;
	}

	@Override
	public void setImmatriculationDate(Date pImmatriculationDate) {
		immatriculationDate = pImmatriculationDate;
	}

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface Engin
	 * @param <TM> interface Engin manager
	 * @return manager
	 */
	protected abstract <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws BatifreeException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws BatifreeException {
		return (TM) getEnginManager();
	}

}
