package admin.api.dao.hibernate.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import admin.api.application.impl.ApplicationAdmin;

import common.api.dao.hibernate.util.HibernateUtil;

/**
 * 
 * Classe/Interface <b>AdminHibernateUtil</b><br/>
 *
 */
@Service("ADMIN_HibernateUtil")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdminHibernateUtil extends HibernateUtil {
	/**
	 * 
	 * Constructeur.
	 */
	public AdminHibernateUtil() {
		super(ApplicationAdmin.CODE_PROJECT + "_" + CONFIG_FILE_NAME_DEFAULT);
	}
}