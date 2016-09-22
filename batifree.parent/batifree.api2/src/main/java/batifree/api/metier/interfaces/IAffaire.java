/***********************************************************************
 * Module: IAffaire.java Author: Kero Purpose: Defines the Interface IAffaire
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IAffaire</b><br/>
 */
public interface IAffaire extends IMetier<Integer> {

	/**
	 * Get Code
	 * 
	 * @return Code
	 */
	java.lang.String getCode();

	/**
	 * Set Code
	 * 
	 * @param pCode Code
	 */
	void setCode(java.lang.String pCode);

	/**
	 * Get Reference
	 * 
	 * @return Reference
	 */
	java.lang.String getReference();

	/**
	 * Set Reference
	 * 
	 * @param pReference Reference
	 */
	void setReference(java.lang.String pReference);

	/**
	 * Get Date Creation
	 * 
	 * @return Date Creation
	 */
	java.util.Date getDateCreation();

	/**
	 * Get Date Maj
	 * 
	 * @return Date Maj
	 */
	java.util.Date getDateMaj();

	/**
	 * Get Termine
	 * 
	 * @return TRUE si Termine, FALSE else
	 */
	Boolean isTermine();

	/**
	 * Set Termine
	 * 
	 * @param pTermine TRUE si Termine, FALSE else
	 */
	void setTermine(Boolean pTermine);

	/**
	 * Get Valide
	 * 
	 * @return TRUE si Valide, FALSE else
	 */
	Boolean isValide();

	/**
	 * Set Valide
	 * 
	 * @param pValide TRUE si Valide, FALSE else
	 */
	void setValide(Boolean pValide);

	/**
	 * Get Duree Validite
	 * 
	 * @return Duree Validite
	 */
	java.util.Date getDureeValidite();

	/**
	 * Set Duree Validite
	 * 
	 * @param pDureeValidite Duree Validite
	 */
	void setDureeValidite(java.util.Date pDureeValidite);

	/**
	 * Get Date Deb Travaux
	 * 
	 * @return Date Debut Travaux
	 */
	java.util.Date getDateDebTravaux();

	/**
	 * Set Date Deb Travaux
	 * 
	 * @param pDateDebTravaux Date Debut Travaux
	 */
	void setDateDebTravaux(java.util.Date pDateDebTravaux);

	/**
	 * Get Date Fin Travaux
	 * 
	 * @return Date Fin Travaux
	 */
	java.util.Date getDateFinTravaux();

	/**
	 * Set Date Fin Travaux
	 * 
	 * @param pDateFinTravaux Date Fin Travaux
	 */
	void setDateFinTravaux(java.util.Date pDateFinTravaux);

	/**
	 * Get Date Cloture
	 * 
	 * @return Date Cloture
	 */
	java.util.Date getDateCloture();

	/**
	 * Set Date Cloture
	 * 
	 * @param pDateCloture Date Cloture
	 */
	void setDateCloture(java.util.Date pDateCloture);

	/**
	 * Get Etat
	 * 
	 * @return Etat
	 * @throws BatifreeException BatifreeException
	 */
	IEtat getEtat() throws BatifreeException;

	/**
	 * Set Etat
	 * 
	 * @param pEtat Etat
	 */
	void setEtat(IEtat pEtat);

	/**
	 * Get Chantier
	 * 
	 * @return Chantier
	 * @throws BatifreeException BatifreeException
	 */
	IChantier getChantier() throws BatifreeException;

	/**
	 * Set Chantier
	 * 
	 * @param pChantier Chantier
	 */
	void setChantier(IChantier pChantier);

	/**
	 * Get Conclusion
	 * 
	 * @return Conclusion
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getConclusion() throws BatifreeException;

	/**
	 * Set Conclusion
	 * 
	 * @param pConclusion Conclusion
	 */
	void setConclusion(IBinaire pConclusion);

	/**
	 * Get Introduction
	 * 
	 * @return Introduction
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getIntroduction() throws BatifreeException;

	/**
	 * Set Introduction
	 * 
	 * @param pIntroduction Introduction
	 */
	void setIntroduction(IBinaire pIntroduction);

	/**
	 * Get Metre
	 * 
	 * @return Metre
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getMetre() throws BatifreeException;

	/**
	 * Set Metre
	 * 
	 * @param pMetre Metre
	 */
	void setMetre(IBinaire pMetre);

	/**
	 * Get Notes
	 * 
	 * @return Notes
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getNotes() throws BatifreeException;

	/**
	 * Set Notes
	 * 
	 * @param pNotes Notes
	 */
	void setNotes(IBinaire pNotes);

	/**
	 * Get Descriptif
	 * 
	 * @return Descriptif
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getDescriptif() throws BatifreeException;

	/**
	 * Set Descriptif
	 * 
	 * @param pDescriptif Descriptif
	 */
	void setDescriptif(IBinaire pDescriptif);

	/**
	 * Get List Echeancier
	 * 
	 * @return List Echeancier
	 * @throws BatifreeException BatifreeException
	 */
	List<IEcheancier> getListEcheancier() throws BatifreeException;

	/**
	 * Retourne TRUE si la liste échéancier a été changé, FALSE sinon
	 * 
	 * @return TRUE si la liste échéancier a été changé, FALSE sinon
	 */
	Boolean isListEcheancierChanged();

	/**
	 * Get List Etude
	 * 
	 * @return List Etude
	 * @throws BatifreeException BatifreeException
	 */
	List<IEtude> getListEtude() throws BatifreeException;

	/**
	 * Retourne TRUE si la liste étude a été changé, FALSE sinon
	 * 
	 * @return TRUE si la liste étude a été changé, FALSE sinon
	 */
	Boolean isListEtudeChanged();

	/**
	 * Get Client
	 * 
	 * @return Client
	 * @throws BatifreeException BatifreeException
	 */
	IClient getClient() throws BatifreeException;

	/**
	 * Set Client
	 * 
	 * @param pClient Client
	 */
	void setClient(IClient pClient);

	/**
	 * Retourne le clone avec ses études et ses échéanciers
	 * 
	 * @param pNewAffaireDest Instance de l'affaire de destination
	 * @param <AFF> IAffaire
	 * @return clone avec ses études et ses échéanciers
	 * @throws BatifreeException BatifreeException
	 */
	<AFF extends IAffaire> AFF getClone(AFF pNewAffaireDest) throws BatifreeException;

}