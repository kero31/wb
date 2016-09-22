package common.api.exception;

import org.apache.log4j.Logger;

/**
 * Classe <b>BatifreeException</b><br/>
 * 
 * Classe <BatifreeException>
 * 
 * Classe <BatifreeException>
 * 
 * Classe <BatifreeException>
 * 
 * Classe <BatifreeException>
 * 
 * Classe <BatifreeException>
 */
public class BatifreeException extends Exception {
	private static final Logger LOGGER = Logger.getLogger(BatifreeException.class);
	private static final long serialVersionUID = 1L;

	/** Constructeur. */
	public BatifreeException() {
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 */
	public BatifreeException(String pArg0) {
		super(pArg0);
		LOGGER.error(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Exception
	 */
	public BatifreeException(Throwable pArg0) {
		super(pArg0);
		LOGGER.error(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 * @param pArg1 Exception
	 */
	public BatifreeException(String pArg0, Throwable pArg1) {
		super(pArg0 + " - " + ((pArg1 != null) ? pArg1.getMessage() : ""));
		LOGGER.error(pArg0, pArg1);
	}

}