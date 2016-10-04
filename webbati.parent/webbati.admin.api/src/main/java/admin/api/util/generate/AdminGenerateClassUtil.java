/**
 * 
 */
package admin.api.util.generate;

import common.api.dao.hibernate.util.GenerateHibernateClassUtil;

/**
 * @author Kero
 * 
 */
public class AdminGenerateClassUtil extends GenerateHibernateClassUtil {

	public static final String PROJECT_NAME = "admin";
	public static final String PROJECT_CODE = "ADMIN";
	public static final String PROJECT_CLASS_CODE = "Admin";

	/**
	 * @param project
	 */
	public AdminGenerateClassUtil() {
		super(PROJECT_NAME, PROJECT_CODE, API, PROJECT_CLASS_CODE);
		setForceRebuild(false);
	}

	/**
	 * Main
	 * 
	 * @param pArgs args
	 */
	public static void main(String[] pArgs) {
		new AdminGenerateClassUtil().createClassImplementation();
	}

}
