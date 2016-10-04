/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <SoustraitantEtude>.
 * 
 */
@Entity
@Table(name = "SOUSTRAITANT_ETUDE")
public class SoustraitantEtude extends Soustraitant implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}