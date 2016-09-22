package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEcheancierReglementDao;
import batifree.api.metier.ejb.EcheancierReglement;
import batifree.api.metier.ejb.EcheancierReglementId;
import batifree.api.metier.impl.EcheancierReglementImpl;
import batifree.api.metier.interfaces.IEcheancierReglement;

/**
 * Classe <EcheancierReglementDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EcheancierReglementDao")
public class EcheancierReglementDaoImpl extends
        BfGenericHibernateDaoImpl<EcheancierReglement, EcheancierReglementImpl, IEcheancierReglement, EcheancierReglementId> implements
        IEcheancierReglementDao {

	/**
	 * Constructeur.
	 * 
	 */
	public EcheancierReglementDaoImpl() {
		super(EcheancierReglement.class, EcheancierReglementImpl.class);
	}
}