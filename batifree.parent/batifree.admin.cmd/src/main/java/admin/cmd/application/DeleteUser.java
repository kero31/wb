/**
 * 
 */
package admin.cmd.application;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.interfaces.IUserAppli;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <DeleteUser>
 *
 */
public class DeleteUser {

	private static final Logger LOGGER = Logger.getLogger(DeleteUser.class);
	private static final String ARG_DROP_DB = "-dropDB";

	/**
	 * 
	 * Constructeur.
	 */
	protected DeleteUser() {
		super();
	}

	/**
	 * Vérifie la validité des users
	 * 
	 * @param pArgs args
	 */
	public static void main(String[] pArgs) {
		if (pArgs.length != 1 && pArgs.length != 2) {
			LOGGER.error("Usage : deleteUser username " + ARG_DROP_DB);
			return;
		}

		// Récup du username
		String username = pArgs[0];
		boolean dropDB = false;
		if (pArgs.length == 2 && ARG_DROP_DB.equals(pArgs[1])) {
			dropDB = true;
		}

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "testAdminApplicationContext.xml" });
		try {
			admin.api.application.interfaces.IApplication app = ApplicationAdmin.getApplicationSingleton();
			IUserAppli user = app.getUserAppliManager().getUserByUsername(username);
			if (user == null) {
				throw new BatifreeException("Le user " + username + " n existe pas");
			}
			if (dropDB) {
				app.getAdminDatabaseManager().deleteUserAndDatabase(user);
			} else {
				app.getUserAppliManager().delete(user);
			}

		} catch (BatifreeException e) {
			LOGGER.error(e);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}
