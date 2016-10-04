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
 * Classe/Interface <b>CreateUserTest</b><br/>
 *
 */
public class CreateUserTest {

	private static final Logger LOGGER = Logger.getLogger(CreateUserTest.class);

	/**
	 * 
	 * Constructeur.
	 */
	protected CreateUserTest() {
		super();
	}

	/**
	 * Crée le user de test.
	 * 
	 * @param pArgs args
	 */
	public static void main(String[] pArgs) {
		if (pArgs.length != 1) {
			LOGGER.error("Usage : createUserTest code_projet");
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
			app.getAdminDatabaseManager().createUserTestFromProject(codeProject);
		} catch (WebbatiException e) {
			LOGGER.error(e);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}
