package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ITvaDao;
import batifree.api.manager.interfaces.ITvaManager;
import batifree.api.metier.interfaces.ITva;

import common.api.dao.interfaces.IDao;

/**
 * Classe <TvaManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_TvaManager")
public class TvaManagerImpl extends BfGenericManagerImpl<ITva, Integer> implements ITvaManager {

	@Resource(name = "BF_TvaDao")
	private ITvaDao tvaDao;

	@Override
	protected IDao<ITva, Integer> getMainDao() {
		return tvaDao;
	}
}