/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICiviliteDao;
import webbati.api.manager.interfaces.ICiviliteManager;
import webbati.api.metier.interfaces.ICivilite;

/**
 * Classe <CiviliteManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_CiviliteManager")
public class CiviliteManagerImpl extends BfGenericManagerImpl<ICivilite, Integer> implements ICiviliteManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_CiviliteDao")
	private ICiviliteDao civiliteDao;

	@Override
	protected IDao<ICivilite, Integer> getMainDao() {
		return civiliteDao;
	}

}
