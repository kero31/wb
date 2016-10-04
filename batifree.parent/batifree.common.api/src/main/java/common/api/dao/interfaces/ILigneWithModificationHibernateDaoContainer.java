/***********************************************************************
 * Module: ILigneWithModificationHibernateDaoContainer.java Author: Kero Purpose: Defines the Interface ILigneWithModificationHibernateDaoContainer
 ***********************************************************************/

package common.api.dao.interfaces;

import java.util.List;

import java.io.Serializable;

import org.hibernate.Criteria;

import common.api.exception.WebbatiException;

/**
 * Interface <b>ILigneWithModificationHibernateDaoContainer</b><br/>
 */
public interface ILigneWithModificationHibernateDaoContainer extends ILigneHibernateDaoContainer {

	/**
	 * Retourne une liste d'ejb en fonction d'un criteria.
	 * 
	 * @param pCriteria criteria
	 * @return liste d'ejb
	 * @throws WebbatiException WebbatiException
	 */
	List<?> getListEJBGenericForLigneDao(Criteria pCriteria) throws WebbatiException;

	/**
	 * Supprime un ejb à partir de son id.
	 * 
	 * @param pId id
	 * @param pClazzEjb classe de l'ejb
	 * @param <TEJB> TEJB
	 * @param <IDD> Serializable
	 * @throws WebbatiException WebbatiException
	 */
	<TEJB, IDD extends Serializable> void deleteGenericForLigneDao(IDD pId, Class<TEJB> pClazzEjb) throws WebbatiException;

	/**
	 * Sauvegarde un ejb.
	 * 
	 * @param pEjb ejb
	 * @throws WebbatiException WebbatiException
	 */
	void saveOrUpdateEjbForLigneDao(Object pEjb) throws WebbatiException;

	/**
	 * Retourne le criteria de la session.
	 * 
	 * @return criteria de la session
	 * @throws WebbatiException WebbatiException
	 */
	Criteria getCriteriaSessionForLigneDao() throws WebbatiException;

	/**
	 * Retourne la session courante.
	 * 
	 * @return session courante
	 * @throws WebbatiException WebbatiException
	 */
	org.hibernate.Session getSessionForLigneDao() throws WebbatiException;

}