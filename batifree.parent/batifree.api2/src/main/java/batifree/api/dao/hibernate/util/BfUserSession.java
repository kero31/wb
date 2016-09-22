/**
 * 
 */
package batifree.api.dao.hibernate.util;

import javax.ejb.SessionBean;

import org.springframework.stereotype.Service;

import common.api.application.impl.UserSession;

/**
 * @author Kero
 * 
 */
@Service("BF_UserSession")
public class BfUserSession extends UserSession implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
