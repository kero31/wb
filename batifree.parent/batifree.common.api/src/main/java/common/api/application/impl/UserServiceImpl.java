package common.api.application.impl;

import common.api.application.interfaces.IUserService;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.ServiceBeanFactory;

/**
 * 
 * Classe/Interface <UserServiceImpl>
 *
 */
public abstract class UserServiceImpl implements IUserService {

	private boolean sessionWeb = true;
	private boolean bdPasswordEncoded;

	@Override
	public boolean isSessionWeb() {
		return sessionWeb;
	}

	@Override
	public void setSessionWeb(boolean pSessionWeb) {
		this.sessionWeb = pSessionWeb;
	}

	@Override
	public void setBdPasswordEncoded(boolean pBdPasswordEncoded) {
		this.bdPasswordEncoded = pBdPasswordEncoded;
	}

	@Override
	public boolean isBdPasswordEncoded() {
		return bdPasswordEncoded;
	}

	@Override
	public void closeSessions() throws BatifreeException {
	}

	/**
	 * Retourne le user app de session.
	 * 
	 * @return user app de session
	 */
	public abstract IUserApp getUserAppSession();

	@Override
	public IUserApp getUser() throws BatifreeUserException, BatifreeException {
		IUserApp user = null;
		if (sessionWeb) {
			user = getUserAppSession();
		} else {
			user = ServiceBeanFactory.getServiceBean(UserSingleton.class);
		}

		if (user == null) {
			throw new BatifreeUserException("Récupération de l'utilisateur SPRING impossible");
		}

		return user;
	}

	@Override
	public void updateInfoUserApp(IUserApp pUserApp) throws BatifreeUserException, BatifreeException {
		getUser().updateInfoUserApp(pUserApp);
	}

	@Override
	public boolean checkValidUser() throws BatifreeException {
		boolean bValid = false;
		try {
			bValid = getUser().isValid();
		} catch (BatifreeException | BatifreeUserException e) {
			throw new BatifreeException("L'utilisateur courant ne peut pas pour accéder à l'application à cause de :" + e.getMessage());
		}

		return bValid;
	}
}
