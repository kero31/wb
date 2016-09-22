/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IEcheancierReglementDao;
import batifree.api.manager.interfaces.IEcheancierReglementManager;
import batifree.api.metier.ejb.EcheancierReglementId;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.dao.interfaces.IDao;

/**
 * Classe <EcheancierReglementManagerImpl>.
 * 
 */
@Service("BF_EcheancierReglementManager")
public class EcheancierReglementManagerImpl extends BfGenericManagerImpl<IEcheancierReglement, EcheancierReglementId> implements
        IEcheancierReglementManager {

	@Resource(name = "BF_EcheancierReglementDao")
	private IEcheancierReglementDao echeancierReglementDao;

	@Override
	protected IDao<IEcheancierReglement, EcheancierReglementId> getMainDao() {
		return echeancierReglementDao;
	}

}
