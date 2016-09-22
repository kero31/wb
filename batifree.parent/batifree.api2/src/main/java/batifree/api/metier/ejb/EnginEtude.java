/**
 * 
 */
package batifree.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <EnginEtude>.
 * 
 */
@Entity
@Table(name = "ENGIN_ETUDE")
public class EnginEtude extends Engin implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
