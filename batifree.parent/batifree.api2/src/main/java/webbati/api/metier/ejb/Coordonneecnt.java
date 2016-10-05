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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Coordonneecnt generated by hbm2java
 */
@Entity
@Table(name = "COORDONNEECNT")
@SuppressWarnings("serial")
public class Coordonneecnt implements java.io.Serializable {

	private Integer id;
	private Localisation localisation;
	private Integer localisationId;
	private Client client;
	private Integer clientId;
	private Pays pays;
	private Integer paysId;
	private Civilite civilite;
	private Integer civiliteId;
	private String nom;
	private String prenom;
	private String rue;
	private String complementaire;
	private String cp;
	private String ville;
	private String tel1;
	private String tel2;
	private String fax;
	private String mobile;
	private String mail;
	private String mail2;
	private String web;
	private Set<Detailcnt> detailcnts = new HashSet<Detailcnt>(0);
	private Set<Contact> contacts = new HashSet<Contact>(0);

	public Coordonneecnt() {
	}

	public Coordonneecnt(Localisation localisation, Client client, Pays pays, Civilite civilite, String nom, String prenom, String rue,
			String complementaire, String cp, String ville, String tel1, String tel2, String fax, String mobile, String mail, String mail2,
			String web, Set<Detailcnt> detailcnts, Set<Contact> contacts) {
		this.localisation = localisation;
		this.client = client;
		this.pays = pays;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.complementaire = complementaire;
		this.cp = cp;
		this.ville = ville;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.fax = fax;
		this.mobile = mobile;
		this.mail = mail;
		this.mail2 = mail2;
		this.web = web;
		this.detailcnts = detailcnts;
		this.contacts = contacts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COO_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOC_ID", insertable = false, updatable = false)
	public Localisation getLocalisation() {
		return this.localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	@Column(name = "LOC_ID")
	public Integer getLocalisationId() {
		return this.localisationId;
	}

	public void setLocalisationId(Integer localisationId) {
		this.localisationId = localisationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CNT_ID", insertable = false, updatable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "CNT_ID")
	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAY_ID", insertable = false, updatable = false)
	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Column(name = "PAY_ID")
	public Integer getPaysId() {
		return this.paysId;
	}

	public void setPaysId(Integer paysId) {
		this.paysId = paysId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIV_ID", insertable = false, updatable = false)
	public Civilite getCivilite() {
		return this.civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	@Column(name = "CIV_ID")
	public Integer getCiviliteId() {
		return this.civiliteId;
	}

	public void setCiviliteId(Integer civiliteId) {
		this.civiliteId = civiliteId;
	}

	@Column(name = "COO_NOM", length = 40)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "COO_PRENOM", length = 40)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "COO_RUE", length = 35)
	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(name = "COO_COMPLEMENTAIRE", length = 35)
	public String getComplementaire() {
		return this.complementaire;
	}

	public void setComplementaire(String complementaire) {
		this.complementaire = complementaire;
	}

	@Column(name = "COO_CP", length = 10)
	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Column(name = "COO_VILLE", length = 36)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "COO_TEL1", length = 21)
	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@Column(name = "COO_TEL2", length = 21)
	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Column(name = "COO_FAX", length = 21)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "COO_MOBILE", length = 21)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "COO_MAIL", length = 69)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "COO_MAIL2", length = 69)
	public String getMail2() {
		return this.mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	@Column(name = "COO_WEB", length = 69)
	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coordonneecnt")
	public Set<Detailcnt> getDetailcnts() {
		return this.detailcnts;
	}

	public void setDetailcnts(Set<Detailcnt> detailcnts) {
		this.detailcnts = detailcnts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coordonneecnt")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
