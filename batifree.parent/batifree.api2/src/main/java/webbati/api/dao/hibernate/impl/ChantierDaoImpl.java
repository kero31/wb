package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IChantierDao;
import webbati.api.metier.ejb.Chantier;
import webbati.api.metier.impl.ChantierImpl;
import webbati.api.metier.interfaces.IChantier;

/**
 * Classe <ChantierDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ChantierDao")
public class ChantierDaoImpl extends BfGenericHibernateDaoImpl<Chantier, ChantierImpl, IChantier, Integer> implements IChantierDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ChantierDaoImpl() {
		super(Chantier.class, ChantierImpl.class);
	}
}