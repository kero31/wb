package admin.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IProjectscriptDao;
import admin.api.manager.interfaces.IProjectscriptManager;
import admin.api.metier.interfaces.IProjectscript;

import common.api.dao.interfaces.IDao;

/**
 * Classe <ProjectscriptManagerImpl>.
 * 
 * 
 * 
 */
@Service("ADMIN_ProjectscriptManager")
public class ProjectscriptManagerImpl extends AdminGenericManagerImpl<IProjectscript, Integer> implements IProjectscriptManager {

	@Resource(name = "ADMIN_ProjectscriptDao")
	private IProjectscriptDao projectscriptDao;

	@Override
	protected IDao<IProjectscript, Integer> getMainDao() {
		return projectscriptDao;
	}
}