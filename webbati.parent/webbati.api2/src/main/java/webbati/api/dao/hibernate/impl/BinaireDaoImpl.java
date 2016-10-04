package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IBinaireDao;
import webbati.api.metier.ejb.Binaire;
import webbati.api.metier.impl.BinaireImpl;
import webbati.api.metier.interfaces.IBinaire;

/**
 * Classe <BinaireDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_BinaireDao")
public class BinaireDaoImpl extends BfGenericHibernateDaoImpl<Binaire, BinaireImpl, IBinaire, Integer> implements IBinaireDao {

	/**
	 * Constructeur.
	 * 
	 */
	public BinaireDaoImpl() {
		super(Binaire.class, BinaireImpl.class);
	}
}