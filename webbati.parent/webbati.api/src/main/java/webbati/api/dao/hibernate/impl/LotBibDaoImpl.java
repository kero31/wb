package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILotBibDao;
import webbati.api.metier.ejb.TacheLotBib;
import webbati.api.metier.impl.LotBibImpl;
import webbati.api.metier.interfaces.ILotBib;

/**
 * Classe <LotBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_LotBibDao")
public class LotBibDaoImpl extends LotDaoImpl<TacheLotBib, LotBibImpl, ILotBib> implements ILotBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public LotBibDaoImpl() {
		super(TacheLotBib.class, LotBibImpl.class);
	}
}