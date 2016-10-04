package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILotEtudeDao;
import webbati.api.manager.interfaces.ILotEtudeManager;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_LotEtudeManager")
public class LotEtudeManagerImpl extends LotManagerImpl<ILotEtude> implements ILotEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_LotEtudeDao")
	private ILotEtudeDao lotEtudeDao;

	@Override
	protected IDao<ILotEtude, Integer> getMainDao() {
		return lotEtudeDao;
	}
}