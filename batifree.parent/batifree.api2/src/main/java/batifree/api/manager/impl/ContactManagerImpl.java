/**
 * 
 */
package batifree.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import batifree.api.dao.interfaces.IContactDao;
import batifree.api.manager.interfaces.IContactManager;
import batifree.api.manager.interfaces.ICoordonneeCntManager;
import batifree.api.manager.interfaces.IDetailCntManager;
import batifree.api.metier.interfaces.IContact;
import batifree.api.metier.interfaces.IDetailCnt;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>ContactManagerImpl</b><br/>
 *
 * @param <IT> IContact
 */
public abstract class ContactManagerImpl<IT extends IContact> extends BfGenericManagerImpl<IT, Integer> implements IContactManager<IT> {

	/** Le coordonneeCntManager. */
	@Resource(name = "BF_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	/** Le detailCntManager. */
	@Resource(name = "BF_DetailCntManager")
	private IDetailCntManager detailCntManager;

	@Override
	public List<IDetailCnt> getListDetailContact(IContact pContact) throws BatifreeException {
		return getListDaoFromObject(pContact, ((IContactDao<IT>) getDao()).getListDetailContact(pContact));
	}

	@Override
	public void delete(IT pMetier) throws BatifreeException {
		if (pMetier != null) {
			// Suprime les détail contact associés
			List<IDetailCnt> listDetail = pMetier.getListDetailContact();
			detailCntManager.delete(listDetail);

			// Supprime le contact lui même
			super.delete(pMetier);
		}
	}

}
