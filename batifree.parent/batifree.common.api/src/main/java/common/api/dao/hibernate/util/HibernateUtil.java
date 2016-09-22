package common.api.dao.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.EncodingTools;

/**
 * 
 * Classe <HibernateUtil>.
 * 
 * @author Kero
 * 
 */
public class HibernateUtil {

	private SessionFactory sessionFactory = null;
	private final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private final String fileNameConfigHibernate;
	protected static final String CONFIG_FILE_NAME_DEFAULT = "hibernate.cfg.xml";
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private boolean bdPasswordEncoded = false;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pFileNameConfigHibernate fileNameConfigHibernate
	 */
	public HibernateUtil(String pFileNameConfigHibernate) {
		fileNameConfigHibernate = pFileNameConfigHibernate;
	}

	/**
	 * 
	 * Constructeur.
	 */
	public HibernateUtil() {
		this("");
	}

	/**
	 * Configue la session
	 * 
	 * @param pUserConfig user contenant les paramètres de connection
	 * @return session factory
	 * @throws HibernateException
	 * @throws BatifreeException
	 */
	private SessionFactory configureSessionFactory(IUserApp pUserConfig) throws BatifreeException {
		try {
			Configuration configuration = new Configuration();

			// Configue fichier
			if (fileNameConfigHibernate != null && !fileNameConfigHibernate.isEmpty()) {
				configuration.configure(fileNameConfigHibernate);
			} else {
				configuration.configure();
			}

			// Configuration user
			if (pUserConfig != null && !pUserConfig.getBdLogin().isEmpty()) {
				String password = pUserConfig.getBdPassword();
				String passwordEncoded = "";
				if (bdPasswordEncoded) {
					// Reconstruit le password car il a été encodé
					password = pUserConfig.getBdLogin() + "_" + EncodingTools.ENCODING_KEY + "_" + pUserConfig.getBdShema();

					// Vérifie si le mot de passe construit correspond bien à celui de userConfig
					passwordEncoded = EncodingTools.encode(password, EncodingTools.ENCODING_MD5);
				}

				if (!bdPasswordEncoded || (passwordEncoded != null && passwordEncoded.equals(pUserConfig.getBdPassword()))) {

					/* HSQLDB
					 * configuration
					.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
					.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
					.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/BookShopDB")
					.setProperty("hibernate.connection.username", "sa")
					.setProperty("hibernate.connection.password", "");*/
					/* STANDARD */
					configuration.setProperty("hibernate.dialect", pUserConfig.getBdDialect())
					        .setProperty("hibernate.connection.driver_class", pUserConfig.getBdDriver())
					        .setProperty("hibernate.connection.url", pUserConfig.getBdURL() + pUserConfig.getBdShema())
					        .setProperty("hibernate.connection.username", pUserConfig.getBdLogin())
					        .setProperty("hibernate.connection.password", password)
					        .setProperty("hibernate.default_schema", DRIVER_MYSQL.equals(pUserConfig.getBdDriver()) ? "" : pUserConfig.getBdShema());
					/*
					configuration 
					.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
					.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
					.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/batifreem")
					.setProperty("hibernate.default_schema", "batifreem")
					.setProperty("hibernate.connection.username", "root")
					.setProperty("hibernate.connection.password", "");*/

				} else {
					throw new BatifreeException("Le mot de passe hibernate n'est pas correct");
				}
			}

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			throw new BatifreeException("Erreur configuration hibernate", e);
		}
	}

	/**
	 * Renvoie la session courante de l'user
	 * 
	 * @param pUser user contenant les paramètres de connection
	 * @return session courante
	 * @throws HibernateException
	 * @throws BatifreeException
	 */
	public Session currentSession(IUserApp pUser) throws BatifreeException {
		Session s = session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null) {
			sessionFactory = configureSessionFactory(pUser);
			s = sessionFactory.openSession();
			session.set(s);
		} else if (!s.isOpen()) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	/**
	 * Ferme la session courante
	 * 
	 * @throws HibernateException
	 */
	public void closeSession() throws HibernateException {
		Session s = session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}

	/**
	 * Met à jour le champ bdPasswordEncoded .
	 * 
	 * @param pBdPasswordEncoded le bdPasswordEncoded à mettre à jour
	 */
	public void setBdPasswordEncoded(boolean pBdPasswordEncoded) {
		this.bdPasswordEncoded = pBdPasswordEncoded;
	}
}
