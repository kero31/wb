package batifree.api.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IDiversCntDao;
import batifree.api.metier.ejb.Diverscnt;
import batifree.api.metier.ejb.Groupecnt;
import batifree.api.metier.impl.DiversCntImpl;
import batifree.api.metier.impl.GroupeCntImpl;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Classe <DiversCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_DiversCntDao")
public class DiversCntDaoImpl extends ContactDaoImpl<Diverscnt, DiversCntImpl, IDiversCnt> implements IDiversCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DiversCntDaoImpl() {
		super(Diverscnt.class, DiversCntImpl.class);
	}

	@Override
	public List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws BatifreeException {
		Diverscnt obj = getEjbFromMetier(pDiversCnt);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getGroupecnts(), GroupeCntImpl.class, IGroupeCnt.class);
		}
		return null;
	}

	@Override
	protected Diverscnt getEjbUpdatedFromMetier(IDiversCnt pMetier) throws BatifreeException {
		// Transforme la liste de group contact métier en liste de group contact EJB
		Diverscnt ejb = super.getEjbUpdatedFromMetier(pMetier);

		Set<Groupecnt> listGroupeCntEjb = ejb.getGroupecnts();
		Map<Serializable, Groupecnt> mapEJB = new HashMap<>();
		if (listGroupeCntEjb != null) {
			for (Groupecnt groupeCnt : listGroupeCntEjb) {
				mapEJB.put(groupeCnt.getId(), groupeCnt);
			}
		}
		updateEjbListFromMetier(pMetier.getListGroupeContact(), mapEJB, listGroupeCntEjb, Groupecnt.class);

		return ejb;
	}

}