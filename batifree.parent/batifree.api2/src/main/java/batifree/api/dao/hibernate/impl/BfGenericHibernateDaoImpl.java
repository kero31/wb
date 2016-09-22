package batifree.api.dao.hibernate.impl;

import java.io.Serializable;

import batifree.api.application.impl.ApplicationBf;

import common.api.application.interfaces.IApplicationCommun;
import common.api.dao.hibernate.impl.HibernateDaoImpl;
import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;
import common.api.metier.interfaces.IMetier;

/**
 * Classe <BfGenericHibernateDaoImpl> comprenant toutes les classes génériques DAO pour le projet BATIFREE.
 * 
 * @param <T> Classe EJB
 * @param <TI> Classe métier implémentation
 * @param <ITI> Interface métier implémentation
 * @param <ID> Classe ID
 */
public abstract class BfGenericHibernateDaoImpl<T, TI extends MetierImpl<ID>, ITI extends IMetier<ID>, ID extends Serializable> extends
        HibernateDaoImpl<T, TI, ITI, ID> {

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public BfGenericHibernateDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	public IApplicationCommun getApplication() throws BatifreeException {
		return ApplicationBf.getApplication();
	}
}
