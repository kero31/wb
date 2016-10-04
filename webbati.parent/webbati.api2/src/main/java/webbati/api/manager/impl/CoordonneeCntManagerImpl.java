/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICoordonneeCntDao;
import webbati.api.manager.interfaces.ICoordonneeCntManager;
import webbati.api.metier.interfaces.ICoordonneeCnt;

/**
 * Classe <CoordonneeCntManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_CoordonneeCntManager")
public class CoordonneeCntManagerImpl extends BfGenericManagerImpl<ICoordonneeCnt, Integer> implements ICoordonneeCntManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_CoordonneeCntDao")
	private ICoordonneeCntDao coordonneeCntDao;

	@Override
	protected IDao<ICoordonneeCnt, Integer> getMainDao() {
		return coordonneeCntDao;
	}

}
