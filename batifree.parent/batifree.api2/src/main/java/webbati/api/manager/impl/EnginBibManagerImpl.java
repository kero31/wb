/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEnginBibDao;
import webbati.api.manager.interfaces.IEnginBibManager;
import webbati.api.metier.interfaces.IEnginBib;
import webbati.api.metier.interfaces.IEnginEtude;

/**
 * Classe <EnginBibManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EnginBibManager")
public class EnginBibManagerImpl extends EnginManagerImpl<IEnginBib> implements IEnginBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EnginBibDao")
	private IEnginBibDao enginBibDao;

	@Override
	protected IDao<IEnginBib, Integer> getMainDao() {
		return enginBibDao;
	}

	@Override
	public IEnginEtude getEnginEtudeFromBib(IEnginBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(IEnginEtude.class));
	}
}
