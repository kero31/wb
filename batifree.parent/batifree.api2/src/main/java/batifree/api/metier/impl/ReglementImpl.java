/**
 * 
 */
package batifree.api.metier.impl;

import java.util.Date;
import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IModePaiement;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <ReglementImpl>.
 * 
 */
public class ReglementImpl extends MetierImpl<Integer> implements IReglement {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String descriptif;
	private Date datePaiement;
	private String banque;
	private String numCheque;
	private Integer modePaiementId;

	@Override
	public List<IEcheancierReglement> getListEcheancierReglement() throws BatifreeException {
		return ApplicationBf.getApplication().getReglementManager().getListEcheancierReglement(this);
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		code = pCode;
	}

	@Override
	public String getDescriptif() {
		return descriptif;
	}

	@Override
	public void setDescriptif(String pDescriptif) {
		descriptif = pDescriptif;
	}

	@Override
	public Date getDatePaiement() {
		return datePaiement;
	}

	@Override
	public void setDatePaiement(Date pDatePaiement) {
		datePaiement = pDatePaiement;
	}

	@Override
	public String getBanque() {
		return banque;
	}

	@Override
	public void setBanque(String pBanque) {
		banque = pBanque;
	}

	@Override
	public String getNumCheque() {
		return numCheque;
	}

	@Override
	public void setNumCheque(String pNumCheque) {
		numCheque = pNumCheque;
	}

	@Override
	public IModePaiement getModePaiement() throws BatifreeException {
		return ApplicationBf.getApplication().getModePaiementManager().getById(modePaiementId);
	}

	@Override
	public void setModePaiement(IModePaiement pModePaiement) {
		if (pModePaiement != null) {
			setModePaiementId(pModePaiement.getId());
		} else {
			setModePaiementId(null);
		}
	}

	/**
	 * Retourne le champ modePaiementId.
	 * 
	 * @return le modePaiementId
	 */
	public Integer getModePaiementId() {
		return modePaiementId;
	}

	/**
	 * Met à jour le champ modePaiementId.
	 * 
	 * @param pModePaiementId le modePaiementId à mettre à jour
	 */
	public void setModePaiementId(Integer pModePaiementId) {
		modePaiementId = pModePaiementId;
	}
}
