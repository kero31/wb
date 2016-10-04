/**
 * 
 */
package common.api.application.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IUserApp;

/**
 * Class <UserAppImpl> utilisateur applicatif.
 * 
 */
@Service("UserApp")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserAppImpl implements IUserApp {

	private String username = "";
	private String password = "";
	private String bdLogin = "";
	private String bdPassword = "";
	private String bdURL = "";
	private String bdDialect = "";
	private String bdDriver = "";
	private String bdShema = "";
	private List<String> listRole;
	private Boolean locked = false;

	/**
	 * 
	 * Constructeur.
	 */
	public UserAppImpl() {
		listRole = new ArrayList<String>();
	}

	@Override
	public void updateInfoUserApp(IUserApp pUser) {
		username = pUser.getUsername();
		password = pUser.getPassword();
		bdLogin = pUser.getBdLogin();
		bdPassword = pUser.getBdPassword();
		bdURL = pUser.getBdURL();
		bdShema = pUser.getBdShema();
		bdDialect = pUser.getBdDialect();
		bdDriver = pUser.getBdDriver();
		listRole = new ArrayList<String>(pUser.getListRole());
		locked = pUser.getLocked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUsername() {
		return getValue(username);
	}

	/**
	 * Set Username.
	 * 
	 * @param pUsername username
	 */
	public void setUsername(String pUsername) {
		this.username = pUsername;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return getValue(password);
	}

	/**
	 * Set Password
	 * 
	 * @param pPassword the password to set
	 */
	public void setPassword(String pPassword) {
		this.password = pPassword;
	}

	@Override
	public String getBdLogin() {
		return getValue(bdLogin);
	}

	/**
	 * Set BdLogin
	 * 
	 * @param pBdLogin the bdLogin to set
	 */
	public void setBdLogin(String pBdLogin) {
		this.bdLogin = pBdLogin;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBdPassword() {
		return getValue(bdPassword);
	}

	/**
	 * set BdPassword
	 * 
	 * @param pBdPassword the bdPassword to set
	 */
	public void setBdPassword(String pBdPassword) {
		this.bdPassword = pBdPassword;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBdURL() {
		return getValue(bdURL);
	}

	/**
	 * @param pBdURL the bdURL to set
	 */
	public void setBdURL(String pBdURL) {
		this.bdURL = pBdURL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBdDialect() {
		return getValue(bdDialect);
	}

	/**
	 * @param pBdDialect the bdDialect to set
	 */
	public void setBdDialect(String pBdDialect) {
		this.bdDialect = pBdDialect;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getListRole() {
		return listRole;
	}

	/**
	 * @param pListRole the listRole to set
	 */
	public void setListRole(List<String> pListRole) {
		this.listRole = pListRole;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBdDriver() {
		return getValue(bdDriver);
	}

	/**
	 * set BdDriver
	 * 
	 * @param pBdDriver the bdDriver to set
	 */
	public void setBdDriver(String pBdDriver) {
		this.bdDriver = pBdDriver;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isValid() throws WebbatiException {
		return !locked;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBdShema() {
		return bdShema;
	}

	/**
	 * Set BdShema
	 * 
	 * @param pBdShema the BdShema to set
	 */
	public void setBdShema(String pBdShema) {
		this.bdShema = pBdShema;
	}

	/**
	 * Return un string formatté par rapport à la valeur.
	 * 
	 * @param pValue valeur
	 * @return string formatté
	 */
	private String getValue(String pValue) {
		return pValue == null ? "" : pValue;
	}

	/**
	 * locked
	 * 
	 * @param pValue locked
	 */
	public void setLocked(Boolean pValue) {
		locked = pValue;
	}

	@Override
	public Boolean getLocked() {
		return locked;
	}
}
