/***********************************************************************
 * Module: IConnectiondb.java Author: Kero Purpose: Defines the Interface IConnectiondb
 ***********************************************************************/

package admin.api.metier.interfaces;

import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IConnectiondb</b><br/>
 */
public interface IConnectiondb extends IMetier<Integer> {

	/**
	 * Retourne le driver.
	 * 
	 * @return Driver
	 */
	String getDriver();

	/**
	 * Met à jour le driver.
	 * 
	 * @param pDriver le driver
	 */
	void setDriver(String pDriver);

	/**
	 * Retourne le dialect.
	 * 
	 * @return Dialect
	 */
	String getDialect();

	/**
	 * Met à jour le dialect.
	 * 
	 * @param pDialect le dialect
	 */
	void setDialect(String pDialect);

	/**
	 * Retourne la limite du nombre d'utilisateurs sur la connection. Si la limite est dépassée une alerte doit être gérée.
	 * 
	 * @return Limite du nombre d'utilisateurs sur la connection
	 */
	Integer getLimitUserAlert();

	/**
	 * Met à jour la limite du nombre d'utilisateurs sur la connection.
	 * 
	 * @param pLimitUserAlert la limite du nombre d'utilisateurs sur la connection
	 */
	void setLimitUserAlert(Integer pLimitUserAlert);

	/**
	 * Retourne le nom de la base de données pour le root.
	 * 
	 * @return Nom de la base de données pour le root
	 */
	String getRootDbname();

	/**
	 * Met à jour le nom de la base de données pour le root
	 * 
	 * @param pRootDbname le nom de la base de données pour le root
	 */
	void setRootDbname(String pRootDbname);

	/**
	 * Retourne le login du root.
	 * 
	 * @return Login du root
	 */
	String getRootLogin();

	/**
	 * Met à jour le login du root.
	 * 
	 * @param pRootLogin le login root
	 */
	void setRootLogin(String pRootLogin);

	/**
	 * Retourne le mot de passe du root.
	 * 
	 * @return Mot de passe du root
	 */
	String getRootPassword();

	/**
	 * Met à jour le mot de passe du root
	 * 
	 * @param pRootPassword le mot de passe du root
	 */
	void setRootPassword(String pRootPassword);

	/**
	 * Retourne l'URL de connection.
	 * 
	 * @return URL de connection
	 */
	String getUrl();

	/**
	 * Met à jour l'URL de connection
	 * 
	 * @param pUrl l'URL de connection
	 */
	void setUrl(String pUrl);

	/**
	 * Retourne la validité de la connection.
	 * 
	 * @return TRUE si la connection est valide, sinon FALSE
	 */
	java.lang.Boolean isEnabled();

	/**
	 * Met à jour la validité de la connection
	 * 
	 * @param pEnabled TRUE si la connection est enable, else FALSE
	 */
	void setEnabled(java.lang.Boolean pEnabled);

}