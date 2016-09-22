package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ITacheEtudeDao;
import batifree.api.manager.interfaces.ITacheEtudeManager;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <TacheEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_TacheEtudeManager")
public class TacheEtudeManagerImpl extends TacheManagerImpl<ITacheEtude> implements ITacheEtudeManager {

	@Resource(name = "BF_TacheEtudeDao")
	private ITacheEtudeDao tacheEtudeDao;

	@Override
	protected IDao<ITacheEtude, Integer> getMainDao() {
		return tacheEtudeDao;
	}
}