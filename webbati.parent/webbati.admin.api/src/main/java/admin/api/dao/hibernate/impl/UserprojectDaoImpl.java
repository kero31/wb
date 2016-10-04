package admin.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IUserprojectDao;
import admin.api.metier.ejb.Userproject;
import admin.api.metier.id.UserprojectId;
import admin.api.metier.impl.UserprojectImpl;
import admin.api.metier.interfaces.IUserproject;

/**
 * 
 * Classe/Interface <b>UserprojectDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_UserprojectDao")
public class UserprojectDaoImpl extends AdminGenericHibernateDaoImpl<Userproject, UserprojectImpl, IUserproject, UserprojectId> implements
IUserprojectDao {

	/**
	 * 
	 * Constructeur.
	 */
	public UserprojectDaoImpl() {
		super(Userproject.class, UserprojectImpl.class);
	}
}