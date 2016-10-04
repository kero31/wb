/**
 * 
 */
package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.application.interfaces.IApplication;
import webbati.api.dao.interfaces.IMateriauxDao;
import webbati.api.manager.interfaces.IMateriauxManager;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IMateriaux;

/**
 * 
 * Classe/Interface <b>MateriauxManagerImpl</b><br/>
 *
 * @param <IT> IMateriaux
 */
public abstract class MateriauxManagerImpl<IT extends IMateriaux> extends BibliothequeElementManagerImpl<IT> implements IMateriauxManager<IT> {

	/** Le WB Application. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_Application")
	private IApplication application;

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws WebbatiException {
		return getListDaoFromObject(pMateriaux, ((IMateriauxDao<IT>) getDao()).getListFournisseurMateriaux(pMateriaux));
	}
}