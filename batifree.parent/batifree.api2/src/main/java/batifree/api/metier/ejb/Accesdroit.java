package batifree.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Accesdroit generated by hbm2java
 */
@Entity
@Table(name = "ACCESDROIT")
@SuppressWarnings("serial")
public class Accesdroit implements java.io.Serializable {

	private Integer id;

	public Accesdroit() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACC_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
