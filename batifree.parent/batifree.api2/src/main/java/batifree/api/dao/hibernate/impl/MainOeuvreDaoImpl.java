package batifree.api.dao.hibernate.impl;

import batifree.api.dao.interfaces.IMainOeuvreDao;
import batifree.api.metier.ejb.Mainoeuvre;
import batifree.api.metier.impl.MainOeuvreImpl;
import batifree.api.metier.interfaces.IMainOeuvre;

/**
 * 
 * Classe/Interface <b>MainOeuvreDaoImpl</b><br/>
 *
 * @param <T> Mainoeuvre
 * @param <TI> MainOeuvreImpl
 * @param <IT> IMainOeuvre
 */
public abstract class MainOeuvreDaoImpl<T extends Mainoeuvre, TI extends MainOeuvreImpl, IT extends IMainOeuvre> extends
        BibliothequeDaoImpl<T, TI, IT> implements IMainOeuvreDao<IT> {

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public MainOeuvreDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}
}