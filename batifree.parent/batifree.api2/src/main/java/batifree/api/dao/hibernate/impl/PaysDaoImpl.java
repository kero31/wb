package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IPaysDao;
import batifree.api.metier.ejb.Pays;
import batifree.api.metier.impl.PaysImpl;
import batifree.api.metier.interfaces.IPays;

/**
 * Classe <PaysDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_PaysDao")
public class PaysDaoImpl extends BfGenericHibernateDaoImpl<Pays, PaysImpl, IPays, Integer> implements IPaysDao {

	/**
	 * Constructeur.
	 * 
	 */
	public PaysDaoImpl() {
		super(Pays.class, PaysImpl.class);
	}
}