/**
 * 
 */
package webbati.api.metier.impl;

import java.util.Date;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IActivite;
import webbati.api.metier.interfaces.IBinaire;
import webbati.api.metier.interfaces.ICategorie;
import webbati.api.metier.interfaces.IContact;
import webbati.api.metier.interfaces.ICoordonneeCnt;

/**
 * Classe <ContactImpl>.
 * 
 */
public abstract class ContactImpl extends MetierImpl<Integer> implements IContact {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Integer activiteId;
	private Integer categorieId;
	private String code;
	private String codeNaf;
	private Integer coordonneId;
	private Date dateCreation;
	private Date dateMaj;
	private String nomSociete;
	private Date rappelDate;
	private Integer rappelMotifId;
	private Integer remarquesId;
	private String siren;
	private String tvaIntra;
	private Boolean hide;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String pCode) {
		code = pCode;
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
	public Boolean isHide() {
		return getValue(hide);
	}

	/**
	 * Return hide.
	 * 
	 * @return hide
	 */
	public Boolean getHide() {
		return hide;
	}

	@Override
	public void setHide(Boolean pHide) {
		hide = pHide;
	}

	@Override
	public String getNomSociete() {
		return nomSociete;
	}

	@Override
	public void setNomSociete(String pNomSociete) {
		nomSociete = pNomSociete;
	}

	@Override
	public String getCodeNaf() {
		return codeNaf;
	}

	@Override
	public void setCodeNaf(String pCodeNaf) {
		codeNaf = pCodeNaf;
	}

	@Override
	public String getSiren() {
		return siren;
	}

	@Override
	public void setSiren(String pSiren) {
		siren = pSiren;
	}

	@Override
	public Date getRappelDate() {
		return rappelDate;
	}

	@Override
	public void setRappelDate(Date pRappelDate) {
		rappelDate = pRappelDate;
	}

	@Override
	public String getTvaIntra() {
		return tvaIntra;
	}

	@Override
	public void setTvaIntra(String pTvaIntra) {
		tvaIntra = pTvaIntra;
	}

	@Override
	public IBinaire getRemarques() throws WebbatiException {
		return ApplicationWb.getApplication().getBinaireManager().getById(remarquesId);
	}

	@Override
	public void setRemarques(IBinaire pRemarques) {
		if (pRemarques != null) {
			setRemarquesId(pRemarques.getId());
		} else {
			setRemarquesId(null);
		}
	}

	@Override
	public IBinaire getRappelMotif() throws WebbatiException {
		return ApplicationWb.getApplication().getBinaireManager().getById(rappelMotifId);
	}

	@Override
	public void setRappelMotif(IBinaire pRappelMotif) {
		if (pRappelMotif != null) {
			setRappelMotifId(pRappelMotif.getId());
		} else {
			setRappelMotifId(null);
		}
	}

	@Override
	public ICoordonneeCnt getCoordonnee() throws WebbatiException {
		return ApplicationWb.getApplication().getCoordonneeCntManager().getById(coordonneId);
	}

	@Override
	public void setCoordonnee(ICoordonneeCnt pCoordonnee) {
		if (pCoordonnee != null) {
			setCoordonneId(pCoordonnee.getId());
		} else {
			setCoordonneId(null);
		}
	}

	@Override
	public IActivite getActivite() throws WebbatiException {
		return ApplicationWb.getApplication().getActiviteManager().getById(activiteId);
	}

	@Override
	public void setActivite(IActivite pActivite) {
		if (pActivite != null) {
			setActiviteId(pActivite.getId());
		} else {
			setActiviteId(null);
		}
	}

	@Override
	public ICategorie getCategorie() throws WebbatiException {
		return ApplicationWb.getApplication().getCategorieManager().getById(categorieId);
	}

	@Override
	public void setCategorie(ICategorie pCategorie) {
		if (pCategorie != null) {
			setCategorieId(pCategorie.getId());
		} else {
			setCategorieId(null);
		}
	}

	/**
	 * Retourne le champ activiteId.
	 * 
	 * @return le activiteId
	 */
	public Integer getActiviteId() {
		return activiteId;
	}

	/**
	 * Met à jour le champ activiteId.
	 * 
	 * @param pActiviteId le activiteId à mettre à jour
	 */
	public void setActiviteId(Integer pActiviteId) {
		activiteId = pActiviteId;
	}

	/**
	 * Retourne le champ categorieId.
	 * 
	 * @return le categorieId
	 */
	public Integer getCategorieId() {
		return categorieId;
	}

	/**
	 * Met à jour le champ categorieId.
	 * 
	 * @param pCategorieId le categorieId à mettre à jour
	 */
	public void setCategorieId(Integer pCategorieId) {
		categorieId = pCategorieId;
	}

	/**
	 * Retourne le champ coordonneId.
	 * 
	 * @return le coordonneId
	 */
	public Integer getCoordonneId() {
		return coordonneId;
	}

	/**
	 * Met à jour le champ coordonneId.
	 * 
	 * @param pCoordonneId le coordonneId à mettre à jour
	 */
	public void setCoordonneId(Integer pCoordonneId) {
		coordonneId = pCoordonneId;
	}

	/**
	 * Retourne le champ rappelMotifId.
	 * 
	 * @return le rappelMotifId
	 */
	public Integer getRappelMotifId() {
		return rappelMotifId;
	}

	/**
	 * Met à jour le champ rappelMotifId.
	 * 
	 * @param pRappelMotifId le rappelMotifId à mettre à jour
	 */
	public void setRappelMotifId(Integer pRappelMotifId) {
		rappelMotifId = pRappelMotifId;
	}

	/**
	 * Retourne le champ remarquesId.
	 * 
	 * @return le remarquesId
	 */
	public Integer getRemarquesId() {
		return remarquesId;
	}

	/**
	 * Met à jour le champ remarquesId.
	 * 
	 * @param pRemarquesId le remarquesId à mettre à jour
	 */
	public void setRemarquesId(Integer pRemarquesId) {
		remarquesId = pRemarquesId;
	}
}
