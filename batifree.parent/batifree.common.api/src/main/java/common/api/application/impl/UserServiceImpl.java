package common.api.application.impl;

import common.api.application.interfaces.IUserService;
import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
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
	public void closeSessions() throws WebbatiException {
	}

	/**
	 * Retourne le user app de session.
	 * 
	 * @return user app de session
	 */
	public abstract IUserApp getUserAppSession();

	@Override
	public IUserApp getUser() throws WebbatiUserException, WebbatiException {
		IUserApp user = null;
		if (sessionWeb) {
			user = getUserAppSession();
		} else {
			user = ServiceBeanFactory.getServiceBean(UserSingleton.class);
		}

		if (user == null) {
			throw new WebbatiUserException("Récupération de l'utilisateur SPRING impossible");
		}

		return user;
	}

	@Override
	public void updateInfoUserApp(IUserApp pUserApp) throws WebbatiUserException, WebbatiException {
		getUser().updateInfoUserApp(pUserApp);
	}

	@Override
	public boolean checkValidUser() throws WebbatiException {
		boolean bValid = false;
		try {
			bValid = getUser().isValid();
		} catch (WebbatiException | WebbatiUserException e) {
			throw new WebbatiException("L'utilisateur courant ne peut pas pour accéder à l'application à cause de :" + e.getMessage());
		}

		return bValid;
	}
}
