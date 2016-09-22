package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ICiviliteDao;
import batifree.api.metier.ejb.Civilite;
import batifree.api.metier.impl.CiviliteImpl;
import batifree.api.metier.interfaces.ICivilite;

/**
 * Classe <CiviliteDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_CiviliteDao")
public class CiviliteDaoImpl extends BfGenericHibernateDaoImpl<Civilite, CiviliteImpl, ICivilite, Integer> implements ICiviliteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public CiviliteDaoImpl() {
		super(Civilite.class, CiviliteImpl.class);
	}
}