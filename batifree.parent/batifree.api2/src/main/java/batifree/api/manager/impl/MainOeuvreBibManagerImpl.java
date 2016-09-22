package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.IMainOeuvreBibDao;
import batifree.api.manager.interfaces.IMainOeuvreBibManager;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <MainOeuvreBibManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_MainOeuvreBibManager")
public class MainOeuvreBibManagerImpl extends MainOeuvreManagerImpl<IMainOeuvreBib> implements IMainOeuvreBibManager {

	@Resource(name = "BF_MainOeuvreBibDao")
	private IMainOeuvreBibDao mainOeuvreBibDao;

	@Override
	protected IDao<IMainOeuvreBib, Integer> getMainDao() {
		return mainOeuvreBibDao;
	}

	@Override
	public IMainOeuvreEtude getMainOeuvreEtudeFromBib(IMainOeuvreBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(IMainOeuvreEtude.class));
	}
}