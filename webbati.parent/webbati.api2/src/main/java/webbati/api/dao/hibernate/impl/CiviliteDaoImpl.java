package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICiviliteDao;
import webbati.api.metier.ejb.Civilite;
import webbati.api.metier.impl.CiviliteImpl;
import webbati.api.metier.interfaces.ICivilite;

/**
 * Classe <CiviliteDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_CiviliteDao")
public class CiviliteDaoImpl extends BfGenericHibernateDaoImpl<Civilite, CiviliteImpl, ICivilite, Integer> implements ICiviliteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public CiviliteDaoImpl() {
		super(Civilite.class, CiviliteImpl.class);
	}
}