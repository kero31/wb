/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IDevisDao;
import batifree.api.manager.interfaces.IDevisManager;
import batifree.api.metier.interfaces.IDevis;

import common.api.dao.interfaces.IDao;

/**
 * Classe <DevisManagerImpl>.
 * 
 */
@Service("BF_DevisManager")
public class DevisManagerImpl extends AffaireManagerImpl<IDevis> implements IDevisManager {

	@Resource(name = "BF_DevisDao")
	private IDevisDao devisDao;

	@Override
	protected IDao<IDevis, Integer> getMainDao() {
		return devisDao;
	}

}
