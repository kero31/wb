/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IAcompteDao;
import batifree.api.manager.interfaces.IAcompteManager;
import batifree.api.metier.interfaces.IAcompte;

import common.api.dao.interfaces.IDao;

/**
 * Classe <AcompteManagerImpl>.
 * 
 */
@Service("BF_AcompteManager")
public class AcompteManagerImpl extends AffaireManagerImpl<IAcompte> implements IAcompteManager {

	@Resource(name = "BF_AcompteDao")
	private IAcompteDao acompteDao;

	@Override
	protected IDao<IAcompte, Integer> getMainDao() {
		return acompteDao;
	}
}
