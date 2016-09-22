package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ICategorieDao;
import batifree.api.metier.ejb.Categorie;
import batifree.api.metier.impl.CategorieImpl;
import batifree.api.metier.interfaces.ICategorie;

/**
 * Classe <CategorieDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_CategorieDao")
public class CategorieDaoImpl extends BfGenericHibernateDaoImpl<Categorie, CategorieImpl, ICategorie, Integer> implements ICategorieDao {

	/**
	 * Constructeur.
	 * 
	 */
	public CategorieDaoImpl() {
		super(Categorie.class, CategorieImpl.class);
	}
}