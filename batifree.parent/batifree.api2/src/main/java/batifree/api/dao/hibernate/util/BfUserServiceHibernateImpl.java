/**
 * 
 */
package batifree.api.dao.hibernate.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.hibernate.util.HibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.metier.interfaces.IUserApp;

/**
 * Classe <BfUserServiceHibernateImpl>.
 * 
 * @author Kero
 * 
 */
@Service("BF_UserServiceHibernate")
public class BfUserServiceHibernateImpl extends UserServiceHibernateImpl {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "BF_HibernateUtil")
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
