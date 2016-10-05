/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IDetailCntDao;
import webbati.api.manager.interfaces.ICoordonneeCntManager;
import webbati.api.manager.interfaces.IDetailCntManager;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * Classe <DetailCntManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_DetailCntManager")
public class DetailCntManagerImpl extends BfGenericManagerImpl<IDetailCnt, Integer> implements IDetailCntManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_DetailCntDao")
	private IDetailCntDao detailCntDao;

	/** Le coordonneeCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	@Override
	protected IDao<IDetailCnt, Integer> getMainDao() {
		return detailCntDao;
	}

	@Override
	public void delete(IDetailCnt pMetier) throws WebbatiException {
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
