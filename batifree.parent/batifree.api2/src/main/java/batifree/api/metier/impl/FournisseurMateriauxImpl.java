/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.ejb.FournisseurMateriauxId;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IMateriaux;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <FournisseurMateriauxImpl>.
 * 
 */
public class FournisseurMateriauxImpl extends MetierImpl<FournisseurMateriauxId> implements IFournisseurMateriaux {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Float prixTarif;
	private Float remise;
	private Float quantiteMini;

	/**
	 * 
	 * Constructeur.
	 */
	public FournisseurMateriauxImpl() {
		setId(new FournisseurMateriauxId());
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pMateriaux Materiaux
	 * @param pFournisseur Fournisseur
	 * @throws BatifreeException
	 */
	public FournisseurMateriauxImpl(IMateriaux pMateriaux, IFournisseur pFournisseur) throws BatifreeException {
		if (pMateriaux != null && pFournisseur != null) {
			setId(new FournisseurMateriauxId(pMateriaux.getId(), pFournisseur.getId()));
		} else {

			throw new BatifreeException("IMateriaux et Fournisseur ne peuvent pas être NULL. IMateriaux=" + (pMateriaux == null ? "NULL" : "")
			        + "Fournisseur=" + (pFournisseur == null ? "NULL" : ""));
		}
	}

	@Override
	public Float getPrixTarif() {
		return getValue(prixTarif);
	}

	@Override
	public void setPrixTarif(Float pPrixTarif) {
		prixTarif = pPrixTarif;
	}

	@Override
	public Float getRemise() {
		return getValue(remise);
	}

	@Override
	public void setRemise(Float pRemise) {
		remise = pRemise;
	}

	@Override
	public Float getQuantiteMini() {
		return getValue(quantiteMini);
	}

	@Override
	public void setQuantiteMini(Float pQuantiteMini) {
		quantiteMini = pQuantiteMini;
	}

	@Override
	public IMateriaux getMateriaux() throws BatifreeException {
		IMateriaux mx = ApplicationBf.getApplication().getMateriauxBibManager().getById(getId().getMateriauxId());
		if (mx == null) {
			mx = ApplicationBf.getApplication().getMateriauxEtudeManager().getById(getId().getMateriauxId());
		}

		return mx;
	}

	@Override
	public void setMateriaux(IMateriaux pMateriaux) throws BatifreeException {
		if (pMateriaux != null) {
			getId().setMateriauxId(pMateriaux.getId());
		} else {
			throw new BatifreeException("Le Materiaux ne peut pas être vide");
		}
	}

	@Override
	public IFournisseur getFournisseur() throws BatifreeException {
		return ApplicationBf.getApplication().getFournisseurManager().getById(getId().getFournisseurId());
	}

	@Override
	public void setFournisseur(IFournisseur pFournisseur) throws BatifreeException {
		if (pFournisseur != null) {
			getId().setFournisseurId(pFournisseur.getId());
		} else {
			throw new BatifreeException("Le Fournisseur ne peut pas être vide");
		}
	}
}
