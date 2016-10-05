package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISituationDao;
import webbati.api.metier.ejb.Situation;
import webbati.api.metier.impl.SituationImpl;
import webbati.api.metier.interfaces.ISituation;

/**
 * Classe <SituationDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_SituationDao")
public class SituationDaoImpl extends AffaireDaoImpl<Situation, SituationImpl, ISituation> implements ISituationDao {

	/**
	 * Constructeur.
	 * 
	 */
	public SituationDaoImpl() {
		super(Situation.class, SituationImpl.class);
	}
}