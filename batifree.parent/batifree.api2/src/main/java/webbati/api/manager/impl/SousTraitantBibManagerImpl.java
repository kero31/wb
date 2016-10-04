package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISousTraitantBibDao;
import webbati.api.manager.interfaces.ISousTraitantBibManager;
import webbati.api.metier.interfaces.ISousTraitantBib;
import webbati.api.metier.interfaces.ISousTraitantEtude;

/**
 * Classe <SousTraitantBibManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_SousTraitantBibManager")
public class SousTraitantBibManagerImpl extends SousTraitantManagerImpl<ISousTraitantBib> implements ISousTraitantBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_SousTraitantBibDao")
	private ISousTraitantBibDao sousTraitantBibDao;

	@Override
	protected IDao<ISousTraitantBib, Integer> getMainDao() {
		return sousTraitantBibDao;
	}

	@Override
	public ISousTraitantEtude getTacheEtudeFromBib(ISousTraitantBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(ISousTraitantEtude.class));
	}
}