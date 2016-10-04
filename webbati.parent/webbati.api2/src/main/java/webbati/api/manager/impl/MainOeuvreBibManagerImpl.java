package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMainOeuvreBibDao;
import webbati.api.manager.interfaces.IMainOeuvreBibManager;
import webbati.api.metier.interfaces.IMainOeuvreBib;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Classe <MainOeuvreBibManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_MainOeuvreBibManager")
public class MainOeuvreBibManagerImpl extends MainOeuvreManagerImpl<IMainOeuvreBib> implements IMainOeuvreBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MainOeuvreBibDao")
	private IMainOeuvreBibDao mainOeuvreBibDao;

	@Override
	protected IDao<IMainOeuvreBib, Integer> getMainDao() {
		return mainOeuvreBibDao;
	}

	@Override
	public IMainOeuvreEtude getMainOeuvreEtudeFromBib(IMainOeuvreBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(IMainOeuvreEtude.class));
	}
}