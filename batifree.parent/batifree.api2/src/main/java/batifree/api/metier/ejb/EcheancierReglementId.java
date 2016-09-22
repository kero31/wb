package batifree.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EcheancierReglementId generated by hbm2java
 */
@Embeddable
@SuppressWarnings("serial")
public class EcheancierReglementId implements java.io.Serializable {

	private int echeancierId;
	private int reglementId;

	public EcheancierReglementId() {
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pEcheancierId echeancier id
	 * @param pReglementId reglement id
	 */
	public EcheancierReglementId(int pEcheancierId, int pReglementId) {
		this.echeancierId = pEcheancierId;
		this.reglementId = pReglementId;
	}

	@Column(name = "ECH_ID", nullable = false)
	public int getEcheancierId() {
		return this.echeancierId;
	}

	public void setEcheancierId(int id) {
		this.echeancierId = id;
	}

	@Column(name = "REG_ID", nullable = false)
	public int getReglementId() {
		return this.reglementId;
	}

	public void setReglementId(int id) {
		this.reglementId = id;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof EcheancierReglementId)) {
			return false;
		}
		EcheancierReglementId castOther = (EcheancierReglementId) other;

		return (this.getEcheancierId() == castOther.getEcheancierId()) && (this.getReglementId() == castOther.getReglementId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEcheancierId();
		result = 37 * result + this.getReglementId();
		return result;
	}

}
