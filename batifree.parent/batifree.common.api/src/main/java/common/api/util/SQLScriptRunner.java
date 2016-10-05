package common.api.util;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Tool to run database scripts
 */
public class SQLScriptRunner {

	private static final String DEFAULT_DELIMITER = ";";

	private Connection connection;

	private boolean stopOnError;
	private boolean autoCommit;
	private String delimiter = DEFAULT_DELIMITER;
	private boolean fullLineDelimiter = false;

	private static final Logger LOGGER = Logger.getLogger(SQLScriptRunner.class);

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pConnection connection
	 * @param pIsAutoCommit TRUE si autoCommit, FALSE sinon
	 * @param pIsStopOnError TRUE si stop sur Erreur, FALSE sinon
	 */
	public SQLScriptRunner(Connection pConnection, boolean pIsAutoCommit, boolean pIsStopOnError) {
		this.connection = pConnection;
		this.autoCommit = pIsAutoCommit;
		this.stopOnError = pIsStopOnError;
	}

	/**
	 * Set Delimiter
	 * 
	 * @param pDelimiter deletimer
	 * @param pFullLineDelimiter TRUE si ligne pleine delimiter
	 */
	public void setDelimiter(String pDelimiter, boolean pFullLineDelimiter) {
		this.delimiter = pDelimiter;
		this.fullLineDelimiter = pFullLineDelimiter;
	}

	/**
	 * Runs an SQL script (read in using the Reader parameter)
	 *
	 * @param pReader - the source of the script
	 * @throws IOException
	 * @throws SQLException
	 */
	public void runScript(Reader pReader) throws IOException, SQLException {
		boolean originalAutoCommit = connection.getAutoCommit();
		try {
			if (originalAutoCommit != this.autoCommit) {
				connection.setAutoCommit(this.autoCommit);
			}
			runScript(connection, pReader);
		} catch (SQLException | IOException e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.rollback();
				connection.setAutoCommit(originalAutoCommit);
				connection.close();
			}
		}
	}

	/**
	 * Runs an SQL script (read in using the Reader parameter) using the connection passed in
	 *
	 * @param pConnection - the connection to use for the script
	 * @param pReader - the source of the script
	 * @throws SQLException if any SQL errors occur
	 * @throws IOException
	 */
	private void runScript(Connection pConnection, Reader pReader) throws SQLException, IOException {
		StringBuffer command = null;
		Statement statement = null;
		try {
			LineNumberReader lineReader = new LineNumberReader(pReader);
			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (command == null) {
					command = new StringBuffer();
				}
				String trimmedLine = line.trim();
				if (trimmedLine.startsWith("--")) {
					println(trimmedLine);
				} else if (trimmedLine.length() < 1 || trimmedLine.startsWith("//")) {
					// Do nothing
					LOGGER.debug("Comment '//'");
				} else if (trimmedLine.length() < 1 || trimmedLine.startsWith("/*")) {
					// Do nothing
					LOGGER.debug("Comment '/*'");
				} else if (trimmedLine.length() < 1 || trimmedLine.startsWith("--")) {
					// Do nothing
					LOGGER.debug("Comment '--'");
				} else if (!fullLineDelimiter && trimmedLine.endsWith(getDelimiter()) || fullLineDelimiter && trimmedLine.equals(getDelimiter())) {
					command.append(line.substring(0, line.lastIndexOf(getDelimiter())));
					command.append(" ");
					statement = pConnection.createStatement();

					println(command);

					boolean hasResults = false;
					if (stopOnError) {
						hasResults = statement.execute(command.toString());
					} else {
						statement.execute(command.toString());
					}

					if (autoCommit && !pConnection.getAutoCommit()) {
						pConnection.commit();
					}

					ResultSet rs = statement.getResultSet();
					if (hasResults && rs != null) {
						ResultSetMetaData md = rs.getMetaData();
						int cols = md.getColumnCount();
						for (int i = 0; i < cols; i++) {
							String name = md.getColumnLabel(i);
							print(name + "\t");
						}
						println("");
						while (rs.next()) {
							for (int i = 0; i < cols; i++) {
								String value = rs.getString(i);
								print(value + "\t");
							}
							println("");
						}
					}

					command = null;
					statement.close();
					Thread.yield();
				} else {
					command.append(line);
					command.append(" ");
				}
			}
			if (!autoCommit) {
				pConnection.commit();
			}
		} catch (SQLException e) {
			if (command != null) {
				throw new SQLException("Commande : " + command.toString() + " - ", e);
			}
			throw e;
		} finally {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
		}
	}

	/**
	 * Retourne le delimiter
	 * 
	 * @return delimiter
	 */
	private String getDelimiter() {
		return delimiter;
	}

	/**
	 * Ecrit les logs
	 * 
	 * @param pObject objet à écrire
	 */
	private void print(Object pObject) {
		LOGGER.info(pObject);
	}

	/**
	 * Ecrit les logs en sautant une ligne
	 * 
	 * @param pObject objet à écrire
	 */
	private void println(Object pObject) {
		LOGGER.info(pObject);
	}
}