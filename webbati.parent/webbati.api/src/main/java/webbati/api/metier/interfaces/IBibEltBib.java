/***********************************************************************
 * Module: IBibEltBib.java Author: Kero Purpose: Defines the Interface IBibEltBib
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;

/**
 * Interface <b>IBibEltBib</b><br/>
 */
public interface IBibEltBib {

	/**
	 * Retourne le clone de l'objet courant pour utilisation dans l'import. Copie la bib origine dans la propriété "ElementOrigin" de la bib de
	 * destination.
	 * 
	 * @param <BIBD> IBibliotheque
	 * @return clone de l'objet courant
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getCloneForImport() throws WebbatiException;

	/**
	 * Retourne le clone de l'objet courant pour utilisation dans l'import. Copie la bib origine dans la propriété "ElementOrigin" de la bib de
	 * destination.
	 * 
	 * @param pClassInterfaceDest Classe de l'interface de l'élément de destination
	 * @param <BIBD> IBibliotheque
	 * @return clone de l'objet courant
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getCloneForImport(Class<BIBD> pClassInterfaceDest) throws WebbatiException;

	/**
	 * Retourne l'élément bib origine
	 * 
	 * @return élément bib origine
	 * @throws WebbatiException WebbatiException
	 */
	IBibEltBib getElementOrigin() throws WebbatiException;

	/**
	 * Met à jour l'élément bib origine
	 * 
	 * @param pElementOrigine Element bib origine
	 */
	void setElementOrigin(IBibEltBib pElementOrigine);

}