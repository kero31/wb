/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <MainoeuvreEtude>.
 * 
 */
@Entity
@Table(name = "MAINOEUVRE_ETUDE")
public class MainoeuvreEtude extends Mainoeuvre implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
