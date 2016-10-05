/***********************************************************************
 * Module: IEtudeManager.java Author: Kero Purpose: Defines the Interface IEtudeManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.manager.interfaces.IManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IEtude;

/**
 * Interface <b>IEtudeManager</b><br/>
 */
public interface IEtudeManager extends IManager<IEtude, Integer> {

	/**
	 * Retourne la liste des éléments de la bibliothèque de l'étude.
	 * 
	 * @param pEtude Etude
	 * @return liste des éléments de la bibliothèque de l'étude.
	 * @throws WebbatiException WebbatiException
	 */
	List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws WebbatiException;

	/**
	 * Retourne une étude clonée à partir d'une étude origine en mettant à jour une nouvelle instance d'une étude. L'étude sera affecté sur l'affaire
	 * de l'affaire de l'étude d'origine.
	 * 
	 * @param pEtudeOrigin Etude origine
	 * @param pNewEtudeDest Nouvelle instance de étude
	 * @return étude clonée
	 * @throws WebbatiException WebbatiException
	 */
	IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest) throws WebbatiException;

	/**
	 * Retourne une étude clonée à partir d'une étude origine en mettant à jour une nouvelle instance d'une étude. Cette étude sera affectée à une
	 * affaire.
	 * 
	 * @param pEtudeOrigin Etude origine
	 * @param pNewEtudeDest Nouvelle instance de étude
	 * @param pAffaire Affaire
	 * @return étude clonée
	 * @throws WebbatiException WebbatiException
	 */
	IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest, IAffaire pAffaire) throws WebbatiException;

}