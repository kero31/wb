/**
 * 
 */
package batifree.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <TacheBib>.
 * 
 */
@Entity
@Table(name = "TACHE_LOT_BIB")
public class TacheLotBib extends TacheLot implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}