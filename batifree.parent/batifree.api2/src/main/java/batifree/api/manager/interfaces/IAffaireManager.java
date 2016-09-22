/***********************************************************************
 * Module: IAffaireManager.java Author: Kero Purpose: Defines the Interface IAffaireManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEtude;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IAffaireManager</b><br/>
 * 
 * @param <IT> IAffaire
 */
public interface IAffaireManager<IT extends IAffaire> extends IManager<IT, Integer> {

	/**
	 * Retourne la liste des Echeanciers.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Echeanciers
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws BatifreeException;

	/**
	 * Retourne une affaire clonée à partir d'une affaire origine en mettant à jour une nouvelle instance d'une affaire. Cela clone aussi ses sous
	 * éléments.
	 * 
	 * @param pAffaireOrigin Affaire origine
	 * @param pNewAffaireDest Nouvelle instaance de affaire
	 * @param <AFF> IAffaire
	 * @return affaire clonée
	 * @throws BatifreeException BatifreeException
	 */
	<AFF extends IAffaire> AFF getClone(IT pAffaireOrigin, AFF pNewAffaireDest) throws BatifreeException;

	/**
	 * Retourne la liste des Etudes.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Etude
	 * @throws BatifreeException BatifreeException
	 */
	List<IEtude> getListEtude(IAffaire pAffaire) throws BatifreeException;

}