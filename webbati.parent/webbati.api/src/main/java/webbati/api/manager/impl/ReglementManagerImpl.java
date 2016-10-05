package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IReglementDao;
import webbati.api.manager.interfaces.IReglementManager;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IReglement;

/**
 * Classe <ReglementManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ReglementManager")
public class ReglementManagerImpl extends BfGenericManagerImpl<IReglement, Integer> implements IReglementManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ReglementDao")
	private IReglementDao reglementDao;

	@Override
	protected IDao<IReglement, Integer> getMainDao() {
		return reglementDao;
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws WebbatiException {
		return getListDaoFromObject(pReglement, reglementDao.getListEcheancierReglement(pReglement));
	}
}