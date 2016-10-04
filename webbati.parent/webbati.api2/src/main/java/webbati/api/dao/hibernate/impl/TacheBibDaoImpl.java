package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITacheBibDao;
import webbati.api.metier.ejb.TacheLotBib;
import webbati.api.metier.impl.TacheBibImpl;
import webbati.api.metier.interfaces.ITacheBib;

/**
 * Classe <TacheBibDaoImpl>.
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_TacheBibDao")
public class TacheBibDaoImpl extends TacheDaoImpl<TacheLotBib, TacheBibImpl, ITacheBib> implements ITacheBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TacheBibDaoImpl() {
		super(TacheLotBib.class, TacheBibImpl.class);
	}
}