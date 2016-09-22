/**
 * 
 */
package batifree.api.test.commun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.manager.interfaces.IAdminDatabaseManager;
import batifree.api.application.impl.ApplicationBf;
import batifree.api.application.interfaces.IApplication;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.util.EncodingTools;

/**
 * Classe <TestCommunBfApi>.
 * 
 */
public class TestCommunBfApi extends TestCommunApi {

	protected IApplication app = null;

	@Override
	protected void loadUserByUsernamePassword() throws BatifreeUserException, BatifreeException {
		// Login
		app.loadUserByUsernamePassword(getUsernameTest(), EncodingTools.encode(IAdminDatabaseManager.TEST_PASSWORD_USERNAME, "md5"));
	}

	@Override
	protected IApplicationCommun getApplication() throws BatifreeException {
		app = ApplicationBf.getApplication();
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
