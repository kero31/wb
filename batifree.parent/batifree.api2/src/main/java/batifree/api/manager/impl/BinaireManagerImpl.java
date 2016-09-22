/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IBinaireDao;
import batifree.api.manager.interfaces.IBinaireManager;
import batifree.api.metier.interfaces.IBinaire;

import common.api.dao.interfaces.IDao;

/**
 * Classe <BinaireManagerImpl>.
 * 
 */
@Service("BF_BinaireManager")
public class BinaireManagerImpl extends BfGenericManagerImpl<IBinaire, Integer> implements IBinaireManager {

	@Resource(name = "BF_BinaireDao")
	private IBinaireDao binaireDao;

	@Override
	protected IDao<IBinaire, Integer> getMainDao() {
		return binaireDao;
	}

}
