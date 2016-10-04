/**
 * 
 */
package common.api.application.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import common.api.application.interfaces.IFactory;
import common.api.metier.interfaces.IMetier;

/**
 * Classe <b>FactoryImpl</b>.
 * 
 */
public abstract class FactoryImpl implements IFactory {

	private static final Logger LOGGER = Logger.getLogger(FactoryImpl.class);

	/**
	 * Retourne l'implémentation métier par rapport à l'interface.
	 * 
	 * @param <IT> IMetier
	 * @param pInterface l'interface
	 * @return implémentation métier
	 */
	@Override
	public <IT extends IMetier<?>> IT createNewInstance(IT pInterface) {
		return createNewInstance(pInterface, null);
	}

	/**
	 * Retourne l'implémentation métier par rapport à l'interface.
	 * 
	 * @param <IT> IMetier
	 * @param pInterfaceClass la classe interface
	 * @return implémentation métier
	 */
	@Override
	public <IT extends IMetier<?>> IT createNewInstance(Class<IT> pInterfaceClass) {
		return createNewInstance(null, pInterfaceClass);
	}

	/**
	 * Retourne l'implémentation métier par rapport à l'interface.
	 * 
	 * @param <IT> IMetier
	 * @param pInterface l'interface
	 * @param pInterfaceClass la classe interface
	 * @return implémentation métier
	 */
	@SuppressWarnings("unchecked")
	protected <IT extends IMetier<?>> IT createNewInstance(IT pInterface, Class<IT> pInterfaceClass) {
		if (pInterface == null && pInterfaceClass == null) {
			return null;
		}

		Class<?> clazz = getClassImplementation(pInterface, pInterfaceClass);
		Object obj = null;
		if (clazz != null) {
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LOGGER.error("createNewInstance", e);
			}
		}
		return (IT) obj;
	}

	@Override
	public <IT extends IMetier<?>> Class<?> getClassImplementation(Class<IT> pInterfaceClass) {
		return getClassImplementation(null, pInterfaceClass);
	}

	@Override
	public <IT> List<IT> createNewListInstance(Class<IT> pInterfaceClass) {
		return new ArrayList<>();
	}
}
