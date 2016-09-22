/***********************************************************************
 * Module: IFamilleManager.java Author: Kero Purpose: Defines the Interface IFamilleManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFamille;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.ILigneManager;

/**
 * Interface <b>IFamilleManager</b><br/>
 */
public interface IFamilleManager extends ILigneManager<IFamille, Integer, IFamille> {

	/**
	 * Retourne la liste des Bibliotheques.
	 * 
	 * @param pFamille Famille
	 * @return liste des Bibliotheques.
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws BatifreeException;

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour. <br/>
	 * <b>Cette méthode renvoie la famille du 1er niveau</b>
	 * 
	 * @param pFamille Famille à créer ou à mettre à jour
	 * @return objet créé ou modifié
	 * @throws BatifreeException BatifreeException
	 */
	IFamille save(IFamille pFamille) throws BatifreeException;

	/**
	 * Supprime la ligne et ses sous lignes
	 * 
	 * @param pObject Objet à supprimer
	 * @throws BatifreeException BatifreeException
	 */
	void delete(IFamille pObject) throws BatifreeException;

	/**
	 * Supprime toutes les lignes et ses sous lignes
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	void deleteAll() throws BatifreeException;

}