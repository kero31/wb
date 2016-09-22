/**
 * 
 */

package common.api.application.interfaces;

import java.sql.Connection;

import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.metier.interfaces.IUserApp;

/**
 * Interface <b>IUserService</b><br/>
 * 
 * Interface <IUserService>
 * 
 * Classe <IUserService>.
 * 
 * 
 * 
 * @author Kero
 */
public interface IUserService {

	/**
	 * Retourne la transaction.
	 * 
	 * 
	 * @return la transaction
	 * @throws BatifreeException BatifreeException
	 */
	ITransaction getTransaction() throws BatifreeException;

	/**
	 * Retourne l'utilisateur courant.
	 * 
	 * 
	 * @return l'utilisateur courant
	 * 
	 * @throws BatifreeUserException, BatifreeException BatifreeUserException, BatifreeException
	 */
	IUserApp getUser() throws BatifreeUserException, BatifreeException;

	/**
	 * Met à jour les infos de user app.
	 * 
	 * 
	 * @param pUserApp info à mettre à jour
	 * @throws BatifreeUserException, BatifreeException BatifreeUserException, BatifreeException
	 */
	void updateInfoUserApp(IUserApp pUserApp) throws BatifreeUserException, BatifreeException;

	/**
	 * Valide l'utilisateur.
	 * 
	 * 
	 * @return TRUE si le check a été validé, FALSE sinon
	 * @throws BatifreeException BatifreeException
	 */
	boolean checkValidUser() throws BatifreeException;

	/**
	 * Ferme les sessions courante.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void closeSessions() throws BatifreeException;

	/**
	 * Retourne si on est en session WEB ou non
	 * 
	 * 
	 * @return session WEB ou non
	 */
	boolean isSessionWeb();

	/**
	 * Spécifie le type de session WEB.
	 * 
	 * 
	 * @param pSessionWeb TRUE si on veut en session WEB, FALSE sinon
	 */
	void setSessionWeb(boolean pSessionWeb);

	/**
	 * Met à jour le champ bdPasswordEncoded .
	 * 
	 * 
	 * @param pBdPasswordEncoded le bdPasswordEncoded à mettre à jour
	 */
	void setBdPasswordEncoded(boolean pBdPasswordEncoded);

	/**
	 * Retourne si le mot de la base de données est encodée.
	 * 
	 * 
	 * @return TRUE si le mot de la base de données est encodée, FALSE sinon
	 */
	boolean isBdPasswordEncoded();

	/**
	 * Récupère une connection SQL.
	 * 
	 * 
	 * @return connection SQL
	 * @throws BatifreeException BatifreeException
	 */
	Connection getConnectionSQL() throws BatifreeException;

}