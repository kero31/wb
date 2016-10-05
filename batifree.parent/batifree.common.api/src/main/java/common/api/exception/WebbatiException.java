package common.api.exception;

import org.apache.log4j.Logger;

/**
 * Classe <b>WebbatiException</b><br/>
 * 
 */
public class WebbatiException extends Exception {
	private static final Logger LOGGER = Logger.getLogger(WebbatiException.class);
	private static final long serialVersionUID = 1L;

	/** Constructeur. */
	public WebbatiException() {
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 */
	public WebbatiException(String pArg0) {
		super(pArg0);
		LOGGER.error(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Exception
	 */
	public WebbatiException(Throwable pArg0) {
		super(pArg0);
		LOGGER.error(pArg0);
	}

	/**
	 * Constructeur.
	 * 
	 * @param pArg0 Message
	 * @param pArg1 Exception
	 */
	public WebbatiException(String pArg0, Throwable pArg1) {
		super(pArg0 + " - " + ((pArg1 != null) ? pArg1.getMessage() : ""));
		LOGGER.error(pArg0, pArg1);
	}

}