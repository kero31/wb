/**
 * 
 */
package webbati.api.metier.impl;

import common.api.metier.impl.MetierImpl;
import webbati.api.metier.interfaces.IIdLibelle;

/**
 * Classe <IdLibelleImpl>.
 * 
 */
public abstract class IdLibelleImpl extends MetierImpl<Integer> implements IIdLibelle {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String libelle;

	@Override
	public String getLibelle() {
		return libelle;
	}

	@Override
	public void setLibelle(String pLibelle) {
		libelle = pLibelle;
	}

}
