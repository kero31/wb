package webbati.api.test.beans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import common.api.application.interfaces.IApplicationCommun;
import common.api.exception.WebbatiException;
import junit.framework.Assert;
import webbati.api.test.commun.TestCommunBfApi;

public class TestContext extends TestCommunBfApi {

	protected ApplicationContext context = null;
	private IApplicationCommun appCommun;

	/**
	 * Méthode appelée à l'initialisation de la classe de test Unitaire.
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		// Crée le context Spring
		context = getContext();
		Assert.assertNotNull(context);

		// On récupère l'application Spring
		appCommun = getApplication();
		Assert.assertNotNull(appCommun);
	}

	@Override
	@After
	public void setDown() {
	}

	@Test
	public void testContext() throws WebbatiException {
		int i = 0;
	}
}
