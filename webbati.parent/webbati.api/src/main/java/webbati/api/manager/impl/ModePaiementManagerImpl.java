/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IModePaiementDao;
import webbati.api.manager.interfaces.IModePaiementManager;
import webbati.api.metier.interfaces.IModePaiement;

/**
 * Classe <b>ModePaiementManagerImpl</b>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ModePaiementManager")
public class ModePaiementManagerImpl extends BfGenericManagerImpl<IModePaiement, Integer> implements IModePaiementManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ModePaiementDao")
	private IModePaiementDao modePaiementDao;

	@Override
	protected IDao<IModePaiement, Integer> getMainDao() {
		return modePaiementDao;
	}
}
