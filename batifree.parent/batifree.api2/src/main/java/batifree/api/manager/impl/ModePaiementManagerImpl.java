/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IModePaiementDao;
import batifree.api.manager.interfaces.IModePaiementManager;
import batifree.api.metier.interfaces.IModePaiement;

import common.api.dao.interfaces.IDao;

/**
 * Classe <b>ModePaiementManagerImpl</b>.
 * 
 */
@Service("BF_ModePaiementManager")
public class ModePaiementManagerImpl extends BfGenericManagerImpl<IModePaiement, Integer> implements IModePaiementManager {

	@Resource(name = "BF_ModePaiementDao")
	private IModePaiementDao modePaiementDao;

	@Override
	protected IDao<IModePaiement, Integer> getMainDao() {
		return modePaiementDao;
	}
}
