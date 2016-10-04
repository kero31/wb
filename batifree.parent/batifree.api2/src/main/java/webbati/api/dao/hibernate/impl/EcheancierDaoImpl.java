package webbati.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEcheancierDao;
import webbati.api.metier.ejb.Echeancier;
import webbati.api.metier.impl.EcheancierImpl;
import webbati.api.metier.impl.EcheancierReglementImpl;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Classe <EcheancierDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EcheancierDao")
public class EcheancierDaoImpl extends BfGenericHibernateDaoImpl<Echeancier, EcheancierImpl, IEcheancier, Integer> implements IEcheancierDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EcheancierDaoImpl() {
		super(Echeancier.class, EcheancierImpl.class);
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws WebbatiException {
		Echeancier obj = getEjbFromMetier(pEcheancier);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getEcheancierReglements(), EcheancierReglementImpl.class, IEcheancierReglement.class);
		}
		return null;
	}
}