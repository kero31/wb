/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IEnginEtudeDao;
import batifree.api.manager.interfaces.IEnginEtudeManager;
import batifree.api.metier.interfaces.IEnginEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <EnginEtudeManagerImpl>.
 * 
 */
@Service("BF_EnginEtudeManager")
public class EnginEtudeManagerImpl extends EnginManagerImpl<IEnginEtude> implements IEnginEtudeManager {

	@Resource(name = "BF_EnginEtudeDao")
	private IEnginEtudeDao enginEtudeDao;

	@Override
	protected IDao<IEnginEtude, Integer> getMainDao() {
		return enginEtudeDao;
	}
}
