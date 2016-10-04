package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITvaDao;
import webbati.api.manager.interfaces.ITvaManager;
import webbati.api.metier.interfaces.ITva;

/**
 * Classe <TvaManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_TvaManager")
public class TvaManagerImpl extends BfGenericManagerImpl<ITva, Integer> implements ITvaManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_TvaDao")
	private ITvaDao tvaDao;

	@Override
	protected IDao<ITva, Integer> getMainDao() {
		return tvaDao;
	}
}