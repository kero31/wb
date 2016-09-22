package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ISousTraitantBibDao;
import batifree.api.metier.ejb.SoustraitantBib;
import batifree.api.metier.impl.SousTraitantBibImpl;
import batifree.api.metier.interfaces.ISousTraitantBib;

/**
 * Classe <SousTraitantBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_SousTraitantBibDao")
public class SousTraitantBibDaoImpl extends SousTraitantDaoImpl<SoustraitantBib, SousTraitantBibImpl, ISousTraitantBib> implements
        ISousTraitantBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public SousTraitantBibDaoImpl() {
		super(SoustraitantBib.class, SousTraitantBibImpl.class);
	}
}