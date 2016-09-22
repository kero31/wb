package common.api.util.generate;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.net.URL;

import org.apache.log4j.Logger;

/**
 * 
 * Classe/Interface <GenerateClassUtil>
 *
 */
public abstract class GenerateClassUtil {

	protected final static String INTERFACE_PREFIXE = "I";
	protected final static String CLASS_GI_SUFFIXE = "GI";
	protected final static String CLASS_G_SUFFIXE = "G";
	protected final static String CLASS_DAO_SUFFIXE = "Dao";
	protected final static String CLASS_APP_SUFFIXE = "App";

	protected final static String API = "api";

	protected final static String VUE_PREFIXE = "V";

	protected final static String EXTENSION_JAVA = ".java";

	protected final static String IMPLEMENTATION_SUFFIXE = "Impl";

	protected final static String PACKAGE_IMPL = "impl";
	protected final static String PACKAGE_INTERFACES = "interfaces";

	protected final static String PACKAGE_APPLICATION = "application";
	protected final static String PACKAGE_DAO = "dao";
	protected final static String PACKAGE_MANAGER = "manager";
	protected final static String PACKAGE_METIER = "metier";
	protected final static String PACKAGE_EJB = "ejb";

	protected final static String CLASS_GENERIC = "Generic";

	protected final static String CLASS_APPLICATION_IMPL = "Application";

	protected final static String INTERFACE_COMMON_APPLICATION = INTERFACE_PREFIXE + "ApplicationCommun";
	protected final static String INTERFACE_COMMON_METIER = INTERFACE_PREFIXE + "Metier";
	protected final static String INTERFACE_COMMON_DAO = INTERFACE_PREFIXE + "Dao";
	protected final static String INTERFACE_APPLICATION = INTERFACE_PREFIXE + CLASS_APPLICATION_IMPL;

	protected final static String CLASS_COMMON_EXCEPTION_BATIFREE = "BatifreeException";
	protected final static String CLASS_COMMON_MANAGER = "Manager";
	protected final static String CLASS_COMMON_MANAGER_IMPL = CLASS_COMMON_MANAGER + IMPLEMENTATION_SUFFIXE;
	protected final static String CLASS_COMMON_DAO = "Dao";
	protected final static String CLASS_COMMON_DAO_IMPL = CLASS_COMMON_DAO + IMPLEMENTATION_SUFFIXE;
	protected final static String CLASS_COMMON_APPLICATION_IMPL = CLASS_APPLICATION_IMPL + "Commun";
	protected final static String CLASS_COMMON_METIER = "Metier";
	protected final static String CLASS_COMMON_METIER_IMPL = CLASS_COMMON_METIER + IMPLEMENTATION_SUFFIXE;

	protected final static String PROJECT_COMMUN = "common";

	private static final Logger LOGGER = Logger.getLogger(GenerateClassUtil.class);

	/** nom du projet utilisé pour les noms de packages. Exemple : batifree, admin. */
	protected final String projectName;
	/** type du projetutilisé pour les noms de packages. Exemple : api, common, web. */
	protected final String projectType;
	/** code du projet utilisé pour les noms de services. Exemple : BF, ADMIN. */
	protected final String projectCode;

	/** prefixe de la classe du projet utilisé pour les noms de classes. Exemple : Bf, Admin. */
	protected final String projectClassPrefix;

	/** Force la reconstruction. */
	protected boolean bForceRebuild = false;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pProjectName nom du projet utilisé pour les noms de packages. Exemple : batifree, admin
	 * @param pProjectCode code du projet utilisé pour les noms de services. Exemple : BF, ADMIN
	 * @param pProjectType type du projetutilisé pour les noms de packages. Exemple : api, common, web
	 * @param pProjectClassPrefix prefixe de la classe du projet utilisé pour les noms de classes. Exemple : Bf, Admin
	 */
	public GenerateClassUtil(String pProjectName, String pProjectCode, String pProjectType, String pProjectClassPrefix) {
		super();
		projectType = pProjectType;
		projectName = pProjectName;
		projectCode = pProjectCode;
		projectClassPrefix = pProjectClassPrefix;
		bForceRebuild = false;
	}

	/**
	 * Retourne le code projet pour le service
	 * 
	 * @return code projet pour le service
	 */
	protected String getProjectCodeService() {
		return projectCode + "_";
	}

	/**
	 * @return the bForceRebuild
	 */
	protected boolean isForceRebuild() {
		return bForceRebuild;
	}

