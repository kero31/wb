/***********************************************************************
 * Module: IRole.java Author: Kero Purpose: Defines the Interface IRole
 ***********************************************************************/

package admin.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IRole</b><br/>
 */
public interface IRole extends IMetier<Integer> {

	/**
	 * Retourne le code.
	 * 
	 * @return code.
	 */
	String getCode();

	/**
	 * Met à jour le code.
	 * 
	 * @param pCode Le code.
	 */
	void setCode(String pCode);

	/**
	 * Retourne la liste des utilisateurs.
	 * 
	 * @return liste des utilisateurs.
	 * @throws WebbatiException WebbatiException
	 */
	List<IUserAppli> getListUserAppli() throws WebbatiException;

	/**
	 * Retourne le projet.
	 * 
	 * @return projet.
	 * @throws WebbatiException WebbatiException
	 */
	IProject getProject() throws WebbatiException;

	/**
	 * Met à jour le projet
	 * 
	 * @param pProject Le projet
	 */
	void setProject(IProject pProject);

}