/***********************************************************************
 * Module: IBibliothequeDao.java Author: Kero Purpose: Defines the Interface IBibliothequeDao
 ***********************************************************************/

package batifree.api.dao.interfaces;

import java.util.List;

import batifree.api.metier.ejb.Bibliotheque;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.ITache;

import common.api.dao.interfaces.ILigneDao;
import common.api.exception.BatifreeException;

/**
 * Interface <b>IBibliothequeDao</b><br/>
 * 
 * @param <IT> IBibliotheque
 */
public interface IBibliothequeDao<IT extends IBibliotheque> extends ILigneDao<IT, Integer, IBibliotheque> {

	/**
	 * Retourne la liste des Tâches parente à partir de l'objet bibliothèque.
	 * 
	 * @param pBib Bib
	 * @return liste des Tâches parente à partir de l'objet bibliothèque
	 * @throws BatifreeException BatifreeException
	 */
	List<ITache> getListTacheParente(IT pBib) throws BatifreeException;

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour <br/>
	 * <b>Cette méthode renvoie la famille du 1er niveau</b>
	 * 
	 * @param pObject Objet à créer ou à mettre à jour
	 * @param <BIB> IBibliotheque
	 * @param <ILIGNEEJB> Bibliotheque
	 * @return objet créée ou modifiée
	 * @throws BatifreeException BatifreeException
	 */
	<BIB extends IBibliotheque, ILIGNEEJB extends Bibliotheque> BIB saveLigne(IT pObject) throws BatifreeException;

}