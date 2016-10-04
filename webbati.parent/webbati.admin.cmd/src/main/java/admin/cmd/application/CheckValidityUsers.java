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
 * 
 * Classe/Interface <CheckValidityUsers>
 *
 */
public class CheckValidityUsers {

	private static final Logger LOGGER = Logger.getLogger(CheckValidityUsers.class);

	/**
	 * 
	 * Constructeur.
	 */
	protected CheckValidityUsers() {
		super();
	}

	/**
	 * Vérifie la validité des users
	 * 
	 * @param pArgs args
	 */
	public static void main(String[] pArgs) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "testAdminApplicationContext.xml" });
		try {
			IApplication app = ApplicationAdmin.getApplicationSingleton();
			app.getAdminDatabaseManager().checkValidityUsers();
		} catch (WebbatiException e) {
			LOGGER.error(e);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}
