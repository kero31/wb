/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMateriauxEtudeDao;
import webbati.api.manager.interfaces.IMateriauxEtudeManager;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxEtudeManagerImpl>.
 * 
 * @author Kero
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_MateriauxEtudeManager")
public class MateriauxEtudeManagerImpl extends MateriauxManagerImpl<IMateriauxEtude> implements IMateriauxEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MateriauxEtudeDao")
	private IMateriauxEtudeDao materiauxEtudeDao;

	@Override
	protected IDao<IMateriauxEtude, Integer> getMainDao() {
		return materiauxEtudeDao;
	}
}
