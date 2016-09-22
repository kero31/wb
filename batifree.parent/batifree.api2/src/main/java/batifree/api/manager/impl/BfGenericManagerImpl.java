/**
 * 
 */
package batifree.api.manager.impl;

import java.io.Serializable;

import batifree.api.application.impl.ApplicationBf;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.BatifreeException;
import common.api.manager.impl.ManagerImpl;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe <BfManagerImpl> Manager pour BATIFREE.
 * 
 * 
 * @param <IT> Interface IMetier
 * @param <ID> Classe ID
 */
public abstract class BfGenericManagerImpl<IT extends IMetier<ID>, ID extends Serializable> extends ManagerImpl<IT, ID> {

	@Override
	public IApplicationCommun getApplication() throws BatifreeException {
		return ApplicationBf.getApplication();
	}
}