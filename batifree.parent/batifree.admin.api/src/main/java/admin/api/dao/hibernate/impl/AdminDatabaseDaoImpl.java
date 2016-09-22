/**
 * 
 */
package admin.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.dao.interfaces.IAdminDatabaseDao;
import admin.api.metier.interfaces.IConnectiondb;

import common.api.dao.hibernate.util.QueryHibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.exception.BatifreeException;
import common.api.util.EncodingTools;

/**
 * Classe <AdminDatabaseDao>.
 * 
 * @author Kero
 * 
 */
@Repository("ADMIN_AdminDatabaseDao")
public class AdminDatabaseDaoImpl implements IAdminDatabaseDao {

	private QueryHibernateUtil queryUtil;

	/**
	 * Retourne le QueryHibernateUtil.
	 * 
	 * @return le QueryHibernateUtil
	 * @throws BatifreeException
	 */
	private QueryHibernateUtil getQueryHibernateUtil() throws BatifreeException {
		if (queryUtil == null) {
			queryUtil = new QueryHibernateUtil((UserServiceHibernateImpl) ApplicationAdmin.getApplication().getUserService());
		}
		return queryUtil;
	}

	@Override
	public void dropDatase(String pBdName, String pBdLogin, IConnectiondb pConnectionDb, String pBdClientHost, boolean pIsBdPasswordEncoded)
	        throws BatifreeException {
		if (pConnectionDb == null) {
			throw new BatifreeException("La connection du userproject ne peut pas être vide");
		}
		String rootDbName = pConnectionDb.getRootDbname();
		if (rootDbName == null || rootDbName.isEmpty()) {
			throw new BatifreeException("La db admin de la connection du userproject ne peut pas être vide");
		}
		String url = pConnectionDb.getUrl();
		if (url == null || url.isEmpty()) {
			throw new BatifreeException("L'url de la connection du userproject ne peut pas être vide");
		}
		String rootLogin = pConnectionDb.getRootLogin();
		if (rootLogin == null || rootLogin.isEmpty()) {
			throw new BatifreeException("Le login admin de la connection du userproject ne peut pas être vide");
		}
		String rootPassword = pConnectionDb.getRootPassword();
		if (pIsBdPasswordEncoded) {
			String rootPasswordClear = rootLogin + "_" + EncodingTools.ENCODING_KEY + "_" + rootDbName;
			String rootPasswordEncoded = EncodingTools.encode(rootPasswordClear, EncodingTools.ENCODING_MD5);
			if (rootPasswordEncoded == null || !rootPasswordEncoded.equals(rootPassword)) {
				throw new BatifreeException("createDatabaseForUserProject - Le mot de passe connection est incorrect");
			}
			rootPassword = rootPasswordClear;
		}

		List<String> queries = new ArrayList<>();

		// Drop database
		queries.add("DROP DATABASE IF EXISTS " + pBdName);

		// Drop user
		queries.add("DROP USER '" + pBdLogin + "'@'" + pBdClientHost + "'");

		// Execute queries
		getQueryHibernateUtil().executeQueriesFromExternConnection(pConnectionDb.getDriver(), url + rootDbName, rootLogin, rootPassword, queries);
	}

	@Override
	public Integer getConnectionIdDefault() throws BatifreeException {
		String reqMinUser = "select min(CON_ID) from V_CONNECTIONDB "
		        + "where NB_USER_RESTANT = (select min(NB_USER_RESTANT) from V_CONNECTIONDB where NB_USER_RESTANT > 0)";
		Integer idConn = getQueryHibernateUtil().executeQueryUniqueResult(reqMinUser, Integer.class);
		if (idConn == null) {
			String reqMaxUser = "select min(CON_ID) from V_CONNECTIONDB "
			        + "where NB_USER_RESTANT = (select max(NB_USER_RESTANT) from V_CONNECTIONDB where NB_USER_RESTANT <= 0)";
			idConn = getQueryHibernateUtil().executeQueryUniqueResult(reqMaxUser, Integer.class);

		}
		return idConn;
	}

	@Override
	public int updateProjectscriptFromUserprojectId(Integer pUserAppliId, Integer pProjectId, Integer pProjectscript) throws BatifreeException {
		// enregistre dans le user project, la version courante du script
		// On passe par une requête pour améliorer les temps de perf et éviter de faire plein de requêtes
		String reqUpdate = "update USERPROJECT set PSR_ID=" + pProjectscript + " where USE_ID=" + pUserAppliId + " AND PRO_ID=" + pProjectId;
		return getQueryHibernateUtil().executeUpdateQuery(reqUpdate);
	}

	@Override
	public void createUserDatabase(String pDatabaseName, String pLogin, String pPassword, String pDriver, String pUrl, String pRootLogin,
	        String pRootPassword, String pBdClientHost) throws BatifreeException {
		// Liste des requêtes à exécuter
		List<String> queries = new ArrayList<String>();

		// Crée l'utilisateur
		queries.add("CREATE USER '" + pLogin + "'@'" + pBdClientHost + "' IDENTIFIED BY  '" + pPassword + "'");

		// Crée la base de données
		queries.add("CREATE DATABASE IF NOT EXISTS  `" + pDatabaseName + "`");

		// Ajoute les droits d'accès sur cet utilisateur sur sa base de données
		queries.add("GRANT USAGE ON `" + pDatabaseName + "` . * TO  '" + pLogin + "'@'" + pBdClientHost + "' IDENTIFIED BY  '" + pPassword + "' "
		        + "WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0");

		// Rajoute les droits d'accès sur cette base
		queries.add("GRANT SELECT, INSERT, UPDATE, DELETE ON  `" + pDatabaseName + "` . * TO  '" + pLogin + "'@'" + pBdClientHost + "'");

		// Lance l'exécution des requêtes sur la connection de l'userproject avec le compte admin sur cette base
		getQueryHibernateUtil().executeQueriesFromExternConnection(pDriver, pUrl, pRootLogin, pRootPassword, queries);
	}

}
