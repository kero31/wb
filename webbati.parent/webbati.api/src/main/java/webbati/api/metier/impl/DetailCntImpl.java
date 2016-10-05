/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IDetailCnt;

/**
 * Classe <DetailCntImpl>.
 * 
 */
public class DetailCntImpl extends MetierImpl<Integer> implements IDetailCnt {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Boolean defaut;
	private Integer coordonneeId;
	private String fonction;
	private Short ordre;

	/**
	 * Return defaut.
	 * 
	 * @return defaut
	 */
	public Boolean getDefaut() {
		return defaut;
	}

	@Override
	public Boolean isDefaut() {
		return getValue(defaut);
	}

	@Override
	public void setDefaut(Boolean pDefaut) {
		defaut = pDefaut;
	}

	@Override
	public Short getOrdre() {
		return getValue(ordre);
	}

	@Override
	public void setOrdre(Short pOrdre) {
		ordre = pOrdre;
	}

	@Override
	public String getFonction() {
		return fonction;
	}

	@Override
	public void setFonction(String pFonction) {
		fonction = pFonction;
	}

	@Override
	public ICoordonneeCnt getCoordonnee() throws WebbatiException {
		return ApplicationWb.getApplication().getCoordonneeCntManager().getById(coordonneeId);
	}

	@Override
	public void setCoordonnee(ICoordonneeCnt pCoordonnee) {
		if (pCoordonnee != null) {
			setCoordonneeId(pCoordonnee.getId());
		} else {
			setCoordonneeId(null);
		}
	}

	/**
	 * Retourne le champ coordonneeId.
	 * 
	 * @return le coordonneeId
	 */
	public Integer getCoordonneeId() {
		return coordonneeId;
	}

	/**
	 * Met à jour le champ coordonneeId.
	 * 
	 * @param pCoordonneeId le coordonneeId à mettre à jour
	 */
	public void setCoordonneeId(Integer pCoordonneeId) {
		coordonneeId = pCoordonneeId;
	}

}
