/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IDetailCnt;
import webbati.api.metier.interfaces.IReglement;

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
	public List<ICoordonneeCnt> getListCoordonnee() throws WebbatiException {
		return ApplicationWb.getApplication().getClientManager().getListCoordonnee(this);
	}

	@Override
	public List<IAffaire> getListAffaire() throws WebbatiException {
		return ApplicationWb.getApplication().getClientManager().getListAffaire(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws WebbatiException {
		return ApplicationWb.getApplication().getClientManager().getListDetailContact(this);
	}

	@Override
	public List<IReglement> getListReglement() throws WebbatiException {
		return ApplicationWb.getApplication().getClientManager().getListReglement(this);
	}

	@Override
	public Integer getEncours() throws WebbatiException {
		// TODO Attente Didier pour méthode de calcul
		return 0;
	}

	@Override
	public Float getDepassement() throws WebbatiException {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}

}
