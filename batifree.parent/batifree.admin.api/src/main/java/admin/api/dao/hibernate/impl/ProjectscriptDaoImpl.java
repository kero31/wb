package admin.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IProjectscriptDao;
import admin.api.metier.ejb.Projectscript;
import admin.api.metier.impl.ProjectscriptImpl;
import admin.api.metier.interfaces.IProjectscript;

/**
 * 
 * Classe/Interface <b>ProjectscriptDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_ProjectscriptDao")
public class ProjectscriptDaoImpl extends AdminGenericHibernateDaoImpl<Projectscript, ProjectscriptImpl, IProjectscript, Integer> implements
IProjectscriptDao {

	/**
	 * 
	 * Constructeur.
	 */
	public ProjectscriptDaoImpl() {
		super(Projectscript.class, ProjectscriptImpl.class);
	}

}