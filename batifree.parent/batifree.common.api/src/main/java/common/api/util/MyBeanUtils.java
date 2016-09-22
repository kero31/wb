package common.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.log4j.Logger;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>MyBeanUtils</b><br/>
 *
 */
public class MyBeanUtils extends BeanUtilsBean {

	private static final Logger LOGGER = Logger.getLogger(MyBeanUtils.class);

	private static MyBeanUtils myBeanUtils = null;

	/**
	 * Retourne l'instance courante.
	 * 
	 * @return instance courant
	 */
	public static MyBeanUtils getInstance() {
		if (myBeanUtils == null) {
			return new MyBeanUtils();
		}

		return myBeanUtils;
	}

	/**
	 * Copie toutes les propriétés de l'objet origine vers l'objet destination.
	 * 
	 * @param <TDEST> classe de destination
	 * @param <TORIG> classe d'origine
	 * @param pMapClazzDest map classe objet destination : key=classe origine; value=classe destination
	 * @param pListOrig list objet origine
	 * @return list objet destination
	 * @throws BatifreeException
	 */
	public <TDEST, TORIG> List<? extends TDEST> copyPropertiesEJBList(Map<Class<? extends TORIG>, Class<? extends TDEST>> pMapClazzDest,
	        Collection<? extends TORIG> pListOrig) throws BatifreeException {

		// Validate existence of the specified beans
		if (pMapClazzDest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}

		if (pListOrig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}

		List<TDEST> listDest = new ArrayList<TDEST>();
		if (!pListOrig.isEmpty()) {

			// Pour chaque classe des maps, crée une liste de properties
			for (Map.Entry<Class<? extends TORIG>, Class<? extends TDEST>> entry : pMapClazzDest.entrySet()) {

				// Récupère la classe origine
				Class<? extends TORIG> clazzOriginTemplate = entry.getKey();

				// Récupère la classe destination
				Class<? extends TDEST> clazzDestTemplate = entry.getValue();

				listDest.addAll(copyPropertiesEJBList(clazzOriginTemplate, clazzDestTemplate, pListOrig));
			}
		}

		return listDest;
	}

	/**
	 * Copie toutes les propriétés de l'objet origine vers l'objet destination.
	 * 
	 * @param <TORIG> classe d'origine
	 * @param <TDEST> classe de destination
	 * @param pClazzDest classe objet destination
	 * @param pListOrig list objet origine
	 * @return list objet destination
	 * @throws BatifreeException
	 */
	public <TDEST, TORIG> List<TDEST> copyPropertiesEJBList(Class<TDEST> pClazzDest, Collection<? extends TORIG> pListOrig) throws BatifreeException {
		return copyPropertiesEJBList(null, pClazzDest, pListOrig);
	}

