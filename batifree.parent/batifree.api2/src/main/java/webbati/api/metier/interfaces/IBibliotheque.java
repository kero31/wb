/***********************************************************************
 * Module: IBibliotheque.java Author: Didier Purpose: Defines the Interface IBibliotheque
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.ILigne;
import webbati.api.manager.interfaces.IBibliothequeManager;

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
	 * @throws WebbatiException WebbatiException
	 */
	IBinaire getNotes() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IBinaire getDescriptionTechnique() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IBinaire getDescriptionCommerciale() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IImage getImage() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IBinaire getDescriptif() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	ITva getTva() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	IFamille getFamille() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	<BIBD extends IBibliotheque> BIBD getClone() throws WebbatiException;

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
	 * @throws WebbatiException WebbatiException
	 */
	<IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException;

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