package batifree.api.metier.ejb;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODE_PAIEMENT")
@SuppressWarnings("serial")
public class ModePaiement implements java.io.Serializable {

	private Integer id;
	private String libelle;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MP_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MP_LIBELLE")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String pLibelle) {
		libelle = pLibelle;
	}
}
