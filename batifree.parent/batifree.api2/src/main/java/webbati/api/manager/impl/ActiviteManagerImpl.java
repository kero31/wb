/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IActiviteDao;
import webbati.api.manager.interfaces.IActiviteManager;
import webbati.api.metier.interfaces.IActivite;

/**
 * Classe <ActiviteManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ActiviteManager")
public class ActiviteManagerImpl extends BfGenericManagerImpl<IActivite, Integer> implements IActiviteManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ActiviteDao")
	private IActiviteDao activiteDao;

	@Override
	protected IDao<IActivite, Integer> getMainDao() {
		return activiteDao;
	}

}
