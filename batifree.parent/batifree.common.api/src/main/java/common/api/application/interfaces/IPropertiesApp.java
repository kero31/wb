package common.api.application.interfaces;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IPropertiesApp</b><br/>
 * 
 * Interface <IPropertiesApp>
 */
public interface IPropertiesApp {
	String BD_ADMIN_DIALECT = "bd.admin.dialect";
	String BD_ADMIN_DRIVER = "bd.admin.driver";
	String BD_ADMIN_URL = "bd.admin.url";
	String BD_ADMIN_USERNAME = "bd.admin.username";
	String BD_ADMIN_PASSWORD = "bd.admin.password";
	String BD_ADMIN_PASSWORD_ENCODE = "bd.admin.password.encoding";
	String BD_ADMIN_SCHEMA = "bd.admin.schema";
	String BD_CLIENT_HOST = "bd.client.host";
	String EMAIL_FROM = "email.from";
	String EMAIL_SMTP_HOST = "email.smtp.host";
	String EMAIL_SMTP_PORT = "email.smtp.port";
	String EMAIL_SMTP_USERNAME = "email.smtp.username";
	String EMAIL_SMTP_PASSWORD = "email.smtp.password";

	/**
	 * Retourne la valeur pour la clé key
	 * 
	 * 
	 * @param pKey clé à rechercher
	 * @return @return @return valeur pour la clé key, null si la properties n'a pu être ouverte ou si la clé n'a pas été trouvé
	 * @throws BatifreeException BatifreeException
	 */
	String getProperty(String pKey) throws BatifreeException;

	/**
	 * Retourne la property pour la clé key avec valeur par défaut defaultValue
	 * 
	 * 
	 * @param pKey clé à rechercher
	 * @param pDefaultValue valeur par défaut si la clé n'a pas été trouvé
	 * @return @return @return valeur pour la clé key, null si la properties n'a pu être ouverte, defaultValue si la clé n'a pas été trouvé
	 * @throws BatifreeException BatifreeException
	 */
	String getProperty(String pKey, String pDefaultValue) throws BatifreeException;

}