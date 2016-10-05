/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEnginEtudeDao;
import webbati.api.manager.interfaces.IEnginEtudeManager;
import webbati.api.metier.interfaces.IEnginEtude;

/**
 * Classe <EnginEtudeManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EnginEtudeManager")
public class EnginEtudeManagerImpl extends EnginManagerImpl<IEnginEtude> implements IEnginEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EnginEtudeDao")
	private IEnginEtudeDao enginEtudeDao;

	@Override
	protected IDao<IEnginEtude, Integer> getMainDao() {
		return enginEtudeDao;
	}
}
