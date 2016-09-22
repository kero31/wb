/**
 * 
 */
package admin.api.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import admin.api.metier.ejb.Project;
import admin.api.metier.ejb.Role;
import admin.api.metier.ejb.Userappli;
import admin.api.metier.ejb.Userproject;
import admin.api.metier.ejb.VScriptupdate;
import admin.api.metier.ejb.VScriptupdateId;
import admin.api.metier.id.UserprojectId;
import admin.api.test.commun.TestCommunAdminApi;

import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.exception.BatifreeException;

/**
 * Classe <TestEJB>.
 * 
 */
public class TestEJB extends TestCommunAdminApi {

	@SuppressWarnings("unused")
	// @Test
	public void beansAddRoleUserEJB() throws BatifreeException {
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();
		Transaction trans = session.beginTransaction();
		try {

			Userappli user19 = (Userappli) session.get(Userappli.class, 19);

			Role role3 = (Role) session.get(Role.class, 3);
			Role role4 = (Role) session.get(Role.class, 4);

			Set<Role> listRole = user19.getRoles();
			int nbRole = listRole.size();

			Set<Userappli> listUser = role4.getUserapplis();
			int nbUserappli = listUser.size();

			// role4.getUserapplis().add(user19);
			// session.save(role4);

			user19.getRoles().add(role3);
			session.save(user19);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGet() throws BatifreeException {
		System.out.println("testGet");
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();

		try {
			Criteria crit = session.createCriteria(Project.class);
			List<Project> listProject = crit.list();

			int nb = listProject.size();
			System.out.println("NB project=" + nb);

			for (Project project : listProject) {
				System.out.println("code=" + project.getCode() + ", name=" + project.getCode());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testViews() throws BatifreeException {
		System.out.println("testViews");
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();

		try {
			Criteria crit = session.createCriteria(VScriptupdate.class);
			List<VScriptupdate> ts = crit.list();

			int nb = ts.size();
			System.out.println("NB=" + nb);

			for (VScriptupdate v : ts) {
				VScriptupdateId vid = v.getId();
				System.out.println("driver=" + vid.getDriver());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings({ "unchecked", "unused" })
	// @Test
	public void testUserProject() throws BatifreeException {
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();

		Transaction trans = session.beginTransaction();
		try {
			Criteria crit = session.createCriteria(Userproject.class);
			List<Userproject> list = crit.list();

			int nb = list.size();
			System.out.println("NB=" + nb);

			for (Userproject usp : list) {
				UserprojectId vid = usp.getId();
				System.out.println("BdDbname=" + usp.getBdDbname());
			}

			Userproject usp = new Userproject();
			UserprojectId id = new UserprojectId(17, 1);
			usp.setId(id);
			usp.setBdDbname("toto");
			session.saveOrUpdate(usp);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}
