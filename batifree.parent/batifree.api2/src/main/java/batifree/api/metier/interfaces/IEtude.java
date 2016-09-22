/***********************************************************************
 * Module: IEtude.java Author: Kero Purpose: Defines the Interface IEtude
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IEtude</b><br/>
 */
public interface IEtude extends IMetier<Integer> {

	/**
	 * Get List Bibliotheque Etude
	 * 
	 * @return List Bibliotheque Etude
	 * @throws BatifreeException BatifreeException
	 */
	List<IBibEltEtude> getListBibliotheque() throws BatifreeException;

	/**
	 * Set List Bibliotheque Etude
	 * 
	 * @param pListBibEtude List Bib Etude
	 */
	void setListBibliotheque(List<IBibEltEtude> pListBibEtude);

	/**
	 * Retourne TRUE si la liste bibliothèque a été changé, FALSE sinon
	 * 
	 * @return TRUE si la liste bibliothèque a été changé, FALSE sinon
	 */
	Boolean isListBibliothequeChanged();

	/**
	 * Get Tva Defaut
	 * 
	 * @return Tva Defaut
	 * @throws BatifreeException BatifreeException
	 */
	ITva getTvaDefaut() throws BatifreeException;

	/**
	 * Set Tva Defaut
	 * 
	 * @param pTvaDefaut Tva Defaut
	 */
	void setTvaDefaut(ITva pTvaDefaut);

	/**
	 * Set Affaire
	 * 
	 * @param pAffaire Affaire
	 */
	void setAffaire(IAffaire pAffaire);

	/**
	 * Get Affaire
	 * 
	 * @return Affaire
	 * @throws BatifreeException BatifreeException
	 */
	IAffaire getAffaire() throws BatifreeException;

	/**
	 * Get clone Etude
	 * 
	 * @param pAffaire Affaire Destination
	 * @return Clone Etude
	 * @throws BatifreeException BatifreeException
	 */
	IEtude getClone(IAffaire pAffaire) throws BatifreeException;

}