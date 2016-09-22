/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ICoordonneeCntDao;
import batifree.api.manager.interfaces.ICoordonneeCntManager;
import batifree.api.metier.interfaces.ICoordonneeCnt;

import common.api.dao.interfaces.IDao;

/**
 * Classe <CoordonneeCntManagerImpl>.
 * 
 */
@Service("BF_CoordonneeCntManager")
public class CoordonneeCntManagerImpl extends BfGenericManagerImpl<ICoordonneeCnt, Integer> implements ICoordonneeCntManager {

	@Resource(name = "BF_CoordonneeCntDao")
	private ICoordonneeCntDao coordonneeCntDao;

	@Override
	protected IDao<ICoordonneeCnt, Integer> getMainDao() {
		return coordonneeCntDao;
	}

}
