/***********************************************************************
 * Module: IFamilleManager.java Author: Kero Purpose: Defines the Interface IFamilleManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.ILigneManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IFamille;

/**
 * Interface <b>IFamilleManager</b><br/>
 */
public interface IFamilleManager extends ILigneManager<IFamille, Integer, IFamille> {

	/**
	 * Retourne la liste des Bibliotheques.
	 * 
	 * @param pFamille Famille
	 * @return liste des Bibliotheques.
	 * @throws WebbatiException WebbatiException
	 */
	List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws WebbatiException;

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour. <br/>
	 * <b>Cette méthode renvoie la famille du 1er niveau</b>
	 * 
	 * @param pFamille Famille à créer ou à mettre à jour
	 * @return objet créé ou modifié
	 * @throws WebbatiException WebbatiException
	 */
	IFamille save(IFamille pFamille) throws WebbatiException;

	/**
	 * Supprime la ligne et ses sous lignes
	 * 
	 * @param pObject Objet à supprimer
	 * @throws WebbatiException WebbatiException
	 */
	void delete(IFamille pObject) throws WebbatiException;

	/**
	 * Supprime toutes les lignes et ses sous lignes
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	void deleteAll() throws WebbatiException;

}