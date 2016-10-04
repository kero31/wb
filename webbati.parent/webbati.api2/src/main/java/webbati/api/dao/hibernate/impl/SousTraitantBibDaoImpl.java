package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISousTraitantBibDao;
import webbati.api.metier.ejb.SoustraitantBib;
import webbati.api.metier.impl.SousTraitantBibImpl;
import webbati.api.metier.interfaces.ISousTraitantBib;

/**
 * Classe <SousTraitantBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_SousTraitantBibDao")
public class SousTraitantBibDaoImpl extends SousTraitantDaoImpl<SoustraitantBib, SousTraitantBibImpl, ISousTraitantBib> implements
        ISousTraitantBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public SousTraitantBibDaoImpl() {
		super(SoustraitantBib.class, SousTraitantBibImpl.class);
	}
}