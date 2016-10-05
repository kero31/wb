package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILotBibDao;
import webbati.api.manager.interfaces.ILotBibManager;
import webbati.api.metier.interfaces.ILotBib;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotBibManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_LotBibManager")
public class LotBibManagerImpl extends LotManagerImpl<ILotBib> implements ILotBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_LotBibDao")
	private ILotBibDao lotBibDao;

	@Override
	protected IDao<ILotBib, Integer> getMainDao() {
		return lotBibDao;
	}

	@Override
	public ILotEtude getLotEtudeFromBib(ILotBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(ILotEtude.class));
	}
}