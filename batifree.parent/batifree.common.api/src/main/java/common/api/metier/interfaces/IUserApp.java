/**
 * 
 */

package common.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IUserApp</b><br/>
 */
public interface IUserApp {

	/**
	 * Obtient la valeur de la propriété bdDialect.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getBdDialect();

	/**
	 * Obtient la valeur de la propriété bdDriver.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getBdDriver();

	/**
	 * Obtient la valeur de la propriété bdLogin.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getBdLogin();

	/**
	 * Obtient la valeur de la propriété bdPassword.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getBdPassword();

	/**
	 * Obtient la valeur de la propriété bdURL.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getBdURL();

	/**
	 * Gets the value of the listRole property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
	 * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the listRole property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getListRole().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 * 
	 * 
	 * @return @return liste des rôles
	 */
	List<String> getListRole();

	/**
	 * Obtient la valeur de la propriété password.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getPassword();

	/**
	 * Obtient la valeur de la propriété username.
	 * 
	 * 
	 * @return @return possible object is {@link String }
	 */
	String getUsername();

	/**
	 * Obtient la valeur de la propriété bd schema.
	 * 
	 * 
	 * @return @return bd schema
	 */
	String getBdShema();

	/**
	 * Met à jour le user app à partir des infos du user passé en paramètre.
	 * 
	 * 
	 * @param pUser user
	 */
	void updateInfoUserApp(IUserApp pUser);

	/**
	 * Vérifie la validité des infos de l'user.
	 * 
	 * 
	 * @return @return TRUE si ok, FALSE sinon
	 * @throws WebbatiException WebbatiException
	 */
	Boolean isValid() throws WebbatiException;

	/**
	 * Retourne si bloqué ou pas.
	 * 
	 * 
	 * @return @return TRUE si le user est bloqué, FALSE sinon
	 */
	Boolean getLocked();

}