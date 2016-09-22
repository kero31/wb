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
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IEtude;
import batifree.api.metier.interfaces.IFacture;
import batifree.api.metier.interfaces.ISituation;
import batifree.api.metier.interfaces.ITva;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <EtudeImpl>.
 * 
 */
public class EtudeImpl extends MetierImpl<Integer> implements IEtude {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Integer tvaDefaultId;
	private Integer affaireId;
	private IAffaire affaireSaved;
	private List<IBibEltEtude> listLigneEtudeUpdated = null;
	private boolean isListLigneEtudeUpdated = false;

	/**
	 * Constructeur.
	 */
	public EtudeImpl() {
		super();
	}

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pAffaire Affaire
	 */
	public EtudeImpl(IAffaire pAffaire) {
		super();
		setAffaire(pAffaire);
	}

	@Override
	public List<IBibEltEtude> getListBibliotheque() throws BatifreeException {
		if (isListLigneEtudeUpdated) {
			return listLigneEtudeUpdated;
		}
		return ApplicationBf.getApplication().getEtudeManager().getListBibliotheque(this);
	}

	@Override
	public ITva getTvaDefaut() throws BatifreeException {
		return ApplicationBf.getApplication().getTvaManager().getById(tvaDefaultId);
	}

	@Override
	public IAffaire getAffaire() throws BatifreeException {
		if (affaireSaved instanceof IDevis) {
			return ApplicationBf.getApplication().getDevisManager().getById(affaireId);
		}
		if (affaireSaved instanceof IFacture) {
			return ApplicationBf.getApplication().getFactureManager().getById(affaireId);
		}
		if (affaireSaved instanceof ISituation) {
			return ApplicationBf.getApplication().getSituationManager().getById(affaireId);
		}
		if (affaireSaved instanceof IAcompte) {
			return ApplicationBf.getApplication().getAcompteManager().getById(affaireId);
		}
		if (affaireSaved instanceof IAvoir) {
			return ApplicationBf.getApplication().getAvoirManager().getById(affaireId);
		}
		return null;
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
	public IEtude getClone(IAffaire pAffaire) throws BatifreeException {
		IApplication app = ApplicationBf.getApplication();
		return app.getEtudeManager().getClone(this, app.getFactory().createNewInstanceEtude(pAffaire), pAffaire);
	}

	@Override
	public void setTvaDefaut(ITva pTvaDefaut) {
		if (pTvaDefaut != null) {
			setTvaDefaultId(pTvaDefaut.getId());
		} else {
			setTvaDefaultId(null);
		}
	}

	/**
	 * Retourne le champ tvaDefaultId.
	 * 
	 * @return le tvaDefaultId
	 */
	public Integer getTvaDefaultId() {
		return tvaDefaultId;
	}

	/**
	 * Met à jour le champ tvaDefaultId.
	 * 
	 * @param pTvaDefaultId le tvaDefaultId à mettre à jour
	 */
	public void setTvaDefaultId(Integer pTvaDefaultId) {
		tvaDefaultId = pTvaDefaultId;
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
	public void setListBibliotheque(List<IBibEltEtude> pListLigneEtude) {
		listLigneEtudeUpdated = pListLigneEtude;
		isListLigneEtudeUpdated = true;
	}

	@Override
	public Boolean isListBibliothequeChanged() {
		return isListLigneEtudeUpdated;
	}
}
