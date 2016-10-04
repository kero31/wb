package webbati.api.dao.hibernate.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IDiversCntDao;
import webbati.api.metier.ejb.Diverscnt;
import webbati.api.metier.ejb.Groupecnt;
import webbati.api.metier.impl.DiversCntImpl;
import webbati.api.metier.impl.GroupeCntImpl;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Classe <DiversCntDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_DiversCntDao")
public class DiversCntDaoImpl extends ContactDaoImpl<Diverscnt, DiversCntImpl, IDiversCnt> implements IDiversCntDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DiversCntDaoImpl() {
		super(Diverscnt.class, DiversCntImpl.class);
	}

	@Override
	public List<IGroupeCnt> getListGroupeContact(IDiversCnt pDiversCnt) throws WebbatiException {
		Diverscnt obj = getEjbFromMetier(pDiversCnt);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getGroupecnts(), GroupeCntImpl.class, IGroupeCnt.class);
		}
		return null;
	}

	@Override
	protected Diverscnt getEjbUpdatedFromMetier(IDiversCnt pMetier) throws WebbatiException {
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