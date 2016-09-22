package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IEtatDao;
import batifree.api.manager.interfaces.IEtatManager;
import batifree.api.metier.interfaces.IEtat;

import common.api.dao.interfaces.IDao;

/**
 * Classe <EtatManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_EtatManager")
public class EtatManagerImpl extends BfGenericManagerImpl<IEtat, Integer> implements IEtatManager {

	@Resource(name = "BF_EtatDao")
	private IEtatDao etatDao;

	@Override
	protected IDao<IEtat, Integer> getMainDao() {
		return etatDao;
	}
}