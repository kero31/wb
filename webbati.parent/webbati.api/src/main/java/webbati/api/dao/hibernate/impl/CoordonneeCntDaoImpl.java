package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICoordonneeCntDao;
import webbati.api.metier.ejb.Coordonneecnt;
import webbati.api.metier.impl.CoordonneeCntImpl;
import webbati.api.metier.interfaces.ICoordonneeCnt;

/**
 * Classe <CoordonneeCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_CoordonneeCntDao")
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