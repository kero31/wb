package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ITacheEtudeDao;
import batifree.api.metier.ejb.TacheLotEtude;
import batifree.api.metier.impl.TacheEtudeImpl;
import batifree.api.metier.interfaces.ITacheEtude;

/**
 * Classe <TacheEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_TacheEtudeDao")
public class TacheEtudeDaoImpl extends TacheDaoImpl<TacheLotEtude, TacheEtudeImpl, ITacheEtude> implements ITacheEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public TacheEtudeDaoImpl() {
		super(TacheLotEtude.class, TacheEtudeImpl.class);
	}
}