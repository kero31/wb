package common.api.exception;

/**
 * Classe <b>WebbatiUserException</b><br/>
 * 
 */
public class WebbatiUserException extends Exception {
	private static final long serialVersionUID = 1L;

	/** Constructeur. */
	public WebbatiUserException() {
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 */
	public WebbatiUserException(String pArg0) {
		super(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Exception
	 */
	public WebbatiUserException(Throwable pArg0) {
		super(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 * @param pArg1 Exception
	 */
	public WebbatiUserException(String pArg0, Throwable pArg1) {
		super(pArg0, pArg1);
	}

}