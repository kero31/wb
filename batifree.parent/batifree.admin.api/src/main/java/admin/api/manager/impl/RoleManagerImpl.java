package admin.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IRoleDao;
import admin.api.manager.interfaces.IRoleManager;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <RoleManagerImpl>.
 * 
 * 
 * 
 */
@Service("ADMIN_RoleManager")
public class RoleManagerImpl extends AdminGenericManagerImpl<IRole, Integer> implements IRoleManager {

	@Resource(name = "ADMIN_RoleDao")
	private IRoleDao roleDao;

	@Override
	protected IDao<IRole, Integer> getMainDao() {
		return roleDao;
	}

	@Override
	public List<IUserAppli> getListUser(IRole pRole) throws BatifreeException {
		return getListDaoFromObject(pRole, roleDao.getListUser(pRole));
	}
}