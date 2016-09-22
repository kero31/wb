/***********************************************************************
 * Module: IProject.java Author: Kero Purpose: Defines the Interface IProject
 ***********************************************************************/

package admin.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IProject</b><br/>
 */
public interface IProject extends IMetier<Integer> {

	/**
	 * Retourne la liste des rôles.
	 * 
	 * @return liste des rôles.
	 * @throws BatifreeException BatifreeException
	 */
	List<IRole> getListRole() throws BatifreeException;

	/**
	 * Retourne la liste des scripts.
	 * 
	 * @return liste des scripts.
	 * @throws BatifreeException BatifreeException
	 */
	List<IProjectscript> getListProjectscript() throws BatifreeException;

	/**
	 * Retourne le nom.
	 * 
	 * @return nom.
	 */
	String getName();

	/**
	 * Met à jour le nom.
	 * 
	 * @param pName le nom
	 */
	void setName(String pName);

	/**
	 * Retourne le code
	 * 
	 * @return code
	 */
	String getCode();

	/**
	 * Met à jour le code.
	 * 
	 * @param pCode le code
	 */
	void setCode(String pCode);

}