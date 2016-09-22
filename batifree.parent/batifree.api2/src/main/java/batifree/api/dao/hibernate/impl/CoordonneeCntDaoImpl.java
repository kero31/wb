package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ICoordonneeCntDao;
import batifree.api.metier.ejb.Coordonneecnt;
import batifree.api.metier.impl.CoordonneeCntImpl;
import batifree.api.metier.interfaces.ICoordonneeCnt;

/**
 * Classe <CoordonneeCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_CoordonneeCntDao")
public class CoordonneeCntDaoImpl extends BfGenericHibernateDaoImpl<Coordonneecnt, CoordonneeCntImpl, ICoordonneeCnt, Integer> implements
        ICoordonneeCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public CoordonneeCntDaoImpl() {
		super(Coordonneecnt.class, CoordonneeCntImpl.class);
	}
}