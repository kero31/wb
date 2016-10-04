/**
 * 
 */

package common.api.application.interfaces;

import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
import common.api.metier.interfaces.IUserApp;

/**
 * Interface <b>IApplicationCommun</b><br/>
 */
public interface IApplicationCommun {

	/**
	 * Retourne la properties applicatif.
	 * 
	 * 
	 * 
	 * @return Properties applicatif
	 */
	IPropertiesApp getProperties();

	/**
	 * Enregistre le user courant.
	 * 
	 * 
	 * @param pUser user à enregistré
	 * @throws WebbatiUserException, WebbatiException WebbatiUserException, WebbatiException
	 */
	void setUserApp(IUserApp pUser) throws WebbatiUserException, WebbatiException;

	/**
	 * Met à jour le user à partir du username.
	 * 
	 * 
	 * @param pUsername login
	 * @param pPassword mot de passe
	 * @throws WebbatiUserException WebbatiUserException
	 */
	void loadUserByUsernamePassword(String pUsername, String pPassword) throws WebbatiUserException;

	/**
	 * Retourne le format applicatif
	 * 
	 * 
	 * @return Format applicatif
	 */
	IFormat getFormat();

	/**
	 * Retourne le service user.
	 * 
	 * 
	 * 
	 * @return Service user
	 */
	IUserService getUserService();

	/**
	 * Déconnecte l'application en fermant les sesssions.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void deconnection() throws WebbatiException;

	/**
	 * Retourne le service Impression.
	 * 
	 * @return Impression service
	 */
	IImpression getImpression();

}