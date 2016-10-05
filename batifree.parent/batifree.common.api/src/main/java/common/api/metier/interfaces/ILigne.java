/***********************************************************************
 * Module: ILigne.java Author: Kero Purpose: Defines the Interface ILigne
 ***********************************************************************/

package common.api.metier.interfaces;

import java.util.List;

import java.io.Serializable;

/**
 * Interface <b>ILigne</b><br/>
 * 
 * @param <IT>
 * @param <ID> Serializable
 */
public interface ILigne<IT, ID extends Serializable> extends IMetier<ID> {

	/**
	 * Get Ordre
	 * 
	 * @return Ordre
	 */
	Integer getOrdre();

	/**
	 * Set Ordre
	 * 
	 * @param pOrdre Ordre
	 */
	void setOrdre(Integer pOrdre);

	/**
	 * Get Parent
	 * 
	 * @return Parent
	 */
	IT getParent();

	/**
	 * Set Parent
	 * 
	 * @param pParent Parent
	 */
	void setParent(IT pParent);

	/**
	 * Renvoie la liste des ligne fils
	 * 
	 * @return Liste des Ligne
	 */
	List<IT> getListLigne();

	/**
	 * Met à jour la liste ligne
	 * 
	 * @param pListLigne Liste ligne
	 */
	void setListLigne(List<IT> pListLigne);

}