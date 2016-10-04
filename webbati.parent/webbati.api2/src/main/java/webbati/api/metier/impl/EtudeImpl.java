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
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.IEtude;
import webbati.api.metier.interfaces.IFacture;
import webbati.api.metier.interfaces.ISituation;
import webbati.api.metier.interfaces.ITva;

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
	public List<IBibEltEtude> getListBibliotheque() throws WebbatiException {
		if (isListLigneEtudeUpdated) {
			return listLigneEtudeUpdated;
		}
		return ApplicationWb.getApplication().getEtudeManager().getListBibliotheque(this);
	}

	@Override
	public ITva getTvaDefaut() throws WebbatiException {
		return ApplicationWb.getApplication().getTvaManager().getById(tvaDefaultId);
	}

	@Override
	public IAffaire getAffaire() throws WebbatiException {
		if (affaireSaved instanceof IDevis) {
			return ApplicationWb.getApplication().getDevisManager().getById(affaireId);
		}
		if (affaireSaved instanceof IFacture) {
			return ApplicationWb.getApplication().getFactureManager().getById(affaireId);
		}
		if (affaireSaved instanceof ISituation) {
			return ApplicationWb.getApplication().getSituationManager().getById(affaireId);
		}
		if (affaireSaved instanceof IAcompte) {
			return ApplicationWb.getApplication().getAcompteManager().getById(affaireId);
		}
		if (affaireSaved instanceof IAvoir) {
			return ApplicationWb.getApplication().getAvoirManager().getById(affaireId);
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
	public IEtude getClone(IAffaire pAffaire) throws WebbatiException {
		IApplication app = ApplicationWb.getApplication();
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
