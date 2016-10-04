package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEtatDao;
import webbati.api.manager.interfaces.IEtatManager;
import webbati.api.metier.interfaces.IEtat;

/**
 * Classe <EtatManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EtatManager")
public class EtatManagerImpl extends BfGenericManagerImpl<IEtat, Integer> implements IEtatManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EtatDao")
	private IEtatDao etatDao;

	@Override
	protected IDao<IEtat, Integer> getMainDao() {
		return etatDao;
	}
}