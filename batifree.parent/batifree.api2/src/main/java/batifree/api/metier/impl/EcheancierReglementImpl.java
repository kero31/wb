/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.ejb.EcheancierReglementId;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <EcheancierReglementImpl>.
 * 
 */
public class EcheancierReglementImpl extends MetierImpl<EcheancierReglementId> implements IEcheancierReglement {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Float montant;

	/**
	 * 
	 * Constructeur.
	 */
	public EcheancierReglementImpl() {
		setId(new EcheancierReglementId());
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pEcheancier Echeancier
	 * @param pReglement Reglement
	 * @throws BatifreeException BatifreeException
	 */
	public EcheancierReglementImpl(IEcheancier pEcheancier, IReglement pReglement) throws BatifreeException {
		if (pEcheancier != null && pReglement != null) {
			setId(new EcheancierReglementId(pEcheancier.getId(), pReglement.getId()));
		} else {

			throw new BatifreeException("Echeancier et Reglement ne peuvent pas être NULL. Echeancier=" + (pEcheancier == null ? "NULL" : "")
			        + "Reglement=" + (pReglement == null ? "NULL" : ""));
		}
	}

	@Override
	public Float getMontant() {
		return getValue(montant);
	}

	@Override
	public void setMontant(Float pMontant) {
		montant = pMontant;
	}

	@Override
	public IEcheancier getEcheancier() throws BatifreeException {
		return ApplicationBf.getApplication().getEcheancierManager().getById(getId().getEcheancierId());
	}

	@Override
	public void setEcheancier(IEcheancier pEcheancier) throws BatifreeException {
		if (pEcheancier != null) {
			getId().setEcheancierId(pEcheancier.getId());
		} else {
			throw new BatifreeException("L'Echeancier ne peut pas être vide");
		}
	}

	@Override
	public IReglement getReglement() throws BatifreeException {
		return ApplicationBf.getApplication().getReglementManager().getById(getId().getReglementId());
	}

	@Override
	public void setReglement(IReglement pReglement) throws BatifreeException {
		if (pReglement != null) {
			getId().setReglementId(pReglement.getId());
		} else {
			throw new BatifreeException("Le Reglement ne peut pas être vide");
		}
	}
}
