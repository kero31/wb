/***********************************************************************
 * Module: IDetailCnt.java Author: Kero Purpose: Defines the Interface IDetailCnt
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IDetailCnt</b><br/>
 */
public interface IDetailCnt extends IMetier<Integer> {

	/**
	 * Get Defaut
	 * 
	 * @return TRUE si Defaut, FALSE sinon
	 */
	Boolean isDefaut();

	/**
	 * Set Defaut
	 * 
	 * @param pDefaut TRUE si Defaut, FALSE sinon
	 */
	void setDefaut(Boolean pDefaut);

	/**
	 * Get Ordre
	 * 
	 * @return Ordre
	 */
	java.lang.Short getOrdre();

	/**
	 * Set Ordre
	 * 
	 * @param pOrdre Ordre
	 */
	void setOrdre(java.lang.Short pOrdre);

	/**
	 * Get Fonction
	 * 
	 * @return Fonction
	 */
	java.lang.String getFonction();

	/**
	 * Set Fonction
	 * 
	 * @param pFonction Fonction
	 */
	void setFonction(java.lang.String pFonction);

	/**
	 * Get Coordonnee
	 * 
	 * @return Coordonnee
	 * @throws WebbatiException WebbatiException
	 */
	ICoordonneeCnt getCoordonnee() throws WebbatiException;

	/**
	 * Set Coordonnee
	 * 
	 * @param pCoordonnee Coordonnee
	 */
	void setCoordonnee(ICoordonneeCnt pCoordonnee);

}