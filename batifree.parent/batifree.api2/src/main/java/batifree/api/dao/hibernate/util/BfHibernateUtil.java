package batifree.api.dao.hibernate.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import batifree.api.application.impl.ApplicationBf;

import common.api.dao.hibernate.util.HibernateUtil;

/**
 * 
 * Classe/Interface <b>BfHibernateUtil</b><br/>
 *
 */
@Service("BF_HibernateUtil")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class BfHibernateUtil extends HibernateUtil {

	/**
	 * 
	 * Constructeur.
	 */
	public BfHibernateUtil() {
		super(ApplicationBf.CODE_PROJECT + "_" + CONFIG_FILE_NAME_DEFAULT);
	}
}