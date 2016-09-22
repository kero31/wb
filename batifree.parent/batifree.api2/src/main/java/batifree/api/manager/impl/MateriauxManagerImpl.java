/**
 * 
 */
package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import batifree.api.application.interfaces.IApplication;
import batifree.api.dao.interfaces.IMateriauxDao;
import batifree.api.manager.interfaces.IMateriauxManager;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IMateriaux;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>MateriauxManagerImpl</b><br/>
 *
 * @param <IT> IMateriaux
 */
public abstract class MateriauxManagerImpl<IT extends IMateriaux> extends BibliothequeElementManagerImpl<IT> implements IMateriauxManager<IT> {

	/** Le BF Application. */
	@Resource(name = "BF_Application")
	private IApplication application;

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws BatifreeException {
		return getListDaoFromObject(pMateriaux, ((IMateriauxDao<IT>) getDao()).getListFournisseurMateriaux(pMateriaux));
	}
}