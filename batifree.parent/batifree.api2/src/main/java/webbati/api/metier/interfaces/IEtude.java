/***********************************************************************
 * Module: IEtude.java Author: Kero Purpose: Defines the Interface IEtude
 ***********************************************************************/

package webbati.api.metier.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IEtude</b><br/>
 */
public interface IEtude extends IMetier<Integer> {

	/**
	 * Get List Bibliotheque Etude
	 * 
	 * @return List Bibliotheque Etude
	 * @throws WebbatiException WebbatiException
	 */
	List<IBibEltEtude> getListBibliotheque() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	ITva getTvaDefaut() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IAffaire getAffaire() throws WebbatiException;

	/**
	 * Get clone Etude
	 * 
	 * @param pAffaire Affaire Destination
	 * @return Clone Etude
	 * @throws WebbatiException WebbatiException
	 */
	IEtude getClone(IAffaire pAffaire) throws WebbatiException;

}