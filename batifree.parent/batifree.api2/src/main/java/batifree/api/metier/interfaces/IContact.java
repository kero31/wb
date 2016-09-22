/***********************************************************************
 * Module: IContact.java Author: Kero Purpose: Defines the Interface IContact
 ***********************************************************************/

package batifree.api.metier.interfaces;

import java.util.List;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>IContact</b><br/>
 */
public interface IContact extends IMetier<Integer> {

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
	 * Get Hide, savoir si le contact est caché
	 * 
	 * @return TRUE si caché, FALSE sinon
	 */
	Boolean isHide();

	/**
	 * Set Hide, cache ou non le contact
	 * 
	 * @param pHide TRUE si caché, FALSE else
	 */
	void setHide(Boolean pHide);

	/**
	 * Get Nom Societe
	 * 
	 * @return Nom Societe
	 */
	java.lang.String getNomSociete();

	/**
	 * Set Nom Societe
	 * 
	 * @param pNomSociete Nom Societe
	 */
	void setNomSociete(java.lang.String pNomSociete);

	/**
	 * Get Code Naf
	 * 
	 * @return Code Naf
	 */
	java.lang.String getCodeNaf();

	/**
	 * Set Code Naf
	 * 
	 * @param pCodeNaf Code Naf
	 */
	void setCodeNaf(java.lang.String pCodeNaf);

	/**
	 * Get Siren
	 * 
	 * @return Siren
	 */
	java.lang.String getSiren();

	/**
	 * Set Siren
	 * 
	 * @param pSiren Siren
	 */
	void setSiren(java.lang.String pSiren);

	/**
	 * Get Rappel Date
	 * 
	 * @return Rappel Date
	 */
	java.util.Date getRappelDate();

	/**
	 * Set Rappel Date
	 * 
	 * @param pRappelDate Rappel Date
	 */
	void setRappelDate(java.util.Date pRappelDate);

	/**
	 * Get Tva Intra
	 * 
	 * @return Tva Intra
	 */
	java.lang.String getTvaIntra();

	/**
	 * Set Tva Intra
	 * 
	 * @param pTvaIntra Tva Intra
	 */
	void setTvaIntra(java.lang.String pTvaIntra);

	/**
	 * Get Remarques
	 * 
	 * @return Remarques
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getRemarques() throws BatifreeException;

	/**
	 * Set Remarques
	 * 
	 * @param pRemarques Remarques
	 */
	void setRemarques(IBinaire pRemarques);

	/**
	 * Get Rappel Motif
	 * 
	 * @return Rappel Motif
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getRappelMotif() throws BatifreeException;

	/**
	 * Set Rappel Motif
	 * 
	 * @param pRappelMotif Rappel Motif
	 */
	void setRappelMotif(IBinaire pRappelMotif);

	/**
	 * Get Coordonnee
	 * 
	 * @return Coordonnee
	 * @throws BatifreeException BatifreeException
	 */
	ICoordonneeCnt getCoordonnee() throws BatifreeException;

	/**
	 * Set Coordonnee
	 * 
	 * @param pCoordonnee Coordonnee
	 */
	void setCoordonnee(ICoordonneeCnt pCoordonnee);

	/**
	 * Get Activite
	 * 
	 * @return Activite
	 * @throws BatifreeException BatifreeException
	 */
	IActivite getActivite() throws BatifreeException;

	/**
	 * Set Activite
	 * 
	 * @param pActivite Activite
	 */
	void setActivite(IActivite pActivite);

	/**
	 * Get Categorie
	 * 
	 * @return Categorie
	 * @throws BatifreeException BatifreeException
	 */
	ICategorie getCategorie() throws BatifreeException;

	/**
	 * Set Categorie
	 * 
	 * @param pCategorie Categorie
	 */
	void setCategorie(ICategorie pCategorie);

	/**
	 * Retourne la liste des détails contact
	 * 
	 * @return liste des détails contact
	 * @throws BatifreeException BatifreeException
	 */
	List<IDetailCnt> getListDetailContact() throws BatifreeException;

}