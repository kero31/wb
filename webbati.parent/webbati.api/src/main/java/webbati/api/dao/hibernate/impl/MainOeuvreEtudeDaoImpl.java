package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMainOeuvreEtudeDao;
import webbati.api.metier.ejb.MainoeuvreEtude;
import webbati.api.metier.impl.MainOeuvreEtudeImpl;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Classe <MainOeuvreEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_MainOeuvreEtudeDao")
public class MainOeuvreEtudeDaoImpl extends MainOeuvreDaoImpl<MainoeuvreEtude, MainOeuvreEtudeImpl, IMainOeuvreEtude> implements IMainOeuvreEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MainOeuvreEtudeDaoImpl() {
		super(MainoeuvreEtude.class, MainOeuvreEtudeImpl.class);
	}
}