	/**
	 * @param pForceRebuild the bForceRebuild to set
	 */
	public void setForceRebuild(boolean pForceRebuild) {
		this.bForceRebuild = pForceRebuild;
	}

	/**
	 * Retourne le real path en fonction du package.
	 * 
	 * @param pPackageName packageName
	 * @return real path
	 */
	protected String getPackageRealPath(String pPackageName) {
		// ciblage du package voulu
		String targetPackage = pPackageName;
		String targetPackagePath = targetPackage.replace('.', '/');
		String targetPath = "/" + targetPackagePath;

		// récupération du chemin 'réel' du package
		URL resourceURL = Class.class.getResource(targetPath);
		if (resourceURL == null) {
			return "";
		}

		return resourceURL.getFile();
	}

	/**
	 * Retourne le file en fonction du packageName.
	 * 
	 * @param pPackageName packageName
	 * @return file
	 */
	protected File getPackageFile(String pPackageName) {
		return new File(getPackageRealPath(pPackageName));
	}

	/**
	 * Retourne la liste des classes en fonction du packageName.
	 * 
	 * @param pPackageName packageName
	 * @return liste des classes
	 */
	protected List<Class<?>> getListClassFromPackage(String pPackageName) {
		File packageFile = getPackageFile(pPackageName);

		// Parcours les classes du package
		List<Class<?>> listeClasses = new ArrayList<Class<?>>();
		List<Class<?>> listClassesMetierImplToIgnore = getListMetierImplToIgnore();
		for (File classFile : packageFile.listFiles()) {
			String fileName = classFile.getName();
			// ne traite que les fichiers '.class'
			if (fileName.endsWith(".class")) {
				// enlève le '.class'
				String className = fileName.substring(0, fileName.lastIndexOf("."));
				String fullClassName = pPackageName + "." + className;

				try {
					// Classe du package
					Class<?> classEJB = Class.forName(fullClassName);
					if (!listClassesMetierImplToIgnore.contains(classEJB)) {
						listeClasses.add(classEJB);
					}
				} catch (ClassNotFoundException e) {
					LOGGER.error(e);
				}
			}
		}

		return listeClasses;
	}

	/* Paths */
	/**
	 * Return path
	 * 
	 * @return path
	 */
	protected String getPath() {
		return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator
				+ projectName + File.separator + projectType + File.separator;
	}

	/**
	 * Return path Metier
	 * 
	 * @return path Metier
	 */
	protected String getPathMetier() {
		return getPath() + PACKAGE_METIER + File.separator;
	}

	/**
	 * Return path Ejb
	 * 
	 * @return path Ejb
	 */
	protected String getPathMetierEjb() {
		return getPathMetier() + PACKAGE_EJB + File.separator;
	}

	/**
	 * Return path Metier Interfaces
	 * 
	 * @return path Metier Interfaces
	 */
	protected String getPathMetierInterfaces() {
		return getPathMetier() + PACKAGE_INTERFACES + File.separator;
	}

	/**
	 * Return path Metier Impl
	 * 
	 * @return path Metier Impl
	 */
	protected String getPathMetierImpl() {
		return getPathMetier() + PACKAGE_IMPL + File.separator;
	}

	/**
	 * Return path Manager
	 * 
	 * @return path Manager
	 */
	protected String getPathManager() {
		return getPath() + PACKAGE_MANAGER + File.separator;
	}

	/**
	 * Return path Manager Interfaces
	 * 
	 * @return path Manager Interfaces
	 */
	protected String getPathManagerInterfaces() {
		return getPathManager() + PACKAGE_INTERFACES + File.separator;
	}

	/**
	 * Return path Manager Impl
	 * 
	 * @return path Manager Impl
	 */
	protected String getPathManagerImpl() {
		return getPathManager() + PACKAGE_IMPL + File.separator;
	}

	/**
	 * Return path Dao
	 * 
	 * @return path Dao
	 */
	protected String getPathDao() {
		return getPath() + PACKAGE_DAO + File.separator;
	}

	/**
	 * Return path Dao Interfaces
	 * 
	 * @return path Dao Interfaces
	 */
	protected String getPathDaoInterfaces() {
		return getPathDao() + PACKAGE_INTERFACES + File.separator;
	}

	/**
	 * Return path Dao Impl
	 * 
	 * @return path Dao Impl
	 */
	protected abstract String getPathDaoImpl();

