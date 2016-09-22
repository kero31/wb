/**
 * 
 */
package batifree.api.metier.impl;

import batifree.api.metier.interfaces.IImage;

import common.api.metier.impl.MetierImpl;

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
