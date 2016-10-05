package webbati.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Activite generated by hbm2java
 */
@Entity
@Table(name = "ACTIVITE")
@SuppressWarnings("serial")
public class Activite implements java.io.Serializable {

	private Integer id;
	private String libelle;
	private Set<Contact> contacts = new HashSet<Contact>(0);

	public Activite() {
	}

	public Activite(String libelle, Set<Contact> contacts) {
		this.libelle = libelle;
		this.contacts = contacts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACT_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ACT_LIBELLE", length = 30)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activite")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
