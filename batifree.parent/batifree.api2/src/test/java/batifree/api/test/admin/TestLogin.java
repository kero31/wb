package batifree.api.test.admin;

import org.junit.Assert;
import org.junit.Test;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.application.interfaces.IApplication;
import admin.api.manager.interfaces.IAdminDatabaseManager;
import batifree.api.test.commun.TestCommunBfApi;

import common.api.application.impl.UserAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.EncodingTools;

public class TestLogin extends TestCommunBfApi {

	public TestLogin() {
	}

	@Test
	public void loginApi() throws BatifreeException, BatifreeUserException {
		String username = IAdminDatabaseManager.TEST_USERNAME;
		String password = IAdminDatabaseManager.TEST_PASSWORD_USERNAME;
		String codeProject = "BF";

		// Initialise
		IApplication appAdmin = ApplicationAdmin.getApplication();
		IPropertiesApp prop = ApplicationAdmin.getApplication().getProperties();

		// Mise à jour des infos de connexion à la bd d'admin à partir du fichier properties
		UserAppImpl userAdmin = new UserAppImpl();
		userAdmin.setUsername("TEST");
		userAdmin.setBdDriver("com.mysql.jdbc.Driver");
		userAdmin.setBdURL(prop.getProperty(IPropertiesApp.BD_ADMIN_URL));
		userAdmin.setBdLogin(prop.getProperty(IPropertiesApp.BD_ADMIN_USERNAME));
		userAdmin.setBdPassword(prop.getProperty(IPropertiesApp.BD_ADMIN_PASSWORD));
		userAdmin.setBdDialect("org.hibernate.dialect.MySQLDialect");
		appAdmin.setUserApp(userAdmin);

		// Récup user app
		IUserApp domainUser = appAdmin.getUserAppFromUsernameProject(username, codeProject);

		Assert.assertNotNull(domainUser);
		Assert.assertEquals(username, domainUser.getUsername());
		Assert.assertEquals(EncodingTools.encode(password, "md5"), domainUser.getPassword());
	}
}
