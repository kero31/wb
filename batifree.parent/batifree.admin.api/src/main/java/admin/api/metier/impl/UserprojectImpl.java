package admin.api.metier.impl;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.id.UserprojectId;
import admin.api.metier.interfaces.IConnectiondb;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>UserprojectImpl</b><br/>
 *
 */
public class UserprojectImpl extends MetierImpl<UserprojectId> implements IUserproject {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String bdLogin;
	private String bdPassword;
	private String bdDbname;
	private Integer connectiondbId = null;
	private Integer projectscriptId = null;

	/**
	 * 
	 * Constructeur.
	 * 
	 */
	public UserprojectImpl() {
		setId(new UserprojectId());
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pUserAppli userAppli
	 * @param pProject project
	 * @throws BatifreeException
	 */
	public UserprojectImpl(IUserAppli pUserAppli, IProject pProject) throws BatifreeException {
		if (pUserAppli == null || pProject == null || pUserAppli.getId() == null || pProject.getId() == null) {
			String userIdException = "";
			String projectIdException = "";
			if (pUserAppli != null) {
				userIdException = ", UserAppliId=" + pUserAppli.getId();
			}
			if (pProject != null) {
				projectIdException = ", ProjectId=" + pProject.getId();
			}
			throw new BatifreeException("Le UserAppli et le Project ainsi que leurs IDs ne peuvent pas être vide. " + "UserAppli=" + pUserAppli
			        + userIdException + ", Project=" + pProject + projectIdException);
		}

		setId(new UserprojectId(pUserAppli.getId(), pProject.getId()));
	}

	@Override
	public String getBdPassword() {
		return bdPassword;
	}

	@Override
	public void setBdPassword(String pBdPassword) {
		this.bdPassword = pBdPassword;
	}

	@Override
	public String getBdLogin() {
		return bdLogin;
	}

	@Override
	public void setBdLogin(String pBdLogin) {
		this.bdLogin = pBdLogin;
	}

	@Override
	public String getBdDbname() {
		return bdDbname;
	}

	@Override
	public void setBdDbname(String pBdDbname) {
		this.bdDbname = pBdDbname;
	}

	@Override
	public IUserAppli getUserappli() throws BatifreeException {
		return ApplicationAdmin.getApplication().getUserAppliManager().getById(getId().getUseId());
	}

	@Override
	public void setUserappli(IUserAppli pUserAppli) throws BatifreeException {
		if (pUserAppli != null && pUserAppli.getId() != null) {
			getId().setUseId(pUserAppli.getId());
		} else {
			throw new BatifreeException("Le UserAppli ne peut pas être vide");
		}
	}

	@Override
	public IProject getProject() throws BatifreeException {
		return ApplicationAdmin.getApplication().getProjectManager().getById(getId().getProId());
	}

	@Override
	public void setProject(IProject pProject) throws BatifreeException {
		if (pProject != null) {
			getId().setProId(pProject.getId());
		} else {
			throw new BatifreeException("Le Projet ne peut pas être vide");
		}
	}

	@Override
	public IConnectiondb getConnectiondb() throws BatifreeException {
		return ApplicationAdmin.getApplication().getConnectiondbManager().getById(connectiondbId);
	}

	@Override
	public void setConnectiondb(IConnectiondb pConnectiondb) {
		if (pConnectiondb != null) {
			connectiondbId = pConnectiondb.getId();
		} else {
			connectiondbId = null;
		}
	}

	@Override
	public IProjectscript getProjectscript() throws BatifreeException {
		return ApplicationAdmin.getApplication().getProjectscriptManager().getById(projectscriptId);
	}

	@Override
	public void setProjectscript(IProjectscript pProjectscript) {
		if (pProjectscript != null) {
			projectscriptId = pProjectscript.getId();
		} else {
			projectscriptId = null;
		}
	}

	/**
	 * Retourne le champ connectiondbId.
	 * 
	 * @return le connectiondbId
	 */
	public Integer getConnectiondbId() {
		return connectiondbId;
	}

	/**
	 * Met à jour le champ connectiondbId.
	 * 
	 * @param pConnectiondbId le connectiondbId à mettre à jour
	 */
	public void setConnectiondbId(Integer pConnectiondbId) {
		connectiondbId = pConnectiondbId;
	}

	/**
	 * Retourne le champ projectScriptId.
	 * 
	 * @return le projectScriptId
	 */
	public Integer getProjectscriptId() {
		return projectscriptId;
	}

	/**
	 * Met à jour le champ projectScriptId.
	 * 
	 * @param pProjectScriptId le projectScriptId à mettre à jour
	 */
	public void setProjectscriptId(Integer pProjectScriptId) {
		projectscriptId = pProjectScriptId;
	}

}