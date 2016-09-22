package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ILocalisationDao;
import batifree.api.manager.interfaces.ILocalisationManager;
import batifree.api.metier.interfaces.ILocalisation;

import common.api.dao.interfaces.IDao;

/**
 * Classe <LocalisationManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_LocalisationManager")
public class LocalisationManagerImpl extends BfGenericManagerImpl<ILocalisation, Integer> implements ILocalisationManager {

	@Resource(name = "BF_LocalisationDao")
	private ILocalisationDao localisationDao;

	@Override
	protected IDao<ILocalisation, Integer> getMainDao() {
		return localisationDao;
	}
}