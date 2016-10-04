package webbati.api.dao.hibernate.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.dao.interfaces.IContactDao;
import webbati.api.metier.ejb.Contact;
import webbati.api.metier.impl.ContactImpl;
import webbati.api.metier.impl.DetailCntImpl;
import webbati.api.metier.interfaces.IContact;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * 
 * Classe/Interface <b>ContactDaoImpl</b><br/>
 *
 * @param <T> Contact
 * @param <TI> ContactImpl
 * @param <IT> IContact
 */
public abstract class ContactDaoImpl<T extends Contact, TI extends ContactImpl, IT extends IContact> extends
        BfGenericHibernateDaoImpl<T, TI, IT, Integer> implements IContactDao<IT> {

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public ContactDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	public List<IDetailCnt> getListDetailContact(IContact pContact) throws WebbatiException {
		Contact contact = getEjbFromMetier(pContact);
		if (contact != null) {
			return getListMetierFromListEjb(contact.getDetailcnts(), DetailCntImpl.class, IDetailCnt.class);
		}
		return null;
	}

}