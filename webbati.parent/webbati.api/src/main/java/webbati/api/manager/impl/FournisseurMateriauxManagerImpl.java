package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFournisseurMateriauxDao;
import webbati.api.manager.interfaces.IFournisseurMateriauxManager;
import webbati.api.metier.ejb.FournisseurMateriauxId;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurMateriauxManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_FournisseurMateriauxManager")
public class FournisseurMateriauxManagerImpl extends BfGenericManagerImpl<IFournisseurMateriaux, FournisseurMateriauxId> implements
        IFournisseurMateriauxManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_FournisseurMateriauxDao")
	private IFournisseurMateriauxDao fournisseurMateriauxDao;

	@Override
	protected IDao<IFournisseurMateriaux, FournisseurMateriauxId> getMainDao() {
		return fournisseurMateriauxDao;
	}
}