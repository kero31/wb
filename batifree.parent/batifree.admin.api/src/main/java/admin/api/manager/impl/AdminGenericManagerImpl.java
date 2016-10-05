/**
 * 
 */
package admin.api.manager.impl;

import java.io.Serializable;

import admin.api.application.impl.ApplicationAdmin;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.WebbatiException;
import common.api.manager.impl.ManagerImpl;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe <AdminManagerImpl> Manager pour ADMIN.
 * 
 * @author Kero
 * 
 * @param <IT>
 * @param <ID>
 */
public abstract class AdminGenericManagerImpl<IT extends IMetier<ID>, ID extends Serializable> extends ManagerImpl<IT, ID> {

	@Override
	public IApplicationCommun getApplication() throws WebbatiException {
		return ApplicationAdmin.getApplication();
	}
}