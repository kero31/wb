package webbati.api.dao.hibernate.impl;

import webbati.api.dao.interfaces.IMainOeuvreDao;
import webbati.api.metier.ejb.Mainoeuvre;
import webbati.api.metier.impl.MainOeuvreImpl;
import webbati.api.metier.interfaces.IMainOeuvre;

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