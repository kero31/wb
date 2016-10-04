/**
 * 
 */
package admin.api.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import admin.api.manager.interfaces.IAdminDatabaseManager;
import admin.api.manager.interfaces.IConnectiondbManager;
import admin.api.manager.interfaces.IProjectManager;
import admin.api.manager.interfaces.IProjectscriptManager;
import admin.api.manager.interfaces.IRoleManager;
import admin.api.manager.interfaces.IUserAppliManager;
import admin.api.manager.interfaces.IUserprojectManager;
import admin.api.metier.impl.ConnectiondbImpl;
import admin.api.metier.impl.ProjectImpl;
import admin.api.metier.impl.ProjectscriptImpl;
import admin.api.metier.impl.RoleImpl;
import admin.api.metier.impl.UserAppliImpl;
import admin.api.metier.impl.UserprojectImpl;
import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;
import admin.api.test.commun.TestCommunAdminApi;

import common.api.exception.WebbatiException;

/**
 * @author Kero
 * 
 */
public class TestBeans extends TestCommunAdminApi {

	private static final String USER_USERNAME = "TestUserUsername";
	private static final String USER_USERNAME2 = "TestUserUsername2";
	private static final String USER_USERNAME_FILS = "TestUserUsernameFils";
	private static final String USER_MAIL = "TestUserMail";
	private static final String PROJECT_CODE = "TestProjectCode";
	private static final String PROJECT_NAME = "TestProjectName";
	private static final String PROJECTSCRIPT_FILENAME = "TestProjectScriptFileName";
	private static final String CONNECTION_DRIVER = "TestConnDriver";
	private static final String ROLE_CODE = "TestRoleCode";
	private static final String ROLE_CODE2 = "TestRoleCode2";
	private static final String USERPROJECT_BD_LOGIN = "TestUserProjectBdLogin";
	private static final String USERPROJECT_BD_PASSWORD = "TestUserProjectBdPassword";
	private static final String USERPROJECT_BD_NAME = "TestUserProjectBdName";

	@Test
	public void testGet() throws WebbatiException {
		IUserAppliManager userMng = app.getUserAppliManager();
		List<IUserAppli> listUser = userMng.getList();
		Assert.assertNotNull(listUser);

		IUserprojectManager userProjectMng = app.getUserprojectManager();
		List<IUserproject> listUserProject = userProjectMng.getList();
		Assert.assertNotNull(listUserProject);
	}

	@Test
	public void manageBeans() throws WebbatiException {
		beansAdd();
		beansGet();
		beansUpdate();
		beansUpdateUserProject();
		beansGet();
		beansRemove();
	}

	private void beansGet() throws WebbatiException {
		IUserAppliManager userMng = app.getUserAppliManager();
		List<IUserAppli> listUser = userMng.getList();
		boolean isUserFind = false;
		for (IUserAppli user : listUser) {
			if (USER_USERNAME.equals(user.getUsername())) {
				isUserFind = true;
			}
		}
		Assert.assertTrue(isUserFind);

		// USER_USERNAME_FILS fils du père USER_USERNAME
		IUserAppli userFils = null;
		for (IUserAppli user : listUser) {
			if (USER_USERNAME_FILS.equals(user.getUsername())) {
				userFils = user;
			}
		}
		Assert.assertNotNull(userFils);
		Assert.assertNotNull(userFils.getUserappliParent());
		Assert.assertEquals(USER_USERNAME, userFils.getUserappliParent().getUsername());

		for (IUserAppli user : listUser) {
			if (USER_USERNAME.equals(user.getUsername())) {
				List<IUserproject> listUserProject = user.getListUserproject();
				Assert.assertNotNull(listUserProject);
				Assert.assertEquals(listUserProject.size(), 1);
				for (IUserproject userproject : listUserProject) {
					IProject project = userproject.getProject();
					Assert.assertEquals(userproject.getBdDbname(), USERPROJECT_BD_NAME);
					Assert.assertEquals(userproject.getBdPassword(), USERPROJECT_BD_PASSWORD);
					Assert.assertEquals(project.getCode(), PROJECT_CODE);
				}
			}
		}
	}

