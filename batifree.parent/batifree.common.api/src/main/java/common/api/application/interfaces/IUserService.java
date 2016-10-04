/**
 * 
 */

package common.api.application.interfaces;

import java.sql.Connection;

import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
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
	 * @throws WebbatiException WebbatiException
	 */
	ITransaction getTransaction() throws WebbatiException;

	/**
	 * Retourne l'utilisateur courant.
	 * 
	 * 
	 * @return l'utilisateur courant
	 * 
	 * @throws WebbatiUserException, WebbatiException WebbatiUserException, WebbatiException
	 */
	IUserApp getUser() throws WebbatiUserException, WebbatiException;

	/**
	 * Met à jour les infos de user app.
	 * 
	 * 
	 * @param pUserApp info à mettre à jour
	 * @throws WebbatiUserException, WebbatiException WebbatiUserException, WebbatiException
	 */
	void updateInfoUserApp(IUserApp pUserApp) throws WebbatiUserException, WebbatiException;

	/**
	 * Valide l'utilisateur.
	 * 
	 * 
	 * @return TRUE si le check a été validé, FALSE sinon
	 * @throws WebbatiException WebbatiException
	 */
	boolean checkValidUser() throws WebbatiException;

	/**
	 * Ferme les sessions courante.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void closeSessions() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	Connection getConnectionSQL() throws WebbatiException;

}