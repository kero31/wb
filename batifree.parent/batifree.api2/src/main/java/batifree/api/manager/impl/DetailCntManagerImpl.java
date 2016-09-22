/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IDetailCntDao;
import batifree.api.manager.interfaces.ICoordonneeCntManager;
import batifree.api.manager.interfaces.IDetailCntManager;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IDetailCnt;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <DetailCntManagerImpl>.
 * 
 */
@Service("BF_DetailCntManager")
public class DetailCntManagerImpl extends BfGenericManagerImpl<IDetailCnt, Integer> implements IDetailCntManager {

	@Resource(name = "BF_DetailCntDao")
	private IDetailCntDao detailCntDao;

	/** Le coordonneeCntManager. */
	@Resource(name = "BF_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	@Override
	protected IDao<IDetailCnt, Integer> getMainDao() {
		return detailCntDao;
	}

	@Override
	public void delete(IDetailCnt pMetier) throws BatifreeException {
		if (pMetier != null) {
			// Supprime le coordonnesContact associé
			ICoordonneeCnt coo = pMetier.getCoordonnee();
			if (coo != null) {
				coordonneeCntManager.delete(coo);
			}

			// Supprime le contact lui même
			super.delete(pMetier);
		}
	}

}
