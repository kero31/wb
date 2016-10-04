/**
 * 
 */
package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMateriauxBibDao;
import webbati.api.manager.interfaces.IMateriauxBibManager;
import webbati.api.metier.interfaces.IMateriauxBib;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxBibManagerImpl>.
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_MateriauxBibManager")
public class MateriauxBibManagerImpl extends MateriauxManagerImpl<IMateriauxBib> implements IMateriauxBibManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MateriauxBibDao")
	private IMateriauxBibDao materiauxBibDao;

	@Override
	protected IDao<IMateriauxBib, Integer> getMainDao() {
		return materiauxBibDao;
	}

	@Override
	public IMateriauxEtude getMateriauxEtudeFromBib(IMateriauxBib pBib) throws WebbatiException {
		return getClone(pBib, ApplicationWb.getApplication().getFactory().createNewInstance(IMateriauxEtude.class));
	}
}
