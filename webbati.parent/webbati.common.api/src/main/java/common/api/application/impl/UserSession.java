/**
 * 
 */
package common.api.application.impl;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * 
 * Classe/Interface <UserSession>
 *
 */
public abstract class UserSession extends UserAppImpl implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
	}

	@Override
	public void setSessionContext(SessionContext pArg0) throws EJBException, RemoteException {
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() {
	}
}
