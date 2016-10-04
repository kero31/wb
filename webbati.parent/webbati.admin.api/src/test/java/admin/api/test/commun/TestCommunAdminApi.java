/**
 * 
 */
package admin.api.test.commun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.application.interfaces.IApplication;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.WebbatiException;

/**
 * 
 * Classe <TestCommunAdminApi>.
 * 
 */
public abstract class TestCommunAdminApi extends TestCommunApi {

	protected IApplication app = null;

	@Override
	protected IApplicationCommun getApplication() throws WebbatiException {
		app = ApplicationAdmin.getApplicationSingleton();
		return app;
	}

	@Override
	protected ApplicationContext getContext() {
		return new ClassPathXmlApplicationContext(new String[] { "testAdminApplicationContext.xml" });
	}
}