	private void beansUpdateUserProject() throws WebbatiException {
		try {
			beginTransaction();

			// userproject
			// user
			IUserAppliManager userMng = app.getUserAppliManager();
			IUserAppli user1 = userMng.getUserByUsername(USER_USERNAME);
			Assert.assertNotNull(user1);

			// project
			IProjectManager projectMng = app.getProjectManager();
			IProject project1 = projectMng.getProjectByCode(PROJECT_CODE);

			// userproject
			IUserprojectManager userprojectMng = app.getUserprojectManager();
			IUserproject userproject1 = userprojectMng.getUserprojectFromUserAppliAndProject(user1, project1);
			Assert.assertNotNull(userproject1);
			userproject1.setConnectiondb(null);

			IUserproject userproject2 = userprojectMng.save(userproject1);
			Assert.assertNotNull(userproject2);
			Assert.assertNull(userproject2.getConnectiondb());

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void beansUpdate() throws WebbatiException {
		beginTransaction();
		try {

			final String valueNew = "_0000";

			// user
			IUserAppliManager userMng = app.getUserAppliManager();
			IUserAppli user1 = userMng.getUserByUsername(USER_USERNAME);
			Assert.assertNotNull(user1);
			String newMail = USER_MAIL + valueNew;
			user1.setMail(newMail);
			IUserAppli user2 = userMng.save(user1);
			Assert.assertEquals(user1.getId(), user2.getId());
			Assert.assertEquals(user2.getMail(), newMail);

			// project
			IProjectManager projectMng = app.getProjectManager();
			IProject project1 = projectMng.getProjectByCode(PROJECT_CODE);
			String newProjectName = PROJECT_NAME + valueNew;
			project1.setName(newProjectName);
			project1 = projectMng.save(project1);
			Assert.assertEquals(project1.getName(), newProjectName);

			// userproject
			IUserprojectManager userprojectMng = app.getUserprojectManager();
			IUserproject userproject1 = userprojectMng.getUserprojectFromUserAppliAndProject(user1, project1);
			Assert.assertNotNull(userproject1);
			String newBdLogin = USERPROJECT_BD_LOGIN + valueNew;
			userproject1.setBdLogin(newBdLogin);
			IUserproject userproject2 = userprojectMng.save(userproject1);
			Assert.assertEquals(userproject1.getId(), userproject2.getId());
			Assert.assertEquals(userproject2.getBdLogin(), newBdLogin);

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void beansRemove() throws WebbatiException {
		beginTransaction();
		try {
			// user manager
			IUserAppliManager userMng = app.getUserAppliManager();

			// user fils
			IUserAppli userFils1 = userMng.getUserByUsername(USER_USERNAME_FILS);
			// user fils - delete
			userMng.delete(userFils1);

			// user
			IUserAppli user1 = userMng.getUserByUsername(USER_USERNAME);

			// userrole
			List<IRole> listRoleToDelete = new ArrayList<>();
			listRoleToDelete.addAll(user1.getListRole());
			user1.setListRole(new ArrayList<IRole>());
			user1 = userMng.save(user1);

			// role
			IRoleManager roleMng = app.getRoleManager();
			for (IRole role : listRoleToDelete) {
				roleMng.delete(role);
			}

			// userproject
			IUserprojectManager userprojectMng = app.getUserprojectManager();
			IProject project = null;
			for (IUserproject userproject : user1.getListUserproject()) {

				// project - get
				project = userproject.getProject();

				// connection - get
				// Car supprimée dans le beansUpdateUserProject()
				Assert.assertNull(userproject.getConnectiondb());

				userprojectMng.delete(userproject);
			}

			// connection
			// Cherche la conection dont son driver est CONNECTION_DRIVER
			IConnectiondbManager connMng = app.getConnectiondbManager();
			List<IConnectiondb> listConnection = connMng.getList();
			if (listConnection != null) {
				for (IConnectiondb conn : listConnection) {
					if (CONNECTION_DRIVER.equals(conn.getDriver())) {
						connMng.delete(conn);
					}
				}
			}

			// project - delete
			// projectscript
			IProjectManager projectMng = app.getProjectManager();
			IProjectscriptManager projectScriptMng = app.getProjectscriptManager();
			for (IProjectscript projectScript : project.getListProjectscript()) {
				projectScriptMng.delete(projectScript);
			}
			projectMng.delete(project);

			// user - delete
			userMng.delete(user1);

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	@Test
	public void manageBeansList() throws WebbatiException {
		beansAddList();
		beansGetList();
		beansUpdateList();
		beansGetList();
		beansRemoveList();
	}

	private void beansAddList() throws WebbatiException {
		beginTransaction();
		try {

			// user - save list
			IUserAppli user1 = new UserAppliImpl();
			user1.setUsername(USER_USERNAME);
			user1.setMail(USER_MAIL);
			IUserAppli user2 = new UserAppliImpl();
			user2.setUsername(USER_USERNAME2);
			user2.setMail(USER_MAIL);
			List<IUserAppli> userList = new ArrayList<>();
			userList.add(user1);
			userList.add(user2);

			IUserAppliManager userMng = app.getUserAppliManager();
			userMng.save(userList);

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void beansGetList() throws WebbatiException {
		// user - get list
		IUserAppliManager userMng = app.getUserAppliManager();
		List<IUserAppli> userList = userMng.getList();
		Assert.assertNotNull(userList);
		List<IUserAppli> userGetList = new ArrayList<>();
		for (IUserAppli userappli : userList) {
			if (USER_USERNAME.equals(userappli.getUsername()) || USER_USERNAME2.equals(userappli.getUsername())) {
				userGetList.add(userappli);
			}
		}
		Assert.assertEquals(userGetList.size(), 2);
	}

	private void beansUpdateList() throws WebbatiException {
		beginTransaction();
		final String valueNew = "_0000";
		try {
			IUserAppliManager userMng = app.getUserAppliManager();
			List<IUserAppli> listUsers = userMng.getList();
			List<IUserAppli> userUpdateList = new ArrayList<>();
			Assert.assertNotNull(listUsers);
			for (IUserAppli user : listUsers) {
				if (USER_USERNAME.equals(user.getUsername()) || USER_USERNAME2.equals(user.getUsername())) {
					user.setMail(user.getMail() + valueNew);
					userUpdateList.add(user);
				}
			}
			userMng.save(userUpdateList);

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void beansRemoveList() throws WebbatiException {
		beginTransaction();
		try {

			// user - get list
			IUserAppliManager userMng = app.getUserAppliManager();
			List<IUserAppli> userList = userMng.getList();
			List<IUserAppli> userDeleteList = new ArrayList<>();
			for (IUserAppli userappli : userList) {
				if (USER_USERNAME.equals(userappli.getUsername()) || USER_USERNAME2.equals(userappli.getUsername())) {
					userDeleteList.add(userappli);
				}
			}
			Assert.assertEquals(userDeleteList.size(), 2);

			// user - delete list
			userMng.delete(userDeleteList);

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}

	private void beansAdd() throws WebbatiException {
		beginTransaction();
		try {

			// project
			IProject project1 = new ProjectImpl();
			project1.setCode(PROJECT_CODE);
			project1.setName(PROJECT_NAME);
			IProjectManager projectMng = app.getProjectManager();
			project1 = projectMng.save(project1);
			Assert.assertNotNull(project1);
			Assert.assertEquals(project1.getCode(), PROJECT_CODE);
			Assert.assertEquals(project1.getName(), PROJECT_NAME);

			// role1
			IRole role1 = new RoleImpl();
			role1.setCode(ROLE_CODE);
			role1.setProject(project1);
			IRoleManager roleMng = app.getRoleManager();
			role1 = roleMng.save(role1);
			Assert.assertNotNull(role1);
			Assert.assertEquals(role1.getCode(), ROLE_CODE);

			// role2
			IRole role2 = new RoleImpl();
			role2.setCode(ROLE_CODE2);
			role2.setProject(project1);
			role2 = roleMng.save(role2);
			Assert.assertNotNull(role2);
			Assert.assertEquals(role2.getCode(), ROLE_CODE2);

			// user
			IUserAppli user1 = new UserAppliImpl();
			user1.setUsername(USER_USERNAME);
			user1.setMail(USER_MAIL);
			IUserAppliManager userMng = app.getUserAppliManager();
			user1 = userMng.save(user1);
			Assert.assertNotNull(user1);
			Assert.assertEquals(user1.getMail(), USER_MAIL);

			// user fils de user1
			IUserAppli userFils1 = new UserAppliImpl();
			userFils1.setUsername(USER_USERNAME_FILS);
			userFils1.setMail(USER_MAIL);
			userFils1.setUserappliParent(user1);
			userFils1 = userMng.save(userFils1);
			Assert.assertNotNull(userFils1);
			Assert.assertEquals(USER_MAIL, userFils1.getMail());
			Assert.assertNotNull(userFils1.getUserappliParent());
			Assert.assertEquals(USER_USERNAME, userFils1.getUserappliParent().getUsername());

			// userrole
			List<IRole> listRolesUser1 = user1.getListRole();
			Assert.assertNotNull(listRolesUser1);
			Assert.assertEquals(listRolesUser1.size(), 0);
			listRolesUser1.add(role1);
			listRolesUser1.add(role2);
			user1.setListRole(listRolesUser1);
			user1 = userMng.save(user1);
			Assert.assertEquals(user1.getListRole().size(), 2);

			// projectscript
			IProjectscript projectScript1 = new ProjectscriptImpl();
			projectScript1.setFileName(PROJECTSCRIPT_FILENAME);
			projectScript1.setProject(project1);
			projectScript1 = app.getProjectscriptManager().save(projectScript1);
			Assert.assertNotNull(projectScript1);
			Assert.assertEquals(projectScript1.getFileName(), PROJECTSCRIPT_FILENAME);
			Assert.assertNotNull(projectScript1.getProject());

			// connection
			IAdminDatabaseManager adminMng = app.getAdminDatabaseManager();
			IConnectiondb connDefault = adminMng.getConnectionDefault();
			Assert.assertNotNull(connDefault);
			IConnectiondb conn1 = new ConnectiondbImpl();
			conn1.setDriver(CONNECTION_DRIVER);
			IConnectiondbManager connMng = app.getConnectiondbManager();
			conn1 = connMng.save(conn1);
			Assert.assertNotNull(conn1);
			Assert.assertEquals(conn1.getDriver(), CONNECTION_DRIVER);

			// userproject
			IUserproject userproject1 = new UserprojectImpl(user1, project1);
			userproject1.setBdDbname(USERPROJECT_BD_NAME);
			userproject1.setBdLogin(USERPROJECT_BD_LOGIN);
			userproject1.setBdPassword(USERPROJECT_BD_PASSWORD);
			userproject1.setConnectiondb(conn1);
			userproject1.setProjectscript(projectScript1);
			IUserprojectManager userprojectMng = app.getUserprojectManager();
			userproject1 = userprojectMng.save(userproject1);
			Assert.assertNotNull(userproject1);
			Assert.assertEquals(userproject1.getBdDbname(), USERPROJECT_BD_NAME);
			Assert.assertEquals(userproject1.getBdLogin(), USERPROJECT_BD_LOGIN);
			Assert.assertEquals(userproject1.getBdPassword(), USERPROJECT_BD_PASSWORD);
			Assert.assertNotNull(userproject1.getProject());
			Assert.assertNotNull(userproject1.getUserappli());
			Assert.assertNotNull(userproject1.getConnectiondb());
			Assert.assertNotNull(userproject1.getProjectscript());

			commitTransaction();
		} catch (WebbatiException e) {
			rollbackTransaction();
			throw e;
		} finally {
			closeTransaction();
		}
	}
}
