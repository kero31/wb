package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEnginBibDao;
import batifree.api.metier.ejb.EnginBib;
import batifree.api.metier.impl.EnginBibImpl;
import batifree.api.metier.interfaces.IEnginBib;

/**
 * Classe <EnginBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EnginBibDao")
public class EnginBibDaoImpl extends EnginDaoImpl<EnginBib, EnginBibImpl, IEnginBib> implements IEnginBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EnginBibDaoImpl() {
		super(EnginBib.class, EnginBibImpl.class);
	}
}