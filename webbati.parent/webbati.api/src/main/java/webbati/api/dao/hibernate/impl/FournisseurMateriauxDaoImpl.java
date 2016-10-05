package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFournisseurMateriauxDao;
import webbati.api.metier.ejb.FournisseurMateriaux;
import webbati.api.metier.ejb.FournisseurMateriauxId;
import webbati.api.metier.impl.FournisseurMateriauxImpl;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurMateriauxDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_FournisseurMateriauxDao")
public class FournisseurMateriauxDaoImpl extends
        BfGenericHibernateDaoImpl<FournisseurMateriaux, FournisseurMateriauxImpl, IFournisseurMateriaux, FournisseurMateriauxId> implements
        IFournisseurMateriauxDao {

	/**
	 * Constructeur.
	 * 
	 */
	public FournisseurMateriauxDaoImpl() {
		super(FournisseurMateriaux.class, FournisseurMateriauxImpl.class);
	}
}