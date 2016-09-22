/***********************************************************************
 * Module: IUserAppli.java Author: Kero Purpose: Defines the Interface IUserAppli
 ***********************************************************************/

package admin.api.metier.interfaces;

import java.util.Date;
import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IUserAppli</b><br/>
 */
public interface IUserAppli extends IMetier<Integer> {

	/**
	 * Retourne le username.
	 * 
	 * @return Username
	 */
	String getUsername();

	/**
	 * Met à jour le username.
	 * 
	 * @param pUsername Le username
	 */
	void setUsername(String pUsername);

	/**
	 * Retourne la date de création.
	 * 
	 * @return Date de création
	 */
	Date getDateCreate();

	/**
	 * Met à jour la date de création.
	 * 
	 * @param pDateCreate La date de création.
	 */
	void setDateCreate(Date pDateCreate);

	/**
	 * Retourne la date d'expiration.
	 * 
	 * @return Date d'expiration
	 */
	Date getDateExpired();

	/**
	 * Met à jour la date d'expiration.
	 * 
	 * @param pDateExpired La date d'expiration.
	 */
	void setDateExpired(Date pDateExpired);

	/**
	 * Retourne le mot de passe encodé.
	 * 
	 * @return Mot de passe
	 */
	String getPassword();

	/**
	 * Met à jour le mot de passe encodé.
	 * 
	 * @param pPassword Le mot de passe.
	 */
	void setPassword(String pPassword);

	/**
	 * Retourne le mail.
	 * 
	 * @return Mail
	 */
	String getMail();

	/**
	 * Met à jour le mail.
	 * 
	 * @param pMail Le mail.
	 */
	void setMail(String pMail);

	/**
	 * Retourne TRUE si l'utilisateur est locké, FALSE sinon.
	 * 
	 * @return TRUE si l'utilisateur est locké, FALSE sinon
	 */
	Boolean isLocked();

	/**
	 * Met à jour le champs locked.
	 * 
	 * @param pLocked Le champs locked. TRUE si l'utilisateur est locké, FALSE sinon.
	 */
	void setLocked(Boolean pLocked);

	/**
	 * Retourne la liste des rôles.
	 * 
	 * @return Liste des rôles
	 * @throws BatifreeException BatifreeException
	 */
	List<IRole> getListRole() throws BatifreeException;

	/**
	 * Met à jour la liste des rôles.
	 * 
	 * @param pListRole liste des rôles
	 */
	void setListRole(List<IRole> pListRole);

	/**
	 * Retourne la liste des projets.
	 * 
	 * @return Liste des projets
	 * @throws BatifreeException BatifreeException
	 */
	List<IUserproject> getListUserproject() throws BatifreeException;

	/**
	 * Retourne le userappli parent
	 * 
	 * @return userappli parent
	 * @throws BatifreeException BatifreeException
	 */
	IUserAppli getUserappliParent() throws BatifreeException;

	/**
	 * Met à jour le userappli parent
	 * 
	 * @param pUserappliParent Userappli Parent
	 */
	void setUserappliParent(IUserAppli pUserappliParent);

}