/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.application.interfaces.IApplication;
import batifree.api.metier.interfaces.IAcompte;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IAvoir;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IFacture;
import batifree.api.metier.interfaces.ISituation;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <EcheancierImpl>.
 * 
 */
public class EcheancierImpl extends MetierImpl<Integer> implements IEcheancier {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Integer affaireId;
	private IAffaire affaireSaved;

	/**
	 * Constructeur.
	 */
	public EcheancierImpl() {
		super();
	}

	/**
	 * Constructeur.
	 * 
	 * @param pAffaire l'affaire
	 */
	public EcheancierImpl(IAffaire pAffaire) {
		super();
		setAffaire(pAffaire);
	}

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement() throws BatifreeException {
		return ApplicationBf.getApplication().getEcheancierManager().getListEcheancierReglement(this);
	}

	@Override
	public void setAffaire(IAffaire pAffaire) {
		if (pAffaire != null) {
			setAffaireId(pAffaire.getId());
		} else {
			setAffaireId(null);
		}
		affaireSaved = pAffaire;
	}

	@Override
	public IAffaire getAffaire() throws BatifreeException {
		IAffaire aff = null;
		if (affaireId != null) {
			if (affaireSaved != null) {
				if (affaireSaved instanceof IDevis) {
					aff = ApplicationBf.getApplication().getDevisManager().getById(affaireId);
				} else if (affaireSaved instanceof IFacture) {
					aff = ApplicationBf.getApplication().getFactureManager().getById(affaireId);
				} else if (affaireSaved instanceof ISituation) {
					aff = ApplicationBf.getApplication().getSituationManager().getById(affaireId);
				} else if (affaireSaved instanceof IAcompte) {
					aff = ApplicationBf.getApplication().getAcompteManager().getById(affaireId);
				} else if (affaireSaved instanceof IAvoir) {
					aff = ApplicationBf.getApplication().getAvoirManager().getById(affaireId);
				}
			} else {
				aff = ApplicationBf.getApplication().getDevisManager().getById(affaireId);
				if (aff == null) {
					aff = ApplicationBf.getApplication().getFactureManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationBf.getApplication().getSituationManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationBf.getApplication().getAcompteManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationBf.getApplication().getAvoirManager().getById(affaireId);
				}
			}
		}
		return aff;
	}

	/**
	 * Retourne le champ affaireId.
	 * 
	 * @return le affaireId
	 */
	public Integer getAffaireId() {
		return affaireId;
	}

	/**
	 * Met à jour le champ affaireId.
	 * 
	 * @param pAffaireId le affaireId à mettre à jour
	 */
	public void setAffaireId(Integer pAffaireId) {
		affaireId = pAffaireId;
	}

	@Override
	public IEcheancier getClone(IAffaire pAffaire) throws BatifreeException {
		IApplication app = ApplicationBf.getApplication();
		return app.getEcheancierManager().getClone(this, app.getFactory().createNewInstance(IEcheancier.class), pAffaire);
	}
}
