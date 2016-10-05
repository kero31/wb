package webbati.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import common.api.util.MyBeanUtils;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IClientDao;
import webbati.api.metier.ejb.Client;
import webbati.api.metier.impl.AffaireImpl;
import webbati.api.metier.impl.ClientImpl;
import webbati.api.metier.impl.CoordonneeCntImpl;
import webbati.api.metier.impl.ReglementImpl;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IReglement;

/**
 * Classe <ClientDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ClientDao")
public class ClientDaoImpl extends ContactDaoImpl<Client, ClientImpl, IClient> implements IClientDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ClientDaoImpl() {
		super(Client.class, ClientImpl.class);
	}

	@Override
	public List<ICoordonneeCnt> getListCoordonnee(IClient pClient) throws WebbatiException {
		Client client = getEjbFromMetier(pClient);
		if (client != null) {
			return getListMetierFromListEjb(client.getCoordonneecnts(), CoordonneeCntImpl.class, ICoordonneeCnt.class);
		}
		return null;
	}

	@Override
	public List<IAffaire> getListAffaire(IClient pClient) throws WebbatiException {
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
	public List<IReglement> getListReglement(IClient pClient) throws WebbatiException {
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