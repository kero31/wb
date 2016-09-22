/***********************************************************************
 * Module: ILigneWithModificationHibernateDaoContainer.java Author: Kero Purpose: Defines the Interface ILigneWithModificationHibernateDaoContainer
 ***********************************************************************/

package common.api.dao.interfaces;

import java.util.List;

import java.io.Serializable;

import org.hibernate.Criteria;

import common.api.exception.BatifreeException;

/**
 * Interface <b>ILigneWithModificationHibernateDaoContainer</b><br/>
 */
public interface ILigneWithModificationHibernateDaoContainer extends ILigneHibernateDaoContainer {

	/**
	 * Retourne une liste d'ejb en fonction d'un criteria.
	 * 
	 * @param pCriteria criteria
	 * @return liste d'ejb
	 * @throws BatifreeException BatifreeException
	 */
	List<?> getListEJBGenericForLigneDao(Criteria pCriteria) throws BatifreeException;

	/**
	 * Supprime un ejb à partir de son id.
	 * 
	 * @param pId id
	 * @param pClazzEjb classe de l'ejb
	 * @param <TEJB> TEJB
	 * @param <IDD> Serializable
	 * @throws BatifreeException BatifreeException
	 */
	<TEJB, IDD extends Serializable> void deleteGenericForLigneDao(IDD pId, Class<TEJB> pClazzEjb) throws BatifreeException;

	/**
	 * Sauvegarde un ejb.
	 * 
	 * @param pEjb ejb
	 * @throws BatifreeException BatifreeException
	 */
	void saveOrUpdateEjbForLigneDao(Object pEjb) throws BatifreeException;

	/**
	 * Retourne le criteria de la session.
	 * 
	 * @return criteria de la session
	 * @throws BatifreeException BatifreeException
	 */
	Criteria getCriteriaSessionForLigneDao() throws BatifreeException;

	/**
	 * Retourne la session courante.
	 * 
	 * @return session courante
	 * @throws BatifreeException BatifreeException
	 */
	org.hibernate.Session getSessionForLigneDao() throws BatifreeException;

}