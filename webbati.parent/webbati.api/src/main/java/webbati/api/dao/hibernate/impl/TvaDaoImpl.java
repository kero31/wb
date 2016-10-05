package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITvaDao;
import webbati.api.metier.ejb.Tva;
import webbati.api.metier.impl.TvaImpl;
import webbati.api.metier.interfaces.ITva;

/**
 * Classe <TvaDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_TvaDao")
public class TvaDaoImpl extends BfGenericHibernateDaoImpl<Tva, TvaImpl, ITva, Integer> implements ITvaDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TvaDaoImpl() {
		super(Tva.class, TvaImpl.class);
	}
}