/**
 * 
 */
package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IMateriauxEtudeDao;
import batifree.api.manager.interfaces.IMateriauxEtudeManager;
import batifree.api.metier.interfaces.IMateriauxEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <MateriauxEtudeManagerImpl>.
 * 
 * @author Kero
 * 
 */
@Service("BF_MateriauxEtudeManager")
public class MateriauxEtudeManagerImpl extends MateriauxManagerImpl<IMateriauxEtude> implements IMateriauxEtudeManager {

	@Resource(name = "BF_MateriauxEtudeDao")
	private IMateriauxEtudeDao materiauxEtudeDao;

	@Override
	protected IDao<IMateriauxEtude, Integer> getMainDao() {
		return materiauxEtudeDao;
	}
}
