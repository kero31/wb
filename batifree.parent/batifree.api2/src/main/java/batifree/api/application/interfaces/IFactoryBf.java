/***********************************************************************
 * Module: IFactoryBf.java Author: Kero Purpose: Defines the Interface IFactoryBf
 ***********************************************************************/

package batifree.api.application.interfaces;

import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IEtude;
import batifree.api.metier.interfaces.IReglement;

import common.api.exception.BatifreeException;

/**
 * Interface <b>IFactoryBf</b><br/>
 */
public interface IFactoryBf extends common.api.application.interfaces.IFactory {

	/**
	 * Retourne l'implémentation métier Affaire avec son devis si l'interface IT hérite de l'interface IAffaireDevis.
	 * 
	 * @param pInterfaceClass la classe interface
	 * @param pDevis le devis
	 * @param <IT> IAffaire
	 * @return implémentation métier Etude
	 */
	<IT extends IAffaire> IT createNewInstanceAffaire(Class<IT> pInterfaceClass, IDevis pDevis);

	/**
	 * Retourne l'implémentation métier Etude avec son affaire.
	 * 
	 * @param pAffaire l'affaire
	 * @return implémentation métier Etude
	 */
	IEtude createNewInstanceEtude(IAffaire pAffaire);

	/**
	 * Retourne l'implémentation métier EcheancierReglement avec son Echeancier et son Règlement.
	 * 
	 * @param pEcheancier Echéancier
	 * @param pReglement Reglement
	 * @return implémentation métier LigneEtude
	 * @throws BatifreeException BatifreeException
	 */
	IEcheancierReglement createNewInstanceEcheancierReglement(IEcheancier pEcheancier, IReglement pReglement) throws BatifreeException;

	/**
	 * Retourne l'implémentation métier Echeancier avec son affaire.
	 * 
	 * @param pAffaire l'affaire
	 * @return implémentation métier Etude
	 */
	IEcheancier createNewInstanceEcheancier(IAffaire pAffaire);

}