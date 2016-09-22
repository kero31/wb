/**
 * 
 */
package admin.cmd.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.application.interfaces.IApplication;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <CreateUser>
 *
 */
public class CreateUser {

	private static final Logger LOGGER = Logger.getLogger(CreateUser.class);

	/**
	 * 
	 * Constructeur.
	 */
	protected CreateUser() {
		super();
	}

	/**
	 * Crée un utilisateur sur un projet avec une date d'expiration
	 * 
	 * @param pArgs args
	 */
	public static void main(String[] pArgs) {
		if (pArgs.length != 4 && pArgs.length != 5) {
			LOGGER.error("Usage : createUser code_projet username dateExpired(yyyy/MM/dd-HH:mm:ss) email [connection_id]");
			System.exit(1);
		}

		// Récup du code projet
		String codeProject = pArgs[0];
		// Récup du username
		String username = pArgs[1];
		// Récup de la dateExpired
		String sDateExpired = pArgs[2];
		// Récup du mail de l'user
		String emailUsername = pArgs[3];
		Integer connectionId = null;
		if (pArgs.length == 5) {
			connectionId = Integer.parseInt(pArgs[4]);
		}

		// Format the output with leading zeros for days and month
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		ClassPathXmlApplicationContext context = null;
		try {
			Date dateExpired = dateFormat.parse(sDateExpired);

			context = new ClassPathXmlApplicationContext(new String[] { "testAdminApplicationContext.xml" });
			IApplication app = ApplicationAdmin.getApplicationSingleton();

			String password = null;
			if (connectionId != null) {
				password = app.getAdminDatabaseManager().createUserFromUsernameProject(username, codeProject, dateExpired, connectionId,
				        emailUsername);
			} else {
				password = app.getAdminDatabaseManager().createUserFromUsernameProject(username, codeProject, dateExpired, emailUsername);
			}

			LOGGER.info("Mot de passe : " + password);

			LOGGER.info("Le user " + username + " a ete cree avec succes sur le projet " + codeProject);
		} catch (BatifreeException | ParseException | BeansException e) {
			LOGGER.error(e);
			System.exit(1);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}
