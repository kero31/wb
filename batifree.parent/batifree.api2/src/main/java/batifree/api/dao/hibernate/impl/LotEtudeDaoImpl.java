package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ILotEtudeDao;
import batifree.api.metier.ejb.TacheLotEtude;
import batifree.api.metier.impl.LotEtudeImpl;
import batifree.api.metier.interfaces.ILotEtude;

/**
 * Classe <LotEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_LotEtudeDao")
public class LotEtudeDaoImpl extends LotDaoImpl<TacheLotEtude, LotEtudeImpl, ILotEtude> implements ILotEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public LotEtudeDaoImpl() {
		super(TacheLotEtude.class, LotEtudeImpl.class);
	}
}