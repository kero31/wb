/**
 * 
 */
package admin.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IUserAppliDao;
import admin.api.manager.interfaces.IAdminDatabaseManager;
import admin.api.manager.interfaces.IUserAppliManager;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <UserAppliManagerImpl>.
 * 
 * @author Kero
 * 
 */
@Service("ADMIN_UserAppliManager")
public class UserAppliManagerImpl extends AdminGenericManagerImpl<IUserAppli, Integer> implements IUserAppliManager {

	private static final Logger LOGGER = Logger.getLogger(UserAppliManagerImpl.class);

	@Resource(name = "ADMIN_UserAppliDao")
	private IUserAppliDao userAppliDao;

	@Resource(name = "ADMIN_AdminDatabaseManager")
	private IAdminDatabaseManager adminDatabaseManager;

	@Override
	protected IDao<IUserAppli, Integer> getMainDao() {
		return userAppliDao;
	}

	@Override
	public IUserAppli getUserByUsername(String pUsername) throws BatifreeException {
		if (pUsername != null) {
			try {
				List<IUserAppli> list = getList();
				if (list != null) {
					for (IUserAppli user : list) {
						if (pUsername.equals(user.getUsername())) {
							return user;
						}
					}
				}
				LOGGER.info("Not Find");
			} catch (BatifreeException e) {
				LOGGER.info("Erreur : " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public List<IUserproject> getListUserproject(IUserAppli pUserAppli) throws BatifreeException {
		return getListDaoFromObject(pUserAppli, userAppliDao.getListUserproject(pUserAppli));
	}

	@Override
	public List<IRole> getListRole(IUserAppli pUserAppli) throws BatifreeException {
		return getListDaoFromObject(pUserAppli, userAppliDao.getListRole(pUserAppli));
	}

	@Override
	public void delete(IUserAppli pObject) throws BatifreeException {
		super.delete(pObject);
	}
}
