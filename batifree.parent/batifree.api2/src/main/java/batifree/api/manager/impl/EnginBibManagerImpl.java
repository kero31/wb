/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.IEnginBibDao;
import batifree.api.manager.interfaces.IEnginBibManager;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <EnginBibManagerImpl>.
 * 
 */
@Service("BF_EnginBibManager")
public class EnginBibManagerImpl extends EnginManagerImpl<IEnginBib> implements IEnginBibManager {

	@Resource(name = "BF_EnginBibDao")
	private IEnginBibDao enginBibDao;

	@Override
	protected IDao<IEnginBib, Integer> getMainDao() {
		return enginBibDao;
	}

	@Override
	public IEnginEtude getEnginEtudeFromBib(IEnginBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(IEnginEtude.class));
	}
}
