package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ITvaDao;
import batifree.api.metier.ejb.Tva;
import batifree.api.metier.impl.TvaImpl;
import batifree.api.metier.interfaces.ITva;

/**
 * Classe <TvaDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_TvaDao")
public class TvaDaoImpl extends BfGenericHibernateDaoImpl<Tva, TvaImpl, ITva, Integer> implements ITvaDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TvaDaoImpl() {
		super(Tva.class, TvaImpl.class);
	}
}