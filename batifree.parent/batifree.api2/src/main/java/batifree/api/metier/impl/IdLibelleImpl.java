/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.metier.interfaces.IIdLibelle;

import common.api.metier.impl.MetierImpl;

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
