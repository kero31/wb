package webbati.api.dao.hibernate.impl;

import webbati.api.dao.interfaces.ISousTraitantDao;
import webbati.api.metier.ejb.Soustraitant;
import webbati.api.metier.impl.SousTraitantImpl;
import webbati.api.metier.interfaces.ISousTraitant;

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