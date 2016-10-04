package admin.api.metier.impl;

import java.util.List;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>RoleImpl</b><br/>
 *
 */
public class RoleImpl extends MetierImpl<Integer> implements IRole {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private Integer projectId;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		this.code = pCode;
	}

	@Override
	public List<IUserAppli> getListUserAppli() throws WebbatiException {
		return ApplicationAdmin.getApplication().getRoleManager().getListUser(this);
	}

	@Override
	public IProject getProject() throws WebbatiException {
		return ApplicationAdmin.getApplication().getProjectManager().getById(projectId);
	}

	@Override
	public void setProject(IProject pProject) {
		if (pProject != null) {
			projectId = pProject.getId();
		} else {
			projectId = null;
		}
	}

	/**
	 * Retourne le champ projectId.
	 * 
	 * @return le projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * Met à jour le champ projectId.
	 * 
	 * @param pProjectId le projectId à mettre à jour
	 */
	public void setProjectId(Integer pProjectId) {
		projectId = pProjectId;
	}
}