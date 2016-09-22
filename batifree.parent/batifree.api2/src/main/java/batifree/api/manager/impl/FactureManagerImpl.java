package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IFactureDao;
import batifree.api.manager.interfaces.IFactureManager;
import batifree.api.metier.interfaces.IFacture;

import common.api.dao.interfaces.IDao;

/**
 * Classe <FactureManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_FactureManager")
public class FactureManagerImpl extends AffaireManagerImpl<IFacture> implements IFactureManager {

	@Resource(name = "BF_FactureDao")
	private IFactureDao factureDao;

	@Override
	protected IDao<IFacture, Integer> getMainDao() {
		return factureDao;
	}
}