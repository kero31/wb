package admin.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IUserAppliDao;
import admin.api.dao.interfaces.IUserprojectDao;
import admin.api.manager.interfaces.IUserprojectManager;
import admin.api.metier.id.UserprojectId;
import admin.api.metier.interfaces.IProject;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <UserprojectManagerImpl>.
 * 
 * 
 * 
 */
@Service("ADMIN_UserprojectManager")
public class UserprojectManagerImpl extends AdminGenericManagerImpl<IUserproject, UserprojectId> implements IUserprojectManager {

	@Resource(name = "ADMIN_UserprojectDao")
	private IUserprojectDao userprojectDao;

	@Resource(name = "ADMIN_UserAppliDao")
	private IUserAppliDao userAppliDao;

	@Override
	protected IDao<IUserproject, UserprojectId> getMainDao() {
		return userprojectDao;
	}

	@Override
	public IUserproject getUserprojectFromUserAppliAndProject(IUserAppli pUserAppli, IProject pProject) throws BatifreeException {
		if (pUserAppli != null && pProject != null) {
			return getById(new UserprojectId(pUserAppli.getId(), pProject.getId()));
		}

		return null;
	}
}