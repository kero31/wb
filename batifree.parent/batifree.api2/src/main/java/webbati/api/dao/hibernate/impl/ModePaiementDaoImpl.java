/**
 * 
 */
package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IModePaiementDao;
import webbati.api.metier.ejb.ModePaiement;
import webbati.api.metier.impl.ModePaiementImpl;
import webbati.api.metier.interfaces.IModePaiement;

/**
 * Classe <b>ModePaiementDaoImpl</b>.
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ModePaiementDao")
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