	/**
	 * Return path Application
	 * 
	 * @return path Application
	 */
	protected String getPathApplication() {
		return getPath() + PACKAGE_APPLICATION + File.separator;
	}

	/**
	 * Return path Application Interfaces
	 * 
	 * @return path Application Interfaces
	 */
	protected String getPathApplicationInterfaces() {
		return getPathApplication() + PACKAGE_INTERFACES + File.separator;
	}

	/**
	 * Return path Application Impl
	 * 
	 * @return path Application Impl
	 */
	protected String getPathApplicationImpl() {
		return getPathApplication() + PACKAGE_IMPL + File.separator;
	}

	/* Packages */
	/**
	 * Return path Package
	 * 
	 * @return path Package
	 */
	protected String getPackage() {
		return getPackage(projectName, projectType);
	}

	/**
	 * Return path Package
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package
	 */
	protected String getPackage(String pProject, String pProjectType) {
		return pProject + "." + pProjectType;
	}

	/**
	 * Return path Package Metier
	 * 
	 * @return path Package Metier
	 */
	protected String getPackageMetier() {
		return getPackage() + "." + PACKAGE_METIER;
	}

	/**
	 * Return path Package Metier
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Metier
	 */
	protected String getPackageMetier(String pProject, String pProjectType) {
		return getPackage(pProject, pProjectType) + "." + PACKAGE_METIER;
	}

	/**
	 * Return path Package Application
	 * 
	 * @return path Package Application
	 */
	protected String getPackageApplication() {
		return getPackage() + "." + PACKAGE_APPLICATION;
	}

	/**
	 * Return path Package Application
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Application
	 */
	protected String getPackageApplication(String pProject, String pProjectType) {
		return getPackage(pProject, pProjectType) + "." + PACKAGE_APPLICATION;
	}

