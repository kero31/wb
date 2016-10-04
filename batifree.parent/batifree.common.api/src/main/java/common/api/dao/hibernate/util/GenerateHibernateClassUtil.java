/**
 * 
 */
package common.api.dao.hibernate.util;

import java.io.File;

import common.api.util.generate.GenerateClassUtil;
import common.api.util.generate.StringBufferI;

/**
 * Classe <GenerateHibernateClassUtil>.
 * 
 * @author Kero
 * 
 */
public class GenerateHibernateClassUtil extends GenerateClassUtil {

	protected final static String PACKAGE_HIBERNATE = "hibernate";

	protected final static String CLASS_HIBERNATE = "Hibernate";
	protected final static String CLASS_COMMON_DAO_IMPL = CLASS_DAO_SUFFIXE + IMPLEMENTATION_SUFFIXE;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pProjectName nom du projet utilisé pour les noms de packages. Exemple : webbati, admin
	 * @param pProjectCode code du projet utilisé pour les noms de services. Exemple : BF, ADMIN
	 * @param pProjectType type du projetutilisé pour les noms de packages. Exemple : api, common, web
	 * @param pProjectClassPrefix prefixe de la classe du projet utilisé pour les noms de classes. Exemple : Bf, Admin
	 */
	public GenerateHibernateClassUtil(String pProjectName, String pProjectCode, String pProjectType, String pProjectClassPrefix) {
		super(pProjectName, pProjectCode, pProjectType, pProjectClassPrefix);
	}

	@Override
	protected String getPathDaoImpl() {
		return getPathDao() + PACKAGE_HIBERNATE + File.separator + PACKAGE_IMPL + File.separator;
	}

	@Override
	protected String getPackageDaoImpl() {
		return getPackageDao() + "." + PACKAGE_HIBERNATE + "." + PACKAGE_IMPL;
	}

	@Override
	protected String getPackageDaoImpl(String pProject, String pProjectType) {
		return getPackageDao(pProject, pProjectType) + "." + PACKAGE_HIBERNATE + "." + PACKAGE_IMPL;
	}

	@Override
	protected String getClassNameCommonDaoImpl() {
		return CLASS_HIBERNATE + CLASS_COMMON_DAO_IMPL;
	}

	@Override
	protected String getClassNameDaoImpl(String pClassName) {
		return pClassName + CLASS_COMMON_DAO_IMPL;
	}

	/**
	 * Return Class Metier EJB à partir du nom de la classe
	 * 
	 * @param pClassName nom de la classe
	 * @return Class Metier EJB
	 */
	protected String getClassMetierEJB(String pClassName) {
		return getPackageMetierEjb() + "." + pClassName;
	}

