/**
 * 
 */
package admin.api.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import admin.api.application.impl.PropertiesAppAdminImpl;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;
import admin.api.test.commun.TestCommunAdminApi;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IUserApp;

/**
 * @author Kero
 * 
 */
public class TestLogin extends TestCommunAdminApi {

	protected static final String EMAIL_USERNAME = "kero31@gmail.com";

	/**
	 * Retourne TRUE si le lancement des tests unitaires peut se faire, FALSE sinon
	 * 
	 * @return si le lancement des tests unitaires peut se faire
	 */
	private boolean isExecutionEnabled() {
		try {
			return "1".equals(app.getProperties().getProperty("test.login.enabled", "0"));
		} catch (BatifreeException e) {
			return false;
		}
	}

	@Test
	public void createUserAndCheckValidityAndDeleteAll() throws BatifreeException {
		if (isExecutionEnabled()) {
			String codeProjet = "BF";

			Calendar dateExpired = new GregorianCalendar();
			dateExpired.add(Calendar.YEAR, -1);
			// create user expired
			String loginExpired = "tutu_expired";
			app.getAdminDatabaseManager().createUserFromUsernameProject(loginExpired, codeProjet, dateExpired.getTime(), EMAIL_USERNAME);

			// create user locked
			Calendar dateLocked = new GregorianCalendar();
			dateLocked.add(Calendar.DAY_OF_YEAR, -1);
			String loginLocked = "tutu_locked";
			app.getAdminDatabaseManager().createUserFromUsernameProject(loginLocked, codeProjet, dateLocked.getTime(), EMAIL_USERNAME);

			// create user normal
			Calendar dateNormal = new GregorianCalendar();
			dateNormal.add(Calendar.DAY_OF_YEAR, 10);
			String loginNormal = "tutu_normal";
			app.getAdminDatabaseManager().createUserFromUsernameProject(loginNormal, codeProjet, dateNormal.getTime(), EMAIL_USERNAME);

			// Check validity
			app.getAdminDatabaseManager().checkValidityUsers();

			// Récup des users
			IUserAppli user = app.getUserAppliManager().getUserByUsername(loginExpired);
			Assert.assertNull(user);

			user = app.getUserAppliManager().getUserByUsername(loginLocked);
			Assert.assertNotNull(user);
			Assert.assertTrue(user.isLocked());
			// on supprime après
			app.getAdminDatabaseManager().deleteUserAndDatabase(user);
			user = app.getUserAppliManager().getUserByUsername(loginLocked);
			Assert.assertNull(user);

			user = app.getUserAppliManager().getUserByUsername(loginNormal);
			Assert.assertNotNull(user);
			Assert.assertFalse(user.isLocked());
			// on supprime après
			app.getAdminDatabaseManager().deleteUserAndDatabase(user);
			user = app.getUserAppliManager().getUserByUsername(loginNormal);
			Assert.assertNull(user);
		}
	}

	@Test
	public void updateDatabases() throws BatifreeException {
		String codeProjet = "BF";
		app.getAdminDatabaseManager().updateDatabases(codeProjet);
	}

	@Test
	public void checkValidityUsers() throws BatifreeException {
		// Check validity
		app.getAdminDatabaseManager().checkValidityUsers();
	}

	@Test
	public void testConnectionDefault() throws BatifreeException {
		Assert.assertNotNull(app.getAdminDatabaseManager().getConnectionDefault());
	}

	@Test
	public void createDemo() throws BatifreeException {
		if (isExecutionEnabled()) {
			String codeProject = "BF";

			String demo = app.getAdminDatabaseManager().createUserDemoFromProject(codeProject, EMAIL_USERNAME);
			Assert.assertNotNull(demo);

			String[] list = demo.split("/");
			Assert.assertEquals(list.length, 2);

			String username = list[0];
			Assert.assertNotNull(username);

			String password = list[1];
			Assert.assertNotNull(password);

			// Récup du user en base
			IUserAppli user = app.getUserAppliManager().getUserByUsername(username);
			Assert.assertNotNull(user);

			// Récup du user en fonction du projet
			IUserApp userApp = app.getUserAppFromUsernameProject(username, codeProject);
			Assert.assertNotNull(userApp);
			Assert.assertTrue(username.equals(userApp.getUsername()));

			// Suppression de cette démo
			app.getAdminDatabaseManager().deleteUserAndDatabase(user);
		}
	}

