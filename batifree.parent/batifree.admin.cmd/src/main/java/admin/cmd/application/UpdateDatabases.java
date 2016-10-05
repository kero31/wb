/**
 * 
 */
package admin.cmd.application;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.application.interfaces.IApplication;

import common.api.exception.WebbatiException;

/**
 * @author Kero
 * 
 */
public class UpdateDatabases {

	private static final Logger LOGGER = Logger.getLogger(UpdateDatabases.class);

	/**
	 * 
	 * Constructeur.
	 */
	protected UpdateDatabases() {
		super();
	}

	/**
	 * Met à jour les databases des utilisateurs qui appartiennent au projet passé en paramètre
	 * 
	 * @param pArgs comprend le code du projet sur lequel va être appliquée la mise à jour
	 */
	public static void main(String[] pArgs) {
		if (pArgs.length != 1) {
			LOGGER.error("Usage : updateDatabases code_projet");
			System.exit(1);
		}

		// Récup du code projet
		String codeProject = pArgs[0];

		if (codeProject == null || codeProject.isEmpty()) {
			LOGGER.error("Le code projet est vide");
		}

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "testAdminApplicationContext.xml" });
		try {
			IApplication app = ApplicationAdmin.getApplicationSingleton();
			app.getAdminDatabaseManager().updateDatabases(codeProject);
		} catch (WebbatiException e) {
			LOGGER.error(e);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}
}
