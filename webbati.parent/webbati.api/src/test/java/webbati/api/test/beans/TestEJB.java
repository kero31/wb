/**
 * 
 */
package webbati.api.test.beans;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.exception.WebbatiException;
import webbati.api.metier.ejb.MateriauxBib;
import webbati.api.metier.ejb.MateriauxEtude;
import webbati.api.metier.ejb.Tva;
import webbati.api.test.commun.TestCommunBfApi;

/**
 * Classe <TestEJB>.
 * 
 */
public class TestEJB extends TestCommunBfApi {

	/*
	 * @Test public void testBackupEJB() throws WebbatiException {
	 * UserServiceHibernateImpl ush = (UserServiceHibernateImpl)
	 * app.getUserService(); Session session = ush.getSessionHibernate();
	 * Transaction trans = session.beginTransaction(); try { // New // Tutu t =
	 * new Tutu(); // t.setBib("bib1"); Tutu1 t1 = new Tutu1(); //
	 * t1.setMx("mx1"); // Tutu2 t2 = new Tutu2(); // t1.setMx("mx1");
	 * 
	 * session.save(t1);
	 * 
	 * // Get // System.out.println("---req1 Tutu"); // Criteria crit =
	 * session.createCriteria(Tutu.class); // List<Tutu> listTutu = crit.list();
	 * // System.out.println("---req2"); // Tutu t = (Tutu)
	 * session.get(Tutu.class, 1); System.out.println("---req3 Tutu1"); Criteria
	 * crit = session.createCriteria(Tutu1.class); List<Tutu1> listTutu1 =
	 * crit.list(); // System.out.println("---req4 Tutu2"); // crit =
	 * session.createCriteria(Tutu2.class); // List<Tutu2> listTutu2 =
	 * crit.list(); // System.out.println("---req5"); // Tutu1 t1 = (Tutu1)
	 * session.get(Tutu1.class, 1); // MateriauxBib mxBib1 = new MateriauxBib();
	 * // mxBib1.setTvaId(tva1.getId());
	 * 
	 * Criteria crit = session.createCriteria(EnginBib.class); List<EnginBib>
	 * listEnginBib = crit.list();
	 * 
	 * trans.commit(); } catch (Exception e) { trans.rollback(); throw e; }
	 * finally { session.close(); } }
	 */

	@SuppressWarnings("unused")
	@Test
	public void testView() throws WebbatiException {
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();
		Transaction trans = session.beginTransaction();
		try {
			Criteria crit = null;
			List<?> list = null;
			Query query = null;
			/*
			 * crit = session.createCriteria(EnginEtude.class).createAlias(
			 * "ligneetude", "ligneetude", JoinType.INNER_JOIN)
			 * .createAlias("ligneetude.tva", "tva",
			 * JoinType.INNER_JOIN).add(Restrictions.eq("ligneetude.etudeId",
			 * new Integer(1))); List<?> list = crit.list();
			 */

			// crit = session.createCriteria(Bibliotheque.class,
			// "BIBLIOTHEQUE").createAlias("BIBLIOTHEQUE.etude", "etude",
			// JoinType.INNER_JOIN)
			// .add(Restrictions.eq("etude.id", new Integer(2)));
			// List<?> list = crit.list();

			// crit = session.createCriteria(Bibliotheque.class,
			// "bib").add(Restrictions.eq("bibOrigin.id", new Integer(10)));
			// crit.list();

			// crit = session.createCriteria(Famille.class,
			// "fam").add(Restrictions.eq("superParentId", new Integer(14)));
			// list = crit.list();
			/*
			 * crit = session.createCriteria(TacheLot.class, "tac")// //
			 * .createAlias("bib.bibParent", "tacBib.bibParent",
			 * JoinType.INNER_JOIN)// .createAlias("tac.bibParent",
			 * "BIBLIOTHEQUE", JoinType.INNER_JOIN)//
			 * .add(Restrictions.eq("tac.superParentId", new Integer(6308)))//
			 * // .add(Restrictions.eq("tac.isLot", false)) ; list =
			 * crit.list();
			 */

			/*
			 * query = session.createSQLQuery(
			 * "select rgl.* from REGLEMENT rgl " +
			 * "inner join ECHEANCIER_REGLEMENT echRgl ON rgl.REG_ID = echRgl.REG_ID "
			 * + "inner join ECHEANCIER ech on ech.ECH_ID = echRgl.ECH_ID " +
			 * "inner join AFFAIRE aff on aff.AFF_ID = ech.AFF_ID " +
			 * "where aff.CNT_ID = :clientId").setParameter("clientId", 25);
			 * list = query.list();
			 * 
			 * query = session.
			 * createQuery("select rgl from EcheancierReglement as echRgl " + //
			 * "inner join echRgl.reglement as rgl " + //
			 * "inner join echRgl.echeancier as ech " + //
			 * "inner join ech.affaire as aff " + //
			 * "inner join aff.client as client " + //
			 * "where client.id = :clientId").setParameter("clientId", 25); list
			 * = query.list();
			 */

			query = session.createQuery("select tac from TacheLot as tac " + //
					"where tac.bibOrigin.id = :bibId").setParameter("bibId", 268);
			list = query.list();

			// crit = session.createCriteria(EnginBib.class);
			// List<?> listEngin = crit.list();

			// System.out.println("size=" + list.size());

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void testListSaveBib() throws WebbatiException {
		UserServiceHibernateImpl ush = (UserServiceHibernateImpl) app.getUserService();
		Session session = ush.getSessionHibernate();
		Transaction trans = session.beginTransaction();
		try {
			Criteria crit = session.createCriteria(Tva.class);
			crit.list();

			crit = session.createCriteria(MateriauxBib.class);
			crit.list();

			crit = session.createCriteria(MateriauxEtude.class);
			crit.list();

			Tva tva1 = (Tva) session.get(Tva.class, 1);
			MateriauxBib mxBib1 = new MateriauxBib();
			mxBib1.setTvaId(tva1.getId());
			session.save(mxBib1);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}
