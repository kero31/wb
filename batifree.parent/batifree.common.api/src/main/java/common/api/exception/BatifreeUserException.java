package common.api.exception;

/**
 * Classe <b>BatifreeUserException</b><br/>
 * 
 * Classe <BatifreeUserException>
 */
public class BatifreeUserException extends Exception {
	private static final long serialVersionUID = 1L;

	/** Constructeur. */
	public BatifreeUserException() {
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 */
	public BatifreeUserException(String pArg0) {
		super(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Exception
	 */
	public BatifreeUserException(Throwable pArg0) {
		super(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 * @param pArg1 Exception
	 */
	public BatifreeUserException(String pArg0, Throwable pArg1) {
		super(pArg0, pArg1);
	}

}