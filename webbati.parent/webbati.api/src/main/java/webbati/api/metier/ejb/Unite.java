package webbati.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Unite generated by hbm2java
 */
@Entity
@Table(name = "UNITE")
@SuppressWarnings("serial")
public class Unite implements java.io.Serializable {

	private Integer id;
	private String ute;

	public Unite() {
	}

	public Unite(String ute) {
		this.ute = ute;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UTE_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "UTE", length = 5)
	public String getUte() {
		return this.ute;
	}

	public void setUte(String ute) {
		this.ute = ute;
	}

}
