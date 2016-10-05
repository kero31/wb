/**
 * 
 */
package webbati.api.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IContactDao;
import webbati.api.manager.interfaces.IContactManager;
import webbati.api.manager.interfaces.ICoordonneeCntManager;
import webbati.api.manager.interfaces.IDetailCntManager;
import webbati.api.metier.interfaces.IContact;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * 
 * Classe/Interface <b>ContactManagerImpl</b><br/>
 *
 * @param <IT> IContact
 */
public abstract class ContactManagerImpl<IT extends IContact> extends BfGenericManagerImpl<IT, Integer> implements IContactManager<IT> {

	/** Le coordonneeCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_CoordonneeCntManager")
	private ICoordonneeCntManager coordonneeCntManager;

	/** Le detailCntManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_DetailCntManager")
	private IDetailCntManager detailCntManager;

	@Override
	public List<IDetailCnt> getListDetailContact(IContact pContact) throws WebbatiException {
		return getListDaoFromObject(pContact, ((IContactDao<IT>) getDao()).getListDetailContact(pContact));
	}

	@Override
	public void delete(IT pMetier) throws WebbatiException {
		if (pMetier != null) {
			// Suprime les détail contact associés
			List<IDetailCnt> listDetail = pMetier.getListDetailContact();
			detailCntManager.delete(listDetail);

			// Supprime le contact lui même
			super.delete(pMetier);
		}
	}

}
