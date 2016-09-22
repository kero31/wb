/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.metier.interfaces.ITva;

/**
 * Classe <TvaImpl>.
 * 
 */
public class TvaImpl extends IdLibelleImpl implements ITva {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Float taux;
	private Boolean hide;

	@Override
	public Float getTaux() {
		return taux;
	}

	@Override
	public void setTaux(Float pTaux) {
		taux = pTaux;
	}

	@Override
	public Boolean isHide() {
		return hide;
	}

	@Override
	public void setHide(Boolean pHide) {
		hide = pHide;
	}

}
