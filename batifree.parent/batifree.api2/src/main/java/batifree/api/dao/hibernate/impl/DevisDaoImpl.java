package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IDevisDao;
import batifree.api.metier.ejb.Devis;
import batifree.api.metier.impl.DevisImpl;
import batifree.api.metier.interfaces.IDevis;

/**
 * Classe <DevisDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_DevisDao")
public class DevisDaoImpl extends AffaireDaoImpl<Devis, DevisImpl, IDevis> implements IDevisDao {

	/**
	 * Constructeur.
	 * 
	 */
	public DevisDaoImpl() {
		super(Devis.class, DevisImpl.class);
	}
}