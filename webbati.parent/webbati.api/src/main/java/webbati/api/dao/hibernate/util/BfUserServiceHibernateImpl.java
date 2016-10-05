/**
 * 
 */
package webbati.api.dao.hibernate.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.hibernate.util.HibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.metier.interfaces.IUserApp;
import webbati.api.application.impl.ApplicationWb;

/**
 * Classe <b>BfUserServiceHibernateImpl</b>.
 * 
 * @author Kero
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_UserServiceHibernate")
public class BfUserServiceHibernateImpl extends UserServiceHibernateImpl {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_HibernateUtil")
	private HibernateUtil hibernateUtil;

	@Resource(name = "UserApp")
	private IUserApp userApp;

	@Override
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	@Override
	public IUserApp getUserAppSession() {
		return userApp;
	}
}
