/**
 * 
 */
package webbati.api.test.commun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.manager.interfaces.IAdminDatabaseManager;
import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
import common.api.util.EncodingTools;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.application.interfaces.IApplication;

/**
 * Classe <b>TestCommunBfApi</b>.
 * 
 */
public class TestCommunBfApi extends TestCommunApi {

	protected IApplication app = null;

	@Override
	protected void loadUserByUsernamePassword() throws WebbatiUserException, WebbatiException {
		// Login
		app.loadUserByUsernamePassword(getUsernameTest(), EncodingTools.encode(IAdminDatabaseManager.TEST_PASSWORD_USERNAME, "md5"));
	}

	@Override
	protected IApplicationCommun getApplication() throws WebbatiException {
		app = ApplicationWb.getApplication();
		return app;
	}

	@Override
	protected ApplicationContext getContext() {
		return new ClassPathXmlApplicationContext(new String[] { "testApplicationContext.xml" });
	}

	/**
	 * Retourne le username pour les tests.
	 * 
	 * @return username pour les tests
	 */
	protected String getUsernameTest() {
		return IAdminDatabaseManager.TEST_USERNAME;
	}
}
