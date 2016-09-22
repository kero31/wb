/**
 * 
 */
package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IDiversCntDao;
import batifree.api.manager.interfaces.IDiversCntManager;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <DiversCntManagerImpl>.
 * 
 */
@Service("BF_DiversCntManager")
public class DiversCntManagerImpl extends ContactManagerImpl<IDiversCnt> implements IDiversCntManager {

	@Resource(name = "BF_DiversCntDao")
	private IDiversCntDao diversCntDao;

	@Override
	protected IDao<IDiversCnt, Integer> getMainDao() {
		return diversCntDao;
	}

	@Override
	public List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws BatifreeException {
		return getListDaoFromObject(pDiversCnt, diversCntDao.getListGroupeContact(pDiversCnt));
	}

	@Override
	public void delete(IDiversCnt pMetier) throws BatifreeException {
		// Supprime l'association avec ses groupes
		pMetier.setListGroupeContact(null);

		// Supprime le divers contact lui même
		super.delete(pMetier);
	}

}
