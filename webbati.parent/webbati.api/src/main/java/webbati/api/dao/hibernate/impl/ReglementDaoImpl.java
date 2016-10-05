package webbati.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IReglementDao;
import webbati.api.metier.ejb.Reglement;
import webbati.api.metier.impl.EcheancierReglementImpl;
import webbati.api.metier.impl.ReglementImpl;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IReglement;

/**
 * Classe <ReglementDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ReglementDao")
public class ReglementDaoImpl extends BfGenericHibernateDaoImpl<Reglement, ReglementImpl, IReglement, Integer> implements IReglementDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ReglementDaoImpl() {
		super(Reglement.class, ReglementImpl.class);
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws WebbatiException {
		Reglement obj = getEjbFromMetier(pReglement);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getEcheancierReglements(), EcheancierReglementImpl.class, IEcheancierReglement.class);
		}
		return null;
	}
}