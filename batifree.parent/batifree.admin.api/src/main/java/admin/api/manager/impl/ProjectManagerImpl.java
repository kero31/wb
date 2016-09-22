package admin.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IProjectDao;
import admin.api.manager.interfaces.IProjectManager;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IProjectscript;
import admin.api.metier.interfaces.IRole;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <ProjectManagerImpl>.
 * 
 * 
 * 
 */
@Service("ADMIN_ProjectManager")
public class ProjectManagerImpl extends AdminGenericManagerImpl<IProject, Integer> implements IProjectManager {

	@Resource(name = "ADMIN_ProjectDao")
	private IProjectDao projectDao;

	@Override
	protected IDao<IProject, Integer> getMainDao() {
		return projectDao;
	}

	@Override
	public IProject getProjectByCode(String pCodeProject) throws BatifreeException {
		if (pCodeProject != null && !pCodeProject.isEmpty()) {
			List<IProject> list = getList();
			if (list != null) {
				for (IProject project : list) {
					if (pCodeProject.equals(project.getCode())) {
						return project;
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<IRole> getListRole(IProject pProject) throws BatifreeException {
		return getListDaoFromObject(pProject, projectDao.getListRole(pProject));
	}

	@Override
	public List<IProjectscript> getListProjectscript(IProject pProject) throws BatifreeException {
		return getListDaoFromObject(pProject, projectDao.getListProjectscript(pProject));
	}
}