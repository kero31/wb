/**
 * 
 */
package webbati.api.metier.impl;

import java.util.Date;

import common.api.exception.WebbatiException;
import webbati.api.manager.interfaces.IBibliothequeManager;
import webbati.api.manager.interfaces.IEnginManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IEngin;

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
	protected abstract <IT extends IEngin, TM extends IEnginManager<IT>> TM getEnginManager() throws WebbatiException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException {
		return (TM) getEnginManager();
	}

}