	/**
	 * Return path Package Application Interfaces
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Application Interfaces
	 */
	protected String getPackageApplicationInterfaces(String pProject, String pProjectType) {
		return getPackageApplication(pProject, pProjectType) + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Application Interfaces
	 * 
	 * @return path Package Application Interfaces
	 */
	protected String getPackageApplicationInterfaces() {
		return getPackageApplication() + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Application Impl
	 * 
	 * @return path Package Application Impl
	 */
	protected String getPackageApplicationImpl() {
		return getPackageApplication() + "." + PACKAGE_IMPL;
	}

	/**
	 * Return path Package Metier Ejb
	 * 
	 * @return path Package Metier Ejb
	 */
	protected String getPackageMetierEjb() {
		return getPackageMetier() + "." + PACKAGE_EJB;
	}

	/**
	 * Return path Package Metier Impl
	 * 
	 * @return path Package Metier Impl
	 */
	protected String getPackageMetierImpl() {
		return getPackageMetier() + "." + PACKAGE_IMPL;
	}

	/**
	 * Return path Package Metier Impl
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Metier Impl
	 */
	protected String getPackageMetierImpl(String pProject, String pProjectType) {
		return getPackageMetier(pProject, pProjectType) + "." + PACKAGE_IMPL;
	}

	/**
	 * Return path Package Metier Interfaces
	 * 
	 * @return path Package Metier Interfaces
	 */
	protected String getPackageMetierInterfaces() {
		return getPackageMetier() + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Metier Interfaces
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Metier Interfaces
	 */
	protected String getPackageMetierInterfaces(String pProject, String pProjectType) {
		return getPackageMetier(pProject, pProjectType) + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Metier Ejb
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Metier Ejb
	 */
	protected String getPackageMetierEjb(String pProject, String pProjectType) {
		return getPackageMetier(pProject, pProjectType) + "." + PACKAGE_EJB;
	}

	/**
	 * Return path Package Dao
	 * 
	 * @return path Package Dao
	 */
	protected String getPackageDao() {
		return getPackage() + "." + PACKAGE_DAO;
	}

	/**
	 * Return path Package Dao
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Dao
	 */
	protected String getPackageDao(String pProject, String pProjectType) {
		return getPackage(pProject, pProjectType) + "." + PACKAGE_DAO;
	}

	/**
	 * Return path Package Dao Interfaces
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Dao Interfaces
	 */
	protected String getPackageDaoInterfaces(String pProject, String pProjectType) {
		return getPackageDao(pProject, pProjectType) + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Dao Interfaces
	 * 
	 * @return path Package Dao Interfaces
	 */
	protected String getPackageDaoInterfaces() {
		return getPackageDao() + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Dao Impl
	 * 
	 * @return path Package Dao Impl
	 */
	protected abstract String getPackageDaoImpl();

	/**
	 * Return path Package Dao Impl
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Dao Impl
	 */
	protected abstract String getPackageDaoImpl(String pProject, String pProjectType);

	/**
	 * Return path Package Dao Manager
	 * 
	 * @return path Package Dao Manager
	 */
	protected String getPackageManager() {
		return getPackage() + "." + PACKAGE_MANAGER;
	}

	/**
	 * Return path Package Manager
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Manager
	 */
	protected String getPackageManager(String pProject, String pProjectType) {
		return getPackage(pProject, pProjectType) + "." + PACKAGE_MANAGER;
	}

	/**
	 * Return path Package Manager Interfaces
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Manager Interfaces
	 */
	protected String getPackageManagerInterfaces(String pProject, String pProjectType) {
		return getPackageManager(pProject, pProjectType) + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Manager Interfaces
	 * 
	 * @return path Package Manager Interfaces
	 */
	protected String getPackageManagerInterfaces() {
		return getPackageManager() + "." + PACKAGE_INTERFACES;
	}

	/**
	 * Return path Package Manager Impl
	 * 
	 * @return path Package Manager Impl
	 */
	protected String getPackageManagerImpl() {
		return getPackageManager() + "." + PACKAGE_IMPL;
	}

	/**
	 * Return path Package Manager Impl
	 * 
	 * @param pProject project
	 * @param pProjectType type de project
	 * @return path Package Manager Impl
	 */
	protected String getPackageManagerImpl(String pProject, String pProjectType) {
		return getPackageManager(pProject, pProjectType) + "." + PACKAGE_IMPL;
	}

	/**
	 * Retourne TRUE si la classe est une table FALSE sinon
	 * 
	 * @param pClassMetierImpl classe à tester
	 * @return TRUE si la classe est une table FALSE sinon
	 */
	protected boolean isClassTable(Class<?> pClassMetierImpl) {
		return !pClassMetierImpl.getSimpleName().startsWith(VUE_PREFIXE);
	}

	/**
	 * Retourne la liste des classes métier impl à ignorer.
	 * 
	 * @return liste des classes métier impl à ignore
	 */
	protected List<Class<?>> getListMetierImplToIgnore() {
		return new ArrayList<>();
	}

	/**
	 * Crée toutes les classes d'implémentation pour le projet courant.
	 */
	public void createClassImplementation() {
		// Récupère la liste des classes des METIER IMPL
		List<Class<?>> listeClassesMetierImpl = getListClassFromPackage(getPackageMetierImpl());

		try {
			// Crée la classe APPLICATION IMPL propre au projet si elle n'existe pas
			File directory = new File(getPathApplicationImpl());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			File file = new File(getPathApplicationImpl() + getClassNameApplicationImpl() + EXTENSION_JAVA);
			String fileTextApplication = getFileTextClassApplication(listeClassesMetierImpl);
			if (!file.exists() || bForceRebuild) {
				PrintWriter ecriManagerGeneric;
				ecriManagerGeneric = new PrintWriter(new FileWriter(file));
				ecriManagerGeneric.print(fileTextApplication);
				ecriManagerGeneric.flush();
				ecriManagerGeneric.close();
			} else {
				System.out.println("*** Appel de l'app dans la classe Application :\n");
				System.out.println(fileTextApplication);
			}

			// Crée la classe Generic Manager IMPL propre au projet si elle n'existe pas
			String classManagerGeneric = getClassNameCommonManagerImplGeneric();
			directory = new File(getPathManagerImpl());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			file = new File(getPathManagerImpl() + classManagerGeneric + EXTENSION_JAVA);
			if (!file.exists() || bForceRebuild) {
				PrintWriter ecriManagerGeneric;
				ecriManagerGeneric = new PrintWriter(new FileWriter(file));
				ecriManagerGeneric.print(getFileTextClassManagerImplGeneric(classManagerGeneric));
				ecriManagerGeneric.flush();
				ecriManagerGeneric.close();
			}

			// Crée la classe Generic Dao IMPL propre au projet si elle n'existe pas
			String classDaoGeneric = getClassNameCommonDaoImplGeneric();
			directory = new File(getPathDaoImpl());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			file = new File(getPathDaoImpl() + classDaoGeneric + EXTENSION_JAVA);
			if (!file.exists() || bForceRebuild) {
				PrintWriter ecriDaoGeneric;
				ecriDaoGeneric = new PrintWriter(new FileWriter(file));
				ecriDaoGeneric.print(getFileTextClassDaoImplGeneric(classDaoGeneric));
				ecriDaoGeneric.flush();
				ecriDaoGeneric.close();
			}

			// Pour chaque classe, crée les classes Implementation
			for (Class<?> classMetierImpl : listeClassesMetierImpl) {
				if (isClassTable(classMetierImpl)) {
					try {
						// Nom de la classe sans le suffixe de l'implémentation
						String classNameImpl = classMetierImpl.getSimpleName();
						int lastIndex = classNameImpl.lastIndexOf(IMPLEMENTATION_SUFFIXE);
						String className = classNameImpl.substring(0, lastIndex);
						// Abstract ou non
						boolean isClassAbstract = Modifier.isAbstract(classMetierImpl.getModifiers());

						// Crée la classe Manager IMPL si elle n'existe pas
						file = new File(getPathManagerImpl() + getClassNameManagerImpl(className) + EXTENSION_JAVA);
						if (!file.exists() || bForceRebuild) {
							PrintWriter ecriManager;
							ecriManager = new PrintWriter(new FileWriter(file));
							ecriManager.print(getFileTextClassManagerImpl(className, isClassAbstract));
							ecriManager.flush();
							ecriManager.close();
						}

						// Crée la classe Dao IMPL si elle n'existe pas
						file = new File(getPathDaoImpl() + getClassNameDaoImpl(className) + EXTENSION_JAVA);
						if (!file.exists() || bForceRebuild) {
							PrintWriter ecriDao;
							ecriDao = new PrintWriter(new FileWriter(file));
							ecriDao.print(getFileTextClassDaoImpl(className, isClassAbstract));
							ecriDao.flush();
							ecriDao.close();
						}
					} catch (IOException e) {
						LOGGER.error(e);
					}
				}
			}

		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	/**
	 * Return Interface Common Application
	 * 
	 * @return Interface Common Application
	 */
	protected String getInterfaceCommonApplication() {
		return getPackageApplicationInterfaces(PROJECT_COMMUN, API) + "." + INTERFACE_COMMON_APPLICATION;
	}

	/**
	 * Return ClassCommonBatifreeException
	 * 
	 * @return ClassCommonBatifreeException
	 */
	protected String getClassCommonBatifreeException() {
		return getPackage(PROJECT_COMMUN, API) + ".exception." + CLASS_COMMON_EXCEPTION_BATIFREE;
	}

	/**
	 * Return ClassCommonManagerImpl
	 * 
	 * @return ClassCommonManagerImpl
	 */
	protected String getClassCommonManagerImpl() {
		return getPackageManagerImpl(PROJECT_COMMUN, API) + "." + CLASS_COMMON_MANAGER_IMPL;
	}

	/**
	 * Return InterfaceCommonMetier
	 * 
	 * @return InterfaceCommonMetier
	 */
	protected String getInterfaceCommonMetier() {
		return getPackageMetierInterfaces(PROJECT_COMMUN, API) + "." + INTERFACE_COMMON_METIER;
	}

	/**
	 * Return InterfaceCommonDao
	 * 
	 * @return InterfaceCommonDao
	 */
	protected String getInterfaceCommonDao() {
		return getPackageDaoInterfaces(PROJECT_COMMUN, API) + "." + INTERFACE_COMMON_DAO;
	}

	/**
	 * Return ClassCommonMetierImpl
	 * 
	 * @return ClassCommonMetierImpl
	 */
	protected String getClassCommonMetierImpl() {
		return getPackageMetierImpl(PROJECT_COMMUN, API) + "." + CLASS_COMMON_METIER_IMPL;
	}

	/**
	 * Return ClassApplicationImpl
	 * 
	 * @return ClassApplicationImpl
	 */
	protected String getClassApplicationImpl() {
		return getPackageApplicationImpl() + "." + getClassNameApplicationImpl();
	}

	/**
	 * Return ClassCommonDaoImpl
	 * 
	 * @return ClassCommonDaoImpl
	 */
	protected String getClassCommonDaoImpl() {
		return getPackageDaoImpl(PROJECT_COMMUN, API) + "." + getClassNameCommonDaoImpl();
	}

	// manager
	/**
	 * Retourne l'interface complète du manager à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface complète du manager
	 */
	protected String getInterfaceManager(String pClassName) {
		return getPackageManagerInterfaces() + "." + getInterfaceNameManager(pClassName);
	}

	/**
	 * Retourne l'interface du manager à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du manager
	 */
	protected String getInterfaceNameManager(String pClassName) {
		return INTERFACE_PREFIXE + pClassName + CLASS_COMMON_MANAGER;
	}

	/**
	 * Retourne la classe du manager impl à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return la classe du manager
	 */
	protected String getClassNameManagerImpl(String pClassName) {
		return pClassName + CLASS_COMMON_MANAGER_IMPL;
	}

	/**
	 * Retourne la classe du manager à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return la classe du manager
	 */
	protected String getClassNameManager(String pClassName) {
		return pClassName + CLASS_COMMON_MANAGER;
	}

	/**
	 * Retourne le servcie du manager à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return la classe du manager
	 */
	protected String getServiceManager(String pClassName) {
		return projectCode + "_" + getClassNameManager(pClassName);
	}

	/**
	 * Retourne Class Name Common Manager Impl Generic
	 * 
	 * @return Class Name Common Manager Impl Generic
	 */
	protected String getClassNameCommonManagerImplGeneric() {
		return projectClassPrefix + CLASS_GENERIC + CLASS_COMMON_MANAGER_IMPL;
	}

	/**
	 * Retourne l'attribut du manager à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'attribut du manager
	 */
	protected String getAttributNameManager(String pClassName) {
		String manager = getClassNameManager(pClassName);
		return manager.substring(0, 1).toLowerCase() + manager.substring(1);
	}

	// metier

	/**
	 * Retourne l'interface complète du métier à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface complète du métier
	 */
	protected String getInterfaceMetier(String pClassName) {
		return getPackageMetierInterfaces() + "." + getInterfaceNameMetier(pClassName);
	}

	/**
	 * Retourne l'interface du métier à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du métier
	 */
	protected String getInterfaceNameMetier(String pClassName) {
		return INTERFACE_PREFIXE + pClassName;
	}

	/**
	 * Retourne l'interface du métier à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du métier
	 */
	protected String getClassMetierImpl(String pClassName) {
		return getPackageMetierImpl() + "." + getClassNameMetierImpl(pClassName);
	}

	/**
	 * Retourne le nom de la classe du métier impl à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du métier
	 */
	protected String getClassNameMetierImpl(String pClassName) {
		return pClassName + IMPLEMENTATION_SUFFIXE;
	}

	// dao
	/**
	 * Return ClassNameCommonDaoImplGeneric
	 * 
	 * @return ClassNameCommonDaoImplGeneric
	 */
	protected String getClassNameCommonDaoImplGeneric() {
		return projectClassPrefix + CLASS_GENERIC + getClassNameCommonDaoImpl();
	}

	/**
	 * Retourne l'interface du dao à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du dao
	 */
	protected String getInterfaceDao(String pClassName) {
		return getPackageDaoInterfaces() + "." + getInterfaceNameDao(pClassName);
	}

	/**
	 * Retourne l'interface du dao à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'interface du dao
	 */
	protected String getInterfaceNameDao(String pClassName) {
		return INTERFACE_PREFIXE + getClassNameDao(pClassName);
	}

	/**
	 * Retourne l'attribut du dao à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple "Bibliotheque, Materiaux
	 * @return l'attribut du dao
	 */
	protected String getAttributNameDao(String pClassName) {
		String dao = getClassNameDao(pClassName);
		return dao.substring(0, 1).toLowerCase() + dao.substring(1);
	}

	/**
	 * Retourne la classe du dao impl à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple Bibliotheque, Materiaux
	 * @return la classe du dao
	 */
	protected abstract String getClassNameDaoImpl(String pClassName);

	/**
	 * Retourne la classe du dao à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple Bibliotheque, Materiaux
	 * @return la classe du manager
	 */
	protected String getClassNameDao(String pClassName) {
		return pClassName + CLASS_COMMON_DAO;
	}

	/**
	 * Retourne service dao à partir du nom de la classe.
	 * 
	 * @param pClassName nom de la classe. Exemple Bibliotheque, Materiaux
	 * @return service dao
	 */
	protected String getServiceDao(String pClassName) {
		return projectCode + "_" + getClassNameDao(pClassName);
	}

	/**
	 * Retourne le nom de la classe générique du dao.
	 * 
	 * @return nom de la classe générique du dao.
	 */
	protected abstract String getClassNameCommonDaoImpl();

	// application
	/**
	 * Return Service Application
	 * 
	 * @return Service Application
	 */
	protected String getServiceApplication() {
		return projectCode + "_" + CLASS_APPLICATION_IMPL;
	}

	/**
	 * Return ClassNameApplicationImpl
	 * 
	 * @return ClassNameApplicationImpl
	 */
	protected String getClassNameApplicationImpl() {
		return CLASS_APPLICATION_IMPL + projectClassPrefix;
	}

	// méthodes generate
	/**
	 * Retourne le texte de la classe application à partir de la liste des classes métier impl.
	 * 
	 * @param pListeClassesMetierImpl liste des classes métier impl
	 * @return texte de la classe application
	 */
	protected String getFileTextClassApplication(List<Class<?>> pListeClassesMetierImpl) {
		StringBufferI buffTxt = new StringBufferI();

		// Entête
		buffTxt.add("package " + getPackageApplicationImpl() + ";", 2);
		buffTxt.add("import org.apache.log4j.Logger;", 2);

		// Classe
		buffTxt.add("@Service(\"" + getServiceApplication() + "\")", 1);
		buffTxt.add("public class " + getClassNameApplicationImpl() + " extends " + CLASS_COMMON_APPLICATION_IMPL + " implements "
				+ INTERFACE_APPLICATION + " {", 2);

		// Attributs
		buffTxt.addInClass("private static final Logger LOGGER = Logger.getLogger(" + getClassNameApplicationImpl() + ".class);", 1);
		buffTxt.addInClass("public static String CODE_PROJECT = \"" + projectCode + "\";", 2);

		buffTxt.addInClass("/** Le User service. */", 1);
		buffTxt.addInClass("@Resource(name = \"" + projectCode + "_XXX\")", 1);
		buffTxt.addInClass("private IUserService userService;", 2);

		for (Class<?> classMetierImpl : pListeClassesMetierImpl) {
			String classNameImpl = classMetierImpl.getSimpleName();
			int lastIndex = classNameImpl.lastIndexOf(IMPLEMENTATION_SUFFIXE);
			String className = classNameImpl.substring(0, lastIndex);

			buffTxt.addInClass("/** Le " + getAttributNameManager(className) + ". */", 1);
			buffTxt.addInClass("@Resource(name = \"" + getServiceManager(className) + "\")", 1);
			buffTxt.addInClass("private " + getInterfaceNameManager(className) + " " + getAttributNameManager(className) + ";", 2);
		}

		// Opérations
		buffTxt.addInClass("public " + getClassNameApplicationImpl() + "() {", 1);
		buffTxt.addInMethod("super(CODE_PROJECT);", 1);
		buffTxt.addInMethod("LOGGER.info(\"Code projet = \" + CODE_PROJECT);", 1);
		buffTxt.addInClass("}", 2);

		buffTxt.addInClass("@Override", 1);
		buffTxt.addInClass("public IUserService getUserService() {", 1);
		buffTxt.addInMethod("return userService;", 1);
		buffTxt.addInClass("}", 2);

		buffTxt.addInClass("/**", 1);
		buffTxt.addInClass(" * Retourne l'application courante.", 1);
		buffTxt.addInClass(" * ", 1);
		buffTxt.addInClass(" * @return application courante", 1);
		buffTxt.addInClass(" * @throws BatifreeException", 1);
		buffTxt.addInClass(" */", 1);
		buffTxt.addInClass("public static IApplication getApplication() throws BatifreeException {", 1);
		buffTxt.addInMethod("return ServiceBeanFactory.getServiceBean(Application.class);", 1);
		buffTxt.addInClass("}", 2);

		// Fin
		buffTxt.add("}");

		return buffTxt.toString();
	}

	/**
	 * Le generic manager
	 * 
	 * @param pClassName nom de la classe
	 * @return generic manager
	 */
	protected String getFileTextClassManagerImplGeneric(String pClassName) {
		StringBufferI buffTxt = new StringBufferI();

		// Entête
		buffTxt.add("package " + getPackageManagerImpl() + ";", 2);
		buffTxt.add("import java.io.Serializable;", 2);
		buffTxt.add("import " + getInterfaceCommonApplication() + ";", 1);
		buffTxt.add("import " + getClassCommonBatifreeException() + ";", 1);
		buffTxt.add("import " + getClassCommonManagerImpl() + ";", 1);
		buffTxt.add("import " + getInterfaceCommonMetier() + ";", 2);
		buffTxt.add("import " + getClassApplicationImpl() + ";", 2);

		// Classe
		buffTxt.add("/**", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * Classe <" + pClassName + "> Manager pour <" + projectName.toUpperCase() + ">.", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * @param <IT> Interface " + INTERFACE_COMMON_METIER, 1);
		buffTxt.add(" * @param <ID> Classe ID", 1);
		buffTxt.add(" */", 1);
		buffTxt.add("public abstract class " + pClassName + "<IT extends " + INTERFACE_COMMON_METIER + "<ID>, ID extends Serializable> extends "
				+ CLASS_COMMON_MANAGER_IMPL + "<IT, ID> {", 2);

		// Opérations
		buffTxt.addInClass("@Override", 1);
		buffTxt.addInClass("public " + INTERFACE_COMMON_APPLICATION + " getApplication() throws " + CLASS_COMMON_EXCEPTION_BATIFREE + " {", 1);
		buffTxt.addInMethod("return " + getClassNameApplicationImpl() + ".getApplication();", 1);
		buffTxt.addInClass("}", 1);

		// Fin
		buffTxt.add("}");

		return buffTxt.toString();
	}

	/**
	 * Le manager de la classe MetierImpl
	 * 
	 * @param pClassName nom de la classe MetierImpl sans l'extention IMPL. Exemple : Bibliotheque, Materiaux
	 * @param pIsClassAbstract TRU si classe abstraite, FALSE sinon
	 * @return manager de la classe MetierImpl
	 */
	protected String getFileTextClassManagerImpl(String pClassName, boolean pIsClassAbstract) {
		StringBufferI buffTxt = new StringBufferI();

		// Entête
		buffTxt.add("package " + getPackageManagerImpl() + ";", 2);
		if (!pIsClassAbstract) {
			buffTxt.add("import javax.annotation.Resource;", 1);
			buffTxt.add("import org.springframework.stereotype.Service;", 1);
			buffTxt.add("import " + getInterfaceCommonDao() + ";", 1);
			buffTxt.add("import " + getInterfaceDao(pClassName) + ";", 1);
		}
		buffTxt.add("import " + getInterfaceManager(pClassName) + ";", 1);
		buffTxt.add("import " + getInterfaceMetier(pClassName) + ";", 2);

		// Classe
		buffTxt.add("/**", 1);
		buffTxt.add(" * Classe <b>" + getClassNameManagerImpl(pClassName) + "</b>.", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" * ", 1);
		buffTxt.add(" */", 1);
		if (pIsClassAbstract) {
			buffTxt.add("public abstract class " + getClassNameManagerImpl(pClassName) + "<IT extends " + getInterfaceNameMetier(pClassName)
					+ "> extends " + getClassNameCommonManagerImplGeneric() + "<IT, Integer> implements " + getInterfaceNameManager(pClassName)
					+ "<IT> {", 2);

		} else {
			buffTxt.add("@Service(\"" + getServiceManager(pClassName) + "\")", 1);
			buffTxt.add("public class " + getClassNameManagerImpl(pClassName) + " extends " + getClassNameCommonManagerImplGeneric() + "<"
					+ getInterfaceNameMetier(pClassName) + ", Integer> implements " + getInterfaceNameManager(pClassName) + " {", 2);

			// Opérations
			buffTxt.addInClass("@Resource(name = \"" + getServiceDao(pClassName) + "\")", 1);
			buffTxt.addInClass("private " + getInterfaceNameDao(pClassName) + " " + getAttributNameDao(pClassName) + ";", 2);

			buffTxt.addInClass("@Override", 1);
			buffTxt.addInClass("protected " + INTERFACE_COMMON_DAO + "<" + getInterfaceNameMetier(pClassName) + ", Integer> getMainDao() {", 1);
			buffTxt.addInMethod("return " + getAttributNameDao(pClassName) + ";", 1);
			buffTxt.addInClass("}", 1);
		}

		// Fin
		buffTxt.add("}");

		return buffTxt.toString();
	}

	/**
	 * Le generic dao
	 * 
	 * @param pClassName le nom de la classe
	 * @return generic dao
	 */
	protected abstract String getFileTextClassDaoImplGeneric(String pClassName);

	/**
	 * Le dao de la classe MetierImpl
	 * 
	 * @param pClassName nom de la classe MetierImpl sans l'extention IMPL. Exemple : Bibliotheque, Materiaux
	 * @param pIsClassAbstract TRU si classe abstraite, FALSE sinon
	 * @return dao de la classe MetierImpl
	 */
	protected abstract String getFileTextClassDaoImpl(String pClassName, boolean pIsClassAbstract);
}
