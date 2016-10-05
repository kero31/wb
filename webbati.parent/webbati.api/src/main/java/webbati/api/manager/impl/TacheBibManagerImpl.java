package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITacheBibDao;
import webbati.api.manager.interfaces.ITacheBibManager;
import webbati.api.metier.interfaces.ITacheBib;
import webbati.api.metier.interfaces.ITacheEtude;

/**
 * Classe <TacheBibManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_TacheBibManager")
public class TacheBibManagerImpl extends TacheManagerImpl<ITacheBib> implements ITacheBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_TacheBibDao")
	private ITacheBibDao tacheBibDao;

	@Override
	protected IDao<ITacheBib, Integer> getMainDao() {
		return tacheBibDao;
	}

	@Override
	public ITacheEtude getTacheEtudeFromBib(ITacheBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(ITacheEtude.class));
	}
}