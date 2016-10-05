package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEnginBibDao;
import webbati.api.metier.ejb.EnginBib;
import webbati.api.metier.impl.EnginBibImpl;
import webbati.api.metier.interfaces.IEnginBib;

/**
 * Classe <EnginBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EnginBibDao")
public class EnginBibDaoImpl extends EnginDaoImpl<EnginBib, EnginBibImpl, IEnginBib> implements IEnginBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EnginBibDaoImpl() {
		super(EnginBib.class, EnginBibImpl.class);
	}
}