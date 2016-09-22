package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IBinaireDao;
import batifree.api.metier.ejb.Binaire;
import batifree.api.metier.impl.BinaireImpl;
import batifree.api.metier.interfaces.IBinaire;

/**
 * Classe <BinaireDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_BinaireDao")
public class BinaireDaoImpl extends BfGenericHibernateDaoImpl<Binaire, BinaireImpl, IBinaire, Integer> implements IBinaireDao {

	/**
	 * Constructeur.
	 * 
	 */
	public BinaireDaoImpl() {
		super(Binaire.class, BinaireImpl.class);
	}
}