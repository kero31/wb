/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.metier.interfaces.IBinaire;

import common.api.metier.impl.MetierImpl;

/**
 * Classe <BinaireImpl>.
 * 
 */
public class BinaireImpl extends MetierImpl<Integer> implements IBinaire {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private byte[] object;

	@Override
	public byte[] getObjet() {
		return object;
	}

	@Override
	public void setObjet(byte[] pObjet) {
		object = pObjet;
	}

}
