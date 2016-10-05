/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IAffaireManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.ISituation;

/**
 * Classe <SituationImpl>.
 * 
 */
public class SituationImpl extends AffaireImpl implements ISituation {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Integer devisId;

	@Override
	public IDevis getDevis() throws WebbatiException {
		return ApplicationWb.getApplication().getDevisManager().getById(devisId);
	}

	@Override
	public void setDevis(IDevis pDevis) {
		if (pDevis != null) {
			setDevisId(pDevis.getId());
		} else {
			setDevisId(null);
		}
	}

	/**
	 * Retourne le champ devisId.
	 * 
	 * @return le devisId
	 */
	public Integer getDevisId() {
		return devisId;
	}

	/**
	 * Met à jour le champ devisId.
	 * 
	 * @param pDevisId le devisId à mettre à jour
	 */
	public void setDevisId(Integer pDevisId) {
		devisId = pDevisId;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <IT extends IAffaire, TM extends IAffaireManager<IT>> TM getManager() throws WebbatiException {
		return (TM) ApplicationWb.getApplication().getSituationManager();
	}

}
