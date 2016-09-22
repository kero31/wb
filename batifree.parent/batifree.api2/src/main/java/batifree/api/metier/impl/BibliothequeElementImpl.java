/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.metier.interfaces.IBibliothequeElement;

/**
 * Classe <b>BibliothequeElementImpl</b>.
 * 
 */
public abstract class BibliothequeElementImpl extends BibliothequeImpl implements IBibliothequeElement {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String barCode;

	@Override
	public String getBarCode() {
		return barCode;
	}

	@Override
	public void setBarCode(String pBarCode) {
		barCode = pBarCode;
	}

	@Override
	public void setBenefice(Float pBenefice) {
		benefice = pBenefice;
	}

	@Override
	public void setFraisGeneraux(Float pFraisGeneraux) {
		fraisGeneraux = pFraisGeneraux;
	}

	@Override
	public void setPrixAchatUnitaire(Float pPrixAchatUnitaire) {
		prixAchatUnitaire = pPrixAchatUnitaire;
	}

	@Override
	public void setNumSerie(String pNumSerie) {
		numSerie = pNumSerie;
	}

	@Override
	public void setPrixRevientUnitaire(Float pPrixRevient) {
		prixRevientUnitaire = pPrixRevient;
	}

	@Override
	public void setPrixVenteUnitaire(Float pPrixVente) {
		prixVenteUnitaire = pPrixVente;
	}
}
