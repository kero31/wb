/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <SoustraitantBib>.
 * 
 */
@Entity
@Table(name = "SOUSTRAITANT_BIB")
public class SoustraitantBib extends Soustraitant implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}