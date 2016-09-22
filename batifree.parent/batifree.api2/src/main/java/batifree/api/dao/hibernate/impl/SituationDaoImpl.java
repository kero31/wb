package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ISituationDao;
import batifree.api.metier.ejb.Situation;
import batifree.api.metier.impl.SituationImpl;
import batifree.api.metier.interfaces.ISituation;

/**
 * Classe <SituationDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_SituationDao")
public class SituationDaoImpl extends AffaireDaoImpl<Situation, SituationImpl, ISituation> implements ISituationDao {

	/**
	 * Constructeur.
	 * 
	 */
	public SituationDaoImpl() {
		super(Situation.class, SituationImpl.class);
	}
}