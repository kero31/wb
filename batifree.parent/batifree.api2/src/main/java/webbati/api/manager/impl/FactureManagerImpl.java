package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFactureDao;
import webbati.api.manager.interfaces.IFactureManager;
import webbati.api.metier.interfaces.IFacture;

/**
 * Classe <FactureManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_FactureManager")
public class FactureManagerImpl extends AffaireManagerImpl<IFacture> implements IFactureManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_FactureDao")
	private IFactureDao factureDao;

	@Override
	protected IDao<IFacture, Integer> getMainDao() {
		return factureDao;
	}
}