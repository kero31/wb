/**
 * 
 */
package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEcheancierDao;
import webbati.api.manager.interfaces.IEcheancierManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Classe <EcheancierManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EcheancierManager")
public class EcheancierManagerImpl extends BfGenericManagerImpl<IEcheancier, Integer> implements IEcheancierManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierDao")
	private IEcheancierDao echeancierDao;

	@Override
	protected IDao<IEcheancier, Integer> getMainDao() {
		return echeancierDao;
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws WebbatiException {
		return getListDaoFromObject(pEcheancier, echeancierDao.getListEcheancierReglement(pEcheancier));
	}

	@Override
	public IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest) throws WebbatiException {
		return pNewEcheancierDest;
	}

	@Override
	public IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest, IAffaire pAffaire) throws WebbatiException {
		pNewEcheancierDest.setAffaire(pAffaire);
		return pNewEcheancierDest;
	}

}
