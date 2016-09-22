/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IActiviteDao;
import batifree.api.manager.interfaces.IActiviteManager;
import batifree.api.metier.interfaces.IActivite;

import common.api.dao.interfaces.IDao;

/**
 * Classe <ActiviteManagerImpl>.
 * 
 */
@Service("BF_ActiviteManager")
public class ActiviteManagerImpl extends BfGenericManagerImpl<IActivite, Integer> implements IActiviteManager {

	@Resource(name = "BF_ActiviteDao")
	private IActiviteDao activiteDao;

	@Override
	protected IDao<IActivite, Integer> getMainDao() {
		return activiteDao;
	}

}
