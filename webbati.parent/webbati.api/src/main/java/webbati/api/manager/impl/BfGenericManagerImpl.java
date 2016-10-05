/**
 * 
 */
package webbati.api.manager.impl;

import java.io.Serializable;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.WebbatiException;
import common.api.manager.impl.ManagerImpl;
import common.api.metier.interfaces.IMetier;
import webbati.api.application.impl.ApplicationWb;

/**
 * 
 * Classe <BfManagerImpl> Manager pour WEBBATI.
 * 
 * 
 * @param <IT> Interface IMetier
 * @param <ID> Classe ID
 */
public abstract class BfGenericManagerImpl<IT extends IMetier<ID>, ID extends Serializable> extends ManagerImpl<IT, ID> {

	@Override
	public IApplicationCommun getApplication() throws WebbatiException {
		return ApplicationWb.getApplication();
	}
}