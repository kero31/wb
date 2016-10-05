package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEcheancierReglementDao;
import webbati.api.metier.ejb.EcheancierReglement;
import webbati.api.metier.ejb.EcheancierReglementId;
import webbati.api.metier.impl.EcheancierReglementImpl;
import webbati.api.metier.interfaces.IEcheancierReglement;

/**
 * Classe <EcheancierReglementDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EcheancierReglementDao")
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