/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.manager.interfaces.IBibliothequeManager;
import batifree.api.manager.interfaces.ILotManager;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.ILot;

import common.api.exception.BatifreeException;

/**
 * Classe <LotImpl>.
 * 
 */
public abstract class LotImpl extends BibliothequeImpl implements ILot {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Boolean isLot;

	/**
	 * Constructeur.
	 */
	public LotImpl() {
		super();
		isLot = true;
	}

	/**
	 * Retourne TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 * 
	 * @return TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 */
	public Boolean getIsLot() {
		return isLot;
	}

	/**
	 * Set is lot
	 * 
	 * @param pIsLot TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 */
	public void setIsLot(Boolean pIsLot) {
		this.isLot = pIsLot;
	}

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface Lot
	 * @param <TM> interface Lot manager
	 * @return manager
	 */
	protected abstract <IT extends ILot, TM extends ILotManager<IT>> TM getLotManager() throws BatifreeException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws BatifreeException {
		return (TM) getLotManager();
	}

	@Override
	public Float getTempsUnitaire() {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}

	@Override
	public Float[] getDebourseParType() {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}
}
