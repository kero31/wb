/**
 * 
 */
package common.api.application.impl;

import java.util.Properties;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.BatifreeException;

/**
 * @author Kero
 * 
 */
@Service("PropertiesApp")
public class PropertiesAppImpl implements IPropertiesApp {

	private Properties properties = null;
	private String fileName = "";
	protected static final String PROPERTIES_FILENAME = "/batifree.properties";

	/**
	 * 
	 */
	public PropertiesAppImpl() {
		fileName = PROPERTIES_FILENAME;
	}

	/**
	 * Charge la liste des propriétés contenu dans le fichier spécifié
	 * 
	 * @return un objet Properties contenant les propriétés du fichier
	 * @throws BatifreeException
	 */
	protected Properties getProperties() throws BatifreeException {
		if (properties != null) {
			return properties;
		}

		Properties prop = new Properties();
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null) {
			throw new BatifreeException("Erreur de chargement du getSystemResourceAsStream(" + fileName + ") à cause de : fichier introuvable");
		}

		try {
			prop.load(input);
			// Enregistrement de la properties
			properties = prop;
		} catch (IOException e) {
			throw new BatifreeException("Erreur de chargement du fichier " + fileName, e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				throw new BatifreeException("Erreur de fermeture du fichier " + fileName, e);
			}
		}

		return properties;
	}

	/**
	 * Charge un fichier properties
	 * 
	 * @param pFileName fileName
	 */
	public void loadProperties(String pFileName) {
		this.fileName = pFileName;
	}

	/**
	 * Charge le fichier properties par défaut
	 */
	public void loadPropertiesDefault() {
		fileName = PROPERTIES_FILENAME;
	}

	@Override
	public String getProperty(String pKey) throws BatifreeException {
		Properties prop = getProperties();
		if (prop != null) {
			return prop.getProperty(pKey);
		}

		return null;
	}

	@Override
	public String getProperty(String pKey, String pDefaultValue) throws BatifreeException {
		Properties prop = getProperties();
		if (prop != null) {
			return prop.getProperty(pKey, pDefaultValue);
		}

		return null;
	}
}
