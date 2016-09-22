/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ICiviliteDao;
import batifree.api.manager.interfaces.ICiviliteManager;
import batifree.api.metier.interfaces.ICivilite;

import common.api.dao.interfaces.IDao;

/**
 * Classe <CiviliteManagerImpl>.
 * 
 */
@Service("BF_CiviliteManager")
public class CiviliteManagerImpl extends BfGenericManagerImpl<ICivilite, Integer> implements ICiviliteManager {

	@Resource(name = "BF_CiviliteDao")
	private ICiviliteDao civiliteDao;

	@Override
	protected IDao<ICivilite, Integer> getMainDao() {
		return civiliteDao;
	}

}
