package webbati.api.dao.hibernate.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import common.api.dao.hibernate.util.HibernateUtil;
import webbati.api.application.impl.ApplicationWb;

/**
 * 
 * Classe/Interface <b>BfHibernateUtil</b><br/>
 *
 */
@Service(ApplicationWb.CODE_PROJECT + "_HibernateUtil")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class BfHibernateUtil extends HibernateUtil {

	/**
	 * 
	 * Constructeur.
	 */
	public BfHibernateUtil() {
		super(ApplicationWb.CODE_PROJECT + "_" + CONFIG_FILE_NAME_DEFAULT);
	}
}