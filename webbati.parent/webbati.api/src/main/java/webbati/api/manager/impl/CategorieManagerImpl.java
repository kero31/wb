/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICategorieDao;
import webbati.api.manager.interfaces.ICategorieManager;
import webbati.api.metier.interfaces.ICategorie;

/**
 * Classe <CategorieManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_CategorieManager")
public class CategorieManagerImpl extends BfGenericManagerImpl<ICategorie, Integer> implements ICategorieManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_CategorieDao")
	private ICategorieDao categorieDao;

	@Override
	protected IDao<ICategorie, Integer> getMainDao() {
		return categorieDao;
	}

}
