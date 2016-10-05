package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IDevisDao;
import webbati.api.metier.ejb.Devis;
import webbati.api.metier.impl.DevisImpl;
import webbati.api.metier.interfaces.IDevis;

/**
 * Classe <DevisDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_DevisDao")
public class DevisDaoImpl extends AffaireDaoImpl<Devis, DevisImpl, IDevis> implements IDevisDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DevisDaoImpl() {
		super(Devis.class, DevisImpl.class);
	}
}