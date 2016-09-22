package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IPaysDao;
import batifree.api.manager.interfaces.IPaysManager;
import batifree.api.metier.interfaces.IPays;

import common.api.dao.interfaces.IDao;

/**
 * Classe <PaysManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_PaysManager")
public class PaysManagerImpl extends BfGenericManagerImpl<IPays, Integer> implements IPaysManager {

	@Resource(name = "BF_PaysDao")
	private IPaysDao paysDao;

	@Override
	protected IDao<IPays, Integer> getMainDao() {
		return paysDao;
	}
}