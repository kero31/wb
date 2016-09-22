package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ITacheBibDao;
import batifree.api.metier.ejb.TacheLotBib;
import batifree.api.metier.impl.TacheBibImpl;
import batifree.api.metier.interfaces.ITacheBib;

/**
 * Classe <TacheBibDaoImpl>.
 * 
 */
@Repository("BF_TacheBibDao")
public class TacheBibDaoImpl extends TacheDaoImpl<TacheLotBib, TacheBibImpl, ITacheBib> implements ITacheBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TacheBibDaoImpl() {
		super(TacheLotBib.class, TacheBibImpl.class);
	}
}