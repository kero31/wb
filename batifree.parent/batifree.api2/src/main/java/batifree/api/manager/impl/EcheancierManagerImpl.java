/**
 * 
 */
package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IEcheancierDao;
import batifree.api.manager.interfaces.IEcheancierManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <EcheancierManagerImpl>.
 * 
 */
@Service("BF_EcheancierManager")
public class EcheancierManagerImpl extends BfGenericManagerImpl<IEcheancier, Integer> implements IEcheancierManager {

	@Resource(name = "BF_EcheancierDao")
	private IEcheancierDao echeancierDao;

	@Override
	protected IDao<IEcheancier, Integer> getMainDao() {
		return echeancierDao;
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws BatifreeException {
		return getListDaoFromObject(pEcheancier, echeancierDao.getListEcheancierReglement(pEcheancier));
	}

	@Override
	public IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest) throws BatifreeException {
		return pNewEcheancierDest;
	}

	@Override
	public IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest, IAffaire pAffaire) throws BatifreeException {
		pNewEcheancierDest.setAffaire(pAffaire);
		return pNewEcheancierDest;
	}

}
