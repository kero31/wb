package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEnginEtudeDao;
import batifree.api.metier.ejb.EnginEtude;
import batifree.api.metier.impl.EnginEtudeImpl;
import batifree.api.metier.interfaces.IEnginEtude;

/**
 * Classe <EnginEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EnginEtudeDao")
public class EnginEtudeDaoImpl extends EnginDaoImpl<EnginEtude, EnginEtudeImpl, IEnginEtude> implements IEnginEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EnginEtudeDaoImpl() {
		super(EnginEtude.class, EnginEtudeImpl.class);
	}
}