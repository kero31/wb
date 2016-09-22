/**
 * 
 */
package batifree.api.metier.impl;

import java.util.Date;
import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.application.interfaces.IFactoryBf;
import batifree.api.manager.interfaces.ISousTacheManager;
import batifree.api.metier.interfaces.IBibEltBib;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IBinaire;
import batifree.api.metier.interfaces.IEtude;
import batifree.api.metier.interfaces.IFamille;
import batifree.api.metier.interfaces.IImage;
import batifree.api.metier.interfaces.ISousTache;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITva;

import common.api.exception.BatifreeException;
import common.api.metier.impl.LigneImpl;

/**
 * Classe <BibliothequeImpl>.
 * 
 */
public abstract class BibliothequeImpl extends LigneImpl<IBibliotheque, Integer> implements IBibliotheque {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	protected Float benefice;
	private String code;
	private Date dateCreation;
	private Date dateMaj;
	private Integer descriptifId;
	private Integer descriptionCommercialeId;
	private Integer descriptionTechniqueId;
	protected Float fraisGeneraux;
	private Integer imageId;
	private String motCle;
	private Integer notesId;
	protected String numSerie;
	protected Float prixAchatUnitaire;
	private Integer tvaId;
	private String unite;
	private Integer familleId;
	private Float quantite;
	protected Float prixVenteUnitaire;
	protected Float prixRevientUnitaire;

	// pour bib elt etude
	private Integer metreId;
	private Integer etudeId;

