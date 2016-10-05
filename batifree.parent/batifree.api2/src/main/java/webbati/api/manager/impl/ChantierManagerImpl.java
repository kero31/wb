/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IChantierDao;
import webbati.api.manager.interfaces.IChantierManager;
import webbati.api.metier.interfaces.IChantier;

/**
 * Classe <ChantierManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ChantierManager")
public class ChantierManagerImpl extends BfGenericManagerImpl<IChantier, Integer> implements IChantierManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ChantierDao")
	private IChantierDao chantierDao;

	@Override
	protected IDao<IChantier, Integer> getMainDao() {
		return chantierDao;
	}

}
