/***********************************************************************
 * Module: ILotTache.java Author: Didier Purpose: Defines the Interface ILotTache
 ***********************************************************************/

package batifree.api.metier.interfaces;

/**
 * Interface <b>ILotTache</b><br/>
 */
public interface ILotTache {

	/**
	 * Retourne le Temps Unitaire = somme des qté de type Main d'oeuvre du sous détail = getQuantite() par ligne
	 * 
	 * @return Temps Unitaire
	 */
	Float getTempsUnitaire();

	/**
	 * Retourne le Debourse Par Type = somme des PAU des éléments du sous-détail par type (MO, MX, Engin, ...) = somme Qte x PAU par ligne et par type
	 * 
	 * @return Debourse Par Type
	 */
	Float[] getDebourseParType();

}