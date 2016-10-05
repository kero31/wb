/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IDevisDao;
import webbati.api.manager.interfaces.IDevisManager;
import webbati.api.metier.interfaces.IDevis;

/**
 * Classe <DevisManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_DevisManager")
public class DevisManagerImpl extends AffaireManagerImpl<IDevis> implements IDevisManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_DevisDao")
	private IDevisDao devisDao;

	@Override
	protected IDao<IDevis, Integer> getMainDao() {
		return devisDao;
	}

}