	@Test
	public void createUserConnectionSpecifique() throws BatifreeException {
		if (isExecutionEnabled()) {
			String login = "test_user_specif";
			// Création du user
			Calendar dateNormal = new GregorianCalendar();
			dateNormal.add(Calendar.DAY_OF_YEAR, 10);
			app.getAdminDatabaseManager().createUserFromUsernameProject(login, "BF", dateNormal.getTime(),
			        new Integer(app.getProperties().getProperty(PropertiesAppAdminImpl.DEMO_CONNECTION_ID)), EMAIL_USERNAME);

			// Récup du user en base
			IUserAppli user = app.getUserAppliManager().getUserByUsername(login);
			Assert.assertNotNull(user);

			// Suppression de ce user
			app.getAdminDatabaseManager().deleteUserAndDatabase(user);

			user = app.getUserAppliManager().getUserByUsername(login);
			Assert.assertNull(user);
		}
	}

	@Test
	public void createUserAndAddOtherProjet() throws BatifreeException {
		if (isExecutionEnabled()) {
			String codeProjet = "BF";

			Calendar dateExpired = new GregorianCalendar();
			dateExpired.add(Calendar.YEAR, 10);
			// create user
			final String username = "newUser";
			String userPassword = app.getAdminDatabaseManager().createUserFromUsernameProject(username, codeProjet, dateExpired.getTime(),
			        EMAIL_USERNAME);
			Assert.assertNotNull(userPassword);

			String[] list = userPassword.split("/");
			Assert.assertEquals(list.length, 2);

			String usernameGet = list[0];
			Assert.assertNotNull(usernameGet);
			Assert.assertTrue(username.equals(usernameGet));

			String passwordGet = list[1];
			Assert.assertNotNull(passwordGet);

			// Récup du user en base
			IUserAppli user = app.getUserAppliManager().getUserByUsername(username);
			Assert.assertNotNull(user);

			// Récup de la liste des user project
			List<IUserproject> listUserProject = user.getListUserproject();
			Assert.assertTrue(listUserProject.size() == 1);

			// Récup du user en fonction du projet
			IUserApp userApp = app.getUserAppFromUsernameProject(username, codeProjet);
			Assert.assertNotNull(userApp);
			Assert.assertTrue(username.equals(userApp.getUsername()));

			// Ajoute un nouveau projet à l'utilisateur username
			final String codeProjet2 = "COMPTA";
			app.getAdminDatabaseManager().addProjectToUser(user, codeProjet2);

			// Récup de la liste des user project
			listUserProject = user.getListUserproject();
			Assert.assertTrue(listUserProject.size() == 2);

			// Suppression de ce user
			app.getAdminDatabaseManager().deleteUserAndDatabase(user);

			user = app.getUserAppliManager().getUserByUsername(username);
			Assert.assertNull(user);
		}
	}

	@Test
	public void createUserWithUserParent() throws BatifreeException {
		if (isExecutionEnabled()) {
			String codeProjet = "BF";

			Calendar dateExpired = new GregorianCalendar();
			dateExpired.add(Calendar.YEAR, 10);

			// Crée user parent
			final String usernameParent = "newUserParent";
			String userPasswordParent = app.getAdminDatabaseManager().createUserFromUsernameProject(usernameParent, codeProjet,
			        dateExpired.getTime(), EMAIL_USERNAME);
			Assert.assertNotNull(userPasswordParent);
			String[] list = userPasswordParent.split("/");
			Assert.assertEquals(list.length, 2);
			Assert.assertEquals(usernameParent, list[0]);
			String passwordParentGet = list[1];
			Assert.assertNotNull(passwordParentGet);

			// Récup du user parent en base
			IUserAppli userParent = app.getUserAppliManager().getUserByUsername(usernameParent);
			Assert.assertNotNull(userParent);

			// Crée le user fils
			final String usernameFils = "newUserFils";
			String userPasswordFils = app.getAdminDatabaseManager().createUserFromUsernameProject(usernameFils, codeProjet, dateExpired.getTime(),
			        EMAIL_USERNAME, usernameParent, passwordParentGet);
			Assert.assertNotNull(userPasswordFils);
			list = userPasswordFils.split("/");
			Assert.assertEquals(list.length, 2);
			Assert.assertEquals(usernameFils, list[0]);

			// Récup du user fils en base
			IUserAppli userFils = app.getUserAppliManager().getUserByUsername(usernameFils);
			Assert.assertNotNull(userFils);

			// Check le user parent à partir du user fils
			Assert.assertNotNull(userFils.getUserappliParent());
			Assert.assertEquals(usernameParent, userFils.getUserappliParent().getUsername());

			// Suppression du user fils
			app.getAdminDatabaseManager().deleteUserAndDatabase(userFils);
			userFils = app.getUserAppliManager().getUserByUsername(usernameFils);
			Assert.assertNull(userFils);

			// Suppression du user parent
			app.getAdminDatabaseManager().deleteUserAndDatabase(userParent);
			userParent = app.getUserAppliManager().getUserByUsername(usernameParent);
			Assert.assertNull(userParent);
		}
	}
}
