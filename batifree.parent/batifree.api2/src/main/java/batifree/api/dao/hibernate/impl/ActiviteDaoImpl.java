package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IActiviteDao;
import batifree.api.metier.ejb.Activite;
import batifree.api.metier.impl.ActiviteImpl;
import batifree.api.metier.interfaces.IActivite;

/**
 * Classe <ActiviteDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_ActiviteDao")
public class ActiviteDaoImpl extends BfGenericHibernateDaoImpl<Activite, ActiviteImpl, IActivite, Integer> implements IActiviteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ActiviteDaoImpl() {
		super(Activite.class, ActiviteImpl.class);
	}
}