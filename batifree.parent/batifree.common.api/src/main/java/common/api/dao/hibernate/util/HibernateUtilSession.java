package common.api.dao.hibernate.util;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * 
 * Classe/Interface <HibernateUtilSession>
 *
 */
public abstract class HibernateUtilSession extends HibernateUtil implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pCodeProject code projet
	 */
	public HibernateUtilSession(String pCodeProject) {
		super(pCodeProject);
	}

	/**
	 * 
	 * Constructeur.
	 */
	public HibernateUtilSession() {
		this("");
	}

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
}