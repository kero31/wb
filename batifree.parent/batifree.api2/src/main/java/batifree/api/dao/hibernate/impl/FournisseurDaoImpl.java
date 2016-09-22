package batifree.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IFournisseurDao;
import batifree.api.metier.ejb.Fournisseur;
import batifree.api.metier.impl.FournisseurImpl;
import batifree.api.metier.impl.FournisseurMateriauxImpl;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

import common.api.exception.BatifreeException;

/**
 * Classe <FournisseurDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_FournisseurDao")
public class FournisseurDaoImpl extends ContactDaoImpl<Fournisseur, FournisseurImpl, IFournisseur> implements IFournisseurDao {

	/**
	 * Constructeur.
	 * 
	 */
	public FournisseurDaoImpl() {
		super(Fournisseur.class, FournisseurImpl.class);
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IFournisseur pFournisseur) throws BatifreeException {
		Fournisseur obj = getEjbFromMetier(pFournisseur);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getFournisseurMateriauxes(), FournisseurMateriauxImpl.class, IFournisseurMateriaux.class);
		}
		return null;
	}
}