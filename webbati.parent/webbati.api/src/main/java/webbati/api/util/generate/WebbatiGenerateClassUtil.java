/**
 * 
 */
package webbati.api.util.generate;

import java.util.ArrayList;
import java.util.List;

import common.api.dao.hibernate.util.GenerateHibernateClassUtil;
import webbati.api.metier.impl.IdLibelleImpl;

/**
 * @author Kero
 * 
 */
public class WebbatiGenerateClassUtil extends GenerateHibernateClassUtil {

	public static final String PROJECT_NAME = "webbati";
	public static final String PROJECT_CODE = "WB";
	public static final String PROJECT_CLASS_CODE = "Wb";

	/**
	 * @param project
	 */
	public WebbatiGenerateClassUtil() {
		super(PROJECT_NAME, PROJECT_CODE, API, PROJECT_CLASS_CODE);
		setForceRebuild(false);
	}

	/**
	 * Main.
	 * 
	 * @param pArgs arguments
	 */
	public static void main(String[] pArgs) {
		new WebbatiGenerateClassUtil().createClassImplementation();
	}

	@Override
	protected List<Class<?>> getListMetierImplToIgnore() {
		List<Class<?>> list = new ArrayList<>();
		list.add(IdLibelleImpl.class);
		return list;
	}

}
