package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ISituationDao;
import batifree.api.manager.interfaces.ISituationManager;
import batifree.api.metier.interfaces.ISituation;

import common.api.dao.interfaces.IDao;

/**
 * Classe <SituationManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_SituationManager")
public class SituationManagerImpl extends AffaireManagerImpl<ISituation> implements ISituationManager {

	@Resource(name = "BF_SituationDao")
	private ISituationDao situationDao;

	@Override
	protected IDao<ISituation, Integer> getMainDao() {
		return situationDao;
	}
}