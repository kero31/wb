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
import webbati.api.dao.interfaces.IDiversCntDao;
import webbati.api.manager.interfaces.IDiversCntManager;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Classe <DiversCntManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_DiversCntManager")
public class DiversCntManagerImpl extends ContactManagerImpl<IDiversCnt> implements IDiversCntManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_DiversCntDao")
	private IDiversCntDao diversCntDao;

	@Override
	protected IDao<IDiversCnt, Integer> getMainDao() {
		return diversCntDao;
	}

	@Override
	public List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws WebbatiException {
		return getListDaoFromObject(pDiversCnt, diversCntDao.getListGroupeContact(pDiversCnt));
	}

	@Override
	public void delete(IDiversCnt pMetier) throws WebbatiException {
		// Supprime l'association avec ses groupes
		pMetier.setListGroupeContact(null);

		// Supprime le divers contact lui même
		super.delete(pMetier);
	}

}
