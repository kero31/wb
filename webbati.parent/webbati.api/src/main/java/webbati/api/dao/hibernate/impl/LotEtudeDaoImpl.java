package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILotEtudeDao;
import webbati.api.metier.ejb.TacheLotEtude;
import webbati.api.metier.impl.LotEtudeImpl;
import webbati.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_LotEtudeDao")
public class LotEtudeDaoImpl extends LotDaoImpl<TacheLotEtude, LotEtudeImpl, ILotEtude> implements ILotEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public LotEtudeDaoImpl() {
		super(TacheLotEtude.class, LotEtudeImpl.class);
	}
}