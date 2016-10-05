/***********************************************************************
 * Module: IBibliothequeDao.java Author: Kero Purpose: Defines the Interface IBibliothequeDao
 ***********************************************************************/

package webbati.api.dao.interfaces;

import java.util.List;

import common.api.dao.interfaces.ILigneDao;
import common.api.exception.WebbatiException;
import webbati.api.metier.ejb.Bibliotheque;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.ITache;

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
	 * @throws WebbatiException WebbatiException
	 */
	List<ITache> getListTacheParente(IT pBib) throws WebbatiException;

	/**
	 * Crée ou met à jour l'objet pObject. Si son ID vaut NULL ou 0, alors c'est une création, sinon c'est une mise à jour <br/>
	 * <b>Cette méthode renvoie la famille du 1er niveau</b>
	 * 
	 * @param pObject Objet à créer ou à mettre à jour
	 * @param <BIB> IBibliotheque
	 * @param <ILIGNEEJB> Bibliotheque
	 * @return objet créée ou modifiée
	 * @throws WebbatiException WebbatiException
	 */
	<BIB extends IBibliotheque, ILIGNEEJB extends Bibliotheque> BIB saveLigne(IT pObject) throws WebbatiException;

}