/**
 * 
 */
package admin.api.test.commun;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;

import common.api.application.impl.UserAppImpl;
import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.ITransaction;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;

/**
 * Classe <TestCommunApi>.
 * 
 */
public abstract class TestCommunApi {

	protected ApplicationContext context = null;
	protected UserAppImpl user = null;
	private StopWatch clockGlobal = null;
	private String memoryBefore;
	private IApplicationCommun appCommun;

	/**
	 * Méthode appelée à l'initialisation de la classe de test Unitaire.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Crée le context Spring
		context = getContext();

		// On récupère l'application Spring
		appCommun = getApplication();

		// Démarre le timer
		clockGlobal = new StopWatch(getClass().getName());
		clockGlobal.start("Global");

		// Mémoire avant
		Runtime runtime = Runtime.getRuntime();
		memoryBefore = "Avant Memory currently occupied : " + ((runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024) + " Mo on a maximum of "
				+ (runtime.maxMemory() / 1024 / 1024) + " Mo (it's not the real memory occupied because the garbage collector is not run yet)";

		// Charge le login
		loadUserByUsernamePassword();
	}

	/**
	 * Charge le login avec le mot de passe.
	 */
	protected void loadUserByUsernamePassword() throws BatifreeUserException, BatifreeException {
	}

	/**
	 * Met à jour l'application.
	 * 
	 * @return l'application
	 */
	protected abstract IApplicationCommun getApplication() throws BatifreeException;

	/**
	 * Retourne le contexte.
	 * 
	 * @return le contexte
	 */
	protected abstract ApplicationContext getContext();

	@After
	public void setDown() {
		clockGlobal.stop();
		System.out.println("\nTemps d'execution : global : running time (millis) = " + clockGlobal.getLastTaskTimeMillis());

		// Mémoire après
		Runtime runtime = Runtime.getRuntime();
		String memoryAfter = "Après Memory currently occupied : " + ((runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024)
				+ " Mo on a maximum of " + (runtime.maxMemory() / 1024 / 1024)
				+ " Mo (it's not the real memory occupied because the garbage collector is not run yet)\n";
		System.out.println(memoryBefore);
		System.out.println(memoryAfter);
	}

	/**
	 * Retourne la transaction.
	 * 
	 * @return la transaction
	 */
	protected ITransaction getTransaction() throws BatifreeException {
		return appCommun.getUserService().getTransaction();
	}

	/**
	 * Ferme la transaction.
	 * 
	 * @throws BatifreeException
	 */
	protected void closeTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.close();
		}
	}

	/**
	 * Commence une transaction.
	 * 
	 * @throws BatifreeException
	 */
	protected void beginTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.beginTransaction();
		}
	}

	/**
	 * Fait un rollback.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	protected void rollbackTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.rollback();
		}
	}

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws BatifreeException BatifreeException
	 */
	protected void commitTransaction() throws BatifreeException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.commit();
		}
	}

}
