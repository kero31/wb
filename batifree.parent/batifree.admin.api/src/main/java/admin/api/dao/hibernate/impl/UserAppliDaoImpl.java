package admin.api.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IUserAppliDao;
import admin.api.metier.ejb.Role;
import admin.api.metier.ejb.Userappli;
import admin.api.metier.impl.RoleImpl;
import admin.api.metier.impl.UserAppliImpl;
import admin.api.metier.impl.UserprojectImpl;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>UserAppliDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_UserAppliDao")
public class UserAppliDaoImpl extends AdminGenericHibernateDaoImpl<Userappli, UserAppliImpl, IUserAppli, Integer> implements IUserAppliDao {

	/**
	 * 
	 * Constructeur.
	 */
	public UserAppliDaoImpl() {
		super(Userappli.class, UserAppliImpl.class);
	}

	@Override
	public List<IUserproject> getListUserproject(IUserAppli pUserAppli) throws BatifreeException {
		Userappli user = getEjbFromMetier(pUserAppli);
		if (user != null) {
			return getListMetierFromListEjb(user.getUserprojects(), UserprojectImpl.class, IUserproject.class);
		}
		return null;
	}

	@Override
	public List<IRole> getListRole(IUserAppli pUserAppli) throws BatifreeException {
		Userappli user = getEjbFromMetier(pUserAppli);
		if (user != null) {
			return getListMetierFromListEjb(user.getRoles(), RoleImpl.class, IRole.class);
		}
		return null;
	}

	@Override
	protected Userappli getEjbUpdatedFromMetier(IUserAppli pMetier) throws BatifreeException {
		Userappli ejb = super.getEjbUpdatedFromMetier(pMetier);

		Set<Role> listRoleEjb = ejb.getRoles();
		Map<Serializable, Role> mapEJB = new HashMap<>();
		if (listRoleEjb != null) {
			for (Role role : listRoleEjb) {
				mapEJB.put(role.getId(), role);
			}
		}
		updateEjbListFromMetier(pMetier.getListRole(), mapEJB, listRoleEjb, Role.class);

		return ejb;
	}
}