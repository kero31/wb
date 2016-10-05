/**
 * 
 */
package admin.api.test.query;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import admin.api.test.commun.TestCommunAdminApi;

import common.api.dao.hibernate.util.QueryHibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.exception.WebbatiException;

/**
 * @author Kero
 * 
 */
public class TestQuery extends TestCommunAdminApi {

	@Test
	public void executeQueryUniqueResult() throws WebbatiException {
		QueryHibernateUtil queryUtil = new QueryHibernateUtil((UserServiceHibernateImpl) app.getUserService());

		String reqMinUser = "select 50 from PROJECT LIMIT 1";
		BigInteger biRes = queryUtil.executeQueryUniqueResult(reqMinUser, BigInteger.class);
		Assert.assertTrue(new BigInteger("50").equals(biRes));

		reqMinUser = "select 'toto' from PROJECT LIMIT 1";
		String sRes = queryUtil.executeQueryUniqueResult(reqMinUser, String.class);
		Assert.assertTrue("toto".equals(sRes));
	}

	@Test
	public void executeQueriesFromExternConnection() throws WebbatiException {
		/*
		String queryH = "select * from V_SCRIPTUPDATE where PROJECT_ID=1";
		List<VScriptupdate> listH = app.getQueryUtil().executeQuery(app.getDaoSession(), queryH, VScriptupdate.class);
		for(VScriptupdate script : listH) {
			Assert.assertNotNull(script);
		}*/

	}
}