	/**
	 * Copie toutes les propriétés de l'objet origine vers l'objet destination.
	 * 
	 * @param <TORIG> classe d'origine
	 * @param <TDEST> classe de destination
	 * @param pClazzOrigin classe origine
	 * @param pClazzDest classe objet destination
	 * @param pListOrig list objet origine
	 * @return list objet destination
	 * @throws BatifreeException
	 */
	private <TDEST, TORIG> List<TDEST> copyPropertiesEJBList(Class<? extends TORIG> pClazzOrigin, Class<TDEST> pClazzDest,
	        Collection<? extends TORIG> pListOrig) throws BatifreeException {
		// Validate existence of the specified beans
		if (pClazzDest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}

		if (pListOrig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}

		List<TDEST> listDest = new ArrayList<TDEST>();
		if (!pListOrig.isEmpty()) {

			// Crée les objets qui vont servir de template
			TORIG origTemplate = null;
			if (pClazzOrigin == null) {
				origTemplate = pListOrig.iterator().next();
			} else {
				for (TORIG o : pListOrig) {
					if (pClazzOrigin.isAssignableFrom(o.getClass())) {
						origTemplate = o;
						break;
					}
				}
			}

			if (origTemplate != null) {
				// Récupère la classe destination
				Class<TDEST> clazzDestTemplate = pClazzDest;

				// Crée l'objet de destination template
				TDEST destTemplate;
				try {
					destTemplate = clazzDestTemplate.newInstance();
				} catch (IllegalAccessException | InstantiationException e) {
					LOGGER.error("Erreur newInstance", e);
					throw new BatifreeException("Erreur newInstance", e);
				}

				// Property Utils Bean
				PropertyUtilsBean propertyUtils = getPropertyUtils();

				// Crée une map de nom d'attribut et de valeur
				Set<String> listProperties = new HashSet<String>();

				// Copy the properties, converting as necessary for the template
				PropertyDescriptor[] origDescriptors = propertyUtils.getPropertyDescriptors(origTemplate);
				for (PropertyDescriptor origDescriptor : origDescriptors) {
					String name = origDescriptor.getName();
					try {
						// Vérifie si on peut lire la valeur dans l'attribut d'origine et si on peut écrire dans l'attribut de destination
						if (propertyUtils.isReadable(origTemplate, name) && propertyUtils.isWriteable(destTemplate, name)) {
							Class<?> origPropertyType = propertyUtils.getPropertyType(origTemplate, name);
							Class<?> destPropertyType = propertyUtils.getPropertyType(destTemplate, name);

							if (origPropertyType != null && origPropertyType.equals(destPropertyType)) {
								listProperties.add(name);
							}
						}
					} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
						LOGGER.error("Erreur copyPropertiesEJB", e);
						throw new BatifreeException("Erreur copyPropertiesEJB", e);
					}
				}

				// Copy tous les attributs de la liste d'origine
				for (TORIG orig : pListOrig) {
					if (pClazzOrigin == null || pClazzOrigin.isAssignableFrom(orig.getClass())) {
						try {
							// Récupère la classe destination
							Class<TDEST> clazzDest = pClazzDest;

							// Crée l'objet de destination
							TDEST dest = clazzDest.newInstance();

							// Parcours chaque propriété valide
							for (String name : listProperties) {
								// Récup de la valeur de l'origine
								Object value = propertyUtils.getSimpleProperty(orig, name);

								// Mise à jour de la valeur dans la destination
								if (value != null) {
									// copy property avec conversion
									copyProperty(dest, name, value);
								} else {
									// copy valeur NULL dans property
									propertyUtils.setProperty(dest, name, value);
								}
							}

							// Ajoute l'objet de destination à la liste des objets de destination
							listDest.add(dest);
						} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
							// Should not happen
							LOGGER.error("Erreur Exception Should not happen");
						}
					}
				}
			}
		}

		return listDest;
	}

	/**
	 * Copie toutes les propriétés de l'objet origine vers l'objet destination.
	 * 
	 * @param pDest objet destination
	 * @param pOrig objet origine
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void copyPropertiesEJB(Object pDest, Object pOrig) throws IllegalAccessException, InvocationTargetException {
		// Validate existence of the specified beans
		if (pDest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}

		if (pOrig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}

		PropertyUtilsBean propertyUtils = getPropertyUtils();

		// Copy the properties, converting as necessary
		PropertyDescriptor[] origDescriptors = propertyUtils.getPropertyDescriptors(pOrig);

		for (PropertyDescriptor origDescriptor : origDescriptors) {
			String name = origDescriptor.getName();

			try {
				// Vérifie si on peut lire la valeur dans l'attribut d'origine et si on peut écrire dans l'attribut de destination
				if (propertyUtils.isReadable(pOrig, name) && propertyUtils.isWriteable(pDest, name)) {
					Class<?> origPropertyType = propertyUtils.getPropertyType(pOrig, name);
					Class<?> destPropertyType = propertyUtils.getPropertyType(pDest, name);

					if (origPropertyType != null && origPropertyType.equals(destPropertyType)) {
						try {
							Object value = propertyUtils.getSimpleProperty(pOrig, name);
							if (value != null) {
								// copy property avec conversion
								copyProperty(pDest, name, value);
							} else {
								// copy valeur NULL dans property
								propertyUtils.setProperty(pDest, name, value);
							}
						} catch (NoSuchMethodException e) {
							// Should not happen
							LOGGER.error("Erreur NoSuchMethodException Should not happen");
						}
					}
				}
			} catch (NoSuchMethodException e) {
				LOGGER.error("Erreur copyPropertiesEJB", e);
			}
		}
	}
}
