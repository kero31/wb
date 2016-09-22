/***********************************************************************
 * Module: IEcheancierManager.java Author: Kero Purpose: Defines the Interface IEcheancierManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IEcheancierManager</b><br/>
 */
public interface IEcheancierManager extends IManager<IEcheancier, Integer> {

	/**
	 * Retourne la liste des Echeancier Reglement.
	 * 
	 * @param pEcheancier Echeancier
	 * @return liste des Echeancier Reglement.
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancierReglement> getListEcheancierReglement(IEcheancier pEcheancier) throws BatifreeException;

	/**
	 * Retourne un échéancier cloné à partir d'un échéancier origine en mettant à jour une nouvelle instance d'un échéancier . L'étude sera affecté
	 * sur l'affaire de l'affaire de l'étude d'origine.
	 * 
	 * @param pEcheancierOrigin Echeancier origine
	 * @param pNewEcheancierDest Nouvelle instance de écheancier
	 * @return échéancier clonée
	 * @throws BatifreeException BatifreeException
	 */
	IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest) throws BatifreeException;

	/**
	 * Retourne un échéancier cloné à partir d'un échéancier origine en mettant à jour une nouvelle instance d'un échéancier . Cette étude sera
	 * affectée à une affaire.
	 * 
	 * @param pEcheancierOrigin Echeancier origine
	 * @param pNewEcheancierDest Nouvelle instance de écheancier
	 * @param pAffaire Affaire
	 * @return échéancier clonée
	 * @throws BatifreeException BatifreeException
	 */
	IEcheancier getClone(IEcheancier pEcheancierOrigin, IEcheancier pNewEcheancierDest, IAffaire pAffaire) throws BatifreeException;

}