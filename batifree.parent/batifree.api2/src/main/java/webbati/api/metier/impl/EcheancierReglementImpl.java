/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.ejb.EcheancierReglementId;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IReglement;

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
	 * @throws WebbatiException WebbatiException
	 */
	public EcheancierReglementImpl(IEcheancier pEcheancier, IReglement pReglement) throws WebbatiException {
		if (pEcheancier != null && pReglement != null) {
			setId(new EcheancierReglementId(pEcheancier.getId(), pReglement.getId()));
		} else {

			throw new WebbatiException("Echeancier et Reglement ne peuvent pas être NULL. Echeancier=" + (pEcheancier == null ? "NULL" : "")
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
	public IEcheancier getEcheancier() throws WebbatiException {
		return ApplicationWb.getApplication().getEcheancierManager().getById(getId().getEcheancierId());
	}

	@Override
	public void setEcheancier(IEcheancier pEcheancier) throws WebbatiException {
		if (pEcheancier != null) {
			getId().setEcheancierId(pEcheancier.getId());
		} else {
			throw new WebbatiException("L'Echeancier ne peut pas être vide");
		}
	}

	@Override
	public IReglement getReglement() throws WebbatiException {
		return ApplicationWb.getApplication().getReglementManager().getById(getId().getReglementId());
	}

	@Override
	public void setReglement(IReglement pReglement) throws WebbatiException {
		if (pReglement != null) {
			getId().setReglementId(pReglement.getId());
		} else {
			throw new WebbatiException("Le Reglement ne peut pas être vide");
		}
	}
}
