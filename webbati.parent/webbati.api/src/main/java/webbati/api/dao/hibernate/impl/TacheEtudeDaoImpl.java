package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ITacheEtudeDao;
import webbati.api.metier.ejb.TacheLotEtude;
import webbati.api.metier.impl.TacheEtudeImpl;
import webbati.api.metier.interfaces.ITacheEtude;

/**
 * Classe <TacheEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_TacheEtudeDao")
public class TacheEtudeDaoImpl extends TacheDaoImpl<TacheLotEtude, TacheEtudeImpl, ITacheEtude> implements ITacheEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TacheEtudeDaoImpl() {
		super(TacheLotEtude.class, TacheEtudeImpl.class);
	}
}