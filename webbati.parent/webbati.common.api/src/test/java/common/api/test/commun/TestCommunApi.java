/**
 * 
 */
package common.api.test.commun;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.ITransaction;
import common.api.exception.WebbatiException;
import common.api.exception.WebbatiUserException;
import common.api.metier.interfaces.IUserApp;

/**
 * Classe <TestCommunApi>.
 * 
 */
public abstract class TestCommunApi {

	protected ApplicationContext context = null;
	protected IUserApp user = null;
	private StopWatch clockGlobal = null;
	private StopWatch clockSpecific = null;
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
		memoryBefore = "Avant Memory currently occupied : " + ((runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024)
		        + " Mo on a maximum of " + (runtime.maxMemory() / 1024 / 1024)
		        + " Mo (it's not the real memory occupied because the garbage collector is not run yet)";

		// Charge le login
		loadUserByUsernamePassword();
	}

	/**
	 * Charge le login avec le mot de passe.
	 */
	protected void loadUserByUsernamePassword() throws WebbatiUserException, WebbatiException {
	}

	/**
	 * Met à jour l'application.
	 * 
	 * @return l'application
	 */
	protected abstract IApplicationCommun getApplication() throws WebbatiException;

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
	 * Démarre le timer spécifique.
	 * 
	 */
	protected void startTimer() {
		// Démarre le timer
		clockSpecific = new StopWatch(getClass().getName());
		clockSpecific.start("Specif");
	}

	/**
	 * Arrête le timer spécifique et retourne la durée du timer.
	 * 
	 * @return durée du timer en millisecondes
	 */
	protected long stopTimer() {
		if (clockSpecific == null) {
			return 0;
		}

		clockSpecific.stop();
		long timer = clockSpecific.getLastTaskTimeMillis();
		clockSpecific = null;

		return timer;
	}

	/**
	 * Arrête le timer spécifique et vérifie que la durée du timer est inférieure à la durée max du timer.
	 * 
	 * @param pTimerMax durée max du timer en millisecondes
	 */
	protected void assertTimer(double pTimerMax) {
		long timer = stopTimer();
		System.out.println(" ===> running time max (millis) = " + pTimerMax + ", running time (millis) = " + timer + " <===");
		Assert.assertTrue("erreur running time max (millis) = " + pTimerMax + ", running time (millis) = " + timer, timer <= pTimerMax);
	}

	/**
	 * Retourne la transaction.
	 * 
	 * @return la transaction
	 */
	protected ITransaction getTransaction() throws WebbatiException {
		return appCommun.getUserService().getTransaction();
	}

	/**
	 * Ferme la transaction.
	 * 
	 * @throws WebbatiException
	 */
	protected void closeTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.close();
		}
	}

	/**
	 * Commence une transaction.
	 * 
	 * @throws WebbatiException
	 */
	protected void beginTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.beginTransaction();
		}
	}

	/**
	 * Fait un rollback.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	protected void rollbackTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.rollback();
		}
	}

	/**
	 * Fait un commit.
	 * 
	 * 
	 * @throws WebbatiException WebbatiException
	 */
	protected void commitTransaction() throws WebbatiException {
		ITransaction transaction = getTransaction();
		if (transaction != null) {
			transaction.commit();
		}
	}

	/**
	 * Vérfie si 2 dates sont égales.
	 * 
	 * @param pDate1 date 1
	 * @param pDate2 date 2
	 */
	protected void assertEqualsDate(Date pDate1, Date pDate2) {
		if (pDate1 != null && pDate2 != null) {
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(pDate1);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(pDate2);
			Assert.assertEquals(cal1.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.DAY_OF_MONTH));
			Assert.assertEquals(cal1.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
			Assert.assertEquals(cal1.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
		} else {
			Assert.assertEquals(pDate1, pDate2);
		}
	}

	/**
	 * Vérfie si 2 dates et heure sont égales.
	 * 
	 * @param pDate1 date 1
	 * @param pDate2 date 2
	 */
	protected void assertEqualsDateTime(Date pDate1, Date pDate2) {
		if (pDate1 != null && pDate2 != null) {
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(pDate1);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(pDate2);
			Assert.assertEquals(cal1.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.DAY_OF_MONTH));
			Assert.assertEquals(cal1.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
			Assert.assertEquals(cal1.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
			Assert.assertEquals(cal1.get(Calendar.HOUR_OF_DAY), cal2.get(Calendar.HOUR_OF_DAY));
			Assert.assertEquals(cal1.get(Calendar.MINUTE), cal2.get(Calendar.MINUTE));
			Assert.assertEquals(cal1.get(Calendar.SECOND), cal2.get(Calendar.SECOND));
		} else {
			Assert.assertEquals(pDate1, pDate2);
		}
	}

}
