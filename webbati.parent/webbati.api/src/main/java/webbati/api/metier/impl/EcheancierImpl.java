/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.application.interfaces.IApplication;
import webbati.api.metier.interfaces.IAcompte;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IAvoir;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IFacture;
import webbati.api.metier.interfaces.ISituation;

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
	public List<IEcheancierReglement> getListEcheancierReglement() throws WebbatiException {
		return ApplicationWb.getApplication().getEcheancierManager().getListEcheancierReglement(this);
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
	public IAffaire getAffaire() throws WebbatiException {
		IAffaire aff = null;
		if (affaireId != null) {
			if (affaireSaved != null) {
				if (affaireSaved instanceof IDevis) {
					aff = ApplicationWb.getApplication().getDevisManager().getById(affaireId);
				} else if (affaireSaved instanceof IFacture) {
					aff = ApplicationWb.getApplication().getFactureManager().getById(affaireId);
				} else if (affaireSaved instanceof ISituation) {
					aff = ApplicationWb.getApplication().getSituationManager().getById(affaireId);
				} else if (affaireSaved instanceof IAcompte) {
					aff = ApplicationWb.getApplication().getAcompteManager().getById(affaireId);
				} else if (affaireSaved instanceof IAvoir) {
					aff = ApplicationWb.getApplication().getAvoirManager().getById(affaireId);
				}
			} else {
				aff = ApplicationWb.getApplication().getDevisManager().getById(affaireId);
				if (aff == null) {
					aff = ApplicationWb.getApplication().getFactureManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationWb.getApplication().getSituationManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationWb.getApplication().getAcompteManager().getById(affaireId);
				}
				if (aff == null) {
					aff = ApplicationWb.getApplication().getAvoirManager().getById(affaireId);
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
	public IEcheancier getClone(IAffaire pAffaire) throws WebbatiException {
		IApplication app = ApplicationWb.getApplication();
		return app.getEcheancierManager().getClone(this, app.getFactory().createNewInstance(IEcheancier.class), pAffaire);
	}
}
