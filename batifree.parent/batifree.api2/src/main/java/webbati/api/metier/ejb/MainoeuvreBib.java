/**
 * 
 */
package webbati.api.metier.ejb;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe <MainoeuvreBib>.
 * 
 */
@Entity
@Table(name = "MAINOEUVRE_BIB")
public class MainoeuvreBib extends Mainoeuvre implements java.io.Serializable {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
