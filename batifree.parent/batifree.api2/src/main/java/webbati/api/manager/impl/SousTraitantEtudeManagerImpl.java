package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISousTraitantEtudeDao;
import webbati.api.manager.interfaces.ISousTraitantEtudeManager;
import webbati.api.metier.interfaces.ISousTraitantEtude;

/**
 * Classe <SousTraitantEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_SousTraitantEtudeManager")
public class SousTraitantEtudeManagerImpl extends SousTraitantManagerImpl<ISousTraitantEtude> implements ISousTraitantEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_SousTraitantEtudeDao")
	private ISousTraitantEtudeDao sousTraitantEtudeDao;

	@Override
	protected IDao<ISousTraitantEtude, Integer> getMainDao() {
		return sousTraitantEtudeDao;
	}
}