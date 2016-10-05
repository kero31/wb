package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILocalisationDao;
import webbati.api.manager.interfaces.ILocalisationManager;
import webbati.api.metier.interfaces.ILocalisation;

/**
 * Classe <LocalisationManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_LocalisationManager")
public class LocalisationManagerImpl extends BfGenericManagerImpl<ILocalisation, Integer> implements ILocalisationManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_LocalisationDao")
	private ILocalisationDao localisationDao;

	@Override
	protected IDao<ILocalisation, Integer> getMainDao() {
		return localisationDao;
	}
}