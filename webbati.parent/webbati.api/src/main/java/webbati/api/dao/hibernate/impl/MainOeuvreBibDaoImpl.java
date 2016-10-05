package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMainOeuvreBibDao;
import webbati.api.metier.ejb.MainoeuvreBib;
import webbati.api.metier.impl.MainOeuvreBibImpl;
import webbati.api.metier.interfaces.IMainOeuvreBib;

/**
 * Classe <MainOeuvreBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_MainOeuvreBibDao")
public class MainOeuvreBibDaoImpl extends MainOeuvreDaoImpl<MainoeuvreBib, MainOeuvreBibImpl, IMainOeuvreBib> implements IMainOeuvreBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MainOeuvreBibDaoImpl() {
		super(MainoeuvreBib.class, MainOeuvreBibImpl.class);
	}
}