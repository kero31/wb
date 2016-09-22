package batifree.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IReglementDao;
import batifree.api.metier.ejb.Reglement;
import batifree.api.metier.impl.EcheancierReglementImpl;
import batifree.api.metier.impl.ReglementImpl;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;

/**
 * Classe <ReglementDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_ReglementDao")
public class ReglementDaoImpl extends BfGenericHibernateDaoImpl<Reglement, ReglementImpl, IReglement, Integer> implements IReglementDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ReglementDaoImpl() {
		super(Reglement.class, ReglementImpl.class);
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IReglement pReglement) throws BatifreeException {
		Reglement obj = getEjbFromMetier(pReglement);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getEcheancierReglements(), EcheancierReglementImpl.class, IEcheancierReglement.class);
		}
		return null;
	}
}