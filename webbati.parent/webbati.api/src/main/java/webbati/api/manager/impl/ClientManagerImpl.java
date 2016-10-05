/**
 * 
 */
package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IClientDao;
import webbati.api.manager.interfaces.IClientManager;
import webbati.api.manager.interfaces.ICoordonneeCntManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IReglement;

/**
 * Classe <ClientManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ClientManager")
public class ClientManagerImpl extends ContactManagerImpl<IClient> implements IClientManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ClientDao")
	private IClientDao clientDao;

	/** Le coordonneeCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	@Override
	protected IDao<IClient, Integer> getMainDao() {
		return clientDao;
	}

	@Override
	public List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws WebbatiException {
		return getListDaoFromObject(pClient, clientDao.getListCoordonnee(pClient));
	}

	@Override
	public List<IAffaire> getListAffaire(IClient pClient) throws WebbatiException {
		return getListDaoFromObject(pClient, clientDao.getListAffaire(pClient));
	}

	@Override
	public void delete(IClient pMetier) throws WebbatiException {
		if (pMetier != null) {
			// Supprime les coordonnées contact associés
			coordonneeCntManager.delete(pMetier.getListCoordonnee());

			// Suprime le client lui même
			super.delete(pMetier);
		}
	}

	@Override
	public List<IReglement> getListReglement(IClient pClient) throws WebbatiException {
		return getListDaoFromObject(pClient, clientDao.getListReglement(pClient));
	}
}
