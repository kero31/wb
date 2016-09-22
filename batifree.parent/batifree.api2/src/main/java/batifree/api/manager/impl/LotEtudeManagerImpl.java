package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ILotEtudeDao;
import batifree.api.manager.interfaces.ILotEtudeManager;
import batifree.api.metier.interfaces.ILotEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <LotEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_LotEtudeManager")
public class LotEtudeManagerImpl extends LotManagerImpl<ILotEtude> implements ILotEtudeManager {

	@Resource(name = "BF_LotEtudeDao")
	private ILotEtudeDao lotEtudeDao;

	@Override
	protected IDao<ILotEtude, Integer> getMainDao() {
		return lotEtudeDao;
	}
}