package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.ISousTraitantEtudeDao;
import webbati.api.metier.ejb.SoustraitantEtude;
import webbati.api.metier.impl.SousTraitantEtudeImpl;
import webbati.api.metier.interfaces.ISousTraitantEtude;

/**
 * Classe <SousTraitantEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_SousTraitantEtudeDao")
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