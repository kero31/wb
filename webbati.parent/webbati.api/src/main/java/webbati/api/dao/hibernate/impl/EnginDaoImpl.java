package webbati.api.dao.hibernate.impl;

import webbati.api.dao.interfaces.IEnginDao;
import webbati.api.metier.ejb.Engin;
import webbati.api.metier.impl.EnginImpl;
import webbati.api.metier.interfaces.IEngin;

/**
 * 
 * Classe/Interface <b>EnginDaoImpl</b><br/>
 *
 * @param <T> Engin
 * @param <TI> EnginImpl
 * @param <IT> IEngin
 */
public abstract class EnginDaoImpl<T extends Engin, TI extends EnginImpl, IT extends IEngin> extends BibliothequeDaoImpl<T, TI, IT> implements
        IEnginDao<IT> {

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public EnginDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

}