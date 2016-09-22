package batifree.api.dao.hibernate.impl;

import java.util.List;

import batifree.api.dao.interfaces.IContactDao;
import batifree.api.metier.ejb.Contact;
import batifree.api.metier.impl.ContactImpl;
import batifree.api.metier.impl.DetailCntImpl;
import batifree.api.metier.interfaces.IContact;
import batifree.api.metier.interfaces.IDetailCnt;

import common.api.exception.BatifreeException;

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
	public List<IDetailCnt> getListDetailContact(IContact pContact) throws BatifreeException {
		Contact contact = getEjbFromMetier(pContact);
		if (contact != null) {
			return getListMetierFromListEjb(contact.getDetailcnts(), DetailCntImpl.class, IDetailCnt.class);
		}
		return null;
	}

}