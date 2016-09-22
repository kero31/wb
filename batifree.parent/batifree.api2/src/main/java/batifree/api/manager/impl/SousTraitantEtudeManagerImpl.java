package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ISousTraitantEtudeDao;
import batifree.api.manager.interfaces.ISousTraitantEtudeManager;
import batifree.api.metier.interfaces.ISousTraitantEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <SousTraitantEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_SousTraitantEtudeManager")
public class SousTraitantEtudeManagerImpl extends SousTraitantManagerImpl<ISousTraitantEtude> implements ISousTraitantEtudeManager {

	@Resource(name = "BF_SousTraitantEtudeDao")
	private ISousTraitantEtudeDao sousTraitantEtudeDao;

	@Override
	protected IDao<ISousTraitantEtude, Integer> getMainDao() {
		return sousTraitantEtudeDao;
	}
}