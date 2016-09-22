package batifree.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import common.api.metier.ejb.ILigneEjb;

/**
 * Famille generated by hbm2java
 */
@Entity
@Table(name = "FAMILLE")
@SuppressWarnings("serial")
public class Famille implements java.io.Serializable, ILigneEjb {

	private Integer id;
	private Short type;
	private Integer ordre;
	private Integer borneGauche;
	private Integer borneDroite;
	private Integer niveau;
	private String descriptif;
	private Set<Bibliotheque> bibliotheques = new HashSet<Bibliotheque>(0);
	private Famille familleParent;
	private Integer familleParentId;

	public Famille() {
	}

	public Famille(Short type, Integer ordre, Integer borneGauche, Integer borneDroite, String descriptif, Set<Bibliotheque> bibliotheques) {
		this.type = type;
		this.ordre = ordre;
		this.borneGauche = borneGauche;
		this.borneDroite = borneDroite;
		this.descriptif = descriptif;
		this.bibliotheques = bibliotheques;
	}

	@Override
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FAM_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FAM_TYPE")
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "FAM_ORDRE", precision = 7, scale = 0)
	public Integer getOrdre() {
		return this.ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	@Override
	@Column(name = "FAM_BORNE_GAUCHE", precision = 7, scale = 0)
	public Integer getBorneGauche() {
		return this.borneGauche;
	}

	@Override
	public void setBorneGauche(Integer borneGauche) {
		this.borneGauche = borneGauche;
	}

	@Override
	@Column(name = "FAM_BORNE_DROITE", precision = 7, scale = 0)
	public Integer getBorneDroite() {
		return this.borneDroite;
	}

	@Override
	public void setBorneDroite(Integer borneDroite) {
		this.borneDroite = borneDroite;
	}

	@Column(name = "FAM_DESCRIPTIF", length = 100)
	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "famille")
	public Set<Bibliotheque> getBibliotheques() {
		return this.bibliotheques;
	}

	public void setBibliotheques(Set<Bibliotheque> bibliotheques) {
		this.bibliotheques = bibliotheques;
	}

	@Override
	@Column(name = "FAM_NIVEAU", precision = 7, scale = 0)
	public Integer getNiveau() {
		return this.niveau;
	}

	@Override
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAM_PARENT", insertable = false, updatable = false)
	public Famille getSuperParent() {
		return this.familleParent;
	}

	public void setSuperParent(Famille famParent) {
		this.familleParent = famParent;
	}

	@Override
	@Column(name = "FAM_PARENT")
	public Integer getSuperParentId() {
		return this.familleParentId;
	}

	@Override
	public void setSuperParentId(Integer famParentId) {
		this.familleParentId = famParentId;
	}
}
