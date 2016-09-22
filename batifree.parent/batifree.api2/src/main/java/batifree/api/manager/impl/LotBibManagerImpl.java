package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.ILotBibDao;
import batifree.api.manager.interfaces.ILotBibManager;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <LotBibManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_LotBibManager")
public class LotBibManagerImpl extends LotManagerImpl<ILotBib> implements ILotBibManager {

	@Resource(name = "BF_LotBibDao")
	private ILotBibDao lotBibDao;

	@Override
	protected IDao<ILotBib, Integer> getMainDao() {
		return lotBibDao;
	}

	@Override
	public ILotEtude getLotEtudeFromBib(ILotBib pBib) throws BatifreeException {
		return getClone(pBib, ApplicationBf.getApplication().getFactory().createNewInstance(ILotEtude.class));
	}
}