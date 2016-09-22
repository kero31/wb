package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IChantierDao;
import batifree.api.metier.ejb.Chantier;
import batifree.api.metier.impl.ChantierImpl;
import batifree.api.metier.interfaces.IChantier;

/**
 * Classe <ChantierDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_ChantierDao")
public class ChantierDaoImpl extends BfGenericHibernateDaoImpl<Chantier, ChantierImpl, IChantier, Integer> implements IChantierDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ChantierDaoImpl() {
		super(Chantier.class, ChantierImpl.class);
	}
}