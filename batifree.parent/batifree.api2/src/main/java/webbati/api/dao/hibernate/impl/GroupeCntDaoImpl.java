package webbati.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IGroupeCntDao;
import webbati.api.metier.ejb.Groupecnt;
import webbati.api.metier.impl.DiversCntImpl;
import webbati.api.metier.impl.GroupeCntImpl;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Classe <GroupeCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_GroupeCntDao")
public class GroupeCntDaoImpl extends BfGenericHibernateDaoImpl<Groupecnt, GroupeCntImpl, IGroupeCnt, Integer> implements IGroupeCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public GroupeCntDaoImpl() {
		super(Groupecnt.class, GroupeCntImpl.class);
	}

	@Override
	public List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws WebbatiException {
		Groupecnt obj = getEjbFromMetier(pGroupeCnt);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getDiverscnts(), DiversCntImpl.class, IDiversCnt.class);
		}
		return null;
	}

}