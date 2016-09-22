/***********************************************************************
 * Module: IBibliotheque.java Author: Didier Purpose: Defines the Interface IBibliotheque
 ***********************************************************************/

package batifree.api.metier.interfaces;

import batifree.api.manager.interfaces.IBibliothequeManager;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.ILigne;

/**
 * Interface <b>IBibliotheque</b><br/>
 */
public interface IBibliotheque extends ILigne<IBibliotheque, Integer> {

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
	 * Get Mot Cle
	 * 
	 * @return Mot Cle
	 */
	java.lang.String getMotCle();

	/**
	 * Set Mot Cle
	 * 
	 * @param pMotCle Mot Cle
	 */
	void setMotCle(java.lang.String pMotCle);

	/**
	 * Get Num Serie
	 * 
	 * @return NumSerie
	 */
	java.lang.String getNumSerie();

	/**
	 * Get Unite
	 * 
	 * @return Unite
	 */
	java.lang.String getUnite();

	/**
	 * Set Unite
	 * 
	 * @param pUnite Unite
	 */
	void setUnite(java.lang.String pUnite);

	/**
	 * Si type Matériau : GetPrixAchatUnitaire() = (PrixTarif - Remise) arrondi<br/>
	 * Si type Tache : GetPrixAchatUnitaire() = somme des éléments du sous-détail = (Qte x PAU) arrondi par ligne
	 * 
	 * @return Prix Achat
	 */
	Float getPrixAchatUnitaire();

	/**
	 * Get Frais Generaux
	 * 
	 * @return Frais Generaux
	 */
	Float getFraisGeneraux();

	/**
	 * Get Benefice
	 * 
	 * @return Benefice
	 */
	Float getBenefice();

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
	 * Get Description Technique
	 * 
	 * @return Description Technique
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getDescriptionTechnique() throws BatifreeException;

	/**
	 * Set Description Technique
	 * 
	 * @param pDescriptionTechnique Description Technique
	 */
	void setDescriptionTechnique(IBinaire pDescriptionTechnique);

	/**
	 * Get Description Commerciale
	 * 
	 * @return Description Commerciale
	 * @throws BatifreeException BatifreeException
	 */
	IBinaire getDescriptionCommerciale() throws BatifreeException;

	/**
	 * Set Description Commerciale
	 * 
	 * @param pDescriptionCommerciale Description Commerciale
	 */
	void setDescriptionCommerciale(IBinaire pDescriptionCommerciale);

	/**
	 * Get Image
	 * 
	 * @return Image
	 * @throws BatifreeException BatifreeException
	 */
	IImage getImage() throws BatifreeException;

	/**
	 * Set Image
	 * 
	 * @param pImage Image
	 */
	void setImage(IImage pImage);

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
	 * Get Tva
	 * 
	 * @return Tva
	 * @throws BatifreeException BatifreeException
	 */
	ITva getTva() throws BatifreeException;

	/**
	 * Set Tva
	 * 
	 * @param pTva Tva
	 */
	void setTva(ITva pTva);

	/**
	 * Get Famille
	 * 
	 * @return Famille
	 * @throws BatifreeException BatifreeException
	 */
	IFamille getFamille() throws BatifreeException;

	/**
	 * Set Famille
	 * 
	 * @param pFamille Famille
	 */
	void setFamille(IFamille pFamille);

	/**
	 * Retourne le clone de l'objet courant
	 * 
	 * @param <BIBD> IBibliotheque
	 * @return clone de l'objet courant
	 * @throws BatifreeException BatifreeException
	 */
	<BIBD extends IBibliotheque> BIBD getClone() throws BatifreeException;

	/**
	 * Get Quantite
	 * 
	 * @return Quantite
	 */
	Float getQuantite();

	/**
	 * Set Quantite
	 * 
	 * @param pQuantite Quantite
	 */
	void setQuantite(Float pQuantite);

	/**
	 * Retourne VRAI si le parent est une tâche, FAUX sinon
	 * 
	 * @return VRAI si le parent est une tâche, FAUX sinon
	 */
	Boolean isParentTache();

	/**
	 * Retourne le manager de l'élément bib courant.
	 * 
	 * @param <IT> IBibliotheque
	 * @param <TM> IBibliothequeManager<IT>
	 * @return manager de l'élément bib courant
	 * @throws BatifreeException BatifreeException
	 */
	<IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws BatifreeException;

	/**
	 * Si type élément : GetPrixRevientUnitaire() = (getPrixAchatUnitaire x getFraisGeneraux) arrondi Si type tache : GetPrixRevientUnitaire() = =
	 * somme des éléments du sous-détail = Qte x PAU x Frais généraux par type (arrondi par ligne)
	 * 
	 * @return Prix Revient
	 */
	Float getPrixRevientUnitaire();

	/**
	 * si type élément : GetPrixVenteUnitaire() = (getPrixRevientUnitaire x getBenefice) arrondi si type tache : GetPrixVenteUnitaire() =
	 * getQuantite() x getPrixAchatUnitaire() x Frais généraux par type (arrondi par ligne) * Bénéfice (arrondi)
	 * 
	 * @return Prix de Vente
	 */
	Float getPrixVenteUnitaire();

}