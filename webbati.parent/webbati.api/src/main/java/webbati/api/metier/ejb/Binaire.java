package webbati.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Binaire generated by hbm2java
 */
@Entity
@Table(name = "BINAIRE")
@SuppressWarnings("serial")
public class Binaire implements java.io.Serializable {

	private Integer id;
	private byte[] objet;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BIN_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "BIN_OBJET")
	public byte[] getObjet() {
		return this.objet;
	}

	public void setObjet(byte[] objet) {
		this.objet = objet;
	}
}
