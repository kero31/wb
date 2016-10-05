/***********************************************************************
 * Module: ISousTacheManager.java Author: Kero Purpose: Defines the Interface ISousTacheManager
 ***********************************************************************/

package webbati.api.manager.interfaces;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.metier.interfaces.ISousTache;
import webbati.api.metier.interfaces.ITache;

/**
 * Interface <b>ISousTacheManager</b><br/>
 * 
 * @param <IT> ISousTache
 */
public interface ISousTacheManager<IT extends ISousTache> {

	/**
	 * Retourne la liste des Tâches parente à partir de l'objet bibliothèque. <br/>
	 * Si cet objet est un objet bibliothèque origine c'est-à-dire qu'il ne possède pas de bib origine, alors on recherche toutes les tâches parentes
	 * de tous les objets liés à cet objet (lié par bib origine). <br/>
	 * Si cet objet est un objet bibliothèque liés c'est-à-dire qu'il possède un bib origine, alors on recherche toutes les tâches parentes de cet
	 * objet uniquement.
	 * 
	 * @param pBib Bib
	 * @return liste des Tâches parente
	 * @throws WebbatiException WebbatiException
	 */
	List<ITache> getListTacheParente(IT pBib) throws WebbatiException;

}