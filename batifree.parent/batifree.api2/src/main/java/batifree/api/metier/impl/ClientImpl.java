/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IDetailCnt;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;

/**
 * Classe <ClientImpl>.
 * 
 */
public class ClientImpl extends ContactImpl implements IClient {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Boolean prospect;
	private Float montantPlafond;

	/**
	 * Return prospect.
	 * 
	 * @return prospect
	 */
	public Boolean getProspect() {
		return prospect;
	}

	@Override
	public Boolean isProspect() {
		return getValue(prospect);
	}

	@Override
	public void setProspect(Boolean pProspect) {
		prospect = pProspect;
	}

	@Override
	public Float getMontantPlafond() {
		return montantPlafond;
	}

	@Override
	public void setMontantPlafond(Float pMontantPlafond) {
		montantPlafond = pMontantPlafond;
	}

	@Override
	public List<ICoordonneeCnt> getListCoordonnee() throws BatifreeException {
		return ApplicationBf.getApplication().getClientManager().getListCoordonnee(this);
	}

	@Override
	public List<IAffaire> getListAffaire() throws BatifreeException {
		return ApplicationBf.getApplication().getClientManager().getListAffaire(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws BatifreeException {
		return ApplicationBf.getApplication().getClientManager().getListDetailContact(this);
	}

	@Override
	public List<IReglement> getListReglement() throws BatifreeException {
		return ApplicationBf.getApplication().getClientManager().getListReglement(this);
	}

	@Override
	public Integer getEncours() throws BatifreeException {
		// TODO Attente Didier pour méthode de calcul
		return 0;
	}

	@Override
	public Float getDepassement() throws BatifreeException {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}

}
