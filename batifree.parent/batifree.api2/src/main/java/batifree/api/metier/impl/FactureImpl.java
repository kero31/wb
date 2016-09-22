package batifree.api.metier.impl;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IAffaireManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IFacture;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>FactureImpl</b><br/>
 *
 */
public class FactureImpl extends AffaireImpl implements IFacture {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Integer devisId;

	@Override
	public IDevis getDevis() throws BatifreeException {
		return ApplicationBf.getApplication().getDevisManager().getById(devisId);
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
	protected <IT extends IAffaire, TM extends IAffaireManager<IT>> TM getManager() throws BatifreeException {
		return (TM) ApplicationBf.getApplication().getFactureManager();
	}
}
