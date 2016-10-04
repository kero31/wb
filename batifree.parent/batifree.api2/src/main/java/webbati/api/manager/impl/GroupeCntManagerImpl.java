package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IGroupeCntDao;
import webbati.api.manager.interfaces.IGroupeCntManager;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

/**
 * Classe <GroupeCntManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_GroupeCntManager")
public class GroupeCntManagerImpl extends BfGenericManagerImpl<IGroupeCnt, Integer> implements IGroupeCntManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_GroupeCntDao")
	private IGroupeCntDao groupeCntDao;

	@Override
	protected IDao<IGroupeCnt, Integer> getMainDao() {
		return groupeCntDao;
	}

	@Override
	public List<IDiversCnt> getListDiversContact(IGroupeCnt pGroupeCnt) throws WebbatiException {
		return getListDaoFromObject(pGroupeCnt, groupeCntDao.getListDiversContact(pGroupeCnt));
	}
}