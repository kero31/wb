package admin.api.dao.hibernate.impl;

import java.io.Serializable;

import admin.api.application.impl.ApplicationAdmin;

import common.api.application.interfaces.IApplicationCommun;
import common.api.dao.hibernate.impl.HibernateDaoImpl;
import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe/Interface <b>AdminGenericHibernateDaoImpl</b><br/>
 * Classe comprenant toutes les classes génériques DAO pour le projet BATIFREE
 * 
 * @param <T> ejb
 * @param <TI> MetierImpl
 * @param <ITI> IMetier
 * @param <ID> Serializable
 */
public abstract class AdminGenericHibernateDaoImpl<T, TI extends MetierImpl<ID>, ITI extends IMetier<ID>, ID extends Serializable> extends
HibernateDaoImpl<T, TI, ITI, ID> {

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public AdminGenericHibernateDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	public IApplicationCommun getApplication() throws BatifreeException {
		return ApplicationAdmin.getApplication();
	}
}
