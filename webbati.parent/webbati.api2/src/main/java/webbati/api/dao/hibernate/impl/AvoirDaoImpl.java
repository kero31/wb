package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IAvoirDao;
import webbati.api.metier.ejb.Avoir;
import webbati.api.metier.impl.AvoirImpl;
import webbati.api.metier.interfaces.IAvoir;

/**
 * Classe <AvoirDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_AvoirDao")
public class AvoirDaoImpl extends AffaireDaoImpl<Avoir, AvoirImpl, IAvoir> implements IAvoirDao {

	/**
	 * Constructeur.
	 * 
	 */
	public AvoirDaoImpl() {
		super(Avoir.class, AvoirImpl.class);
	}
}