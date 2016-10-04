/**
 * 
 */
package webbati.api.dao.hibernate.util;

import javax.ejb.SessionBean;

import org.springframework.stereotype.Service;

import common.api.application.impl.UserSession;
import webbati.api.application.impl.ApplicationWb;

/**
 * @author Kero
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_UserSession")
public class BfUserSession extends UserSession implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
