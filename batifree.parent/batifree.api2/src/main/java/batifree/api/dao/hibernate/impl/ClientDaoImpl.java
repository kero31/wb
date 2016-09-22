package batifree.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IClientDao;
import batifree.api.metier.ejb.Client;
import batifree.api.metier.impl.AffaireImpl;
import batifree.api.metier.impl.ClientImpl;
import batifree.api.metier.impl.CoordonneeCntImpl;
import batifree.api.metier.impl.ReglementImpl;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;
import common.api.util.MyBeanUtils;

/**
 * Classe <ClientDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_ClientDao")
public class ClientDaoImpl extends ContactDaoImpl<Client, ClientImpl, IClient> implements IClientDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ClientDaoImpl() {
		super(Client.class, ClientImpl.class);
	}

	@Override
	public List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws BatifreeException {
		Client client = getEjbFromMetier(pClient);
		if (client != null) {
			return getListMetierFromListEjb(client.getCoordonneecnts(), CoordonneeCntImpl.class, ICoordonneeCnt.class);
		}
		return null;
	}

	@Override
	public List<IAffaire> getListAffaire(IClient pClient) throws BatifreeException {
		Client client = getEjbFromMetier(pClient);
		if (client != null) {
			// return getListMetierFromListEjb(client.getAffaires(), AffaireImpl.class, IAffaire.class);
			List<IAffaire> listAffaire = new ArrayList<IAffaire>();
			List<? extends AffaireImpl> listAffaireImpl = MyBeanUtils.getInstance().copyPropertiesEJBList(AffaireDaoImpl.getMapClassImplWithEjb(),
			        client.getAffaires());
			if (listAffaireImpl != null) {
				for (AffaireImpl aff : listAffaireImpl) {
					listAffaire.add(aff);
				}
			}

			return listAffaire;
		}
		return null;
	}

	@Override
	protected <TEJB> Class<?> getClassMetierFromEjb(TEJB pEjb) {
		return AffaireDaoImpl.getClassImplFromEjb(pEjb);
	}

	@Override
	public List<IReglement> getListReglement(IClient pClient) throws BatifreeException {
		List<IReglement> listReglement = new ArrayList<>();

		if (pClient != null) {
			// Récupère la liste des Reglements

			Query query = getSession().createQuery("select rgl from EcheancierReglement as echRgl " + //
			        "inner join echRgl.reglement as rgl " + //
			        "inner join echRgl.echeancier as ech " + //
			        "inner join ech.affaire as aff " + //
			        "inner join aff.client as client " + //
			        "where client.id = :clientId").setParameter("clientId", 25);
			List<?> listRgl = query.list();

			// Rempli la liste des IReglement par rapport aux ejb renvoyés
			listReglement.addAll(getListMetierFromListEjb(listRgl, ReglementImpl.class, IReglement.class));
		}

		return listReglement;
	}
}