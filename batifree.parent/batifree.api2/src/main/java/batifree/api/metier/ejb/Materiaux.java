package batifree.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Materiaux generated by hbm2java
 */
@Entity
@Table(name = "MATERIAUX")
@PrimaryKeyJoinColumn(name = "BIB_ID", referencedColumnName = "BIB_ID")
@SuppressWarnings("serial")
public abstract class Materiaux extends Bibliotheque implements java.io.Serializable {

	private Fournisseur fournisseur;
	private Integer fournisseurId;
	private Float prixTarif;
	private Float remise;
	private Set<FournisseurMateriaux> fournisseurMateriauxes = new HashSet<FournisseurMateriaux>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FRN_DEFAUT", insertable = false, updatable = false)
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Column(name = "FRN_DEFAUT")
	public Integer getFournisseurDefautId() {
		return this.fournisseurId;
	}

	public void setFournisseurDefautId(Integer fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	@Column(name = "MX_PRIX_TARIF", precision = 8)
	public Float getPrixTarif() {
		return this.prixTarif;
	}

	public void setPrixTarif(Float prixTarif) {
		this.prixTarif = prixTarif;
	}

	@Column(name = "MX_REMISE", precision = 5)
	public Float getRemise() {
		return this.remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiaux")
	public Set<FournisseurMateriaux> getFournisseurMateriauxes() {
		return this.fournisseurMateriauxes;
	}

	public void setFournisseurMateriauxes(Set<FournisseurMateriaux> fournisseurMateriauxes) {
		this.fournisseurMateriauxes = fournisseurMateriauxes;
	}

}