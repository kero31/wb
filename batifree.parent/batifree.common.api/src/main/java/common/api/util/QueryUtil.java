package common.api.util;

import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>QueryUtil</b><br/>
 *
 */
public class QueryUtil {

	/**
	 * Exécute un script SQL à partir d'une connection
	 * 
	 * @param pConnection connection de la database
	 * @param pFilename nom du fichier script SQL
	 * @throws BatifreeException
	 */
	public void executeScript(Connection pConnection, String pFilename) throws BatifreeException {
		// Récup du reader par rapport au filename
		Reader read;
		try {
			read = new FileReader(pFilename);
		} catch (FileNotFoundException e) {
			throw new BatifreeException("Erreur lecture fichier : " + pFilename, e);
		}

		SQLScriptRunner run = new SQLScriptRunner(pConnection, false, true);
		try {
			run.runScript(read);
		} catch (IOException | SQLException e) {
			throw new BatifreeException("Erreur execute script : " + pFilename, e);
		}
	}

	/**
	 * Exécute un script SQL
	 * 
	 * @param pDriver driver
	 * @param pUrl url
	 * @param pLogin login
	 * @param pPassword password
	 * @param pFilename filename
	 * @throws BatifreeException
	 */
	public void executeScript(String pDriver, String pUrl, String pLogin, String pPassword, String pFilename) throws BatifreeException {
		// Connection
		try {
			Class.forName(pDriver);
		} catch (ClassNotFoundException e) {
			throw new BatifreeException(e);
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(pUrl, pLogin, pPassword);
		} catch (SQLException e) {
			throw new BatifreeException("Connection impossible", e);
		}
		if (connection == null) {
			throw new BatifreeException("La Connection est null");
		}

		// Exécute le script SQL à partir de la connection
		executeScript(connection, pFilename);
	}

	/**
	 * Exécute une requête sur une connection externe
	 * 
	 * @param pDriver driver
	 * @param pUrl url
	 * @param pLogin login
	 * @param pPassword password
	 * @param pQuery requête
	 * @throws BatifreeException
	 */
	public void executeQueryFromExternConnection(String pDriver, String pUrl, String pLogin, String pPassword, String pQuery)
			throws BatifreeException {
		List<String> queries = new ArrayList<>();
		queries.add(pQuery);
		executeQueriesFromExternConnection(pDriver, pUrl, pLogin, pPassword, queries);
	}

	/**
	 * Exécute une liste de requêtes sur une connection externe
	 * 
	 * @param pDriver driver
	 * @param pUrl url
	 * @param pLogin login
	 * @param pPassword password
	 * @param pQueries liste de requêtes
	 * @throws BatifreeException
	 */
	public void executeQueriesFromExternConnection(String pDriver, String pUrl, String pLogin, String pPassword, List<String> pQueries)
			throws BatifreeException {
		// Connection
		try {
			Class.forName(pDriver);
		} catch (ClassNotFoundException e) {
			throw new BatifreeException(e);
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(pUrl, pLogin, pPassword);
		} catch (SQLException e) {
			throw new BatifreeException("Connection impossible", e);
		}
		if (connection == null) {
			throw new BatifreeException("La Connection est null");
		}

		// Requêtage dans une transaction
		Statement stat = null;
		try {
			// transaction block start
			connection.setAutoCommit(false);

			// Parcours la liste des queries
			for (String query : pQueries) {
				stat = connection.createStatement();
				String queryUpper = query.toUpperCase();
				if (queryUpper.startsWith("SELECT")) {
					stat.executeQuery(query);
				} else {
					stat.executeUpdate(query);
				}
			}

			// transaction block end
			connection.commit();
		} catch (SQLException e) {
			try {
				// transaction block end
				connection.rollback();
			} catch (SQLException e1) {
				throw new BatifreeException(e);
			}
			throw new BatifreeException("Erreur exécution queries à cause de " + e.getMessage());
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new BatifreeException(e);
			}
		}
	}
}
