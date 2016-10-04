package admin.api.metier.impl;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>ProjectscriptImpl</b><br/>
 *
 */
public class ProjectscriptImpl extends MetierImpl<Integer> implements IProjectscript {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	private Integer projectId;

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void setFileName(java.lang.String pFileName) {
		this.fileName = pFileName;
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