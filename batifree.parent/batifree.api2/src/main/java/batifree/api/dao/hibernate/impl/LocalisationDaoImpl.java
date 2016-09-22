package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ILocalisationDao;
import batifree.api.metier.ejb.Localisation;
import batifree.api.metier.impl.LocalisationImpl;
import batifree.api.metier.interfaces.ILocalisation;

/**
 * Classe <LocalisationDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_LocalisationDao")
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