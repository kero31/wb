/***********************************************************************
 * Module: IAdminDatabaseDao.java Author: Kero Purpose: Defines the Interface IAdminDatabaseDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import admin.api.metier.interfaces.IConnectiondb;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IAdminDatabaseDao</b><br/>
 */
public interface IAdminDatabaseDao {

	/**
	 * Supprime la base de données du nom pBdName en utilisant la connection..
	 * 
	 * @param pBdName le nom de la base de données
	 * @param pBdLogin le login de l'utilisateur de la base de données
	 * @param pConnectionDb la connection
	 * @param pBdClientHost le nom du client host
	 * @param pIsBdPasswordEncoded TRUE si le mot de passe de la base de données est encodé, FALSE sinon
	 * @throws BatifreeException BatifreeException
	 */
	void dropDatase(String pBdName, String pBdLogin, IConnectiondb pConnectionDb, String pBdClientHost, boolean pIsBdPasswordEncoded)
	        throws BatifreeException;

	/**
	 * Retourne l'id de la connection la plus appropriée.
	 * 
	 * @return id de la connection la plus appropriée
	 * @throws BatifreeException BatifreeException
	 */
	Integer getConnectionIdDefault() throws BatifreeException;

	/**
	 * Retourne le nombre de projectscript mis à jour à partir de l'id du userproject.
	 * 
	 * @param pUserAppliId id du user pour mettre à jour les infos
	 * @param pProjectId id du projet pour mettre à jour les infos
	 * @param pProjectscript id du projectscript à mettre à jour dans le userproject
	 * @return nombre de projectscript mis à jour
	 * @throws BatifreeException BatifreeException
	 */
	int updateProjectscriptFromUserprojectId(Integer pUserAppliId, Integer pProjectId, Integer pProjectscript) throws BatifreeException;

	/**
	 * Crée un user et une base de données pour ce user
	 * 
	 * @param pDatabaseName bdDbName
	 * @param pLogin login
	 * @param pPassword password
	 * @param pDriver driver
	 * @param pUrl url
	 * @param pRootLogin rootLogin
	 * @param pRootPassword rootPassword
	 * @param pBdClientHost le nom du client host
	 * @throws BatifreeException BatifreeException
	 */
	void createUserDatabase(String pDatabaseName, String pLogin, String pPassword, String pDriver, String pUrl, String pRootLogin,
	        String pRootPassword, String pBdClientHost) throws BatifreeException;

}