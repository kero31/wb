package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IDetailCntDao;
import webbati.api.metier.ejb.Detailcnt;
import webbati.api.metier.impl.DetailCntImpl;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * Classe <DetailCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_DetailCntDao")
public class DetailCntDaoImpl extends BfGenericHibernateDaoImpl<Detailcnt, DetailCntImpl, IDetailCnt, Integer> implements IDetailCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DetailCntDaoImpl() {
		super(Detailcnt.class, DetailCntImpl.class);
	}
}