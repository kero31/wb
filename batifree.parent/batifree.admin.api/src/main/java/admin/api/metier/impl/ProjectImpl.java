package admin.api.metier.impl;

import java.util.List;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>ProjectImpl</b><br/>
 *
 */
public class ProjectImpl extends MetierImpl<Integer> implements IProject {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String code;

	@Override
	public void setName(String pName) {
		this.name = pName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		this.code = pCode;
	}

	@Override
	public List<IRole> getListRole() throws BatifreeException {
		return ApplicationAdmin.getApplication().getProjectManager().getListRole(this);
	}

	@Override
	public List<IProjectscript> getListProjectscript() throws BatifreeException {
		return ApplicationAdmin.getApplication().getProjectManager().getListProjectscript(this);
	}
}