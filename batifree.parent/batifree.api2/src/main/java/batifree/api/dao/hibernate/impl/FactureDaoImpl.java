package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IFactureDao;
import batifree.api.metier.ejb.Facture;
import batifree.api.metier.impl.FactureImpl;
import batifree.api.metier.interfaces.IFacture;

/**
 * Classe <FactureDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_FactureDao")
public class FactureDaoImpl extends AffaireDaoImpl<Facture, FactureImpl, IFacture> implements IFactureDao {

	/**
	 * Constructeur.
	 * 
	 */
	public FactureDaoImpl() {
		super(Facture.class, FactureImpl.class);
	}
}