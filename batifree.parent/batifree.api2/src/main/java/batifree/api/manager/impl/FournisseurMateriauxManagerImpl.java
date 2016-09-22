package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IFournisseurMateriauxDao;
import batifree.api.manager.interfaces.IFournisseurMateriauxManager;
import batifree.api.metier.ejb.FournisseurMateriauxId;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.dao.interfaces.IDao;

/**
 * Classe <FournisseurMateriauxManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_FournisseurMateriauxManager")
public class FournisseurMateriauxManagerImpl extends BfGenericManagerImpl<IFournisseurMateriaux, FournisseurMateriauxId> implements
        IFournisseurMateriauxManager {

	@Resource(name = "BF_FournisseurMateriauxDao")
	private IFournisseurMateriauxDao fournisseurMateriauxDao;

	@Override
	protected IDao<IFournisseurMateriaux, FournisseurMateriauxId> getMainDao() {
		return fournisseurMateriauxDao;
	}
}