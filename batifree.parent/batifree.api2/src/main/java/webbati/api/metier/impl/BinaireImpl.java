/**
 * 
 */
package webbati.api.metier.impl;

import common.api.metier.impl.MetierImpl;
import webbati.api.metier.interfaces.IBinaire;

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
