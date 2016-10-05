/**
 * 
 */
package webbati.api.metier.impl;

import common.api.metier.impl.MetierImpl;
import webbati.api.metier.interfaces.IImage;

/**
 * Classe <ImageImpl>.
 * 
 */
public class ImageImpl extends MetierImpl<Integer> implements IImage {

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
