package common.api.util.generate;

/**
 * 
 * Classe/Interface <StringBufferI>
 *
 */
public class StringBufferI {

	private StringBuffer buffer = null;

	/**
	 * 
	 * Constructeur.
	 */
	public StringBufferI() {
		buffer = new StringBuffer();
	}

	/**
	 * @return the buffer
	 */
	public StringBuffer getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer the buffer to set
	 */

	/**
	 * Set Buffer
	 * 
	 * @param pBuffer Buffer
	 */
	public void setBuffer(StringBuffer pBuffer) {
		this.buffer = pBuffer;
	}

	/**
	 * Ajoute texte
	 * 
	 * @param pTxt texte
	 * @param pNbRetourLigne Nb Retour Ligne
	 */
	public void add(String pTxt, int pNbRetourLigne) {
		buffer.append(pTxt);
		for (int i = 0; i < pNbRetourLigne; i++) {
			buffer.append("\n");
		}
	}

	/**
	 * Ajoute un retour à la ligne.
	 */
	public void addRetourLigne() {
		buffer.append("\n");
	}

	/**
	 * Ajoute n retour à la ligne.
	 * 
	 * @param pNbRetourLigne Nb Retour Ligne
	 */
	public void addRetourLigne(int pNbRetourLigne) {
		for (int i = 0; i < pNbRetourLigne; i++) {
			buffer.append("\n");
		}
	}

	/**
	 * Ajoute texte dans classe
	 * 
	 * @param pTxt texte
	 * @param pNbRetourLigne Nb Retour Ligne
	 */
	public void addInClass(String pTxt, int pNbRetourLigne) {
		buffer.append("\t");
		add(pTxt, pNbRetourLigne);
	}

	/**
	 * Ajoute texte dans méthode
	 * 
	 * @param pTxt texte
	 * @param pNbRetourLigne Nb Retour Ligne
	 */
	public void addInMethod(String pTxt, int pNbRetourLigne) {
		buffer.append("\t\t");
		add(pTxt, pNbRetourLigne);
	}

	/**
	 * Ajoute texte
	 * 
	 * @param pTxt texte
	 */
	public void add(String pTxt) {
		add(pTxt, 0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return buffer.toString();
	}

}
