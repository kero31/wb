/***********************************************************************
 * Module: ILigneHibernateDaoContainer.java Author: Kero Purpose: Defines the Interface ILigneHibernateDaoContainer
 ***********************************************************************/

package common.api.dao.interfaces;

import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;

/**
 * Interface <b>ILigneHibernateDaoContainer</b><br/>
 */
public interface ILigneHibernateDaoContainer {

	/**
	 * Retourne la classe d'implémentation à partir de l'objet EJB.
	 * 
	 * @param pLigneEjb Objet EJB
	 * @param <ILIGNE> ILigne<ILIGNE, ?>
	 * @return nouvelle instance de ILigne à partir de l'EJB
	 */
	<ILIGNE extends ILigne<ILIGNE, ?>> Class<ILIGNE> getClassMetierImplFromEjbForLigneDao(ILigneEjb pLigneEjb);

	/**
	 * Retourne la classe EJB à partir de l'interface métier
	 * 
	 * @param pLigneMetier Ligne métier
	 * @param <ILIGNE> ILigne<ILIGNE, ?>
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return classe EJB à partir de l'interface métier
	 */
	<ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> Class<ILIGNEEJB> getClassEjbFromMetierImplForLigneDao(ILIGNE pLigneMetier);

}