/***********************************************************************
 * Module: IProjectscript.java Author: Kero Purpose: Defines the Interface IProjectscript
 ***********************************************************************/

package admin.api.metier.interfaces;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IProjectscript</b><br/>
 */
public interface IProjectscript extends IMetier<Integer> {

	/**
	 * Retourne le nom du fichier.
	 * 
	 * @return nom du fichier.
	 */
	String getFileName();

	/**
	 * Met à jour le nom du fichier.
	 * 
	 * @param pFileName le nom du fichier
	 */
	void setFileName(String pFileName);

	/**
	 * Retourne le projet.
	 * 
	 * @return projet.
	 * @throws BatifreeException BatifreeException
	 */
	IProject getProject() throws BatifreeException;

	/**
	 * Met à jour le projet
	 * 
	 * @param pProject Le projet
	 */
	void setProject(IProject pProject);

}