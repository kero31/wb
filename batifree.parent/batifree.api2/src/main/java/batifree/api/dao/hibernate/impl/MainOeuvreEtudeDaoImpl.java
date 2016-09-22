package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IMainOeuvreEtudeDao;
import batifree.api.metier.ejb.MainoeuvreEtude;
import batifree.api.metier.impl.MainOeuvreEtudeImpl;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Classe <MainOeuvreEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_MainOeuvreEtudeDao")
public class MainOeuvreEtudeDaoImpl extends MainOeuvreDaoImpl<MainoeuvreEtude, MainOeuvreEtudeImpl, IMainOeuvreEtude> implements IMainOeuvreEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MainOeuvreEtudeDaoImpl() {
		super(MainoeuvreEtude.class, MainOeuvreEtudeImpl.class);
	}
}