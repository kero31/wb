package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IFournisseurDao;
import batifree.api.manager.interfaces.IFournisseurManager;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <FournisseurManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_FournisseurManager")
public class FournisseurManagerImpl extends ContactManagerImpl<IFournisseur> implements IFournisseurManager {

	@Resource(name = "BF_FournisseurDao")
	private IFournisseurDao fournisseurDao;

	@Override
	protected IDao<IFournisseur, Integer> getMainDao() {
		return fournisseurDao;
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws BatifreeException {
		return getListDaoFromObject(pFournisseur, fournisseurDao.getListFournisseurMateriaux(pFournisseur));
	}
}