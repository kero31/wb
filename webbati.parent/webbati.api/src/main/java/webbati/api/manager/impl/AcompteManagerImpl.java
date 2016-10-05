/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IAcompteDao;
import webbati.api.manager.interfaces.IAcompteManager;
import webbati.api.metier.interfaces.IAcompte;

/**
 * Classe <AcompteManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_AcompteManager")
public class AcompteManagerImpl extends AffaireManagerImpl<IAcompte> implements IAcompteManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_AcompteDao")
	private IAcompteDao acompteDao;

	@Override
	protected IDao<IAcompte, Integer> getMainDao() {
		return acompteDao;
	}
}
