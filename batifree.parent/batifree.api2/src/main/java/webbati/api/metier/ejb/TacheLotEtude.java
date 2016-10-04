/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <TacheEtude>.
 * 
 */
@Entity
@Table(name = "TACHE_LOT_ETUDE")
public class TacheLotEtude extends TacheLot implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}