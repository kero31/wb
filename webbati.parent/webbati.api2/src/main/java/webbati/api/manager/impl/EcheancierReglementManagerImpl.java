/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEcheancierReglementDao;
import webbati.api.manager.interfaces.IEcheancierReglementManager;
import webbati.api.metier.ejb.EcheancierReglementId;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Classe <EcheancierReglementManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EcheancierReglementManager")
public class EcheancierReglementManagerImpl extends BfGenericManagerImpl<IEcheancierReglement, EcheancierReglementId> implements
        IEcheancierReglementManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierReglementDao")
	private IEcheancierReglementDao echeancierReglementDao;

	@Override
	protected IDao<IEcheancierReglement, EcheancierReglementId> getMainDao() {
		return echeancierReglementDao;
	}

}
