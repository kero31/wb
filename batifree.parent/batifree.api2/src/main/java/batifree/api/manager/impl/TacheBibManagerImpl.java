package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.ITacheBibDao;
import batifree.api.manager.interfaces.ITacheBibManager;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <TacheBibManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_TacheBibManager")
public class TacheBibManagerImpl extends TacheManagerImpl<ITacheBib> implements ITacheBibManager {

	@Resource(name = "BF_TacheBibDao")
	private ITacheBibDao tacheBibDao;

	@Override
	protected IDao<ITacheBib, Integer> getMainDao() {
		return tacheBibDao;
	}

	@Override
	public ITacheEtude getTacheEtudeFromBib(ITacheBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(ITacheEtude.class));
	}
}