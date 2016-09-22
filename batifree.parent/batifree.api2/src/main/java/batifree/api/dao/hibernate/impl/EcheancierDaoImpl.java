package batifree.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEcheancierDao;
import batifree.api.metier.ejb.Echeancier;
import batifree.api.metier.impl.EcheancierImpl;
import batifree.api.metier.impl.EcheancierReglementImpl;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.exception.BatifreeException;

/**
 * Classe <EcheancierDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EcheancierDao")
public class EcheancierDaoImpl extends BfGenericHibernateDaoImpl<Echeancier, EcheancierImpl, IEcheancier, Integer> implements IEcheancierDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EcheancierDaoImpl() {
		super(Echeancier.class, EcheancierImpl.class);
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws BatifreeException {
		Echeancier obj = getEjbFromMetier(pEcheancier);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getEcheancierReglements(), EcheancierReglementImpl.class, IEcheancierReglement.class);
		}
		return null;
	}
}