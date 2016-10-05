package webbati.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IFournisseurDao;
import webbati.api.metier.ejb.Fournisseur;
import webbati.api.metier.impl.FournisseurImpl;
import webbati.api.metier.impl.FournisseurMateriauxImpl;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_FournisseurDao")
public class FournisseurDaoImpl extends ContactDaoImpl<Fournisseur, FournisseurImpl, IFournisseur> implements IFournisseurDao {

	/**
	 * Constructeur.
	 * 
	 */
	public FournisseurDaoImpl() {
		super(Fournisseur.class, FournisseurImpl.class);
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws WebbatiException {
		Fournisseur obj = getEjbFromMetier(pFournisseur);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getFournisseurMateriauxes(), FournisseurMateriauxImpl.class, IFournisseurMateriaux.class);
		}
		return null;
	}
}