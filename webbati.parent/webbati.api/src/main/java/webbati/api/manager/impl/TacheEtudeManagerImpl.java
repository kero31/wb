package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITacheEtudeDao;
import webbati.api.manager.interfaces.ITacheEtudeManager;
import webbati.api.metier.interfaces.ITacheEtude;

/**
 * Classe <TacheEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_TacheEtudeManager")
public class TacheEtudeManagerImpl extends TacheManagerImpl<ITacheEtude> implements ITacheEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_TacheEtudeDao")
	private ITacheEtudeDao tacheEtudeDao;

	@Override
	protected IDao<ITacheEtude, Integer> getMainDao() {
		return tacheEtudeDao;
	}
}