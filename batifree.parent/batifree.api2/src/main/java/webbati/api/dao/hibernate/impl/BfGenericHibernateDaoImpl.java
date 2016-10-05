package webbati.api.dao.hibernate.impl;

import java.io.Serializable;

import common.api.application.interfaces.IApplicationCommun;
import common.api.dao.hibernate.impl.HibernateDaoImpl;
import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import common.api.metier.interfaces.IMetier;
import webbati.api.application.impl.ApplicationWb;

/**
 * Classe <BfGenericHibernateDaoImpl> comprenant toutes les classes génériques DAO pour le projet WEBBATI.
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
	public IApplicationCommun getApplication() throws WebbatiException {
		return ApplicationWb.getApplication();
	}
}
