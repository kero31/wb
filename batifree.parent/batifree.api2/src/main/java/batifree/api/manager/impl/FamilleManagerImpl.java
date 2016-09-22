package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IFamilleDao;
import batifree.api.manager.interfaces.IFamilleManager;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFamille;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <FamilleManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_FamilleManager")
public class FamilleManagerImpl extends BfGenericManagerImpl<IFamille, Integer> implements IFamilleManager {

	@Resource(name = "BF_FamilleDao")
	private IFamilleDao familleDao;

	@Override
	protected IDao<IFamille, Integer> getMainDao() {
		return familleDao;
	}

	@Override
	public List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws BatifreeException {
		return getListDaoFromObject(pFamille, familleDao.getListBibliotheque(pFamille));
	}

	@Override
	public List<IFamille> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException {
		return familleDao.getList(pMaxResult, pFirstResult, pWithChildren);
	}

	@Override
	public List<IFamille> getList(boolean pWithChildren) throws BatifreeException {
		return familleDao.getList(NB_ROW_DEFAULT, 0, pWithChildren);
	}

	@Override
	public List<IFamille> getList(int pMaxResult, int pFirstResult) throws BatifreeException {
		return getList(pMaxResult, pFirstResult, false);
	}

	@Override
	public IFamille getWithChildren(IFamille pObject) throws BatifreeException {
		return refresh(pObject);
	}
}