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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Groupecnt generated by hbm2java
 */
@Entity
@Table(name = "GROUPECNT")
@SuppressWarnings("serial")
public class Groupecnt implements java.io.Serializable {

	private Integer id;
	private Set<Diverscnt> diverscnts = new HashSet<Diverscnt>(0);
	private String libelle;

	public Groupecnt() {
	}

	public Groupecnt(Set<Diverscnt> diverscnts) {
		this.diverscnts = diverscnts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GRP_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groupecnts")
	public Set<Diverscnt> getDiverscnts() {
		return this.diverscnts;
	}

	public void setDiverscnts(Set<Diverscnt> diverscnts) {
		this.diverscnts = diverscnts;
	}

	@Column(name = "GRP_LIBELLE")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String pLibelle) {
		libelle = pLibelle;
	}

}
