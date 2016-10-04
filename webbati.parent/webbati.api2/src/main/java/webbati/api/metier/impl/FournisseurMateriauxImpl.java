/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.ejb.FournisseurMateriauxId;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IMateriaux;

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
	 * @throws WebbatiException
	 */
	public FournisseurMateriauxImpl(IMateriaux pMateriaux, IFournisseur pFournisseur) throws WebbatiException {
		if (pMateriaux != null && pFournisseur != null) {
			setId(new FournisseurMateriauxId(pMateriaux.getId(), pFournisseur.getId()));
		} else {

			throw new WebbatiException("IMateriaux et Fournisseur ne peuvent pas être NULL. IMateriaux=" + (pMateriaux == null ? "NULL" : "")
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
	public IMateriaux getMateriaux() throws WebbatiException {
		IMateriaux mx = ApplicationWb.getApplication().getMateriauxBibManager().getById(getId().getMateriauxId());
		if (mx == null) {
			mx = ApplicationWb.getApplication().getMateriauxEtudeManager().getById(getId().getMateriauxId());
		}

		return mx;
	}

	@Override
	public void setMateriaux(IMateriaux pMateriaux) throws WebbatiException {
		if (pMateriaux != null) {
			getId().setMateriauxId(pMateriaux.getId());
		} else {
			throw new WebbatiException("Le Materiaux ne peut pas être vide");
		}
	}

	@Override
	public IFournisseur getFournisseur() throws WebbatiException {
		return ApplicationWb.getApplication().getFournisseurManager().getById(getId().getFournisseurId());
	}

	@Override
	public void setFournisseur(IFournisseur pFournisseur) throws WebbatiException {
		if (pFournisseur != null) {
			getId().setFournisseurId(pFournisseur.getId());
		} else {
			throw new WebbatiException("Le Fournisseur ne peut pas être vide");
		}
	}
}
