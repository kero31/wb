/***********************************************************************
 * Module: IVScriptUpdate.java Author: Kero Purpose: Defines the Interface IVScriptUpdate
 ***********************************************************************/

package admin.api.metier.interfaces;

/**
 * Interface <b>IVScriptUpdate</b><br/>
 */
public interface IVScriptUpdate {

	/**
	 * Retourne l'url.
	 * 
	 * @return l'url
	 */
	String getUrl();

	/**
	 * Retourne le driver.
	 * 
	 * @return le driver
	 */
	String getDriver();

	/**
	 * Retourne le login.
	 * 
	 * @return le login
	 */
	String getLogin();

	/**
	 * Retourne le mot de passe.
	 * 
	 * @return le mot de passe
	 */
	String getPassword();

	/**
	 * Retourne l'id du user
	 * 
	 * @return l'id du user
	 */
	Integer getUserAppliId();

	/**
	 * Retourne l'id du projectscript
	 * 
	 * @return l'id du projectscript
	 */
	Integer getProjectscriptId();

	/**
	 * Retourne le nom du fichier.
	 * 
	 * @return le nom du fichier
	 */
	String getFilename();

}