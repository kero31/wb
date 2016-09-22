/**
 * 
 */
package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IModePaiementDao;
import batifree.api.metier.ejb.ModePaiement;
import batifree.api.metier.impl.ModePaiementImpl;
import batifree.api.metier.interfaces.IModePaiement;

/**
 * Classe <b>ModePaiementDaoImpl</b>.
 * 
 */
@Repository("BF_ModePaiementDao")
public class ModePaiementDaoImpl extends BfGenericHibernateDaoImpl<ModePaiement, ModePaiementImpl, IModePaiement, Integer> implements
        IModePaiementDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ModePaiementDaoImpl() {
		super(ModePaiement.class, ModePaiementImpl.class);
	}
}
