/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IAvoirDao;
import batifree.api.manager.interfaces.IAvoirManager;
import batifree.api.metier.interfaces.IAvoir;

import common.api.dao.interfaces.IDao;

/**
 * Classe <AvoirManagerImpl>.
 * 
 */
@Service("BF_AvoirManager")
public class AvoirManagerImpl extends AffaireManagerImpl<IAvoir> implements IAvoirManager {

	@Resource(name = "BF_AvoirDao")
	private IAvoirDao avoirDao;

	@Override
	protected IDao<IAvoir, Integer> getMainDao() {
		return avoirDao;
	}

}
