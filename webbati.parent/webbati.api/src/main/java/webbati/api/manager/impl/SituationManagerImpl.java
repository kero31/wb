package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISituationDao;
import webbati.api.manager.interfaces.ISituationManager;
import webbati.api.metier.interfaces.ISituation;

/**
 * Classe <SituationManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_SituationManager")
public class SituationManagerImpl extends AffaireManagerImpl<ISituation> implements ISituationManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_SituationDao")
	private ISituationDao situationDao;

	@Override
	protected IDao<ISituation, Integer> getMainDao() {
		return situationDao;
	}
}