package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ICategorieDao;
import webbati.api.metier.ejb.Categorie;
import webbati.api.metier.impl.CategorieImpl;
import webbati.api.metier.interfaces.ICategorie;

/**
 * Classe <CategorieDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_CategorieDao")
public class CategorieDaoImpl extends BfGenericHibernateDaoImpl<Categorie, CategorieImpl, ICategorie, Integer> implements ICategorieDao {

	/**
	 * Constructeur.
	 * 
	 */
	public CategorieDaoImpl() {
		super(Categorie.class, CategorieImpl.class);
	}
}