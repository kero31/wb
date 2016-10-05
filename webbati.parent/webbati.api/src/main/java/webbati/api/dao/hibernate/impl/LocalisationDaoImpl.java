package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ILocalisationDao;
import webbati.api.metier.ejb.Localisation;
import webbati.api.metier.impl.LocalisationImpl;
import webbati.api.metier.interfaces.ILocalisation;

/**
 * Classe <LocalisationDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_LocalisationDao")
public class LocalisationDaoImpl extends BfGenericHibernateDaoImpl<Localisation, LocalisationImpl, ILocalisation, Integer> implements
ILocalisationDao {

	/**
	 * Constructeur.
	 * 
	 */
	public LocalisationDaoImpl() {
		super(Localisation.class, LocalisationImpl.class);
	}
}