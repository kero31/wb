package batifree.api.dao.hibernate.impl;

import batifree.api.dao.interfaces.ISousTraitantDao;
import batifree.api.metier.ejb.Soustraitant;
import batifree.api.metier.impl.SousTraitantImpl;
import batifree.api.metier.interfaces.ISousTraitant;

/**
 * 
 * Classe/Interface <b>SousTraitantDaoImpl</b><br/>
 *
 * @param <T> Soustraitant
 * @param <TI> SousTraitantImpl
 * @param <IT> ISousTraitant
 */
public abstract class SousTraitantDaoImpl<T extends Soustraitant, TI extends SousTraitantImpl, IT extends ISousTraitant> extends
        BibliothequeDaoImpl<T, TI, IT> implements ISousTraitantDao<IT> {

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public SousTraitantDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}
}