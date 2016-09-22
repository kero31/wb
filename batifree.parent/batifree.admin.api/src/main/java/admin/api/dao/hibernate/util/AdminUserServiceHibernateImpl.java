/**
 * 
 */
package admin.api.dao.hibernate.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.hibernate.util.HibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.metier.interfaces.IUserApp;

/**
 * Classe <AdminUserServiceHibernateImpl>.
 * 
 * @author Kero
 * 
 */
@Service("ADMIN_UserServiceHibernate")
public class AdminUserServiceHibernateImpl extends UserServiceHibernateImpl {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "ADMIN_HibernateUtil")
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