	// pour bib elt bib
	private Integer bibElementOriginId;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		code = pCode;
	}

	@Override
	public String getMotCle() {
		return motCle;
	}

	@Override
	public void setMotCle(String pMotCle) {
		motCle = pMotCle;
	}

	@Override
	public String getNumSerie() {
		return numSerie;
	}

	@Override
	public String getUnite() {
		return unite;
	}

	@Override
	public void setUnite(String pUnite) {
		unite = pUnite;
	}

	@Override
	public Float getPrixAchatUnitaire() {
		return getValue(prixAchatUnitaire);
	}

	@Override
	public Float getFraisGeneraux() {
		return getValue(fraisGeneraux);
	}

	@Override
	public Float getBenefice() {
		return getValue(benefice);
	}

	@Override
	public Date getDateCreation() {
		return dateCreation;
	}

	@Override
	public Date getDateMaj() {
		return dateMaj;
	}

	@Override
	public IBinaire getNotes() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(notesId);
	}

	@Override
	public void setNotes(IBinaire pNotes) {
		if (pNotes != null) {
			setNotesId(pNotes.getId());
		} else {
			setNotesId(null);
		}
	}

	@Override
	public IBinaire getDescriptionTechnique() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(descriptionTechniqueId);
	}

	@Override
	public void setDescriptionTechnique(IBinaire pDescriptionTechnique) {
		if (pDescriptionTechnique != null) {
			setDescriptionTechniqueId(pDescriptionTechnique.getId());
		} else {
			setDescriptionTechniqueId(null);
		}
	}

	@Override
	public IBinaire getDescriptionCommerciale() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(descriptionCommercialeId);
	}

	@Override
	public void setDescriptionCommerciale(IBinaire pDescriptionCommerciale) {
		if (pDescriptionCommerciale != null) {
			setDescriptionCommercialeId(pDescriptionCommerciale.getId());
		} else {
			setDescriptionCommercialeId(null);
		}
	}

	@Override
	public IImage getImage() throws BatifreeException {
		return ApplicationBf.getApplication().getImageManager().getById(imageId);
	}

	@Override
	public void setImage(IImage pImage) {
		if (pImage != null) {
			setImageId(pImage.getId());
		} else {
			setImageId(null);
		}
	}

	@Override
	public IBinaire getDescriptif() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(descriptifId);
	}

	@Override
	public void setDescriptif(IBinaire pDescriptif) {
		if (pDescriptif != null) {
			setDescriptifId(pDescriptif.getId());
		} else {
			setDescriptifId(null);
		}
	}

	@Override
	public ITva getTva() throws BatifreeException {
		return ApplicationBf.getApplication().getTvaManager().getById(tvaId);
	}

	@Override
	public void setTva(ITva pTva) {
		if (pTva != null) {
			setTvaId(pTva.getId());
		} else {
			setTvaId(null);
		}
	}

	/**
	 * Retourne le champ tvaId.
	 * 
	 * @return le tvaId
	 */
	public Integer getTvaId() {
		return tvaId;
	}

	/**
	 * Met à jour le champ tvaId.
	 * 
	 * @param pTvaId le tvaId à mettre à jour
	 */
	public void setTvaId(Integer pTvaId) {
		tvaId = pTvaId;
	}

	/**
	 * Retourne le champ descriptifId.
	 * 
	 * @return le descriptifId
	 */
	public Integer getDescriptifId() {
		return descriptifId;
	}

	/**
	 * Met à jour le champ descriptifId.
	 * 
	 * @param pDescriptifId le descriptifId à mettre à jour
	 */
	public void setDescriptifId(Integer pDescriptifId) {
		descriptifId = pDescriptifId;
	}

	/**
	 * Retourne le champ descriptionCommercialeId.
	 * 
	 * @return le descriptionCommercialeId
	 */
	public Integer getDescriptionCommercialeId() {
		return descriptionCommercialeId;
	}

	/**
	 * Met à jour le champ descriptionCommercialeId.
	 * 
	 * @param pDescriptionCommercialeId le descriptionCommercialeId à mettre à jour
	 */
	public void setDescriptionCommercialeId(Integer pDescriptionCommercialeId) {
		descriptionCommercialeId = pDescriptionCommercialeId;
	}

	/**
	 * Retourne le champ descriptionTechniqueId.
	 * 
	 * @return le descriptionTechniqueId
	 */
	public Integer getDescriptionTechniqueId() {
		return descriptionTechniqueId;
	}

	/**
	 * Met à jour le champ descriptionTechniqueId.
	 * 
	 * @param pDescriptionTechniqueId le descriptionTechniqueId à mettre à jour
	 */
	public void setDescriptionTechniqueId(Integer pDescriptionTechniqueId) {
		descriptionTechniqueId = pDescriptionTechniqueId;
	}

	/**
	 * Retourne le champ imageId.
	 * 
	 * @return le imageId
	 */
	public Integer getImageId() {
		return imageId;
	}

	/**
	 * Met à jour le champ imageId.
	 * 
	 * @param pImageId le imageId à mettre à jour
	 */
	public void setImageId(Integer pImageId) {
		imageId = pImageId;
	}

	/**
	 * Retourne le champ notesId.
	 * 
	 * @return le notesId
	 */
	public Integer getNotesId() {
		return notesId;
	}

	/**
	 * Met à jour le champ notesId.
	 * 
	 * @param pNotesId le notesId à mettre à jour
	 */
	public void setNotesId(Integer pNotesId) {
		notesId = pNotesId;
	}

	@Override
	public IFamille getFamille() throws BatifreeException {
		return ApplicationBf.getApplication().getFamilleManager().getById(familleId);
	}

	@Override
	public void setFamille(IFamille pFamille) {
		if (pFamille != null) {
			setFamilleId(pFamille.getId());
		} else {
			setFamilleId(null);
		}
	}

	/**
	 * Retourne le champ familleId.
	 * 
	 * @return le familleId
	 */
	public Integer getFamilleId() {
		return familleId;
	}

	/**
	 * Met à jour le champ familleId.
	 * 
	 * @param pFamilleId le familleId à mettre à jour
	 */
	public void setFamilleId(Integer pFamilleId) {
		familleId = pFamilleId;
	}

	@Override
	public <BIBD extends IBibliotheque> BIBD getClone() throws BatifreeException {
		@SuppressWarnings("unchecked")
		BIBD bib = (BIBD) getFactory().createNewInstance(this);
		return getManager().getClone(this, bib);
	}

	/**
	 * Retourne le clone de l'objet courant pour Import
	 * 
	 * @param <BIBD> IBibliotheque
	 * @return Retourne le clone de l'objet courant
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	public <BIBD extends IBibliotheque> BIBD getCloneForImport() throws BatifreeException {
		BIBD bib = (BIBD) getFactory().createNewInstance(this);
		return getManager().getClone(this, bib, true);
	}

	/**
	 * Retourne le clone de l'objet courant pour Import
	 * 
	 * @param pInterfaceDest interface de destination
	 * @param <BIBD> IBibliotheque
	 * @return Retourne le clone de l'objet courant
	 * @throws BatifreeException
	 */
	public <BIBD extends IBibliotheque> BIBD getCloneForImport(Class<BIBD> pInterfaceDest) throws BatifreeException {
		BIBD bib = getFactory().createNewInstance(pInterfaceDest);
		return getManager().getClone(this, bib, true);
	}

	/**
	 * Retourne la liste des tâches parente
	 * 
	 * @return liste des tâches parente
	 * @throws BatifreeException
	 */
	public List<ITache> getListTacheParente() throws BatifreeException {
		if (getManager() instanceof ISousTacheManager && this instanceof ISousTache) {
			@SuppressWarnings("unchecked")
			ISousTacheManager<ISousTache> ssTacheMng = (ISousTacheManager<ISousTache>) getManager();
			ISousTache ssTache = (ISousTache) this;
			return ssTacheMng.getListTacheParente(ssTache);
		}
		return null;
	}

	/**
	 * Retourne la factory courante.
	 * 
	 * @return factory courante
	 * @throws BatifreeException
	 */
	protected IFactoryBf getFactory() throws BatifreeException {
		return ApplicationBf.getApplication().getFactory();
	}

	@Override
	public Float getQuantite() {
		return quantite;
	}

	@Override
	public void setQuantite(Float pQuantite) {
		quantite = pQuantite;
	}

	@Override
	public Boolean isParentTache() {
		if (getParent() != null) {
			return getParent() instanceof ITache;
		}
		return false;
	}

	/**
	 * Retourne metre
	 * 
	 * @return metre
	 * @throws BatifreeException
	 */
	public IBinaire getMetre() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(metreId);
	}

	/**
	 * Set metre
	 * 
	 * @param pMetre metre
	 */
	public void setMetre(IBinaire pMetre) {
		if (pMetre != null) {
			setMetreId(pMetre.getId());
		} else {
			setMetreId(null);
		}
	}

	/**
	 * Retourne metre id
	 * 
	 * @return metre id
	 */
	public Integer getMetreId() {
		return metreId;
	}

	/**
	 * Set metre id
	 * 
	 * @param pMetreId metre id
	 */
	public void setMetreId(Integer pMetreId) {
		metreId = pMetreId;
	}

	/**
	 * Retourne etude
	 * 
	 * @return etude
	 * @throws BatifreeException
	 */
	public IEtude getEtude() throws BatifreeException {
		return ApplicationBf.getApplication().getEtudeManager().getById(etudeId);
	}

	/**
	 * Set etude
	 * 
	 * @param pEtude etude
	 */
	public void setEtude(IEtude pEtude) {
		if (pEtude != null) {
			setEtudeId(pEtude.getId());
		} else {
			setEtudeId(null);
		}
	}

	/**
	 * Retourne etude id
	 * 
	 * @return etude id
	 */
	public Integer getEtudeId() {
		return etudeId;
	}

	/**
	 * Set etude id
	 * 
	 * @param pEtudeId etude id
	 */
	public void setEtudeId(Integer pEtudeId) {
		etudeId = pEtudeId;
	}

	/**
	 * Retourne element origin
	 * 
	 * @return element origin
	 * @throws BatifreeException
	 */
	public IBibEltBib getElementOrigin() throws BatifreeException {
		return (IBibEltBib) getManager().getById(bibElementOriginId);
	}

	/**
	 * Set element origin
	 * 
	 * @param pElementOrigine element origin
	 */
	public void setElementOrigin(IBibEltBib pElementOrigine) {
		if (pElementOrigine != null) {
			IBibliotheque bib = (IBibliotheque) pElementOrigine;
			setBibOriginId(bib.getId());
		} else {
			setBibOriginId(null);
		}
	}

	/**
	 * Retourne bib origine id
	 * 
	 * @return bib origine id
	 */
	public Integer getBibOriginId() {
		return bibElementOriginId;
	}

	/**
	 * Set bib origine id
	 * 
	 * @param pBibOrigineId bib origine id
	 */
	public void setBibOriginId(Integer pBibOrigineId) {
		bibElementOriginId = pBibOrigineId;
	}

	@Override
	public Float getPrixRevientUnitaire() {
		// TODO Attente Didier pour méthode de calcul
		return 0F;
	}

	@Override
	public Float getPrixVenteUnitaire() {
		// TODO Attente Didier pour méthode de calcul
		return 0F;
	}

	@Override
	protected List<IBibliotheque> getListLigneFromManager() throws BatifreeException {
		IBibliotheque bib = getManager().getWithChildren(this);
		if (bib != null) {
			return bib.getListLigne();
		}
		return null;
	}

}
