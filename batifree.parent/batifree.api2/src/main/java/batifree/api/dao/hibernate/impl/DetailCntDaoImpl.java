package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IDetailCntDao;
import batifree.api.metier.ejb.Detailcnt;
import batifree.api.metier.impl.DetailCntImpl;
import batifree.api.metier.interfaces.IDetailCnt;

/**
 * Classe <DetailCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_DetailCntDao")
public class DetailCntDaoImpl extends BfGenericHibernateDaoImpl<Detailcnt, DetailCntImpl, IDetailCnt, Integer> implements IDetailCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DetailCntDaoImpl() {
		super(Detailcnt.class, DetailCntImpl.class);
	}
}