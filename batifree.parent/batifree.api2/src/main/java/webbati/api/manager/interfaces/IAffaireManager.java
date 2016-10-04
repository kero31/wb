/***********************************************************************
 * Module: IAffaireManager.java Author: Kero Purpose: Defines the Interface IAffaireManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEtude;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws WebbatiException;

	/**
	 * Retourne une affaire clonée à partir d'une affaire origine en mettant à jour une nouvelle instance d'une affaire. Cela clone aussi ses sous
	 * éléments.
	 * 
	 * @param pAffaireOrigin Affaire origine
	 * @param pNewAffaireDest Nouvelle instaance de affaire
	 * @param <AFF> IAffaire
	 * @return affaire clonée
	 * @throws WebbatiException WebbatiException
	 */
	<AFF extends IAffaire> AFF getClone(IT pAffaireOrigin, AFF pNewAffaireDest) throws WebbatiException;

	/**
	 * Retourne la liste des Etudes.
	 * 
	 * @param pAffaire Affaire
	 * @return liste des Etude
	 * @throws WebbatiException WebbatiException
	 */
	List<IEtude> getListEtude(IAffaire pAffaire) throws WebbatiException;

}