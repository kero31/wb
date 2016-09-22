package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IFournisseurMateriauxDao;
import batifree.api.metier.ejb.FournisseurMateriaux;
import batifree.api.metier.ejb.FournisseurMateriauxId;
import batifree.api.metier.impl.FournisseurMateriauxImpl;
import batifree.api.metier.interfaces.IFournisseurMateriaux;

/**
 * Classe <FournisseurMateriauxDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_FournisseurMateriauxDao")
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