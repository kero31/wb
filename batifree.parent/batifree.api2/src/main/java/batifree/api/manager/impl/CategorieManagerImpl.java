/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.ICategorieDao;
import batifree.api.manager.interfaces.ICategorieManager;
import batifree.api.metier.interfaces.ICategorie;

import common.api.dao.interfaces.IDao;

/**
 * Classe <CategorieManagerImpl>.
 * 
 */
@Service("BF_CategorieManager")
public class CategorieManagerImpl extends BfGenericManagerImpl<ICategorie, Integer> implements ICategorieManager {

	@Resource(name = "BF_CategorieDao")
	private ICategorieDao categorieDao;

	@Override
	protected IDao<ICategorie, Integer> getMainDao() {
		return categorieDao;
	}

}
