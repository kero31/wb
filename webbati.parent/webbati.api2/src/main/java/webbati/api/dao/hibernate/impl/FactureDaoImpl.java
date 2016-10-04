package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFactureDao;
import webbati.api.metier.ejb.Facture;
import webbati.api.metier.impl.FactureImpl;
import webbati.api.metier.interfaces.IFacture;

/**
 * Classe <FactureDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_FactureDao")
public class FactureDaoImpl extends AffaireDaoImpl<Facture, FactureImpl, IFacture> implements IFactureDao {

	/**
	 * Constructeur.
	 * 
	 */
	public FactureDaoImpl() {
		super(Facture.class, FactureImpl.class);
	}
}