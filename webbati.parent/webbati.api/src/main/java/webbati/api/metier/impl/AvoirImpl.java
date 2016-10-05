/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IAffaireManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IAvoir;
import webbati.api.metier.interfaces.IFacture;

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
	protected <IT extends IAffaire, TM extends IAffaireManager<IT>> TM getManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getAvoirManager();
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
	public IFacture getFacture() throws WebbatiException {
		return ApplicationWb.getApplication().getFactureManager().getById(factureId);
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
