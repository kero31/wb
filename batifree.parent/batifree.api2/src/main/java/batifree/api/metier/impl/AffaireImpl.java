/**
 * 
 */
package batifree.api.metier.impl;

import java.util.Date;
import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.manager.interfaces.IAffaireManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IBinaire;
import batifree.api.metier.interfaces.IChantier;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEtat;
import batifree.api.metier.interfaces.IEtude;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * Classe <AffaireImpl>.
 * 
 */
public abstract class AffaireImpl extends MetierImpl<Integer> implements IAffaire {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private Integer conclusionId;
	private Date dateCloture;
	private Date dateCreation;
	private Date dateDebTravaux;
	private Date dateFinTravaux;
	private Date dateMaj;
	private Integer descriptifId;
	private Date dureeValidite;
	private Integer etatId;
	private Integer introductionId;
	private Integer metreId;
	private Integer notesId;
	private String reference;
	private Boolean termine;
	private Boolean valide;
	private Integer chantierId;
	private Integer clientId;
	private List<IEcheancier> listEcheancierUpdated = null;
	private boolean isListEcheancierUpdated = false;
	private List<IEtude> listEtudeUpdated = null;
	private boolean isListEtudeUpdated = false;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		code = pCode;
	}

	@Override
	public String getReference() {

		return reference;
	}

	@Override
	public void setReference(String pReference) {
		reference = pReference;

	}

	@Override
	public Date getDateCreation() {

		return dateCreation;
	}

	@Override
	public Date getDateMaj() {

		return dateMaj;
	}

	/**
	 * Retourne Termine
	 * 
	 * @return Termine
	 */
	public Boolean getTermine() {
		return termine;
	}

	@Override
	public Boolean isTermine() {
		return getValue(termine);
	}

	@Override
	public void setTermine(Boolean pTermine) {
		termine = pTermine;

	}

	/**
	 * Retourne Valide
	 * 
	 * @return Valide
	 */
	public Boolean getValide() {
		return valide;
	}

	@Override
	public Boolean isValide() {
		return getValue(valide);
	}

	@Override
	public void setValide(Boolean pValide) {
		valide = pValide;

	}

	@Override
	public Date getDureeValidite() {
		return dureeValidite;
	}

	@Override
	public void setDureeValidite(Date pDureeValidite) {
		dureeValidite = pDureeValidite;

	}

	@Override
	public Date getDateDebTravaux() {

		return dateDebTravaux;
	}

	@Override
	public void setDateDebTravaux(Date pDateDebTravaux) {
		dateDebTravaux = pDateDebTravaux;

	}

	@Override
	public Date getDateFinTravaux() {

		return dateFinTravaux;
	}

	@Override
	public void setDateFinTravaux(Date pDateFinTravaux) {
		dateFinTravaux = pDateFinTravaux;

	}

	@Override
	public Date getDateCloture() {

		return dateCloture;
	}

	@Override
	public void setDateCloture(Date pDateCloture) {
		dateCloture = pDateCloture;

	}

	@Override
	public IEtat getEtat() throws BatifreeException {
		return ApplicationBf.getApplication().getEtatManager().getById(etatId);
	}

	@Override
	public void setEtat(IEtat pEtat) {
		if (pEtat != null) {
			etatId = pEtat.getId();
		} else {
			etatId = null;
		}
	}

	@Override
	public IChantier getChantier() throws BatifreeException {
		return ApplicationBf.getApplication().getChantierManager().getById(chantierId);
	}

	@Override
	public void setChantier(IChantier pChantier) {
		if (pChantier != null) {
			chantierId = pChantier.getId();
		} else {
			chantierId = null;
		}
	}

	@Override
	public IBinaire getConclusion() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(conclusionId);
	}

	@Override
	public void setConclusion(IBinaire pConclusion) {
		if (pConclusion != null) {
			conclusionId = pConclusion.getId();
		} else {
			conclusionId = null;
		}
	}

	@Override
	public IBinaire getIntroduction() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(introductionId);
	}

	@Override
	public void setIntroduction(IBinaire pIntroduction) {
		if (pIntroduction != null) {
			introductionId = pIntroduction.getId();
		} else {
			introductionId = null;
		}
	}

	@Override
	public IBinaire getMetre() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(metreId);
	}

	@Override
	public void setMetre(IBinaire pMetre) {
		if (pMetre != null) {
			metreId = pMetre.getId();
		} else {
			metreId = null;
		}
	}

	@Override
	public IBinaire getNotes() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(notesId);
	}

	@Override
	public void setNotes(IBinaire pNotes) {
		if (pNotes != null) {
			notesId = pNotes.getId();
		} else {
			notesId = null;
		}
	}

	@Override
	public IBinaire getDescriptif() throws BatifreeException {
		return ApplicationBf.getApplication().getBinaireManager().getById(descriptifId);
	}

	@Override
	public void setDescriptif(IBinaire pDescriptif) {
		if (pDescriptif != null) {
			descriptifId = pDescriptif.getId();
		} else {
			descriptifId = null;
		}
	}

	@Override
	public List<IEtude> getListEtude() throws BatifreeException {
		if (isListEtudeUpdated) {
			return getListFormatted(listEtudeUpdated);
		}
		return getManager().getListEtude(this);
	}

	/**
	 * Met à jour la liste Etude
	 * 
	 * @param pListEtude Liste étude
	 */
	public void setListEtude(List<IEtude> pListEtude) {
		listEtudeUpdated = pListEtude;
		isListEtudeUpdated = true;
	}

	@Override
	public Boolean isListEtudeChanged() {
		return isListEtudeUpdated;
	}

	@Override
	public IClient getClient() throws BatifreeException {
		return ApplicationBf.getApplication().getClientManager().getById(clientId);
	}

	@Override
	public void setClient(IClient pClient) {
		if (pClient != null) {
			clientId = pClient.getId();
		} else {
			clientId = null;
		}
	}

	/**
	 * Retourne le champ conclusionId.
	 * 
	 * @return le conclusionId
	 */
	public Integer getConclusionId() {
		return conclusionId;
	}

	/**
	 * Met à jour le champ conclusionId.
	 * 
	 * @param pConclusionId le conclusionId à mettre à jour
	 */
	public void setConclusionId(Integer pConclusionId) {
		conclusionId = pConclusionId;
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
	 * Retourne le champ etatId.
	 * 
	 * @return le etatId
	 */
	public Integer getEtatId() {
		return etatId;
	}

	/**
	 * Met à jour le champ etatId.
	 * 
	 * @param pEtatId le etatId à mettre à jour
	 */
	public void setEtatId(Integer pEtatId) {
		etatId = pEtatId;
	}

	/**
	 * Retourne le champ metreId.
	 * 
	 * @return le metreId
	 */
	public Integer getMetreId() {
		return metreId;
	}

	/**
	 * Met à jour le champ metreId.
	 * 
	 * @param pMetreId le metreId à mettre à jour
	 */
	public void setMetreId(Integer pMetreId) {
		metreId = pMetreId;
	}

	/**
	 * Retourne le champ introductionId.
	 * 
	 * @return le introductionId
	 */
	public Integer getIntroductionId() {
		return introductionId;
	}

	/**
	 * Met à jour le champ introductionId.
	 * 
	 * @param pIntroductionId le introductionId à mettre à jour
	 */
	public void setIntroductionId(Integer pIntroductionId) {
		introductionId = pIntroductionId;
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

	/**
	 * Retourne le champ chantierId.
	 * 
	 * @return le chantierId
	 */
	public Integer getChantierId() {
		return chantierId;
	}

	/**
	 * Met à jour le champ chantierId.
	 * 
	 * @param pChantierId le chantierId à mettre à jour
	 */
	public void setChantierId(Integer pChantierId) {
		chantierId = pChantierId;
	}

	/**
	 * Retourne le champ clientId.
	 * 
	 * @return le clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * Met à jour le champ clientId.
	 * 
	 * @param pClientId le clientId à mettre à jour
	 */
	public void setClientId(Integer pClientId) {
		clientId = pClientId;
	}

	@Override
	public List<IEcheancier> getListEcheancier() throws BatifreeException {
		if (isListEcheancierUpdated) {
			return getListFormatted(listEcheancierUpdated);
		}
		return getManager().getListEcheancier(this);
	}

	/**
	 * Met à jour la liste Echeancier
	 * 
	 * @param pListEcheancier liste Echeancier
	 */
	public void setListEcheancier(List<IEcheancier> pListEcheancier) {
		listEcheancierUpdated = pListEcheancier;
		isListEcheancierUpdated = true;
	}

	@Override
	public Boolean isListEcheancierChanged() {
		return isListEcheancierUpdated;
	}

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface affaire
	 * @param <TM> interface affaire manager
	 * @return manager
	 */
	protected abstract <IT extends IAffaire, TM extends IAffaireManager<IT>> TM getManager() throws BatifreeException;

	@Override
	public <AFF extends IAffaire> AFF getClone(AFF pNewAffaireDest) throws BatifreeException {
		return getManager().getClone(this, pNewAffaireDest);
	}
}
