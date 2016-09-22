package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.ISousTraitantEtudeDao;
import batifree.api.metier.ejb.SoustraitantEtude;
import batifree.api.metier.impl.SousTraitantEtudeImpl;
import batifree.api.metier.interfaces.ISousTraitantEtude;

/**
 * Classe <SousTraitantEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_SousTraitantEtudeDao")
public class SousTraitantEtudeDaoImpl extends SousTraitantDaoImpl<SoustraitantEtude, SousTraitantEtudeImpl, ISousTraitantEtude> implements
        ISousTraitantEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public SousTraitantEtudeDaoImpl() {
		super(SoustraitantEtude.class, SousTraitantEtudeImpl.class);
	}
}