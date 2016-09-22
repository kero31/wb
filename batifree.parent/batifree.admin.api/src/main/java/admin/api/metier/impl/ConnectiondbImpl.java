package admin.api.metier.impl;

import admin.api.metier.interfaces.IConnectiondb;

import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>ConnectiondbImpl</b><br/>
 *
 */
public class ConnectiondbImpl extends MetierImpl<Integer> implements IConnectiondb {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String driver;
	private String url;
	private String dialect;
	private Integer limitUserAlert;
	private String rootLogin;
	private String rootPassword;
	private String rootDbname;
	private Boolean enabled;

	@Override
	public void setDriver(String pDriver) {
		this.driver = pDriver;
	}

	@Override
	public String getDriver() {
		return driver;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String pUrl) {
		this.url = pUrl;
	}

	@Override
	public String getDialect() {
		return dialect;
	}

	@Override
	public void setDialect(String pDialect) {
		this.dialect = pDialect;
	}

	@Override
	public String getRootLogin() {
		return rootLogin;
	}

	@Override
	public void setRootLogin(String pRootLogin) {
		this.rootLogin = pRootLogin;
	}

	@Override
	public Integer getLimitUserAlert() {
		return limitUserAlert;
	}

	@Override
	public void setLimitUserAlert(Integer pLimitUserAlert) {
		this.limitUserAlert = pLimitUserAlert;
	}

	@Override
	public String getRootPassword() {
		return rootPassword;
	}

	@Override
	public void setRootPassword(String pRootPassword) {
		this.rootPassword = pRootPassword;
	}

	@Override
	public String getRootDbname() {
		return rootDbname;
	}

	@Override
	public void setRootDbname(String pRootDbname) {
		this.rootDbname = pRootDbname;
	}

	@Override
	public Boolean isEnabled() {
		return enabled == null ? false : enabled;
	}

	/**
	 * Get Enabled
	 * 
	 * @return Enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(Boolean pEnabled) {
		this.enabled = pEnabled;
	}
}