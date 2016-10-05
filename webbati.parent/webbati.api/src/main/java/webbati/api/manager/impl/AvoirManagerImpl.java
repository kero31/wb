/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IAvoirDao;
import webbati.api.manager.interfaces.IAvoirManager;
import webbati.api.metier.interfaces.IAvoir;

/**
 * Classe <AvoirManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_AvoirManager")
public class AvoirManagerImpl extends AffaireManagerImpl<IAvoir> implements IAvoirManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_AvoirDao")
	private IAvoirDao avoirDao;

	@Override
	protected IDao<IAvoir, Integer> getMainDao() {
		return avoirDao;
	}

}
