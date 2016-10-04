package admin.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IProjectDao;
import admin.api.metier.ejb.Project;
import admin.api.metier.impl.ProjectImpl;
import admin.api.metier.impl.ProjectscriptImpl;
import admin.api.metier.impl.RoleImpl;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;

import common.api.exception.WebbatiException;

/**
 * 
 * Classe/Interface <b>ProjectDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_ProjectDao")
public class ProjectDaoImpl extends AdminGenericHibernateDaoImpl<Project, ProjectImpl, IProject, Integer> implements IProjectDao {

	/**
	 * 
	 * Constructeur.
	 */
	public ProjectDaoImpl() {
		super(Project.class, ProjectImpl.class);
	}

	@Override
	public List<IRole> getListRole(IProject pProject) throws WebbatiException {
		Project project = getEjbFromMetier(pProject);
		if (project != null) {
			return getListMetierFromListEjb(project.getRoles(), RoleImpl.class, IRole.class);
		}
		return null;
	}

	@Override
	public List<IProjectscript> getListProjectscript(IProject pProject) throws WebbatiException {
		Project project = getEjbFromMetier(pProject);
		if (project != null) {
			return getListMetierFromListEjb(project.getProjectscripts(), ProjectscriptImpl.class, IProjectscript.class);
		}
		return null;
	}
}