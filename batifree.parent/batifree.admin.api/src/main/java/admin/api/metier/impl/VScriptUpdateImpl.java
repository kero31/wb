/**
 * 
 */
package admin.api.metier.impl;

import admin.api.metier.interfaces.IVScriptUpdate;

/**
 * Classe <VScriptUpdateGI>.
 * 
 * @author Kero
 * 
 */
public class VScriptUpdateImpl implements IVScriptUpdate {

	private String url;
	private String driver;
	private String login;
	private String password;
	private Integer userprojectId;
	private Integer projectscriptId;
	private String filename;

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getDriver() {
		return driver;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Integer getUserAppliId() {
		return userprojectId;
	}

	@Override
	public Integer getProjectscriptId() {
		return projectscriptId;
	}

	/**
	 * Met à jour le champ url.
	 * 
	 * @param pUrl le url à mettre à jour
	 */
	public void setUrl(String pUrl) {
		url = pUrl;
	}

	/**
	 * Met à jour le champ driver.
	 * 
	 * @param pDriver le driver à mettre à jour
	 */
	public void setDriver(String pDriver) {
		driver = pDriver;
	}

	/**
	 * Met à jour le champ login.
	 * 
	 * @param pLogin le login à mettre à jour
	 */
	public void setLogin(String pLogin) {
		login = pLogin;
	}

	/**
	 * Met à jour le champ password.
	 * 
	 * @param pPassword le password à mettre à jour
	 */
	public void setPassword(String pPassword) {
		password = pPassword;
	}

	/**
	 * Met à jour le champ userprojectId.
	 * 
	 * @param pUserprojectId le userprojectId à mettre à jour
	 */
	public void setUserprojectId(Integer pUserprojectId) {
		userprojectId = pUserprojectId;
	}

	/**
	 * Met à jour le champ projectscriptId.
	 * 
	 * @param pProjectscriptId le projectscriptId à mettre à jour
	 */
	public void setProjectscriptId(Integer pProjectscriptId) {
		projectscriptId = pProjectscriptId;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	/**
	 * Met à jour le champ filename.
	 * 
	 * @param pFilename le filename à mettre à jour
	 */
	public void setFilename(String pFilename) {
		filename = pFilename;
	}

}
