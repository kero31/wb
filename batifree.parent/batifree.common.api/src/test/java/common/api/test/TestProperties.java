/**
 * 
 */
package common.api.test;

import org.junit.Assert;
import org.junit.Test;

import common.api.application.impl.PropertiesAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.BatifreeException;

/**
 * Classe/Interface <TestProperties>
 *
 */
public class TestProperties {

	@Test
	public void loadProperties() throws BatifreeException {
		IPropertiesApp prop = new PropertiesAppImpl();
		String value = prop.getProperty(IPropertiesApp.BD_ADMIN_URL);
		Assert.assertNotNull(value);
		System.out.println("value de " + IPropertiesApp.BD_ADMIN_URL + " = " + value);
		Assert.assertEquals("value", value);
	}
}
