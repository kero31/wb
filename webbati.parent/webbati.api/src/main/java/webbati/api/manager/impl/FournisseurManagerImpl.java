package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFournisseurDao;
import webbati.api.manager.interfaces.IFournisseurManager;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_FournisseurManager")
public class FournisseurManagerImpl extends ContactManagerImpl<IFournisseur> implements IFournisseurManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_FournisseurDao")
	private IFournisseurDao fournisseurDao;

	@Override
	protected IDao<IFournisseur, Integer> getMainDao() {
		return fournisseurDao;
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws WebbatiException {
		return getListDaoFromObject(pFournisseur, fournisseurDao.getListFournisseurMateriaux(pFournisseur));
	}
}