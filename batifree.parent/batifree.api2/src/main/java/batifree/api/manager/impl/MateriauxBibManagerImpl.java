/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.IMateriauxBibDao;
import batifree.api.manager.interfaces.IMateriauxBibManager;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <MateriauxBibManagerImpl>.
 * 
 */
@Service("BF_MateriauxBibManager")
public class MateriauxBibManagerImpl extends MateriauxManagerImpl<IMateriauxBib> implements IMateriauxBibManager {

	@Resource(name = "BF_MateriauxBibDao")
	private IMateriauxBibDao materiauxBibDao;

	@Override
	protected IDao<IMateriauxBib, Integer> getMainDao() {
		return materiauxBibDao;
	}

	@Override
	public IMateriauxEtude getMateriauxEtudeFromBib(IMateriauxBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(IMateriauxEtude.class));
	}
}
