/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IBinaireDao;
import webbati.api.manager.interfaces.IBinaireManager;
import webbati.api.metier.interfaces.IBinaire;

/**
 * Classe <BinaireManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_BinaireManager")
public class BinaireManagerImpl extends BfGenericManagerImpl<IBinaire, Integer> implements IBinaireManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_BinaireDao")
	private IBinaireDao binaireDao;

	@Override
	protected IDao<IBinaire, Integer> getMainDao() {
		return binaireDao;
	}

}
