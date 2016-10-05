package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IPaysDao;
import webbati.api.metier.ejb.Pays;
import webbati.api.metier.impl.PaysImpl;
import webbati.api.metier.interfaces.IPays;

/**
 * Classe <PaysDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_PaysDao")
public class PaysDaoImpl extends BfGenericHibernateDaoImpl<Pays, PaysImpl, IPays, Integer> implements IPaysDao {

	/**
	 * Constructeur.
	 * 
	 */
	public PaysDaoImpl() {
		super(Pays.class, PaysImpl.class);
	}
}