package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.ISousTraitantBibDao;
import batifree.api.manager.interfaces.ISousTraitantBibManager;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <SousTraitantBibManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_SousTraitantBibManager")
public class SousTraitantBibManagerImpl extends SousTraitantManagerImpl<ISousTraitantBib> implements ISousTraitantBibManager {

	@Resource(name = "BF_SousTraitantBibDao")
	private ISousTraitantBibDao sousTraitantBibDao;

	@Override
	protected IDao<ISousTraitantBib, Integer> getMainDao() {
		return sousTraitantBibDao;
	}

	@Override
	public ISousTraitantEtude getTacheEtudeFromBib(ISousTraitantBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(ISousTraitantEtude.class));
	}
}