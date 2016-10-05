package common.api.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 
 * Classe/Interface <TraceInvocation> utilisé pour AOP
 *
 */
@Aspect
@Component
public class TraceInvocation implements Ordered {
	private static final Logger LOGGER = Logger.getLogger(TraceInvocation.class);

	private int order;

	/**
	 * Retourne l'order
	 * 
	 * @return order
	 */
	@Override
	public int getOrder() {
		return order;
	}

	/**
	 * Set Order
	 * 
	 * @param pOrder order
	 */
	@Value("1")
	public void setOrder(final int pOrder) {
		this.order = pOrder;
	}

	/*@Around("execution(* common.api.dao.*.impl.*.*(..))")
	public Object executerDaoImpl(final ProceedingJoinPoint pJointPoint) throws Throwable {
		return afficherTrace(pJointPoint);
	}*/

	/**
	 * Affiche la trace du début et de fin de la méthode.
	 * 
	 * @param pJointPoint le ProceedingJoinPoint
	 * @return object
	 * @throws Throwable
	 */
	@Around("execution(* common.api.manager.impl.*.*(..))")
	public Object executerManagerImpl(final ProceedingJoinPoint pJointPoint) throws Throwable {
		return afficherTrace(pJointPoint);
	}

	/*@Around("execution(* common.api.application.impl.ApplicationCommun.*(..))")
	public Object executerApplicationCommun(final ProceedingJoinPoint pJointPoint) throws Throwable {
		return afficherTraceRetour(pJointPoint);
	}*/

	/**
	 * Affiche la trace du début et de fin de la méthode.
	 * 
	 * @param pJointPoint le ProceedingJoinPoint
	 * @return object
	 * @throws Throwable
	 */
	protected Object afficherTrace(final ProceedingJoinPoint pJointPoint) throws Throwable {
		String nomMethode = pJointPoint.getTarget().getClass().getSimpleName() + "." + pJointPoint.getSignature().getName();
		final Object[] args = pJointPoint.getArgs();
		final StringBuffer sb = new StringBuffer();
		sb.append(pJointPoint.getSignature().toString());
		sb.append(" avec les parametres : (");
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]);
			if (i < args.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");

		LOGGER.info("Debut methode : " + sb);
		Object obj = null;
		try {
			obj = pJointPoint.proceed();
		} finally {
			LOGGER.info("Fin methode :  " + nomMethode);
		}
		return obj;
	}

	/**
	 * Affiche la trace du début et de fin de la méthode ainsi que la valeur de retour de la méthode.
	 * 
	 * @param pJointPoint le ProceedingJoinPoint
	 * @return object
	 * @throws Throwable
	 */
	protected Object afficherTraceRetour(final ProceedingJoinPoint pJointPoint) throws Throwable {
		String nomMethode = pJointPoint.getTarget().getClass().getSimpleName() + "." + pJointPoint.getSignature().getName();
		final Object[] args = pJointPoint.getArgs();
		final StringBuffer sb = new StringBuffer();
		sb.append(pJointPoint.getSignature().toString());
		sb.append(" avec les parametres : (");
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]);
			if (i < args.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");

		LOGGER.info("Debut methode : " + sb);
		Object obj = null;
		try {
			obj = pJointPoint.proceed();
		} finally {
			LOGGER.info("Fin methode :  " + nomMethode + " retour=" + obj);
		}
		return obj;
	}
}