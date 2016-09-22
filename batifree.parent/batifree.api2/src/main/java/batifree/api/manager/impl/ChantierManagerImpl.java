/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IChantierDao;
import batifree.api.manager.interfaces.IChantierManager;
import batifree.api.metier.interfaces.IChantier;

import common.api.dao.interfaces.IDao;

/**
 * Classe <ChantierManagerImpl>.
 * 
 */
@Service("BF_ChantierManager")
public class ChantierManagerImpl extends BfGenericManagerImpl<IChantier, Integer> implements IChantierManager {

	@Resource(name = "BF_ChantierDao")
	private IChantierDao chantierDao;

	@Override
	protected IDao<IChantier, Integer> getMainDao() {
		return chantierDao;
	}

}
