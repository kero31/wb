package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ILotBibDao;
import batifree.api.metier.ejb.TacheLotBib;
import batifree.api.metier.impl.LotBibImpl;
import batifree.api.metier.interfaces.ILotBib;

/**
 * Classe <LotBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_LotBibDao")
public class LotBibDaoImpl extends LotDaoImpl<TacheLotBib, LotBibImpl, ILotBib> implements ILotBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public LotBibDaoImpl() {
		super(TacheLotBib.class, LotBibImpl.class);
	}
}