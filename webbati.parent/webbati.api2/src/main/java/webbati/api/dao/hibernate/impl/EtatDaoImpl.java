package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEtatDao;
import webbati.api.metier.ejb.Etat;
import webbati.api.metier.impl.EtatImpl;
import webbati.api.metier.interfaces.IEtat;

/**
 * Classe <EtatDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EtatDao")
public class EtatDaoImpl extends BfGenericHibernateDaoImpl<Etat, EtatImpl, IEtat, Integer> implements IEtatDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EtatDaoImpl() {
		super(Etat.class, EtatImpl.class);
	}
}