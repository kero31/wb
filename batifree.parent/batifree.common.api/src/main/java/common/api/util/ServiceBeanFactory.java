package common.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe de fabrique de Service depuis le contexte SPRING.
 * 
 */
@Service("ServiceBeanFactory")
public class ServiceBeanFactory implements ApplicationContextAware {

	/** Contexte Spring qui sera injecte par Spring directement. */
	private static ApplicationContext context = null;

	/**
	 * Retourne le context
	 * 
	 * @return context
	 */
	public static ApplicationContext getContext() {
		return context;
	}

	/** {@inheritDoc} */
	@Override
	public void setApplicationContext(ApplicationContext pApplicationContext) throws BeansException {
		context = pApplicationContext;
	}

	/**
	 * Set Application Context Custom
	 * 
	 * @param pApplicationContext applicationContext
	 * @throws BeansException
	 */
	@Deprecated
	public static void setApplicationContextCustom(ApplicationContext pApplicationContext) throws BeansException {
		context = pApplicationContext;
	}

	/**
	 * Methode statique pour récupérer le Bean dans le contexte Spring.
	 * 
	 * @param pClazz Classe
	 * @param pName Nom du bean
	 * @param <T> Type du bean
	 * @return Bean
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getServiceBean(Class<T> pClazz, String pName) throws BatifreeException {
		T bean = (T) context.getBean(pName);
		if (bean == null) {
			throw new BatifreeException("Le bean " + pName + " de la classe " + pClazz.getName() + " est introuvable");
		}
		return bean;
	}

	/**
	 * Methode statique pour récupérer le Bean dans le contexte Spring.
	 * 
	 * @param pName Nom du bean
	 * @return Bean
	 * @throws BatifreeException
	 */
	public static Object getServiceBean(String pName) throws BatifreeException {
		Object bean = context.getBean(pName);
		if (bean == null) {
			throw new BatifreeException("Le bean " + pName + " est introuvable");
		}
		return bean;
	}

	/**
	 * Methode statique pour récupérer le Bean dans le contexte Spring.
	 * 
	 * @param pClazz Classe
	 * @param <T> Type du bean
	 * @return Bean
	 * @throws BatifreeException
	 */
	public static <T> T getServiceBean(Class<T> pClazz) throws BatifreeException {
		T bean = context.getBean(pClazz);
		if (bean == null) {
			throw new BatifreeException("Le bean de la classe" + pClazz.getName() + " est introuvable");
		}
		return bean;
	}

}
