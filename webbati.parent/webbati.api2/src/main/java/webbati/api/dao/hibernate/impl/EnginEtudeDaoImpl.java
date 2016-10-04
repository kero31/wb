package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEnginEtudeDao;
import webbati.api.metier.ejb.EnginEtude;
import webbati.api.metier.impl.EnginEtudeImpl;
import webbati.api.metier.interfaces.IEnginEtude;

/**
 * Classe <EnginEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EnginEtudeDao")
public class EnginEtudeDaoImpl extends EnginDaoImpl<EnginEtude, EnginEtudeImpl, IEnginEtude> implements IEnginEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EnginEtudeDaoImpl() {
		super(EnginEtude.class, EnginEtudeImpl.class);
	}
}