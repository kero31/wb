/***********************************************************************
 * Module: IFactory.java Author: Kero Purpose: Defines the Interface IFactory
 ***********************************************************************/

package common.api.application.interfaces;

import java.util.List;

import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IFactory</b><br/>
 */
public interface IFactory {

	/**
	 * Retourne l'implémentation métier par rapport à l'interface.
	 * 
	 * @param pInterfaceClass l'interface
	 * @param <IT> IMetier<?>
	 * @return implémentation métier
	 */
	<IT extends IMetier<?>> IT createNewInstance(Class<IT> pInterfaceClass);

	/**
	 * Retourne l'implémentation métier par rapport à l'interface.
	 * 
	 * @param pInterface l'interface
	 * @param <IT> IMetier<?>
	 * @return implémentation métier
	 */
	<IT extends IMetier<?>> IT createNewInstance(IT pInterface);

	/**
	 * Retourne la classe de l'implémentation métier par rapport à l'interface.
	 * 
	 * @param pInterfaceClass l'interface
	 * @param <IT> IMetier<?>
	 * @return classe de l'implémentation métier
	 */
	<IT extends IMetier<?>> Class<?> getClassImplementation(Class<IT> pInterfaceClass);

	/**
	 * Retourne la classe de l'implémentation métier par rapport à l'interface.
	 * 
	 * @param pInterface l'interface
	 * @param pInterfaceClass la classe interface
	 * @param <IT> IMetier<?>
	 * @return classe de l'implémentation métier
	 */
	<IT extends IMetier<?>> Class<?> getClassImplementation(IT pInterface, Class<IT> pInterfaceClass);

	/**
	 * Retourne l'impémentation d'une liste par rapport à l'interface.
	 * 
	 * @param pInterfaceClass l'interface
	 * @param <IT> IT
	 * @return impémentation d'une liste
	 */
	<IT> List<IT> createNewListInstance(Class<IT> pInterfaceClass);

}