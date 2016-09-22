package admin.api.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IRoleDao;
import admin.api.metier.ejb.Role;
import admin.api.metier.impl.RoleImpl;
import admin.api.metier.impl.UserAppliImpl;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>RoleDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_RoleDao")
public class RoleDaoImpl extends AdminGenericHibernateDaoImpl<Role, RoleImpl, IRole, Integer> implements IRoleDao {

	/**
	 * 
	 * Constructeur.
	 */
	public RoleDaoImpl() {
		super(Role.class, RoleImpl.class);
	}

	@Override
	public List<IUserAppli> getListUser(IRole pRole) throws BatifreeException {
		Role role = getEjbFromMetier(pRole);
		if (role != null) {
			return getListMetierFromListEjb(pRole.getListUserAppli(), UserAppliImpl.class, IUserAppli.class);
		}
		return null;
	}
}