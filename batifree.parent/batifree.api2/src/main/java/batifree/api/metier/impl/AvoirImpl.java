/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IAffaireManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IAvoir;
import batifree.api.metier.interfaces.IFacture;

import common.api.exception.BatifreeException;

/**
 * Classe <AvoirImpl>.
 * 
 */
public class AvoirImpl extends AffaireImpl implements IAvoir {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Integer factureId;

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IAffaire, TM extends IAffaireManager<IT>> TM getManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getAvoirManager();
	}

	@Override
	public void setFacture(IFacture pFacture) {
		if (pFacture != null) {
			setFactureId(pFacture.getId());
		} else {
			setFactureId(null);
		}
	}

	@Override
	public IFacture getFacture() throws BatifreeException {
		return ApplicationBf.getApplication().getFactureManager().getById(factureId);
	}

	/**
	 * Retourne le champ factureId.
	 * 
	 * @return le factureId
	 */
	public Integer getFactureId() {
		return factureId;
	}

	/**
	 * Met à jour le champ factureId.
	 * 
	 * @param pFactureId le factureId à mettre à jour
	 */
	public void setFactureId(Integer pFactureId) {
		factureId = pFactureId;
	}
}
