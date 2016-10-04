package common.api.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 
 * Classe/Interface <MonitorePerf> utilisé pour AOP
 *
 */
@Aspect
@Component
public class MonitorePerf implements Ordered {
	private static final Logger LOGGER = Logger.getLogger(MonitorePerf.class);
	private int order;

	/**
	 * Set Order
	 * 
	 * @param pOrder order
	 */
	@Value("2")
	public void setOrder(final int pOrder) {
		this.order = pOrder;
	}

	/**
	 * Retourne l'order
	 * 
	 * @return order
	 */
	@Override
	public int getOrder() {
		return order;
	}

	/*@Around("execution(* common.api.dao.*.impl.*.*(..))")
	public Object executerDaoImpl(final ProceedingJoinPoint pJointPoint) throws Throwable {
		return executer(pJointPoint);
	}*/

	/**
	 * Calcule la durée d'exécution de la méthode.
	 * 
	 * @param pJointPoint le ProceedingJoinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("execution(* common.api.manager.impl.*.*(..))")
	public Object executerManagerImpl(final ProceedingJoinPoint pJointPoint) throws Throwable {
		return executer(pJointPoint);
	}

	/**
	 * Calcule la durée d'exécution de la méthode.
	 * 
	 * @param pJointPoint le ProceedingJoinPoint
	 * @return Object
	 * @throws Throwable
	 */
	protected Object executer(final ProceedingJoinPoint pJointPoint) throws Throwable {
		Object returnValue;
		StopWatch clock = new StopWatch(getClass().getName());
		try {
			clock.start(pJointPoint.toString());
			returnValue = pJointPoint.proceed();
		} finally {
			clock.stop();
			LOGGER.info("temps d'execution : " + pJointPoint.getSignature().toString() + " : running time (millis) = " + clock.getTotalTimeMillis());
		}
		return returnValue;
	}
}