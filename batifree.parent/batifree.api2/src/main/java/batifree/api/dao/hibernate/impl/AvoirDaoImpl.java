package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IAvoirDao;
import batifree.api.metier.ejb.Avoir;
import batifree.api.metier.impl.AvoirImpl;
import batifree.api.metier.interfaces.IAvoir;

/**
 * Classe <AvoirDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_AvoirDao")
public class AvoirDaoImpl extends AffaireDaoImpl<Avoir, AvoirImpl, IAvoir> implements IAvoirDao {

	/**
	 * Constructeur.
	 * 
	 */
	public AvoirDaoImpl() {
		super(Avoir.class, AvoirImpl.class);
	}
}