	@Override
	protected String getFileTextClassDaoImplGeneric(String pClassName) {
		StringBufferI buffTxt = new StringBufferI();

		// Entête
		buffTxt.add("package " + getPackageDaoImpl() + ";", 2);
		buffTxt.add("import java.io.Serializable;", 2);
		buffTxt.add("import " + getInterfaceCommonApplication() + ";", 1);
		buffTxt.add("import " + getClassCommonDaoImpl() + ";", 1);
		buffTxt.add("import " + getClassCommonWebbatiException() + ";", 1);
		buffTxt.add("import " + getClassCommonMetierImpl() + ";", 1);
		buffTxt.add("import " + getInterfaceCommonMetier() + ";", 2);
		buffTxt.add("import " + getClassApplicationImpl() + ";", 2);

		// Classe
		buffTxt.add("/**", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * Classe <" + pClassName + "> Dao pour Hibernate pour <" + projectName.toUpperCase() + ">.", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * @param <T> Class hibernate EJB", 1);
		buffTxt.add(" * @param <TI> Class " + CLASS_COMMON_METIER_IMPL, 1);
		buffTxt.add(" * @param <ITI> Interface " + INTERFACE_COMMON_METIER, 1);
		buffTxt.add(" * @param <ID> Classe ID", 1);
		buffTxt.add(" */", 1);
		buffTxt.add("public abstract class " + pClassName + "<T, TI extends " + CLASS_COMMON_METIER_IMPL + "<ID>, ITI extends "
		        + INTERFACE_COMMON_METIER + "<ID>, ID extends Serializable> extends " + getClassNameCommonDaoImpl() + "<T, TI, ITI, ID> {", 2);

		// Constructeur
		buffTxt.addInClass("/**", 1);
		buffTxt.addInClass(" * Constructeur.", 1);
		buffTxt.addInClass(" * ", 1);
		buffTxt.addInClass(" * @param pClazz Classe hibernate de l'ejb", 1);
		buffTxt.addInClass(" * @param pClazzI Classe ihm de l'ejb", 1);
		buffTxt.addInClass(" */", 1);
		buffTxt.addInClass("public " + pClassName + "(Class<T> pClazz, Class<TI> pClazzI) {", 1);
		buffTxt.addInMethod("super(pClazz, pClazzI);", 1);
		buffTxt.addInClass("}", 1);

		// Opérations
		buffTxt.addInClass("@Override", 1);
		buffTxt.addInClass("public " + INTERFACE_COMMON_APPLICATION + " getApplication() throws " + CLASS_COMMON_EXCEPTION_WEBBATI + " {", 1);
		buffTxt.addInMethod("return " + getClassNameApplicationImpl() + ".getApplication();", 1);
		buffTxt.addInClass("}", 1);

		// Fin
		buffTxt.add("}");

		return buffTxt.toString();
	}

	@Override
	protected String getFileTextClassDaoImpl(String pClassName, boolean pIsClassAbstract) {
		StringBufferI buffTxt = new StringBufferI();

		// Entête
		buffTxt.add("package " + getPackageDaoImpl() + ";", 2);
		if (!pIsClassAbstract) {
			buffTxt.add("import org.springframework.stereotype.Repository;", 1);
			buffTxt.add("import " + getInterfaceCommonDao() + ";", 1);
			buffTxt.add("import " + getClassMetierImpl(pClassName) + ";", 1);
			buffTxt.add("import " + getClassMetierEJB(pClassName) + ";", 1);
		} else {
			buffTxt.add("import " + getClassCommonMetierImpl() + ";", 1);
		}
		buffTxt.add("import " + getInterfaceDao(pClassName) + ";", 1);
		buffTxt.add("import " + getInterfaceMetier(pClassName) + ";", 2);

		// Classe
		buffTxt.add("/**", 1);
		buffTxt.add(" * Classe <b>" + getClassNameDaoImpl(pClassName) + "</b>.", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" */", 1);
		if (pIsClassAbstract) {
			buffTxt.add("public abstract class " + getClassNameDaoImpl(pClassName) + "<T, TI extends " + CLASS_COMMON_METIER_IMPL
			        + "<Integer>, IT extends " + getInterfaceNameMetier(pClassName) + "> extends " + getClassNameCommonManagerImplGeneric()
			        + "<T, TI, IT, Integer> implements " + getInterfaceNameDao(pClassName) + "<IT> {", 2);

		} else {
			buffTxt.add("@Repository(\"" + getServiceDao(pClassName) + "\")", 1);
			buffTxt.add("public class " + getClassNameDaoImpl(pClassName) + " extends " + getClassNameCommonDaoImplGeneric() + "<" + pClassName
			        + ", " + getClassNameMetierImpl(pClassName) + ", " + getInterfaceNameMetier(pClassName) + ", Integer> implements "
			        + getInterfaceNameDao(pClassName) + " {", 2);

			// Constructeur
			buffTxt.addInClass("/**", 1);
			buffTxt.addInClass(" * Constructeur.", 1);
			buffTxt.addInClass(" * ", 1);
			buffTxt.addInClass(" */", 1);
			buffTxt.addInClass("public " + getClassNameDaoImpl(pClassName) + "() {", 1);
			buffTxt.addInMethod("super (" + pClassName + ".class, " + getClassNameMetierImpl(pClassName) + ".class);", 1);
			buffTxt.addInClass("}", 1);
		}

		// Fin
		buffTxt.add("}");

		return buffTxt.toString();
	}

}
