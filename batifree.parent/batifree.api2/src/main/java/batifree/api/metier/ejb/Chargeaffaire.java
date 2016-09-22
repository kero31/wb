package batifree.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chargeaffaire generated by hbm2java
 */
@Entity
@Table(name = "CHARGEAFFAIRE")
@SuppressWarnings("serial")
public class Chargeaffaire implements java.io.Serializable {

	private Integer id;

	public Chargeaffaire() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CHAFF_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
