package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IReglementDao;
import batifree.api.manager.interfaces.IReglementManager;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IReglement;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <ReglementManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_ReglementManager")
public class ReglementManagerImpl extends BfGenericManagerImpl<IReglement, Integer> implements IReglementManager {

	@Resource(name = "BF_ReglementDao")
	private IReglementDao reglementDao;

	@Override
	protected IDao<IReglement, Integer> getMainDao() {
		return reglementDao;
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws BatifreeException {
		return getListDaoFromObject(pReglement, reglementDao.getListEcheancierReglement(pReglement));
	}
}