/**
 * 
 */
package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IClientDao;
import batifree.api.manager.interfaces.IClientManager;
import batifree.api.manager.interfaces.ICoordonneeCntManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IReglement;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <ClientManagerImpl>.
 * 
 */
@Service("BF_ClientManager")
public class ClientManagerImpl extends ContactManagerImpl<IClient> implements IClientManager {

	@Resource(name = "BF_ClientDao")
	private IClientDao clientDao;

	/** Le coordonneeCntManager. */
	@Resource(name = "BF_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	@Override
	protected IDao<IClient, Integer> getMainDao() {
		return clientDao;
	}

	@Override
	public List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws BatifreeException {
		return getListDaoFromObject(pClient, clientDao.getListCoordonnee(pClient));
	}

	@Override
	public List<IAffaire> getListAffaire(IClient pClient) throws BatifreeException {
		return getListDaoFromObject(pClient, clientDao.getListAffaire(pClient));
	}

	@Override
	public void delete(IClient pMetier) throws BatifreeException {
		if (pMetier != null) {
			// Supprime les coordonnées contact associés
			coordonneeCntManager.delete(pMetier.getListCoordonnee());

			// Suprime le client lui même
			super.delete(pMetier);
		}
	}

	@Override
	public List<IReglement> getListReglement(IClient pClient) throws BatifreeException {
		return getListDaoFromObject(pClient, clientDao.getListReglement(pClient));
	}
}
