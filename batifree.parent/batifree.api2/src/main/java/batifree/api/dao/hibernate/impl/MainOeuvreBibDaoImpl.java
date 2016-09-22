package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IMainOeuvreBibDao;
import batifree.api.metier.ejb.MainoeuvreBib;
import batifree.api.metier.impl.MainOeuvreBibImpl;
import batifree.api.metier.interfaces.IMainOeuvreBib;

/**
 * Classe <MainOeuvreBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_MainOeuvreBibDao")
public class MainOeuvreBibDaoImpl extends MainOeuvreDaoImpl<MainoeuvreBib, MainOeuvreBibImpl, IMainOeuvreBib> implements IMainOeuvreBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MainOeuvreBibDaoImpl() {
		super(MainoeuvreBib.class, MainOeuvreBibImpl.class);
	}
}