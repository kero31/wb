/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import common.api.metier.impl.MetierImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.ICivilite;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.ILocalisation;
import webbati.api.metier.interfaces.IPays;

/**
 * Classe <CoordonneeCntImpl>.
 * 
 */
public class CoordonneeCntImpl extends MetierImpl<Integer> implements ICoordonneeCnt {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Integer civiliteId;
	private String complementaire;
	private String cp;
	private String fax;
	private Integer localisationId;
	private String mail;
	private String mail2;
	private String mobile;
	private String nom;
	private Integer paysId;
	private String prenom;
	private String rue;
	private String tel1;
	private String tel2;
	private String ville;
	private String web;

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String pNom) {
		nom = pNom;
	}

	@Override
	public String getPrenom() {
		return prenom;
	}

	@Override
	public void setPrenom(String pPrenom) {
		prenom = pPrenom;
	}

	@Override
	public String getRue() {
		return rue;
	}

	@Override
	public void setRue(String pRue) {
		rue = pRue;
	}

	@Override
	public String getComplementaire() {
		return complementaire;
	}

	@Override
	public void setComplementaire(String pComplementaire) {
		complementaire = pComplementaire;
	}

	@Override
	public String getCp() {
		return cp;
	}

	@Override
	public void setCp(String pCp) {
		cp = pCp;
	}

	@Override
	public String getVille() {
		return ville;
	}

	@Override
	public void setVille(String pVille) {
		ville = pVille;
	}

	@Override
	public String getTel1() {
		return tel1;
	}

	@Override
	public void setTel1(String pTel1) {
		tel1 = pTel1;
	}

	@Override
	public String getTel2() {
		return tel2;
	}

	@Override
	public void setTel2(String pTel2) {
		tel2 = pTel2;
	}

	@Override
	public String getFax() {
		return fax;
	}

	@Override
	public void setFax(String pFax) {
		fax = pFax;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public void setMobile(String pMobile) {
		mobile = pMobile;
	}

	@Override
	public String getMail() {
		return mail;
	}

	@Override
	public void setMail(String pMail) {
		mail = pMail;
	}

	@Override
	public String getMail2() {
		return mail2;
	}

	@Override
	public void setMail2(String pMail2) {
		mail2 = pMail2;
	}

	@Override
	public String getWeb() {
		return web;
	}

	@Override
	public void setWeb(String pWeb) {
		web = pWeb;
	}

	@Override
	public IPays getPays() throws WebbatiException {
		return ApplicationWb.getApplication().getPaysManager().getById(paysId);
	}

	@Override
	public void setPays(IPays pPays) {
		if (pPays != null) {
			setPaysId(pPays.getId());
		} else {
			setPaysId(null);
		}
	}

	@Override
	public ICivilite getCivilite() throws WebbatiException {
		return ApplicationWb.getApplication().getCiviliteManager().getById(civiliteId);
	}

	@Override
	public void setCivilite(ICivilite pCivilite) {
		if (pCivilite != null) {
			setCiviliteId(pCivilite.getId());
		} else {
			setCiviliteId(null);
		}
	}

	@Override
	public ILocalisation getLocalisation() throws WebbatiException {
		return ApplicationWb.getApplication().getLocalisationManager().getById(localisationId);
	}

	@Override
	public void setLocalisation(ILocalisation pLocalisation) {
		if (pLocalisation != null) {
			setLocalisationId(pLocalisation.getId());
		} else {
			setLocalisationId(null);
		}
	}

	/**
	 * Retourne le champ civiliteId.
	 * 
	 * @return le civiliteId
	 */
	public Integer getCiviliteId() {
		return civiliteId;
	}

	/**
	 * Met à jour le champ civiliteId.
	 * 
	 * @param pCiviliteId le civiliteId à mettre à jour
	 */
	public void setCiviliteId(Integer pCiviliteId) {
		civiliteId = pCiviliteId;
	}

	/**
	 * Retourne le champ localisationId.
	 * 
	 * @return le localisationId
	 */
	public Integer getLocalisationId() {
		return localisationId;
	}

	/**
	 * Met à jour le champ localisationId.
	 * 
	 * @param pLocalisationId le localisationId à mettre à jour
	 */
	public void setLocalisationId(Integer pLocalisationId) {
		localisationId = pLocalisationId;
	}

	/**
	 * Retourne le champ paysId.
	 * 
	 * @return le paysId
	 */
	public Integer getPaysId() {
		return paysId;
	}

	/**
	 * Met à jour le champ paysId.
	 * 
	 * @param pPaysId le paysId à mettre à jour
	 */
	public void setPaysId(Integer pPaysId) {
		paysId = pPaysId;
	}

}
