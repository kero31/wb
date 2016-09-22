package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEtatDao;
import batifree.api.metier.ejb.Etat;
import batifree.api.metier.impl.EtatImpl;
import batifree.api.metier.interfaces.IEtat;

/**
 * Classe <EtatDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EtatDao")
public class EtatDaoImpl extends BfGenericHibernateDaoImpl<Etat, EtatImpl, IEtat, Integer> implements IEtatDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EtatDaoImpl() {
		super(Etat.class, EtatImpl.class);
	}
}