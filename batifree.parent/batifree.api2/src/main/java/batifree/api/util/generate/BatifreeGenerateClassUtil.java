/**
 * 
 */
package batifree.api.util.generate;

import java.util.ArrayList;
import java.util.List;

import batifree.api.metier.impl.IdLibelleImpl;

import common.api.dao.hibernate.util.GenerateHibernateClassUtil;

/**
 * @author Kero
 * 
 */
public class BatifreeGenerateClassUtil extends GenerateHibernateClassUtil {

	public static final String PROJECT_NAME = "batifree";
	public static final String PROJECT_CODE = "BF";
	public static final String PROJECT_CLASS_CODE = "Bf";

	/**
	 * @param project
	 */
	public BatifreeGenerateClassUtil() {
		super(PROJECT_NAME, PROJECT_CODE, API, PROJECT_CLASS_CODE);
		setForceRebuild(false);
	}

	/**
	 * Main.
	 * 
	 * @param pArgs arguments
	 */
	public static void main(String[] pArgs) {
		new BatifreeGenerateClassUtil().createClassImplementation();
	}

	@Override
	protected List<Class<?>> getListMetierImplToIgnore() {
		List<Class<?>> list = new ArrayList<>();
		list.add(IdLibelleImpl.class);
		return list;
	}

}
