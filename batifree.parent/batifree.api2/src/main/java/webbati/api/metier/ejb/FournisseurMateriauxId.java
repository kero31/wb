package webbati.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FournisseurMateriauxId generated by hbm2java
 */
@Embeddable
@SuppressWarnings("serial")
public class FournisseurMateriauxId implements java.io.Serializable {

	private int materiauxId;
	private int fournisseurId;

	/**
	 * 
	 * Constructeur.
	 */
	public FournisseurMateriauxId() {
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pMateriauxId Materiaux Id
	 * @param pFournisseurId Fournisseur Id
	 */
	public FournisseurMateriauxId(int pMateriauxId, int pFournisseurId) {
		this.materiauxId = pMateriauxId;
		this.fournisseurId = pFournisseurId;
	}

	@Column(name = "BIB_ID", nullable = false)
	public int getMateriauxId() {
		return this.materiauxId;
	}

	public void setMateriauxId(int id) {
		this.materiauxId = id;
	}

	@Column(name = "CNT_ID", nullable = false)
	public int getFournisseurId() {
		return this.fournisseurId;
	}

	public void setFournisseurId(int id) {
		this.fournisseurId = id;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof FournisseurMateriauxId)) {
			return false;
		}
		FournisseurMateriauxId castOther = (FournisseurMateriauxId) other;

		return (this.getMateriauxId() == castOther.getMateriauxId()) && (this.getFournisseurId() == castOther.getFournisseurId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMateriauxId();
		result = 37 * result + this.getFournisseurId();
		return result;
	}

}