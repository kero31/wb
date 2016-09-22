/***********************************************************************
 * Module: IEtudeManager.java Author: Kero Purpose: Defines the Interface IEtudeManager
 ***********************************************************************/

package batifree.api.manager.interfaces;

import java.util.List;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IEtude;

import common.api.exception.BatifreeException;
import common.api.manager.interfaces.IManager;

/**
 * Interface <b>IEtudeManager</b><br/>
 */
public interface IEtudeManager extends IManager<IEtude, Integer> {

	/**
	 * Retourne la liste des éléments de la bibliothèque de l'étude.
	 * 
	 * @param pEtude Etude
	 * @return liste des éléments de la bibliothèque de l'étude.
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws BatifreeException;

	/**
	 * Retourne une étude clonée à partir d'une étude origine en mettant à jour une nouvelle instance d'une étude. L'étude sera affecté sur l'affaire
	 * de l'affaire de l'étude d'origine.
	 * 
	 * @param pEtudeOrigin Etude origine
	 * @param pNewEtudeDest Nouvelle instance de étude
	 * @return étude clonée
	 * @throws BatifreeException BatifreeException
	 */
	IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest) throws BatifreeException;

	/**
	 * Retourne une étude clonée à partir d'une étude origine en mettant à jour une nouvelle instance d'une étude. Cette étude sera affectée à une
	 * affaire.
	 * 
	 * @param pEtudeOrigin Etude origine
	 * @param pNewEtudeDest Nouvelle instance de étude
	 * @param pAffaire Affaire
	 * @return étude clonée
	 * @throws BatifreeException BatifreeException
	 */
	IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest, IAffaire pAffaire) throws BatifreeException;

}