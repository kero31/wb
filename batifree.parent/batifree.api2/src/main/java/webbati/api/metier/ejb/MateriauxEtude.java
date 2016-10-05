/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <MateriauxEtude>.
 * 
 */
@Entity
@Table(name = "MATERIAUX_ETUDE")
public class MateriauxEtude extends Materiaux implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
