/***********************************************************************
 * Module: IBibliothequeManager.java Author: Kero Purpose: Defines the Interface IBibliothequeManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.ILigneManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.ITva;

/**
 * Interface <b>IBibliothequeManager</b><br/>
 * 
 * @param <IT> IBibliotheque
 */
public interface IBibliothequeManager<IT extends IBibliotheque> extends ILigneManager<IT, Integer, IBibliotheque> {

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour <br/>
	 * <b>Cette méthode renvoie la famille du 1er niveau</b>
	 * 
	 * @param pObject Objet à créer ou à mettre à jour
	 * @param <BIB> IBibliotheque
	 * @return objet créé ou modifié
	 * @throws WebbatiException WebbatiException
	 */
	<BIB extends IBibliotheque> BIB saveLigne(IT pObject) throws WebbatiException;

	/**
	 * Retourne le clone de l'objet de bib origine en mettant à jour une nouvelle instance de bib destination
	 * 
	 * @param pBibOrigin Bib Origin
	 * @param pBibNewDest Nouvelle instance de Bib Dest
	 * @param pIsUseForImport TRUE si utilisation pour import, FALSE sinon
	 * @param <BIBD> IBibliotheque
	 * @return clone à partir de l'objet bib origine
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest, Boolean pIsUseForImport) throws WebbatiException;

	/**
	 * Retourne le clone de l'objet de bib origine en mettant à jour une nouvelle instance de bib destination
	 * 
	 * @param pBibOrigin Bib Origin
	 * @param pBibNewDest Nouvelle instance de Bib Dest
	 * @param <BIBD> IBibliotheque
	 * @return clone à partir de l'objet bib origine
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest) throws WebbatiException;

	/**
	 * Retourne une ligne clonée à partir d'une ligne origine en mettant à jour une nouvelle instance d'une ligne. La ligne aura comme parent le
	 * parent passé en paramètre.
	 * 
	 * @param pBibOrigin Bib Origin
	 * @param pBibNewDest Nouvelle instance de Bib Dest
	 * @param pParentDest Bib parent
	 * @param <BIBD> IBibliotheque
	 * @return ligne étude clonée
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest, IT pParentDest) throws WebbatiException;

	/**
	 * Retourne le Bib Element mis à jour avec les données du Bib Element passé en paramètre. Cela met à jour les prix, ...
	 * 
	 * @param pBibEltOrigin Bib Elt Origine
	 * @return Bib Element mis à jour
	 */
	IT getBibEltUpdated(IT pBibEltOrigin);

	/**
	 * Retourne le Bib Element en mettant à jour que la TVA passé en paramètre à partir du Bib Element passé en paramètre
	 * 
	 * @param pBibEltOrigin Bib Elt Origine
	 * @param pTva Tva à mettre à jour
	 * @return Bib Element en mettant à jour que la TVA
	 */
	IT getBibEltUpdatedForTVA(IT pBibEltOrigin, ITva pTva);

	/**
	 * Supprime la ligne et ses sous lignes
	 * 
	 * @param pObject Objet à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(IT pObject) throws WebbatiException;

	/**
	 * Supprime toutes les lignes et ses sous lignes
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void deleteAll() throws WebbatiException;

}