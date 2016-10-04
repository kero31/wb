package admin.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import admin.api.dao.interfaces.IConnectiondbDao;
import admin.api.metier.ejb.Connectiondb;
import admin.api.metier.impl.ConnectiondbImpl;
import admin.api.metier.interfaces.IConnectiondb;

/**
 * 
 * Classe/Interface <b>ConnectiondbDaoImpl</b><br/>
 *
 */
@Repository("ADMIN_ConnectiondbDao")
public class ConnectiondbDaoImpl extends AdminGenericHibernateDaoImpl<Connectiondb, ConnectiondbImpl, IConnectiondb, java.lang.Integer> implements
IConnectiondbDao {

	/**
	 * 
	 * Constructeur.
	 */
	public ConnectiondbDaoImpl() {
		super(Connectiondb.class, ConnectiondbImpl.class);
	}

}