/**
 * 
 */

package common.api.application.interfaces;

import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
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
	 * @throws BatifreeUserException, BatifreeException BatifreeUserException, BatifreeException
	 */
	void setUserApp(IUserApp pUser) throws BatifreeUserException, BatifreeException;

	/**
	 * Met à jour le user à partir du username.
	 * 
	 * 
	 * @param pUsername login
	 * @param pPassword mot de passe
	 * @throws BatifreeUserException BatifreeUserException
	 */
	void loadUserByUsernamePassword(String pUsername, String pPassword) throws BatifreeUserException;

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
	 * @throws BatifreeException BatifreeException
	 */
	void deconnection() throws BatifreeException;

	/**
	 * Retourne le service Impression.
	 * 
	 * @return Impression service
	 */
	IImpression getImpression();

}