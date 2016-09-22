package batifree.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IGroupeCntDao;
import batifree.api.metier.ejb.Groupecnt;
import batifree.api.metier.impl.DiversCntImpl;
import batifree.api.metier.impl.GroupeCntImpl;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Classe <GroupeCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_GroupeCntDao")
public class GroupeCntDaoImpl extends BfGenericHibernateDaoImpl<Groupecnt, GroupeCntImpl, IGroupeCnt, Integer> implements IGroupeCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public GroupeCntDaoImpl() {
		super(Groupecnt.class, GroupeCntImpl.class);
	}

	@Override
	public List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws BatifreeException {
		Groupecnt obj = getEjbFromMetier(pGroupeCnt);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getDiverscnts(), DiversCntImpl.class, IDiversCnt.class);
		}
		return null;
	}

}