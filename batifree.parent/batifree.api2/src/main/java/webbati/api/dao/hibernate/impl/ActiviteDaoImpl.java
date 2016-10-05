package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IActiviteDao;
import webbati.api.metier.ejb.Activite;
import webbati.api.metier.impl.ActiviteImpl;
import webbati.api.metier.interfaces.IActivite;

/**
 * Classe <ActiviteDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ActiviteDao")
public class ActiviteDaoImpl extends BfGenericHibernateDaoImpl<Activite, ActiviteImpl, IActivite, Integer> implements IActiviteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ActiviteDaoImpl() {
		super(Activite.class, ActiviteImpl.class);
	}
}