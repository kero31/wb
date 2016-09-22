package admin.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.api.dao.interfaces.IConnectiondbDao;
import admin.api.manager.interfaces.IConnectiondbManager;
import admin.api.metier.interfaces.IConnectiondb;

import common.api.dao.interfaces.IDao;

/**
 * Classe <ConnectiondbManagerImpl>.
 * 
 * 
 * 
 */
@Service("ADMIN_ConnectiondbManager")
public class ConnectiondbManagerImpl extends AdminGenericManagerImpl<IConnectiondb, Integer> implements IConnectiondbManager {

	@Resource(name = "ADMIN_ConnectiondbDao")
	private IConnectiondbDao connectiondbDao;

	@Override
	protected IDao<IConnectiondb, Integer> getMainDao() {
		return connectiondbDao;
	}
}