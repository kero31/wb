package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFamilleDao;
import webbati.api.manager.interfaces.IFamilleManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IFamille;

/**
 * Classe <FamilleManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_FamilleManager")
public class FamilleManagerImpl extends BfGenericManagerImpl<IFamille, Integer> implements IFamilleManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_FamilleDao")
	private IFamilleDao familleDao;

	@Override
	protected IDao<IFamille, Integer> getMainDao() {
		return familleDao;
	}

	@Override
	public List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws WebbatiException {
		return getListDaoFromObject(pFamille, familleDao.getListBibliotheque(pFamille));
	}

	@Override
	public List<IFamille> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws WebbatiException {
		return familleDao.getList(pMaxResult, pFirstResult, pWithChildren);
	}

	@Override
	public List<IFamille> getList(boolean pWithChildren) throws WebbatiException {
		return familleDao.getList(NB_ROW_DEFAULT, 0, pWithChildren);
	}

	@Override
	public List<IFamille> getList(int pMaxResult, int pFirstResult) throws WebbatiException {
		return getList(pMaxResult, pFirstResult, false);
	}

	@Override
	public IFamille getWithChildren(IFamille pObject) throws WebbatiException {
		return refresh(pObject);
	}
}