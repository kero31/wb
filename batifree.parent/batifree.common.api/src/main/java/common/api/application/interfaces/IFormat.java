/***********************************************************************
 * Module: IFormat.java Author: Kero Purpose: Defines the Interface IFormat
 ***********************************************************************/

package common.api.application.interfaces;

import java.math.BigDecimal;

/**
 * Interface <b>IFormat</b><br/>
 */
public interface IFormat {

	/**
	 * Retourne un String formatté.
	 * 
	 * 
	 * @param pValue String à formatter
	 * @return @return String formatté en String
	 */
	String toString(String pValue);

	/**
	 * Retourne un String formatté pour JavaScript.
	 * 
	 * 
	 * @param pValue String à formatter pour JavaScript
	 * @return @return String formatté en String
	 */
	String toStringJS(String pValue);

	/**
	 * Retourne un BigDecimal formatté en String.
	 * 
	 * 
	 * @param pValue BigDecimal à formatter
	 * @return @return BigDecimal formatté en String
	 */
	String toString(BigDecimal pValue);

	/**
	 * Retourne une Date formatté en String.
	 * 
	 * 
	 * @param pValue Date à formatter
	 * @return @return Date formatté en String
	 */
	String toString(java.util.Date pValue);

	/**
	 * Retourne un objet formatté en String.
	 * 
	 * 
	 * @param pObject objet à formatter
	 * @return @return Objet formatté en String
	 */
	String toString(Object pObject);

}