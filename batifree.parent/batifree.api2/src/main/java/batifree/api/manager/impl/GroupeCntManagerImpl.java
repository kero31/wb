package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IGroupeCntDao;
import batifree.api.manager.interfaces.IGroupeCntManager;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <GroupeCntManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_GroupeCntManager")
public class GroupeCntManagerImpl extends BfGenericManagerImpl<IGroupeCnt, Integer> implements IGroupeCntManager {

	@Resource(name = "BF_GroupeCntDao")
	private IGroupeCntDao groupeCntDao;

	@Override
	protected IDao<IGroupeCnt, Integer> getMainDao() {
		return groupeCntDao;
	}

	@Override
	public List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws BatifreeException {
		return getListDaoFromObject(pGroupeCnt, groupeCntDao.getListDiversContact(pGroupeCnt));
	}
}