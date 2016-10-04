package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IPaysDao;
import webbati.api.manager.interfaces.IPaysManager;
import webbati.api.metier.interfaces.IPays;

/**
 * Classe <PaysManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_PaysManager")
public class PaysManagerImpl extends BfGenericManagerImpl<IPays, Integer> implements IPaysManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_PaysDao")
	private IPaysDao paysDao;

	@Override
	protected IDao<IPays, Integer> getMainDao() {
		return paysDao;
	}
}